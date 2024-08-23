package com.dicoding.mygenshincharacter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGenshinCharacter: RecyclerView
    private val list = ArrayList<GenshinCharacter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGenshinCharacter = findViewById(R.id.rv_genshin_char)
        rvGenshinCharacter.setHasFixedSize(true)

        list.addAll(getListCharacter())
        showRecyclerList()
    }


    private fun getListCharacter(): ArrayList<GenshinCharacter>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataVision = resources.getStringArray(R.array.data_vision)
        val dataWeapon = resources.getStringArray(R.array.data_weapon)
        val dataAssociation = resources.getStringArray(R.array.data_association)
        val listCharacter =ArrayList<GenshinCharacter>()
        for (i in dataName.indices){
            val character = GenshinCharacter(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataVision[i], dataWeapon[i], dataAssociation[i])
            listCharacter.add(character)
        }
        return listCharacter
    }

    private fun showRecyclerList(){
        rvGenshinCharacter.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list)
        rvGenshinCharacter.adapter = listCharacterAdapter

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page-> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
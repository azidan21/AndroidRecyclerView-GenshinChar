package com.dicoding.mygenshincharacter

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailImg: ImageView = findViewById(R.id.detail_photo)
        val detailName: TextView = findViewById(R.id.detail_name)
        val detailVision: TextView = findViewById(R.id.detail_vision)
        val detailWeapon: TextView = findViewById(R.id.detail_weapon)
        val detailAssociation: TextView = findViewById(R.id.detail_association)
        val detailDescription: TextView = findViewById(R.id.detail_description)
        val dataIntent = intent

        if (dataIntent != null) {
            val dataCharacter = if (Build.VERSION.SDK_INT >= 33){
                dataIntent.getParcelableExtra<GenshinCharacter>(
                    "key_character",
                    GenshinCharacter::class.java
                )
            }else{
                @Suppress("DEPRECATION")
                dataIntent.getParcelableExtra<GenshinCharacter>(
                    "key_character")
            }
            if (dataCharacter != null){
                val photo = dataCharacter.photo
                val name = dataCharacter.name
                val vision = dataCharacter.vision
                val weapon = dataCharacter.weapon
                val association = dataCharacter.association
                val description = dataCharacter.description

                detailImg.setImageResource(photo)
                detailName.text = "$name"
                detailVision.text = "$vision"
                detailWeapon.text = "$weapon"
                detailAssociation.text = "$association"
                detailDescription.text = "$description"
            }
        }

    }
}
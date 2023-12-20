package com.example.proyectom13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity) // Usa la vista de login

        // Carga la imagen con Glide
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageUrl = "https://ibb.co/q5Q0SfJ"

        Glide.with(this)
            .load(imageUrl)
            .into(imageView)

        // Configuración del botón de login
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
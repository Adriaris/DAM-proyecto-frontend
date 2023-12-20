package com.example.proyectom13

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectom13.listasEstaticas.CuidadoresProvider
import com.example.proyectom13.retrofit.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    val listaCuidadores :MutableList<Cuidador> = CuidadoresProvider.listaCuidadores
    private lateinit var CuidadoresRvAdapter:CuidadorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // Configurar RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCuidadores)
        recyclerView.layoutManager = LinearLayoutManager(this)
        CuidadoresRvAdapter = CuidadorAdapter(listaCuidadores)
        recyclerView.adapter = CuidadoresRvAdapter


        lifecycleScope.launch(Dispatchers.Default){
            val conexion = Retrofit.Builder(). baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            withContext(Dispatchers.IO){
                val respuesta = conexion.create(APIService::class.java).getCuidadores("cuidadores")
                withContext(Dispatchers.Main){
                    if (respuesta.isSuccessful){
                        val cuidadores = respuesta.body()?: emptyList()
                        listaCuidadores.addAll(cuidadores)
                        CuidadoresRvAdapter.notifyDataSetChanged()
                    }
                }

            }

        }


        // Configuración del botón AboutUs
        val btnAboutUs = findViewById<Button>(R.id.btnAboutUs)
        btnAboutUs.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }
    }


}


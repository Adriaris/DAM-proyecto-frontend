package com.example.proyectom13.listasEstaticas

import com.example.proyectom13.Cuidador
import com.example.proyectom13.R

class CuidadoresProvider {
    companion object{
        // Lista de cuidadores de ejemplo
        val listaCuidadores = mutableListOf<Cuidador>(
            Cuidador("Juan Pérez", 4.5,  R.drawable.profile, 20.0),
            Cuidador("Ana Gómez", 4.8,  R.drawable.profile, 25.0)
            // Más cuidadores según sea necesario
        )
    }
}
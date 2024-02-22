package com.example.menucomida.data

import com.example.menucomida.R
import com.example.menucomida.model.Platillo

class DataSource() {
    fun LoadPlatillos(): List<Platillo> {
        return listOf<Platillo>(
            Platillo(R.string.desayunoa , R.drawable.desayuno ),
            Platillo(R.string.hamburgera , R.drawable.hamburger ),
            Platillo(R.string.pizzaa , R.drawable.pizza ),
            Platillo(R.string.postrea , R.drawable.postre ),
            Platillo(R.string.pozolea , R.drawable.pozole ),
            Platillo(R.string.tacosa , R.drawable.tacos ),
        )
    }
}
package com.opdeveloper.opexpenseadmin.models

import android.graphics.Bitmap

data class ProductosModel(
    val id:Long?,
    val nombre: String?,
    val img: Bitmap?,
    val precio: Double?
)
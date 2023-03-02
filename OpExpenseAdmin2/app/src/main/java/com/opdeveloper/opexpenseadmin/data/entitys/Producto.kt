package com.opdeveloper.opexpenseadmin.data.entitys

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class Producto (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "precio") val precio: Double?
    )
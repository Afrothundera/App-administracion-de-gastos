package com.opdeveloper.opexpenseadmin.data.entitys

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "metodos_pago")
data class MetodoPago (
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "saldo") val saldo: Double?,
    @ColumnInfo(name = "image_icon") val icon : Int?
)
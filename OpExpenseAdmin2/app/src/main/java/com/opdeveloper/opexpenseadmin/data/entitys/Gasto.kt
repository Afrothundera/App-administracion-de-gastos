package com.opdeveloper.opexpenseadmin.data.entitys

import android.graphics.Bitmap
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.util.DateConverter
import com.opdeveloper.opexpenseadmin.data.util.ObjectConverter
import com.opdeveloper.opexpenseadmin.models.ProductosModel

import java.util.*
import kotlin.collections.ArrayList


@Entity(tableName = "gastos")

data class Gasto (
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name = "factura") val factura : String?,
    @ColumnInfo(name = "id_categoria") val categoryId :Long?,

     @ColumnInfo(name = "productos") val productos : List<ProductosModel>?,
    @ColumnInfo(name = "total") val total : Double?,
    @ColumnInfo(name = "metodo_pago") val metodoPago : String?,
    @ColumnInfo(name = "estado_pago") val estadoPago : String?,
    @ColumnInfo(name = "pago_parcial") val pagoParcial : Double?,

     @ColumnInfo(name = "created_at") val createdAt: Date?

    )


package com.opdeveloper.opexpenseadmin.data.entitys

import android.graphics.Bitmap
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.util.DateConverter
import java.util.*

@Entity(tableName = "ingresos")

data class Ingreso (
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name = "factura") val factura : String?,
    @ColumnInfo(name = "id_categoria") val categoryId :Long?,

    @ColumnInfo(name = "total") val total : Double?,
    @ColumnInfo(name = "metodo_pago") val metodoPago : String?,
     @ColumnInfo(name = "created_at") val createdAt: Date?

)
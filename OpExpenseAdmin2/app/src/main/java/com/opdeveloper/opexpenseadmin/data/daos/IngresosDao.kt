package com.opdeveloper.opexpenseadmin.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.entitys.Ingreso

import java.util.*
@Dao
interface IngresosDao {
    @Query("SELECT * from ingresos ORDER BY created_at ASC")
    fun getAllGastos(): LiveData<List<Ingreso>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ingresos: Ingreso)

    @Query("DELETE FROM gastos")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteGasto(ingresos: Ingreso)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateGasto(ingresos: Ingreso)

    @Query("SELECT * from ingresos WHERE created_at LIKE :fecha")
    fun getGastoByFecha(fecha: Date?): LiveData<List<Ingreso>>

    @Query("SELECT * from ingresos WHERE created_at BETWEEN  :fechaInicial AND :fechaFinal")
    fun getGastoBetweenFecha(fechaInicial: Date?, fechaFinal: Date?): LiveData<List<Ingreso>>
}
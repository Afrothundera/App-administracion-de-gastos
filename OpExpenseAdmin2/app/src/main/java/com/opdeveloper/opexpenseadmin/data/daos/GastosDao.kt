package com.opdeveloper.opexpenseadmin.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.entitys.Gasto
import java.time.OffsetDateTime
import java.util.*
@Dao
interface GastosDao {
    @Query("SELECT * from gastos ORDER BY created_at ASC")
    fun getAllGastos(): LiveData<List<Gasto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gasto: Gasto)

    @Query("DELETE FROM gastos")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteGasto(gasto: Gasto)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateGasto(gasto: Gasto)

    @Query("SELECT * from gastos WHERE created_at LIKE :fecha")
    fun getGastoByFecha(fecha: Date?): LiveData<List<Gasto>>

    @Query("SELECT * from gastos WHERE created_at BETWEEN  :fechaInicial AND :fechaFinal")
    fun getGastoBetweenFecha(fechaInicial: Date?, fechaFinal: Date?): LiveData<List<Gasto>>
}
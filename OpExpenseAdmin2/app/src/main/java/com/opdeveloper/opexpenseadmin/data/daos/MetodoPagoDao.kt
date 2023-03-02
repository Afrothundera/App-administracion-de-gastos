package com.opdeveloper.opexpenseadmin.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.entitys.MetodoPago

@Dao
interface MetodoPagoDao {
    @Query("SELECT * from metodos_pago")
    fun getAllMetodo(): LiveData<List<MetodoPago>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(metodo: MetodoPago)

    @Query("DELETE FROM metodos_pago")
    suspend fun deleteAll()

    @Update
    suspend fun updateMetodo(metodo: MetodoPago)

    @Delete
    suspend fun deleteMetodo(metodo: MetodoPago)
}
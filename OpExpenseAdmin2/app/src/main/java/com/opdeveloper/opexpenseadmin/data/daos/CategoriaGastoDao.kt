package com.opdeveloper.opexpenseadmin.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.entitys.CategoryGasto

@Dao
interface CategoriaGastoDao {
    @Query("SELECT * from categoria_ingreso")
    fun getAllCategoria(): LiveData<List<CategoryGasto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(categoria: CategoryGasto)

    @Query("DELETE FROM categoria_gasto")
    suspend fun deleteAll()

    @Update
    suspend fun updateCategoria(categoria: CategoryGasto)

    @Delete
    suspend fun deleteCategoria(categoria: CategoryGasto)
}
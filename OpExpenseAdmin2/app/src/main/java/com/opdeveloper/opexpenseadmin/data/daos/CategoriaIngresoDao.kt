package com.opdeveloper.opexpenseadmin.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.entitys.CategoryIngreso
import com.opdeveloper.opexpenseadmin.data.entitys.Gasto
@Dao
interface CategoriaIngresoDao {
    @Query("SELECT * from categoria_gasto")
    fun getAllCategoria(): LiveData<List<CategoryIngreso>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(categoria: CategoryIngreso)

    @Query("DELETE FROM categoria_gasto")
    suspend fun deleteAll()

    @Update
    suspend fun updateCategoria(categoria: CategoryIngreso)

    @Delete
    suspend fun deleteCategoria(categoria: CategoryIngreso)
}
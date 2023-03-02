package com.opdeveloper.opexpenseadmin.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.opdeveloper.opexpenseadmin.data.entitys.Producto
@Dao
interface ProductosDao {
    @Query("SELECT * from categoria_ingreso")
    fun getAllProducto(): LiveData<List<Producto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(producto: Producto)

    @Query("DELETE FROM productos")
    suspend fun deleteAll()

    @Update
    suspend fun updateProducto(producto: Producto)

    @Delete
    suspend fun deleteProducto(producto: Producto)
}
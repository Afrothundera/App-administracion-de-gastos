package com.opdeveloper.opexpenseadmin.home.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import android.app.Application
import android.util.Log
import com.opdeveloper.opexpenseadmin.data.daos.CategoriaGastoDao
import com.opdeveloper.opexpenseadmin.data.daos.GastosDao
import com.opdeveloper.opexpenseadmin.data.dbroom.OpExpenseDBRoom
import com.opdeveloper.opexpenseadmin.data.entitys.CategoryGasto
import com.opdeveloper.opexpenseadmin.data.entitys.Gasto
import kotlinx.coroutines.CoroutineScope
import java.text.SimpleDateFormat
import java.util.*


class HomeRepository(private val gastosDao: GastosDao) {

    val gasatoMes: LiveData<List<Gasto>> = gastosDao.getGastoByFecha(getMes())



    suspend fun insert(gasto: Gasto) {
        gastosDao.insert(gasto)
    }

    fun getMes(): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 0)
        val date = calendar.time

        return date
    }


}
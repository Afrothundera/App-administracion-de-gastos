package com.opdeveloper.opexpenseadmin.home.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.opdeveloper.opexpenseadmin.data.dbroom.OpExpenseDBRoom
import com.opdeveloper.opexpenseadmin.data.entitys.CategoryGasto
import com.opdeveloper.opexpenseadmin.data.entitys.Gasto
import com.opdeveloper.opexpenseadmin.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {

    private val repository: HomeRepository

    var gastoMes : LiveData<List<Gasto>>

    init {
        val db = OpExpenseDBRoom.getDatabase(application.applicationContext, viewModelScope)
        val gastodao = db.gastosDao()
        val categoriaGastoDao = db.categoriaGastoDao()
        repository = HomeRepository(gastodao)
        gastoMes = repository.gasatoMes


    }

    fun insertGasto(gasto: Gasto) = viewModelScope.launch {
        repository.insert(gasto)
    }
}
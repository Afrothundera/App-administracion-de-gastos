package com.opdeveloper.opexpenseadmin.data.dbroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.opdeveloper.opexpenseadmin.R
import com.opdeveloper.opexpenseadmin.data.daos.*
import com.opdeveloper.opexpenseadmin.data.entitys.*
import com.opdeveloper.opexpenseadmin.data.util.DateConverter
import com.opdeveloper.opexpenseadmin.data.util.ObjectConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(
    Producto::class,
    CategoryGasto::class,
    CategoryIngreso::class,
    Gasto::class,
    Ingreso::class,
    MetodoPago::class), version = 1)
@TypeConverters(ObjectConverter::class, DateConverter::class)
abstract class OpExpenseDBRoom : RoomDatabase() {

    abstract fun gastosDao() : GastosDao
    abstract fun categoriaIngresoDao() : CategoriaIngresoDao
    abstract fun categoriaGastoDao() : CategoriaGastoDao
    abstract fun ingresosDao() : IngresosDao
    abstract fun metodoPagoDao() : MetodoPagoDao
    abstract fun productosDao() : ProductosDao

    companion object {

        @Volatile
        private var INSTANCE: OpExpenseDBRoom? = null

        fun getDatabase(context: Context, scope: CoroutineScope): OpExpenseDBRoom{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OpExpenseDBRoom::class.java,
                    "OpExpenseDb"
                ).addCallback(OpExpenseDBCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class OpExpenseDBCallback(
        private val scope:CoroutineScope

    ): RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE.let {database ->
                scope.launch {
                    var categoriaIngresoDao = database!!.categoriaIngresoDao()
                    var categoriaGastoDao = database.categoriaGastoDao()
                    var metodoPagoDao = database.metodoPagoDao()


                    categoriaIngresoDao.insert(CategoryIngreso(null, "Pagos", R.drawable.account_balance_white))
                    categoriaGastoDao.insert(CategoryGasto(null, "Mercado", R.drawable.add_shopping_cart_white))
                    metodoPagoDao.insert(MetodoPago(null, "Tarjeta de debito", 0.0, R.drawable.account_balance_wallet_white))

                }
            }
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)


        }
    }
}
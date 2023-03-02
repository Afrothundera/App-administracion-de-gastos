package com.opdeveloper.opexpenseadmin.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.opdeveloper.opexpenseadmin.MainActivity
import com.opdeveloper.opexpenseadmin.R
import com.opdeveloper.opexpenseadmin.home.Home
import com.opdeveloper.opexpenseadmin.intro.adapter.IntroViewPagerAdapter
import com.opdeveloper.opexpenseadmin.utils.CustomPreference
import kotlinx.android.synthetic.main.activity_intro.*
import kotlin.properties.Delegates

class IntroActivity : AppCompatActivity() {

    var adapter : IntroViewPagerAdapter? = null
    var position : Int = 0
    var positionold : Int = 0
    var anim: Animation? = null

    private lateinit var preferences: CustomPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_intro)

        supportActionBar!!.hide()
        preferences = CustomPreference(this)
        if (preferences.isFirstTimeLaunched()){
            val intent = Intent(this@IntroActivity, Home::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        val listIntro = mutableListOf<IntroItems>()
        listIntro.add(IntroItems("Hola bienvenido", "descripcion 1", R.drawable.img1))
        listIntro.add(IntroItems("Hola bienvenido", "descripcion 2", R.drawable.img2))
        listIntro.add(IntroItems("Hola bienvenido", "descripcion 3", R.drawable.img3))

        adapter = IntroViewPagerAdapter(this, listIntro)
        pagerIntro.adapter = adapter

        tabIntro.setupWithViewPager(pagerIntro)


        bntNext.setOnClickListener {
            position = pagerIntro.currentItem

            if (position < listIntro.size){
                positionold = position
                position++

                pagerIntro.currentItem = position
            }
            if (position == listIntro.size - 1){
                positionold = position
                loadGetStarted()

            }else{
                if (position == 1 && positionold != 0){
                    positionold = position
                    loadNextButton()
                }

            }
        }

        tabIntro.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                position = tab!!.position
                if (position == 0) positionold = position
                Log.v("Posicion", position.toString())
                if (tab!!.position < listIntro.size -1){

                    if (position == 1 && positionold != 0){
                        positionold = position
                        loadNextButton()
                    }
                }else{

                    positionold = position
                    loadGetStarted()
                }
            }
        })

        bntStart.setOnClickListener {
            val intent = Intent(this@IntroActivity, Home::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            preferences.setFirstTimeLaunch(true)
            finish()
        }
    }

    private fun loadGetStarted() {
        bntNext.visibility = View.INVISIBLE
        bntStart.visibility = View.VISIBLE
        tabIntro.visibility = View.INVISIBLE

        anim = AnimationUtils.loadAnimation(this, R.anim.button_anim)
        bntStart.animation = anim


    }

    private fun loadNextButton(){
        bntNext.visibility = View.VISIBLE
        bntStart.visibility = View.INVISIBLE
        tabIntro.visibility = View.VISIBLE
        if (position == 1){
            anim = AnimationUtils.loadAnimation(this, R.anim.tab_next_anim)
            bntNext.animation = anim
            tabIntro.animation = anim
        }

    }
}

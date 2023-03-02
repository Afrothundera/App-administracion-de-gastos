package com.opdeveloper.opexpenseadmin.intro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.opdeveloper.opexpenseadmin.R
import com.opdeveloper.opexpenseadmin.intro.IntroItems

class IntroViewPagerAdapter(val context: Context, var listScreen: MutableList<IntroItems>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflater = layoutInflater.inflate(R.layout.layout_intro_screen, null)

        val imageIntro = inflater.findViewById<ImageView>(R.id.intro_image)
        val textTitle = inflater.findViewById<TextView>(R.id.introTitle)
        val textDescripcion = inflater.findViewById<TextView>(R.id.textDescription)

        imageIntro.setImageResource(listScreen[position].introImage)
        textTitle.text = listScreen[position].title
        textDescripcion.text = listScreen[position].descripcion

        container.addView(inflater)

        return inflater
    }

    override fun getCount(): Int {
        return listScreen.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }
}
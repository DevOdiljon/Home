package com.example.fragmentgetargument

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initViews()
        initViewsBack()
    }

//    private fun initViews() {
//        addFirstFragment()
//    }

//    private fun addFirstFragment() {
//        var fragmentFirst = FragmentFirst.newInstance("Aji guji")
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.frameFirst, fragmentFirst, "firstFragment")
//            .commit()
//    }
    fun initViewsBack(){
        val btn_first = findViewById<Button>(R.id.btn_first)
        btn_first.setOnClickListener(View.OnClickListener { replaceFragment(FragmentFirst()) })
        val btn_second = findViewById<Button>(R.id.btn_second)
        btn_second.setOnClickListener(View.OnClickListener { replaceFragment(FragmentSecond()) })
        val btn_thrid = findViewById<Button>(R.id.btn_third)
        btn_thrid.setOnClickListener(View.OnClickListener { replaceFragment(FragmentThird()) })

    }

    private fun replaceFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.name
        val manager = supportFragmentManager
        val fragmentPopped = manager.popBackStackImmediate(backStateName,0)
        if (!fragmentPopped){
            val ft = manager.beginTransaction()
            ft.replace(R.id.framLayout, fragment)
            ft.addToBackStack(backStateName)
            ft.commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1){
            finish()
        }else {
            super.onBackPressed()
        }
    }
}
package com.decagon.warbler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val addBtn = findViewById<Button>(R.id.button)
        val removeBtn = findViewById<Button>(R.id.button2)

        // To add fragment to onclick listener
        addBtn.setOnClickListener{
            pushFragment()
        }

        // Remove fragment onclick listener
        removeBtn.setOnClickListener{
            supportFragmentManager.popBackStack()
        }

    }


    private fun pushFragment(){
        val fragment: Fragment
        val bundle = Bundle()
        val count = supportFragmentManager.backStackEntryCount
        bundle.putInt("count", count+1)

        when(count){
            0 -> {
                fragment = FragmentOne()
                fragment.setArguments(bundle)
            }
            1 -> {
                fragment = FragmentTwo()
                fragment.setArguments(bundle)
            }
            2 -> {
                fragment = FragmentThree()
                fragment.setArguments(bundle)
            }
            else -> return
        }
        supportFragmentManager.beginTransaction().replace(R.id.second_layout, fragment).addToBackStack(null).commit()
//        supportFragmentManager.beginTransaction().add(R.id.second_layout, fragment).addToBackStack(null).commit()
    }
    // return to prev task method

}
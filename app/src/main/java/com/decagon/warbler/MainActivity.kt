package com.decagon.warbler

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    var landscapeCounter = 0
    var portraitCounter = 0
    var states = ""


    //    private  val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orientStatus = resources.configuration.orientation

    val landscapeCount = findViewById<TextView>(R.id.landscape_count)
    val portrateCount = findViewById<TextView>(R.id.portrait_count)

        if (savedInstanceState != null){
            landscapeCounter = savedInstanceState.getInt("landscapeCounter")
            portraitCounter = savedInstanceState.getInt("portraitCounter")

            if (orientStatus == Configuration.ORIENTATION_LANDSCAPE){
                landscapeCounter += 1
                //change text
                landscapeCount.text = landscapeCounter.toString()
                portrateCount.text= portraitCounter.toString()
            }else{
                portraitCounter += 1
                // change text
                portrateCount.text= portraitCounter.toString()
                landscapeCount.text = landscapeCounter.toString()

            }
        }else{
            landscapeCount.text = landscapeCounter.toString()
            portraitCounter += 1
            portrateCount.text= portraitCounter.toString()
        }

        states = "onCreate\n"
        var textStatus = findViewById<TextView>(R.id.txt_state)
        textStatus.text = states

        var btnNav = findViewById<Button>(R.id.btnNav)

        btnNav.setOnClickListener{
            navigateAcitvity()
        }
    }
    override fun onStart() {
        super.onStart()
        states += "onStart\n"
        var textStatus = findViewById<TextView>(R.id.txt_state)
        textStatus.text = states
    }

    override fun onResume() {
        super.onResume()
        var textStatus = findViewById<TextView>(R.id.txt_state)
        states+="onResume\n"
        textStatus.text = states
    }

    override fun onPause() {
        super.onPause()
        var textStatus = findViewById<TextView>(R.id.txt_state)
        states+="onPause\n"
        textStatus.text = states
    }

    override fun onStop() {
        super.onStop()
        var textStatus = findViewById<TextView>(R.id.txt_state)
        states+="onStop\n"
        textStatus.text = states
    }

    override fun onRestart() {
        super.onRestart()
        var textStatus = findViewById<TextView>(R.id.txt_state)
        states+="onRestart\n"
        textStatus.text = states
    }

    override fun onDestroy() {
        super.onDestroy()
        var textStatus = findViewById<TextView>(R.id.txt_state)
        states+="onDestroy\n"
        textStatus.text = states
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("landscapeCounter", landscapeCounter)
        outState.putInt("portraitCounter", portraitCounter)
    }

    private fun navigateAcitvity(){
        val intent = Intent(this, SecondActivity::class.java) //Explicit Activity
        startActivity(intent)
    }
}







/*
        if (savedInstanceState != null){
            landscapeCounter = savedInstanceState.getInt("landscapeCounter")
            portraitCounter = savedInstanceState.getInt("portraitCounter")
            showTextView("onCreate")
        }

//        var btn: Button = findViewById<Button>(R.id.btnPlay)

//        btn.setOnClickListener{
////            var i = Intent(this, fragmentActivity::class.java)
//
//            startActivity(i)
//        }

        val monitor: Runnable = Runnable {
            showTextView("onCreate")
        }

        handler.postDelayed(monitor, 2000)

//        kotlin.run {
//            orientation.text = "onCreate"
//        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun showTextView (currentState: String){
        val stateView = findViewById<TextView>(R.id.orientation_count)
        val orientationView = findViewById<TextView>(R.id.orientation)

        stateView.text = currentState
        orientationView.text = landscapeCounter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt()
    }*/
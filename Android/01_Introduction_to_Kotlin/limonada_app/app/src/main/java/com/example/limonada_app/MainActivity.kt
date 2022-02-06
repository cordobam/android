package com.example.limonada_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var lemonSize: Int = 0
    private var squeezeCount: Int = 0
    private var inner_state = " "

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagePress: ImageView = findViewById(R.id.img_limonada)
        imagePress.setImageResource(R.drawable.lemon_tree)
        var initial_state:String = "SELECT"
        var textView : TextView = findViewById(R.id.textView_) as TextView
        textView.text = "Haz clic para seleccionar un limón."
        imagePress.setOnClickListener(){
            var state: String = clickLemonImage(initial_state)
            initial_state = state
            setViewElements(state)
        }
    }



    private fun clickLemonImage(state: String): String {
        if (state == "SELECT"){
            lemonSize = 3
            inner_state = "SQUEEZE"
        }
        else if (state == "SQUEEZE"){
            squeezeCount += 1
            lemonSize -= 1
            if (lemonSize == 0){
                inner_state = "DRINK"
            }
        }
        else if (state == "DRINK"){
            inner_state = "RESTART"
        }
        else if (state == "RESTART"){
            inner_state = "SELECT"
        }
        return inner_state


    }

    private fun setViewElements(state: String){
        val imagePress: ImageView = findViewById(R.id.img_limonada)
        var textView_ : TextView = findViewById(R.id.textView_) as TextView
        if (state == "SELECT"){
            imagePress.setImageResource(R.drawable.lemon_tree)
            textView_.text = "Haz clic para seleccionar un limón."
        }
        else if (state == "SQUEEZE") {
            imagePress.setImageResource(R.drawable.lemon_squeeze)
            textView_.text = " Haz clic para exprimir el limón."
        }
        else if (state == "DRINK") {
            imagePress.setImageResource(R.drawable.lemon_drink)
            textView_.text = "Haz clic para beber la limonada."
        }
        else if (state == "RESTART") {
            imagePress.setImageResource(R.drawable.lemon_restart)
            textView_.text = "Haz clic para comenzar de nuevo."
        }
    }
}
package com.example.launchitsankari.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun numClick(view:View) {
        val buClicked = view as Button

        var etStr = et.text.toString()

        when (buClicked) {
            bt1 -> etStr += "1"
            bt2 -> etStr += "2"
            bt3 -> etStr += "3"
            bt4 -> etStr += "4"
            bt5 -> etStr += "5"
            bt6 -> etStr += "6"
            bt7 -> etStr += "7"
            bt8 -> etStr += "8"
            bt9 -> etStr += "9"
            bt0 -> etStr += "0"
            btDot -> etStr += "."
        }
        et.setText(etStr)
        et.setSelection(etStr.length)
    }

    fun clearText(view:View){
        et.setText(" ")
    }

    var op1="0"
    var operation:String = "add"

    fun doOperation(view:View){

        val opSel = view as Button

        when(opSel.text){
            "+" -> operation = "add"
            "-" -> operation = "sub"
            "*" -> operation = "mul"
            "/" -> operation = "div"

        }
        op1 = et.text.toString()
        et.setText("")
    }

    fun showResult(view:View){
        var op2 = et.text.toString().toDouble()
        var result = 0.0

        when(operation){
            "add" ->  result = op1.toString().toDouble() + op2
            "sub" ->  result = op1.toString().toDouble() - op2
            "mul" ->  result = op1.toString().toDouble() * op2
            "div" ->  {
                if (op2.toString().toDouble() != 0.0)
                    result = op1.toString().toDouble() / op2
            }
        }

        et.setText(result.toString())
    }

}

package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener {

    private var variableFirst = 0.0
    private var variableSecond = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonPoint.setOnClickListener(this)
    }

    fun equal(view: View){
        val value = resultTextview.text.toString()
        if (value.isNotEmpty()){
            variableSecond = value.toDouble()
            operation()
        }
    }

    private fun operation(){
        var result = 0.0
        if(operation ==  ":"){
            result = variableFirst / variableSecond
            resultTextview.text = result.toString()
        }else if (operation == "+"){
            result = variableFirst + variableSecond
            resultTextview.text = result.toString()
        }else if (operation == "x"){
            result = variableFirst * variableSecond
            resultTextview.text = result.toString()
        }else if (operation == "-"){
            result = variableFirst - variableSecond
            resultTextview.text = result.toString()
        }

    }

    fun add(view: View){
        val value = resultTextview.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = resultTextview.text.toString().toDouble()
            operation = "+"
            resultTextview.text = ""
        }

    }

    fun multiply(view: View){
        val value = resultTextview.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = resultTextview.text.toString().toDouble()
            operation = "x"
            resultTextview.text = ""
        }
    }

    fun substract(view: View) {
        val value: String = resultTextview.text.toString()
        if (value.isNotEmpty()) {
            variableFirst = value.toDouble()
            operation = "+"
            resultTextview.text = ""
        }
    }


    fun divide(view: View){
        val value = resultTextview.text.toString()
        if (value.isNotEmpty())
            variableFirst = resultTextview.text.toString().toDouble()
        operation = ":"
        resultTextview.text = ""

    }

    fun delete(view:View){
        val value = resultTextview.text.toString()
        if (value.isNotEmpty())
            resultTextview.text = value.substring(0, value.length - 1)
    }

    override fun onClick(v: View?) {
        val button : Button = v as Button
        resultTextview.text = resultTextview.text.toString() + button.text.toString()
    }
}
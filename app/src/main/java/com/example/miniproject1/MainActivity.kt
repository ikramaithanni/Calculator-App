package com.example.miniproject1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //functions
         fun addToinputText(buttonValue : String): String {
            return "${input.text}$buttonValue"
        }
        fun getInputValue() : String{
            var exp = input.text.replace(Regex("÷"),"/")
            exp = exp.replace(Regex("×"),"*")
            return exp
        }
        fun showResult(){
            try {
                val expression = getInputValue()
                val result = Expression(expression).calculate()
                if(result.isNaN()){
                    //error Message
                    output.text = "ERROR !"
                    output.setTextColor(ContextCompat.getColor(this,R.color.red))
                }else{
                    //result
                    output.text = DecimalFormat("0.######").format(result).toString()
                    output.setTextColor(ContextCompat.getColor(this,R.color.green))
                }
            }catch (e : java.lang.Exception){
                //show error
                output.text = "ERROR !"
                output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }

        }


        button_clear.setOnClickListener{
            input.text = " "
            output.text = " "

        }
        button_bracket_left.setOnClickListener{
            input.text = addToinputText("(")
        }
        button_bracket_right.setOnClickListener{
            input.text = addToinputText(")")
        }
        button_0.setOnClickListener{
            input.text = addToinputText("0")
        }
        button_1.setOnClickListener{
            input.text = addToinputText("1")
        }
        button_2.setOnClickListener{
            input.text = addToinputText("2")
        }
        button_3.setOnClickListener{
            input.text = addToinputText("3")
        }
        button_4.setOnClickListener{
            input.text = addToinputText("4")
        }
        button_5.setOnClickListener{
            input.text = addToinputText("5")
        }
        button_6.setOnClickListener{
            input.text = addToinputText("6")
        }
        button_7.setOnClickListener{
            input.text = addToinputText("7")
        }
        button_8.setOnClickListener{
            input.text = addToinputText("8")
        }
        button_9.setOnClickListener{
            input.text = addToinputText("9")
        }
        button_comma.setOnClickListener {
            input.text = addToinputText(",")
        }
        butto_bracket_moins.setOnClickListener {
            input.text = addToinputText("(-")
        }
        button_division.setOnClickListener {
            input.text = addToinputText("÷")
        }
        button_multuplication.setOnClickListener {
            input.text = addToinputText("×")
        }
        button_plus.setOnClickListener {
            input.text = addToinputText("+")
        }
        button_moin.setOnClickListener {
            input.text = addToinputText("-")
        }
        button_equal.setOnClickListener {
            showResult()
        }


    }
}
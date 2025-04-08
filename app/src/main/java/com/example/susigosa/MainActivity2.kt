package com.example.susigosa

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.susigosa.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(){
    lateinit var binding: ActivityMain2Binding
    var first : String = ""
    var second : String = ""
    var operator: String = ""
    var check = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "계산기1"

        fun colorchange(button: Button){
            button.setOnTouchListener { v, event ->
                when(event.action){
                    MotionEvent.ACTION_DOWN-> v.setBackgroundColor(Color.RED)
                    MotionEvent.ACTION_UP-> v.setBackgroundColor(Color.BLUE)
                }
                false
            }
        }

        fun calnum(button: Button){
            if(check == true){
                if(button.text.toString() == "0"){
                    return
                }else{
                first += button.text.toString()}
            }
            else{
                if(button.text.toString() == "0"){
                    return
                }else{
                    second += button.text.toString()}
            }
            binding.inputscreen.text = binding.inputscreen.text.toString() + button.text.toString()
        }
        fun calop(button: Button){
            if(button.text.toString() == "="){
                val num1 = first.toIntOrNull() ?: return
                val num2 = second.toIntOrNull() ?: return
                val resultText = when (operator) {
                    "+" -> "$first + $second = ${num1 + num2}"
                    "-" -> "$first - $second = ${num1 - num2}"
                    "/" -> "$first / $second = ${num1 / num2}"
                    "x" -> "$first x $second = ${num1 * num2}"
                    else -> "0"
                }
                val intent = Intent()
                intent.putExtra("result",resultText)
                setResult(RESULT_OK, intent)
                finish()
            }
            else {
                check = false
                operator = button.text.toString()
                binding.inputscreen.text =
                    binding.inputscreen.text.toString() + button.text.toString()
            }
        }
        binding.bt0.setOnClickListener {
            calnum(binding.bt0)
        }
        binding.bt1.setOnClickListener {
            calnum(binding.bt1)
        }
        binding.bt2.setOnClickListener {
            calnum(binding.bt2)
        }
        binding.bt3.setOnClickListener {
            calnum(binding.bt3)
        }
        binding.bt4.setOnClickListener {
            calnum(binding.bt4)
        }
        binding.bt5.setOnClickListener {
            calnum(binding.bt5)
        }
        binding.bt6.setOnClickListener {
            calnum(binding.bt6)
        }
        binding.bt7.setOnClickListener {
            calnum(binding.bt7)
        }
        binding.bt8.setOnClickListener {
            calnum(binding.bt8)
        }
        binding.bt9.setOnClickListener {
            calnum(binding.bt9)
        }
        binding.btplus.setOnClickListener {
            calop(binding.btplus)
        }
        binding.btmiu.setOnClickListener {
            calop(binding.btmiu)
        }
        binding.btmul.setOnClickListener {
            calop(binding.btmul)
        }
        binding.btdiv.setOnClickListener {
            calop(binding.btdiv)
        }

        binding.btequl.setOnClickListener {
            calop(binding.btequl)
        }
        colorchange(binding.bt0)
        colorchange(binding.bt1)
        colorchange(binding.bt2)
        colorchange(binding.bt3)
        colorchange(binding.bt4)
        colorchange(binding.bt5)
        colorchange(binding.bt6)
        colorchange(binding.bt7)
        colorchange(binding.bt8)
        colorchange(binding.bt9)
        colorchange(binding.btplus)
        colorchange(binding.btmiu)
        colorchange(binding.btdiv)
        colorchange(binding.btmul)
        colorchange(binding.btequl)
    }

}
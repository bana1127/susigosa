package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityFixBinding
import com.example.myapplication.databinding.ActivityMainBinding

class fixActivity : AppCompatActivity() {
    lateinit var binding: ActivityFixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFixBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "개인 정보 수정"
        setSupportActionBar(binding.toolbar)

        val name = intent.getStringExtra("name")
        val major = intent.getStringExtra("major")
        val num = intent.getStringExtra("num")
        binding.numf.setText(num)
        binding.majorf.setText(major)
        binding.namef.setText(name)

        binding.infoCheck.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN->{v.setBackgroundColor(Color.RED)}
                MotionEvent.ACTION_UP->{v.setBackgroundColor(Color.BLUE)}
            }
            false
        }
        binding.infoCheck.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name",binding.namef.text.toString())
            intent.putExtra("num",binding.numf.text.toString())
            intent.putExtra("major",binding.majorf.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}
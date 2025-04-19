package com.example.myapplication

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityAnimationBinding
import com.example.myapplication.databinding.ActivityImageBinding
import kotlin.concurrent.thread

class AnimationActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationBinding
    var bstart: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "애니메이션"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.stop.isEnabled = false
        binding.reset.isEnabled = false

        binding.start.setOnClickListener {
            binding.image.visibility = View.VISIBLE
            binding.start.isEnabled = false
            binding.stop.isEnabled = true
            binding.reset.isEnabled = true
            bstart = true

            thread {
                while(bstart){
                    SystemClock.sleep(100)
                    runOnUiThread {
                        moveIamge()
                    }
                }
            }
        }

        binding.stop.setOnClickListener {
            bstart = false
            binding.stop.isEnabled = true
            binding.start.text = "재시작"
            binding.start.isEnabled = false
        }
        binding.reset.setOnClickListener {
            bstart = false
            binding.image.x = 0f
            binding.image.y = 0f
            binding.reset.isEnabled = false
            binding.stop.isEnabled = false
            binding.start.text = "시작"
            binding.start.isEnabled = true
        }
    }
    fun moveIamge(){
        val step = 100f
        binding.image.y += step
        binding.image.x += step

        if(binding.image.x > binding.frame.width - binding.image.width){
            binding.image.x = 0f
        }
        if(binding.image.y > binding.frame.height - binding.image.height){
            binding.image.y = 0f
        }
    }
}
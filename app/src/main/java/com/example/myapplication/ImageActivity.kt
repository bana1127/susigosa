package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "ImageMover"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.cup.setOnClickListener {
            binding.imagev.y -= 100f
            if(binding.imagev.y < 0f){
                binding.imagev.y = 0f
            }
        }

        binding.cdown.setOnClickListener {
            binding.imagev.y += 100f
            val maxY = binding.frame.height - binding.imagev.height
            if(binding.imagev.y > maxY){
                binding.imagev.y = maxY.toFloat()
            }
        }

        binding.cleft.setOnClickListener {
            binding.imagev.x -= 100f
            if(binding.imagev.x < 0f){
                binding.imagev.x = 0f
            }
        }

        binding.cright.setOnClickListener {
            binding.imagev.x += 100f
            val maxX = binding.frame.width - binding.imagev.width
            if(binding.imagev.x > maxX){
                binding.imagev.x = maxX.toFloat()
            }
        }
    }
}
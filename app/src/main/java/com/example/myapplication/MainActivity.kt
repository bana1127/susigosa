package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val namedata = it.data?.getStringExtra("name")
        val majordata = it.data?.getStringExtra("major")
        val numdata = it.data?.getStringExtra("num")

        if(numdata != null || majordata != null || namedata != null){
            binding.num.text = numdata
            binding.major.text = majordata
            binding.name.text = namedata
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "중간고사"
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.animation->{startActivity(Intent(this, AnimationActivity::class.java))}
            R.id.imagemover->{startActivity(Intent(this, ImageActivity::class.java))}
            R.id.fix->{
                val intent = Intent(this, fixActivity::class.java)
                intent.putExtra("name",binding.name.text.toString())
                intent.putExtra("major",binding.major.text.toString())
                intent.putExtra("num",binding.num.text.toString())
                requestLauncher.launch(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
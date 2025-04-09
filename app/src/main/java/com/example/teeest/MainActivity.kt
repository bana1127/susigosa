package com.example.teeest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.teeest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        val resultdata = it.data?.getStringExtra("result")
        if (resultdata != null) {
            binding.mainresult.visibility = View.VISIBLE
            binding.mainresult.text = "수식 : $resultdata"
        } else {
            binding.mainresult.visibility = View.INVISIBLE
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "수시고사"

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val menuItem = menu?.findItem(R.id.search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu1 -> {
                val intent = Intent(this, MainActivity2::class.java)
                requestLauncher.launch(intent)
            }
            R.id.menu2 -> {
                val intent = Intent(this, MainActivity3::class.java)
                requestLauncher.launch(intent)
            }
            R.id.menu3 -> {
                val intent = Intent(this, MainActivity4::class.java)
                requestLauncher.launch(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
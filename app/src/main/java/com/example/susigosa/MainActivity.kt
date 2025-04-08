package com.example.susigosa

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.susigosa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
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


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchItem = menu?.findItem(R.id.검색)
        val searchview = searchItem?.actionView as? SearchView

        searchview?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                searchview.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }


        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cal1 -> {
                val intent = Intent(this, MainActivity2::class.java)
                requestLauncher.launch(intent)
            }
            R.id.cal2 -> {
                val intent = Intent(this, MainActivity3::class.java)
                requestLauncher.launch(intent)
            }
            R.id.newa -> {
                val intent = Intent(this, MainActivity4::class.java)
                requestLauncher.launch(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
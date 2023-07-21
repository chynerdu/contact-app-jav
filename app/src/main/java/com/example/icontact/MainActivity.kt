package com.example.icontact

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.icontact.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = ContactAdapter( arrayOf(
            Contacts("Chinedu Uche", "7054119095"),
            Contacts("Kelvin Junior", "8473445789"),
            Contacts("Felix Don", "987336782"),
        ))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter



        binding.floatingActionButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, CreateContactsActivity::class.java)
            startActivity(intent);
        })

//        binding.floatingActionButton.setOnClickListener(
//            object : View.OnClickListener() {
//                fun onClick(v: View?) {
//                    val i = Intent(this@MainActivity, MainActivity2::class.java)
//                    startActivity(i)
//                }
//            }
//        )


    }
//
//    var onClickListener: View.OnClickListener = object : View.OnClickListener() {
//        fun onClick(v: View?) {
//            startActivity(Intent(action))
//        }
//    }
}


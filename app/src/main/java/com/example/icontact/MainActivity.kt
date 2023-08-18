package com.example.icontact
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.icontact.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CreateContactsActivity.contactList
        adapter.setOnClickListener(object :
            ContactAdapter.OnClickListener {
            override fun onClick(position: Int, model: Contacts) {
                val intent = Intent(this@MainActivity, ContactDetails::class.java)
                intent.putExtra("NEXT_SCREEN", position)
                startActivity(intent)
            }
        })

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


        binding.floatingActionButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, CreateContactsActivity::class.java)
            startActivity(intent);
        })

    }

    override fun onRestart() {
        super.onRestart()
        val adapter = CreateContactsActivity.contactList

    }


}


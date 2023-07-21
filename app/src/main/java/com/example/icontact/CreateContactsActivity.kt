package com.example.icontact

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.icontact.databinding.ActivityMainBinding

class CreateContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun onCancelContactClicked(v: View?) {
        val intent = Intent(this@CreateContactsActivity, MainActivity::class.java)
        startActivity(intent);
    }
}
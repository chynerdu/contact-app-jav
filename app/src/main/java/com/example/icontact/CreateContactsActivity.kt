package com.example.icontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateContactsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_contacts)
    }
    fun onCancelContactClicked(v: View?) {
        finish();
//        val intent = Intent(this@CreateContactsActivity, MainActivity::class.java)
//        startActivity(intent);
    }
}
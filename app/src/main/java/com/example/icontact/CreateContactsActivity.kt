package com.example.icontact

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.icontact.databinding.CreateContactsBinding
import com.google.android.material.snackbar.Snackbar

class CreateContactsActivity : AppCompatActivity() {
    private lateinit var binding: CreateContactsBinding

    companion object {

        var contactsList1 = mutableListOf(
            Contacts("Chinedu2 Uche", "7054119095"),
            Contacts("Kelvin Junior", "8473445789"),
            Contacts("Felix Don", "987336782"),
            Contacts("Jerry Gerald", "7069119095"),
            Contacts("Hakimi Habibi", "8473409789"),
            Contacts("Tom Cruise", "987226782"),
        )
        var contactList = ContactAdapter( contactsList1)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onCancelContactClicked(v: View?) {
        finish();

    }

    fun onAddContactClicked(view: View) {
        try {

            val rawName = findViewById<View>(binding.editTextName.id) as EditText
            var name = rawName.text.toString()
            val rawPhone = findViewById<View>(binding.editTextPhone.id) as EditText
            var phone = rawPhone.text.toString()

            if (name == "" || phone == "" ) {
                var snackbar: Snackbar
                snackbar = Snackbar.make(view, "Enter all fields", Snackbar.LENGTH_SHORT);
                val snackBarView = snackbar.view
                snackBarView.setBackgroundColor(Color.parseColor("#FF0000"))
                snackbar.show()
            } else if (phone.length < 10) {
                var snackbar: Snackbar
                snackbar = Snackbar.make(view, "Phone must be 10 digits", Snackbar.LENGTH_SHORT);
                val snackBarView = snackbar.view
                snackBarView.setBackgroundColor(Color.parseColor("#FF0000"))
                snackbar.show()
            }
            else {
                contactsList1.add(Contacts(name, phone))
                finish()
            }

        } catch(e:NumberFormatException) {
            var snackbar: Snackbar
            snackbar = Snackbar.make(view, "Something is not right, check value entered", Snackbar.LENGTH_SHORT);
            val snackBarView = snackbar.view
            snackBarView.setBackgroundColor(Color.parseColor("#FF0000"))
            snackbar.show()
        }
    }
}
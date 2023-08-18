
package com.example.icontact
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.icontact.databinding.ContactDetailsBinding
import com.google.android.material.snackbar.Snackbar

class ContactDetails : AppCompatActivity() {

    private lateinit var binding: ContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ContactDetailsBinding.inflate(layoutInflater)

        val adapter = CreateContactsActivity.contactsList1
        setContentView(binding.root)
        val bundle = intent.extras



        var contactlist: Contacts?=null
        // checking if the intent has extra
        println(bundle?.getInt("NEXT_SCREEN"))
        if(bundle?.getInt("NEXT_SCREEN") != null){

           var position = bundle.getInt("NEXT_SCREEN")
            contactlist = adapter[position]

        }

        if(contactlist!=null){
            binding?.displayName?.text=contactlist!!.name // displaying name
            binding?.displayPhone?.text=contactlist!!.phone // displaying phone
        }

    }

    fun onDeleteContactClicked(v: View) {
        val bundle = intent.extras
        if(bundle?.getInt("NEXT_SCREEN") != null) {

            CreateContactsActivity.contactsList1.removeAt(bundle.getInt("NEXT_SCREEN"))
            finish()
                val i = Intent(this, MainActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)

        }
        else {
            var snackbar: Snackbar
            snackbar = Snackbar.make(v, "Opps! Something went wrong.", Snackbar.LENGTH_SHORT);
            val snackBarView = snackbar.view
            snackBarView.setBackgroundColor(Color.parseColor("#FF0000"))
            snackbar.show()
        }

    }
}

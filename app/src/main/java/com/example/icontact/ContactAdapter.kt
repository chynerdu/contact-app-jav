package com.example.icontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Contacts (

    var name : String,
    var phone : String
)

class ContactAdapter(private val contact: Array<Contacts>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    //Implementation of the ViewHolder Class
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val phonenumberTextView: TextView

        init {
            nameTextView = view.findViewById(R.id.contactName)
            phonenumberTextView = view.findViewById(R.id.contactNumber)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create new view with UI of weather item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set element from weather data [using position] to TextView
        holder.nameTextView.text = contact[position].name
        holder.phonenumberTextView.text = contact[position].phone
    }

    override fun getItemCount(): Int {
        return contact.size
    }
}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.icontact.Contacts
import com.example.icontact.R



class ItemAdapter(
    private val items: ArrayList<Contacts>
) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null

    // Inflates the item views which is designed in xml layout file
    // create a new
    // ViewHolder and initializes some private fields to be used by RecyclerView.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_item, parent, false)
            )

    }

    // Binds each item in the ArrayList to a view

    // Called when RecyclerView needs
    // a new {@link ViewHolder} of the
    // given type to represent
    // an item.

    // This new ViewHolder should be constructed with
    // a new View that can represent the items
    // of the given type. You can either create a
    // new View manually or inflate it from an XML
    // layout file.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.phonenumberTextView.text = item.phone
        // Finally add an onclickListener to the item.
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, item )
            }
        }
    }

    // Gets the number of items in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // A function to bind the onclickListener.
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: Contacts)
    }

    // A ViewHolder describes an item view and metadata
    // about its place within the RecyclerView.
//    class ViewHolder(binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root) {
//        // Holds the TextView that
//        // will add each item to
//        val tvName = binding.tvName
//        val tvEmail = binding.tvEmail
//    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val phonenumberTextView: TextView

        init {
            nameTextView = view.findViewById(R.id.contactName)
            phonenumberTextView = view.findViewById(R.id.contactNumber)
//            itemView.setOnClickListener(this);

        }
    }
}
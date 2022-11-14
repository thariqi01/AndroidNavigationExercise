package thariqi.ruli.androidnavigationexercisebyruli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val list: ArrayList<Users>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postResponse: Users) {
            with(itemView){
                val text = "ID : ${postResponse.id}\n" +
                        "Email : ${postResponse.email}\n" +
                        "First Name : ${postResponse.first_name}\n" +
                        "Last Name  : ${postResponse.last_name}\n"
                val tvText = findViewById<TextView>(R.id.tvText)
                tvText.text = text
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
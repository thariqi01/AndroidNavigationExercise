package thariqi.ruli.androidnavigationexercisebyruli

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdFragment : Fragment() {

    private val list = ArrayList<Users>()
    private lateinit var a: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        a = inflater.inflate(R.layout.fragment_third, container, false)
        showProducts()
        return a
    }

    private fun showProducts() {
        val tvResponseCode = a.findViewById<TextView>(R.id.tvResponseCode)
        val rvPost = a.findViewById<RecyclerView>(R.id.rvPost)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(activity)
        RetrofitClient.instance.getProducts().enqueue(object: Callback<UsersResponse> {
            override fun onResponse(
                call: Call<UsersResponse>,
                response: Response<UsersResponse>
            ) {
                tvResponseCode.text = response.code().toString()
                val listResponse = response.body()?.data
                listResponse?.let { list.addAll(it)}
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                tvResponseCode.text = t.message
            }

        })
    }

}
package es.unex.pruebaexamen1

// MainActivity.kt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.unex.pruebaexamen1.api.RetrofitClient
import es.unex.pruebaexamen1.data.api.Issue
import es.unex.pruebaexamen1.view.IssuesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: IssuesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = IssuesAdapter(emptyList())
        recyclerView.adapter = adapter

        fetchIssues()
    }

    private fun fetchIssues() {
        RetrofitClient.apiService.getIssues().enqueue(object : Callback<List<Issue>> {
            override fun onResponse(call: Call<List<Issue>>, response: Response<List<Issue>>) {
                if (response.isSuccessful) {
                    adapter = IssuesAdapter(response.body()!!)
                    recyclerView.adapter = adapter
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<Issue>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}

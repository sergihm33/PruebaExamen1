package es.unex.pruebaexamen1.api

// ApiService.kt
import es.unex.pruebaexamen1.data.api.Issue
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// RetrofitClient.kt
import com.google.gson.GsonBuilder
import es.unex.pruebaexamen1.data.api.IssueDescription
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://git.eclipse.org/r/"

    private val gson = GsonBuilder().setLenient().create()
    private val okHttpClient = OkHttpClient.Builder().build()

    val apiService: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)
}

interface ApiService {
    @GET("changes/?q=status:open")
    fun getIssues(): Call<List<Issue>>

    @GET("{number}/")
    fun getIssueDescription(@Path("number") number: Int): Call<IssueDescription>

}
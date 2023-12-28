package local.id.suitmediatest

import ApiService
import RetrofitClient
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ThirdScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        val apiService: ApiService = RetrofitClient.apiService

        val call: Call<List<ResponseUser>> = apiService.getUsers(1, 10)

        call.enqueue(object : Callback<List<ResponseUser>> {
            override fun onResponse(
                call: Call<List<ResponseUser>>,
                response: Response<List<ResponseUser>>
            ) {
                if (response.isSuccessful) {
                    val userList: List<ResponseUser>? = response.body()
                } else {
                }
            }

            override fun onFailure(call: Call<List<ResponseUser>>, t: Throwable) {
            }
        })
    }
}

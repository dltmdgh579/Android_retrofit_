package com.example.myapplication
import kotlinx.android.synthetic.main.activity_main.*

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpCookie.parse
import java.net.URLEncoder
import java.util.logging.Level.parse

class MainActivity : AppCompatActivity() {
    var login:Send_test? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit = Retrofit.Builder()
                .baseUrl("http://52.78.96.19:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var serverTest: Server_test = retrofit.create(Server_test::class.java)


        button.setOnClickListener{
            var text1 = editText.text.toString()
//            var text2 = String("한글 왜 안돼".toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
            var text2 = "카카오톡 유료화"

            serverTest.requestServer(text2).enqueue(object: Callback<Send_test> {
                override fun onFailure(call: Call<Send_test>, t: Throwable) {
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()
                }

                override fun onResponse(call: Call<Send_test>, response: Response<Send_test>) {
                    var send_test = response.body()
                    Log.d("LOGIN","msg : "+send_test?.response)
                    Log.d("LOGIN","msg : "+send_test?.NaverTitle)
                    Log.d("LOGIN","msg : " + send_test!!.NaverTitle.slice(1..3))

                    val arraylist = send_test!!.NaverTitle
                    for (i in 0..arraylist.size-1){
                        Log.d("LOGIN", "msg : " + arraylist.slice(i..i))
                    }

                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle(send_test?.response)
                    dialog.setMessage(send_test?.response)
                    dialog.show()
                }
            })
        }
    }
}
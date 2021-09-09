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
                .baseUrl("http://13.124.235.42:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var serverTest: Server_test = retrofit.create(Server_test::class.java)
        var kakaoTest: Kakao_Send = retrofit.create(Kakao_Send::class.java)


        button.setOnClickListener{
            var text1 = editText.text.toString()
//            var text2 = String("한글 왜 안돼".toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
            var text2 = "카카오톡 유료화"
            var nolist = "검색 결과가 없습니다."

            serverTest.requestServer(text1).enqueue(object: Callback<Send_test> {
                override fun onFailure(call: Call<Send_test>, t: Throwable) {
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()
                }

                override fun onResponse(call: Call<Send_test>, response: Response<Send_test>) {
                    var send_test = response.body()
                    try {
                        Log.d("LOGIN","msg : "+send_test?.response)
                        Log.d("LOGIN","msg : "+send_test?.NaverTitle)

                        val arraylist = send_test!!.NaverTitle
                        for (i in 0..arraylist.size-1){
                            Log.d("LOGIN", "msg : " + arraylist.slice(i..i))
                            Log.d("LOGIN", "msg : " + arraylist.get(i))
                        }

                        var dialog = AlertDialog.Builder(this@MainActivity)
                        dialog.setTitle(send_test?.response)
                        dialog.setMessage(arraylist.get(0))
                        dialog.show()
                    } catch (e: Exception){
                        Log.d("LOGIN", "msg : " + nolist)
                    }
                }
            })
        }


        button2.setOnClickListener{
            var text1 = editText.text.toString()
//            var text2 = String("한글 왜 안돼".toByteArray(Charsets.ISO_8859_1), Charsets.UTF_8)
            var text2 = "카카오톡 유료화"
            var nolist = "검색 결과가 없습니다."

            kakaoTest.requestServer(text1).enqueue(object: Callback<Kakao_requests> {
                override fun onFailure(call: Call<Kakao_requests>, t: Throwable) {
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()
                }

                override fun onResponse(call: Call<Kakao_requests>, response: Response<Kakao_requests>) {
                    var send_test = response.body()
                    try {
                        Log.d("LOGIN","msg : "+send_test?.response)
                        Log.d("LOGIN","msg : "+send_test?.objectivity)
                        Log.d("LOGIN","msg : "+send_test?.NaverTitle)

                        val arraylist = send_test!!.NaverTitle
                        for (i in 0..arraylist.size-1){
                            Log.d("LOGIN", "msg : " + arraylist.slice(i..i))
                            Log.d("LOGIN", "msg : " + arraylist.get(i))
                        }

                        var dialog = AlertDialog.Builder(this@MainActivity)
                        dialog.setTitle(send_test?.response)
                        dialog.setMessage(send_test?.objectivity)
                        dialog.show()
                    } catch (e: Exception){
                        Log.d("LOGIN", "msg : " + nolist)
                    }
                }
            })
        }
    }
}
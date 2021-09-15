package com.example.myapplication
import kotlinx.android.synthetic.main.activity_main.*

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding
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

//    var login:Send_test? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var retrofit = Retrofit.Builder()
                .baseUrl("http://13.124.235.42:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var politicsRest: Politics_Send = retrofit.create(Politics_Send::class.java)
        var economyRest: Economy_Send = retrofit.create(Economy_Send::class.java)
        var societyRest: Society_Send = retrofit.create(Society_Send::class.java)
        var othersRest: Others_Send = retrofit.create(Others_Send::class.java)
        var kakaoTest: Kakao_Send = retrofit.create(Kakao_Send::class.java)

        binding.radioGroup1.setOnCheckedChangeListener { radioGroup, checkedId ->
            when(checkedId) {
                R.id.radioKeyword -> {
                    binding.radioGroup2.setOnCheckedChangeListener { group, checkedId2 ->
                        when(checkedId2) {
                            R.id.politics -> {
                                binding.button3.setOnClickListener{
                                    var text1 = editText.text.toString()
                                    var text2 = "카카오톡 유료화"
                                    var nolist = "검색 결과가 없습니다."

                                    politicsRest.requestServer(text1).enqueue(object: Callback<Politics_requests> {
                                        override fun onFailure(call: Call<Politics_requests>, t: Throwable) {
                                            var dialog = AlertDialog.Builder(this@MainActivity)
                                            dialog.setTitle("에러")
                                            dialog.setMessage("호출실패했습니다.")
                                            dialog.show()
                                        }

                                        override fun onResponse(call: Call<Politics_requests>, response: Response<Politics_requests>) {
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
                            }

                            R.id.economy -> {
                                binding.button3.setOnClickListener{
                                    var text1 = editText.text.toString()
                                    var text2 = "카카오톡 유료화"
                                    var nolist = "검색 결과가 없습니다."

                                    economyRest.requestServer(text1).enqueue(object: Callback<Economy_requests> {
                                        override fun onFailure(call: Call<Economy_requests>, t: Throwable) {
                                            var dialog = AlertDialog.Builder(this@MainActivity)
                                            dialog.setTitle("에러")
                                            dialog.setMessage("호출실패했습니다.")
                                            dialog.show()
                                        }

                                        override fun onResponse(call: Call<Economy_requests>, response: Response<Economy_requests>) {
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
                            }

                            R.id.society -> {
                                binding.button3.setOnClickListener{
                                    var text1 = editText.text.toString()
                                    var text2 = "카카오톡 유료화"
                                    var nolist = "검색 결과가 없습니다."

                                    societyRest.requestServer(text1).enqueue(object: Callback<Society_requests> {
                                        override fun onFailure(call: Call<Society_requests>, t: Throwable) {
                                            var dialog = AlertDialog.Builder(this@MainActivity)
                                            dialog.setTitle("에러")
                                            dialog.setMessage("호출실패했습니다.")
                                            dialog.show()
                                        }

                                        override fun onResponse(call: Call<Society_requests>, response: Response<Society_requests>) {
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
                            }

                            R.id.others -> {
                                binding.button3.setOnClickListener{
                                    var text1 = editText.text.toString()
                                    var text2 = "카카오톡 유료화"
                                    var nolist = "검색 결과가 없습니다."

                                    othersRest.requestServer(text1).enqueue(object: Callback<Others_requests> {
                                        override fun onFailure(call: Call<Others_requests>, t: Throwable) {
                                            var dialog = AlertDialog.Builder(this@MainActivity)
                                            dialog.setTitle("에러")
                                            dialog.setMessage("호출실패했습니다.")
                                            dialog.show()
                                        }

                                        override fun onResponse(call: Call<Others_requests>, response: Response<Others_requests>) {
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
                            }
                        }
                    }
                }

                R.id.radioKakao -> {
                    binding.button3.setOnClickListener{
                        var text1 = editText.text.toString()
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
        }
    }
}
package com.example.musicplayer

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        /*        Imagine building a toy robot. "retrofitBuilder"
        is like the blueprint. "Retrofit.Builder()"
        is how we start building the robot.
        "baseUrl" is where the robot will find toys.
        "addConverterFactory(GsonConverterFactory.create())"
         helps the robot understand toy instructions.
        ".build()" is when the robot is ready to play.
        ".create(ApiInterface::class.java)"
        is when we tell the robot its purpose, like playing games.
        So, this code builds a robot that knows where to
        find toys, how to understand their instructions,
       and what games to play with them at the Deezer toy store.

       **Blueprint means a plan or design for building something**
       */


        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback <MyData?>  {
            override fun onResponse(call: Call <MyData?> , response: Response <MyData?> ) {
//                if success it would be excuted
                val dataList = response.body()?.data
                val textView = findViewById<TextView>(R.id.helloText)
                textView.text = dataList.toString()
                Log.d("TAG : onResponse", "onResponse: " + response.body())

            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
//                if failure then this would be executed

                Log.d("TAG : onFailure", "onFailure: " + t.message)
            }
        })

        /*  This code is like asking a teacher for information about
         Eminem. "retrofitData" is your request.
          "retrofitBuilder.getData("eminem")" tells the teacher what
          information you need. ".enqueue()" is like telling the
          teacher to reply later.
          Inside, "object : Callback<List<MyData>?>"
          is how we listen for the teacher's response. "onResponse()"
          is when the teacher answers your question. "onFailure()"
           is if the teacher couldn't find the answer.
           So, this code asks the teacher (server) for information
           about Eminem, waits for the response,
            and reacts accordingly - either by receiving the
            information or handling any issues.*/

    }
}
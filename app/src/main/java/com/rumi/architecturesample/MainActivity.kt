package com.rumi.architecturesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = ApiModule.getRetrofitInstance()

        coroutineScope.launch(Dispatchers.IO) {
            val photoList = apiService.getPic2()
            println("photolist $photoList")

        }
    }
}

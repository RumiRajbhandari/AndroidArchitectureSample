package com.rumi.architecturesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.rumi.architecturesample.remote.ApiModule
import com.rumi.architecturesample.remote.ApiService
import com.rumi.architecturesample.viewmodel.PhotoViewModel
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

        val viewModel = ViewModelProviders.of(this).get(PhotoViewModel::class.java)
        apiService = ApiModule.getRetrofitInstance()

        coroutineScope.launch(Dispatchers.IO) {
            val photoList = apiService.fetchPhotos()
            viewModel.insertPhotos(photoList)

        }
    }
}

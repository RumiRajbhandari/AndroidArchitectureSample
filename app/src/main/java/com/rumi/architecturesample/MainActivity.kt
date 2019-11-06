package com.rumi.architecturesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.rumi.architecturesample.viewmodel.PhotoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    lateinit var viewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appContainer = (application as ArchitectureApplication).appContainer
        viewModel = PhotoViewModel(application, appContainer.photoRepositoryImpl)


        coroutineScope.launch(Dispatchers.IO) {
            val photoList = viewModel.fetchPhotos()
            viewModel.insertPhotos(photoList)

        }

        btn_fetch_title.setOnClickListener {
            val id = et_id.text.toString()
            if (id.isNotEmpty()) {
                println("id is ${id.toInt()}")
                coroutineScope.launch {
                    fetchPhoto(id.toInt())

                }
            }

        }
    }

    private suspend fun fetchPhoto(id: Int) {
        withContext(Dispatchers.Main) {
            val photo = viewModel.getPhoto(id.toInt())
            photo.observe(this@MainActivity, Observer {
                println("photo is $it")
                tv_title.text = it.title

            })
        }
    }
}

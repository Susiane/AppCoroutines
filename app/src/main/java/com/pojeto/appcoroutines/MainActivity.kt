package com.pojeto.appcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callWebService()
    }

    fun callWebService(){


        var list = listOf<Film>()
        coroutineScope.launch {
            val response = withContext(Dispatchers.IO){
                val api = Api()
                api.getFilms().await()
            }
            val filmResult = response.body()!!
            list = filmResult.results
        }
       // Toast.makeText(this, list[0].title, Toast.LENGTH_SHORT).show()

        //Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
        //todo exemplo do erro de Network na MainThread
       /* coroutineScope.launch {
            //callApi
        }*/

        //exemplo de fazer atualização de tela na maisn Thread
        /*coroutineScope.launch(Dispatchers.IO) {
            //todo fazer algo aque que atualize a tela
            //callApi
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}

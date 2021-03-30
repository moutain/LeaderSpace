package com.testalgorithm.test

import android.app.Activity
import android.os.Bundle
import android.provider.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainKActivity : Activity() {
    val name : String = MainKActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun test(){

        Thread(
                Runnable {

                }
        ).start()

//        GlobalScope.launch{
//            delay(1000L)
//            print("world")
//        }
    }
}
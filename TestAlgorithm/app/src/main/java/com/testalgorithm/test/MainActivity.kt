package com.testalgorithm.test

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    var list: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name.setText("fdjklf")
        var nameView: TextView = findViewById(R.id.name)
        nameView.setText("MainActivityNew")

        var result = list?.let {
            list.add(1)
            list.add(2)
            list.add(3)

        }

    }

}
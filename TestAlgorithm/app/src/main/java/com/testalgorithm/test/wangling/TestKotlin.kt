package com.testalgorithm.test.wangling

import android.util.Log
import kotlinx.coroutines.*

class TestKotlin {
}

suspend fun getUserInfo(): String{
    withContext(Dispatchers.IO){
        delay(1000L)
    }
    val name : String  = ""
    name.apply {

    }
    return "Tom"



}


suspend fun getFiendList(id : String): String{
    withContext(Dispatchers.IO){
        delay(1000L)
    }
    return "Bob,Jim"
}


suspend fun getFeedList(id: String): String{
    withContext(Dispatchers.IO){
        delay(1000L)
    }
    return "{feed,...}"
}


fun main(args: Array<String>) {


    var list : ArrayList<Int>?= ArrayList()
    var result = list?.let {
        list.add(1)
        list.add(2)
        list.add(3)

        "ok"
    }
    list?.apply {
        list.add(1)
        list.add(2)
        list.add(3)
    }
    println("$list  $result" )



//    runBlocking{
//        delay(1000L)
//        println("runBlocking内")
//    }
//    println("runBlocking外")



//    var job: Job?=null
//    job = GlobalScope.launch {
//        delay(10000L)
//        println("thread 内")
//    }
//    println("thread 外")
//    Thread.sleep(2000L)
//    job?.cancel()


//    GlobalScope.launch{
//        val time = System.currentTimeMillis()
//        val task1 = withContext(Dispatchers.IO){
//            delay(2000L)
//            println("currenttask1: ${Thread.currentThread().name}")
//        }
//        val task2 = withContext(Dispatchers.IO){
//            delay(1000L)
//            println("currenttask2: ${Thread.currentThread().name}")
//        }
//        println("task1: ${task1}  task2: ${task2} main time 耗时：${System.currentTimeMillis()-time} 当前任务项：${Thread.currentThread().name}")
//    }

//    GlobalScope.launch {
//        val time1 = System.currentTimeMillis()
//
//        val task1 = withContext(Dispatchers.IO) {
//            delay(2000)
//            println("1.执行task1.... [当前线程为：${Thread.currentThread().name}]")
//            "one"  //返回结果赋值给task1
//        }
//
//        val task2 = withContext(Dispatchers.IO) {
//            delay(1000)
//            println( "2.执行task2.... [当前线程为：${Thread.currentThread().name}]")
//            "two"  //返回结果赋值给task2
//        }
//
//        println( "task1 = $task1  , task2 = $task2 , 耗时 ${System.currentTimeMillis()-time1} ms  [当前线程为：${Thread.currentThread().name}]")
//    }
        

//    GlobalScope.launch {
//
//        val time = System.currentTimeMillis()
//        val task1 = async {
//            delay(2000L)
//            println("task1  ${Thread.currentThread().name}")
//        }.await()
//
//        val task2 = async {
//            delay(1000L)
//            println("task2 ${Thread.currentThread().name}")
//        }.await()
//        println("task1 : ${task1}  task2: ${task2} time : ${System.currentTimeMillis() - time}  task : ${Thread.currentThread().name}")
//    }



    var user = User("wangling", 23, "12123123")

    var result1 = with(user) {
        println("my name is $name, I am $age years old, my phone number is $phoneNum")
        1000
    }
    println("result: $result1")



}






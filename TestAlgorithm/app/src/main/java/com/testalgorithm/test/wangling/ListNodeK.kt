package com.testalgorithm.test.wangling

class ListNodeK {

    var value : Int = 0
    var next : ListNodeK?=null

    constructor()

    constructor(value : Int){

    }

    constructor(value: Int, listNodeK: ListNodeK){
        this.value = value
        this.next = listNodeK
    }

}

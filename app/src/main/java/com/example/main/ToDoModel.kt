package com.example.main

data class ToDoModel(
    var id: Int,
    var task: String, //할 일
    var status: Int  //체크 상태
)
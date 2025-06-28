package com.example.stonegame

data class GameVar(
    var click: Boolean = true,
    var nameAnimation:String = "",
    var gameStart:Boolean = false,
    var gameOver:Boolean = false,
    var checkWinner:Boolean = false,
    var score:Int = 0
)
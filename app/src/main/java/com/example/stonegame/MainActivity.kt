package com.example.stonegame

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.Random


class MainActivity : AppCompatActivity() {

    private var start = false
    private var startGame = false
    var count:Int = 0

    val random = Random()
    val randomNumber = random.nextInt(3)




    var countWin:Int = 0
    var oldCountWin:Int = 0
    private  var computerNameAnimation = "computerKnife"

    private  var clickC:Boolean = false

    private var GameAnimation = GameLogic()

    private  var gameVal = GameVar(click = false)
    private  var computerVal = GameVar(click = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCW = findViewById<TextView>(R.id.tvCountWin)
        countWin = getIntent().getIntExtra("countW", 3);
        tvCW.setText(countWin.toString())

        oldCountWin = countWin


        //tvCW.setText(countWin.toString())
        if(randomNumber == 0) {
            computerNameAnimation = "computerKnife"
        }
        else if(randomNumber == 1) {
            computerNameAnimation = "computerStone"
        }
        else {
            computerNameAnimation = "computerPaper"
        }

        val playerStone = findViewById<ImageButton>(R.id.playerStone)
        val playerKnife = findViewById<ImageButton>(R.id.playerKnife)
        val playerPaper = findViewById<ImageButton>(R.id.playerPaper)

        val computerStone = findViewById<ImageButton>(R.id.computerStone)
        val computerKnife = findViewById<ImageButton>(R.id.computerKnife)
        val computerPaper = findViewById<ImageButton>(R.id.computerPaper)
        computerStone.isEnabled = false

        val messageGame = findViewById<TextView>(R.id.messageGame)

        val startGameButton = findViewById<Button>(R.id.startButton)

        val playerScore = findViewById<TextView>(R.id.playerScore)
        val computerScore = findViewById<TextView>(R.id.computerScore)


        val setingBtn = findViewById<ImageButton>(R.id.settingGame)

        setingBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        startGameButton.setOnClickListener {
            start = true
            startGameButton.visibility = View.INVISIBLE

            Thread {
                while(start) {
                    Thread.sleep(1000)
                    runOnUiThread {
                        if(!startGame && count == 3) {
                            startGame = true
                            gameVal.click = false
                            countWin--
                            tvCW.setText(countWin.toString())
                        }

                        if(count < 3) {
                            messageGame.setText(count.toString())
                            clickC = true
                        }

                        else {
                            clickC = false
                        }

                        if (startGame) {

                            if(!gameVal.click) {
                                playerStone.setOnClickListener {
                                    GameAnimation.animationOfObject(
                                        playerStone,
                                        "playerStone",
                                        gameVal
                                    )

                                    if(clickC == false) {

                                        if (computerNameAnimation == "computerStone") {
                                            GameAnimation.animationOfComputerObject(
                                                computerStone,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }

                                        else if (computerNameAnimation == "computerKnife") {
                                            GameAnimation.animationOfComputerObject(
                                                computerKnife,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }

                                        else {
                                            GameAnimation.animationOfComputerObject(
                                                computerPaper,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }
                                        clickC = true
                                    }
                                    startGame = false
                                }
                                playerKnife.setOnClickListener {
                                    GameAnimation.animationOfObject(
                                        playerKnife,
                                        "playerKnife",
                                        gameVal
                                    )

                                    if(clickC == false) {

                                        if (computerNameAnimation == "computerStone") {
                                            GameAnimation.animationOfComputerObject(
                                                computerStone,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }

                                        else if (computerNameAnimation == "computerKnife") {
                                            GameAnimation.animationOfComputerObject(
                                                computerKnife,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }

                                        else {
                                            GameAnimation.animationOfComputerObject(
                                                computerPaper,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }
                                        clickC = true
                                    }
                                    startGame = false
                                }
                                playerPaper.setOnClickListener {
                                    GameAnimation.animationOfObject(
                                        playerPaper,
                                        "playerPaper",
                                        gameVal
                                    )
                                    if(clickC == false) {

                                        if (computerNameAnimation == "computerStone") {
                                            GameAnimation.animationOfComputerObject(
                                                computerStone,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }

                                        else if (computerNameAnimation == "computerKnife") {
                                            GameAnimation.animationOfComputerObject(
                                                computerKnife,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }

                                        else {
                                            GameAnimation.animationOfComputerObject(
                                                computerPaper,
                                                computerNameAnimation,
                                                computerVal
                                            )
                                        }
                                        clickC = true
                                    }
                                    startGame = false
                                }
                            }
                        }

                        if(count > 3) {

                            startGameButton.visibility = View.VISIBLE
                            startGameButton.setText("Еще раз?")
                            startGame = false
                            gameVal.click = true
                            clickC = true


                            if(gameVal.checkWinner == false) {
                                checkWiner(playerScore, computerScore, gameVal, computerVal, computerNameAnimation)
                                gameVal.checkWinner = true
                            }


                            if(countWin <= 0) {
                                if(gameVal.score > computerVal.score)
                                    playerScore.setText("Вы выйграли")
                                else if(gameVal.score == computerVal.score)
                                    playerScore.setText("Ничья")
                                else {
                                    playerScore.setText("Вы проиграли")
                                }
                            }

                            startGameButton.setOnClickListener {
                                startGameButton.visibility = View.INVISIBLE
                                count = 0
                                startGame = true
                                clickC = false
                                gameVal.checkWinner = false

                                if(countWin <= 0) {
                                    countWin = oldCountWin
                                    tvCW.setText(countWin.toString())
                                    computerVal.score = 0
                                    gameVal.score = 0
                                }

                                val random = Random()
                                val randomNumber = random.nextInt(3)

                                if(randomNumber == 0) {
                                    computerNameAnimation = "computerKnife"
                                }
                                else if(randomNumber == 1) {
                                    computerNameAnimation = "computerStone"
                                }
                                else {
                                    computerNameAnimation = "computerPaper"
                                }

                                when (gameVal.nameAnimation) {
                                        "playerStone" -> {
                                            GameAnimation.animationRemovingOfObject(
                                                playerStone,
                                                gameVal
                                            )
                                        }
                                        "playerKnife" -> {
                                            GameAnimation.animationRemovingOfObject(
                                                playerKnife,
                                                gameVal
                                            )
                                        }
                                        "playerPaper" -> {
                                            GameAnimation.animationRemovingOfObject(
                                                playerPaper,
                                                gameVal
                                            )
                                        }
                                }

                                when (computerVal.nameAnimation) {
                                    "computerStone" -> {
                                        GameAnimation.animationRemovingOfComputerObject(
                                            computerStone,
                                            computerVal
                                        )
                                    }

                                    "computerKnife" -> {
                                        GameAnimation.animationRemovingOfComputerObject(
                                            computerKnife,
                                            computerVal
                                        )
                                    }

                                    "computerPaper" -> {
                                        GameAnimation.animationRemovingOfComputerObject(
                                            computerPaper,
                                            computerVal
                                        )
                                    }
                                }
                            }
                        }
                        count++
                    }
                }
            }.start()
        }

    }

    fun checkWiner(scorePlayer:TextView, scoreComputer:TextView, plV:GameVar, compV:GameVar, computerNameAnimation:String) {

        if(plV.nameAnimation == "playerStone" && computerNameAnimation == "computerKnife") {
            plV.score++
        }

        if(plV.nameAnimation == "playerPaper" && computerNameAnimation == "computerKnife") {
            compV.score++
        }

        if(plV.nameAnimation == "playerKnife" && computerNameAnimation == "computerStone") {
            compV.score++
        }

        if(plV.nameAnimation == "playerKnife" && computerNameAnimation == "computerPaper") {
            plV.score++
        }

        if(plV.nameAnimation == "playerPaper" && computerNameAnimation == "computerStone") {
            plV.score++
        }

        if(plV.nameAnimation == "playerStone" && computerNameAnimation == "computerPaper") {
            compV.score++
        }

        if(plV.nameAnimation == "computerStone" && computerNameAnimation == "computerPaper") {
            compV.score++
        }

        if(plV.score > compV.score)
        {
            scorePlayer.setTextColor(Color.GREEN)
            scoreComputer.setTextColor(Color.RED)
        }
        else if(plV.score < compV.score) {
            scorePlayer.setTextColor(Color.RED)
            scoreComputer.setTextColor(Color.GREEN)
        }
        else {
            scorePlayer.setTextColor(Color.GRAY)
            scoreComputer.setTextColor(Color.GRAY)
        }
        scorePlayer.setText(plV.score.toString())
        scoreComputer.setText(compV.score.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
        startGame = false

    }

}
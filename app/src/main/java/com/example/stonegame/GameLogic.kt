package com.example.stonegame

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.widget.ImageButton


class GameLogic {
    fun animationOfObject(imageButton:ImageButton, name:String, click:GameVar) {
        if (click.click == false) {
            when (name) {
                "playerStone" -> {
                    val translationX = PropertyValuesHolder.ofFloat("translationX", 350f)
                    val translationY = PropertyValuesHolder.ofFloat("translationY", -500f)
                    val animator = ObjectAnimator.ofPropertyValuesHolder(
                        imageButton,
                        translationX,
                        translationY
                    )
                    animator.duration = 1000
                    animator.start()
                    click.nameAnimation = "playerStone"
                    click.click = true
                }

                "playerKnife" -> {
                    val translationX1 = PropertyValuesHolder.ofFloat("translationX", 0f)
                    val translationY1 = PropertyValuesHolder.ofFloat("translationY", -500f)
                    val animator1 = ObjectAnimator.ofPropertyValuesHolder(
                        imageButton,
                        translationX1,
                        translationY1
                    )
                    animator1.duration = 1000
                    animator1.start()
                    click.nameAnimation = "playerKnife"
                    click.click = true
                }

                "playerPaper" -> {
                    val translationX1 = PropertyValuesHolder.ofFloat("translationX", -350f)
                    val translationY1 = PropertyValuesHolder.ofFloat("translationY", -500f)
                    val animator1 = ObjectAnimator.ofPropertyValuesHolder(
                        imageButton,
                        translationX1,
                        translationY1
                    )
                    animator1.duration = 1000
                    animator1.start()
                    click.nameAnimation = "playerPaper"
                    click.click = true
                }
            }

        }
    }


    fun animationOfComputerObject(imageButton:ImageButton, name:String, computerVar: GameVar) {

        when (name) {
            "computerStone" -> {
                val translationXC = PropertyValuesHolder.ofFloat("translationX", 350f)
                val translationYC = PropertyValuesHolder.ofFloat("translationY", 500f)
                val animatorC = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationXC,
                    translationYC
                )
                animatorC.duration = 1000
                animatorC.start()
                computerVar.nameAnimation = "computerStone"
            }

            "computerKnife" -> {
                val translationXC = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationYC = PropertyValuesHolder.ofFloat("translationY", 500f)
                val animatorC = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationXC,
                    translationYC
                )
                animatorC.duration = 1000
                animatorC.start()
                computerVar.nameAnimation = "computerKnife"
            }

            "computerPaper" -> {
                val translationXC = PropertyValuesHolder.ofFloat("translationX", -350f)
                val translationYC = PropertyValuesHolder.ofFloat("translationY", 500f)
                val animatorC = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationXC,
                    translationYC
                )
                animatorC.duration = 1000
                animatorC.start()
                computerVar.nameAnimation = "computerPaper"
            }
        }

    }


    fun animationRemovingOfObject(imageButton:ImageButton, click:GameVar) {
        when (click.nameAnimation) {
            "playerStone" -> {
                val translationX = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationY = PropertyValuesHolder.ofFloat("translationY", 0f)
                val animator = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationX,
                    translationY
                )
                animator.duration = 1000
                animator.start()
            }

            "playerKnife" -> {
                val translationX = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationY = PropertyValuesHolder.ofFloat("translationY", 0f)
                val animator = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationX,
                    translationY
                )
                animator.duration = 1000
                animator.start()
            }

            "playerPaper" -> {
                val translationX = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationY = PropertyValuesHolder.ofFloat("translationY", 0f)
                val animator = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationX,
                    translationY
                )
                animator.duration = 1000
                animator.start()
            }
        }
    }

    fun animationRemovingOfComputerObject(imageButton:ImageButton, computerVar:GameVar) {
        when (computerVar.nameAnimation) {
            "computerStone" -> {
                val translationXC = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationYC = PropertyValuesHolder.ofFloat("translationY", 0f)
                val animatorC = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationXC,
                    translationYC
                )
                animatorC.duration = 1000
                animatorC.start()
            }

            "computerKnife" -> {
                val translationXC = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationYC = PropertyValuesHolder.ofFloat("translationY", 0f)
                val animatorC = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationXC,
                    translationYC
                )
                animatorC.duration = 1000
                animatorC.start()
            }

            "computerPaper" -> {
                val translationXC = PropertyValuesHolder.ofFloat("translationX", 0f)
                val translationYC = PropertyValuesHolder.ofFloat("translationY", 0f)
                val animatorC = ObjectAnimator.ofPropertyValuesHolder(
                    imageButton,
                    translationXC,
                    translationYC
                )
                animatorC.duration = 1000
                animatorC.start()
            }
        }
    }
}
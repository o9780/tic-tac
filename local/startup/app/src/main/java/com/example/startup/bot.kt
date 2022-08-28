package com.example.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class bot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot)
    }

    fun buSelect(view: View) {
        val buCoise = view as Button
        var idd = 0
        when (buCoise.id) {
            R.id.bu1 -> idd = 1
            R.id.bu2 -> idd = 2
            R.id.bu3 -> idd = 3
            R.id.bu4 -> idd = 4
            R.id.bu5 -> idd = 5
            R.id.bu6 -> idd = 6
            R.id.bu7 -> idd = 7
            R.id.bu8 -> idd = 8
            R.id.bu9 -> idd = 9
        }
        Log.d("id: ", idd.toString())
        playGame(idd, buCoise)


    }
    val n = 9
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    val freeCell = ArrayList<Int>(9)
    var playerTurn = 1
    var playerXscore=0
    var playerOscore=0
    var win = -1


    fun playGame(idd: Int, buCoise: Button) {
        if (playerTurn == 1) {
            buCoise.text = "X"
            buCoise.setBackgroundResource(R.color.ligth_blue)
            player1.add(idd)
            freeCell.add(idd)
            playerTurn = 2
            textTurn.text = "turn O"
        } else if(playerTurn == 2){
            buCoise.text = "O"
            buCoise.setBackgroundResource(R.color.orange)
            player2.add(idd)
            freeCell.add(idd)
            playerTurn = 1
            textTurn.text = "turn X"
        }
        buCoise.isEnabled = false

        checkWin()

        if (win==-1&&fullBord()) {

            result("Draw")
        }





    }



    private fun result(title: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage("The result is :-\nplayerX: $playerXscore\nplayerO: $playerOscore")
        alertDialogBuilder.setPositiveButton("Again")
        { _, _ ->
            bu1.isEnabled=true
            bu2.isEnabled=true
            bu3.isEnabled=true
            bu4.isEnabled=true
            bu5.isEnabled=true
            bu6.isEnabled=true
            bu7.isEnabled=true
            bu8.isEnabled=true
            bu9.isEnabled=true

            resetBord()
        }
        alertDialogBuilder.setNegativeButton("Reset")
        {_,_->
            bu1.isEnabled=true
            bu2.isEnabled=true
            bu3.isEnabled=true
            bu4.isEnabled=true
            bu5.isEnabled=true
            bu6.isEnabled=true
            bu7.isEnabled=true
            bu8.isEnabled=true
            bu9.isEnabled=true

            playerXscore=0
            playerOscore=0
            resetBord()
        }
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.show()



    }

    private fun resetBord() {
        win=-1

        bu1.text=""
        bu1.setBackgroundResource(R.color.set_blue)

        bu2.text=""
        bu2.setBackgroundResource(R.color.set_blue)

        bu3.text=""
        bu3.setBackgroundResource(R.color.set_blue)

        bu4.text=""
        bu4.setBackgroundResource(R.color.set_blue)

        bu5.text=""
        bu5.setBackgroundResource(R.color.set_blue)

        bu6.text=""
        bu6.setBackgroundResource(R.color.set_blue)

        bu7.text=""
        bu7.setBackgroundResource(R.color.set_blue)

        bu8.text=""
        bu8.setBackgroundResource(R.color.set_blue)

        bu9.text=""
        bu9.setBackgroundResource(R.color.set_blue)

        if (playerTurn==1) {
            textTurn.text = "turn X"
            playerTurn = 1

        } else if (playerTurn==2) {
            textTurn.text = "turn O"
            playerTurn = 2
        }


        player1.clear()
        player2.clear()
        freeCell.clear()

    }

    private fun fullBord():Boolean
    {

        return n==freeCell.size
    }

    fun checkWin() {

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            win = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            win = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            win = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            win = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            win = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            win = 2
        }
//-----------------------------------------------------------
        //cal 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            win = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            win = 2
        }

        //cal 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            win = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            win = 2
        }

        //cal 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            win = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            win = 2
        }

        //rigth corner
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            win = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            win = 2
        }

        //lift corner
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            win = 1

        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            win = 2
        }



        if (win == 1) {
            playerXscore++
            result("playerX is the winner")


        } else if(win == 2) {
            playerOscore++
            result("playerO is the winner")

        }


    }
    fun autoPlay(){


        var emptyCells = ArrayList<Int>()

        for( cellId in 1..9){

            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }



        if(emptyCells.size==0){
            resetBord()
        }


        val r = Random()
        val randIndex = r.nextInt(emptyCells.size )
        val cellId = emptyCells[randIndex]

        var buSelected:Button?
        buSelected =  when(cellId){
            1-> bu1
            2-> bu2
            3-> bu3
            4-> bu4
            5-> bu5
            6-> bu6
            7-> bu7
            8-> bu8
            9-> bu9
            else ->{ bu1}

        }

        playGame(cellId, buSelected)

    }
}





package com.example.madlevel1task1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {
        binding.BtnLower.setOnClickListener{
            onLowerClick()
        }

        binding.BtnEqual.setOnClickListener {
            onEqualClick()
        }

        binding.BtnHigher.setOnClickListener {
            onHigherClick()
        }
        updateUI()
    }

    @SuppressLint("StringFormatInvalid")
    private fun updateUI() {
        binding.lastThrowTV.text = getString(R.string.Last_Throw, lastThrow)
    }

    private fun rollDice() {
        val arrayList = ArrayList<Int>(listOf(R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
            R.drawable.dice4,R.drawable.dice5,R.drawable.dice6,))


        lastThrow = currentThrow
        currentThrow = (1..6).random()
        binding.diceIV.setImageResource(arrayList.get(currentThrow-1))
        updateUI()
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this,"Correct!",Toast.LENGTH_LONG).show()
    }

    private  fun onAnswerIncorrect(){
        Toast.makeText(this,"Incorrect!",Toast.LENGTH_LONG).show()
    }

    private fun onHigherClick(){
        if (currentThrow > lastThrow)
        onAnswerCorrect()
        else
            onAnswerIncorrect()

        rollDice()
    }

    private fun onLowerClick(){
        if (currentThrow < lastThrow)
            onAnswerCorrect()
        else
            onAnswerIncorrect()
        rollDice()
    }

    private fun onEqualClick(){
        if (currentThrow == lastThrow)
            onAnswerCorrect()
        else
            onAnswerIncorrect()
        rollDice()
    }

}
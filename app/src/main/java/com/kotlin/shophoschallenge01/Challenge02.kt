package com.kotlin.shophoschallenge01

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Challenge02 : AppCompatActivity() {

  // UI elements declaration
  private var btnRoll: Button? = null
  private var ivDice: ImageView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dice_roller)

    // UI elements init inside OnCreate method.
    btnRoll = findViewById(R.id.btn_roll)
    ivDice = findViewById(R.id.iv_dice)

    // Adding onClick event to execute rollDice function.
    btnRoll?.setOnClickListener{
      rollDice()
    }
  }

  // Array with each drawable value.
  private val diceList = listOf(
    R.drawable.dice_1,
    R.drawable.dice_2,
    R.drawable.dice_3,
    R.drawable.dice_4,
    R.drawable.dice_5,
    R.drawable.dice_6,
  )

  private fun rollDice(){
    // Get a Random number between 0 and 5.
    val randomNumber = (0..5).random()
    // Using the random number, I get access to the drawable array items index.
    val value = diceList[randomNumber]
    // Updating the UI with the random index value.
    ivDice?.setImageResource(value)
    // Pop-up
    Toast.makeText(this, "Dice value: ${randomNumber + 1}", Toast.LENGTH_SHORT).show()
  }
}
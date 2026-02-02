package com.apsoftware.peoplecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val saveButton: Button = findViewById(R.id.button3)
        val myNumber = findViewById<EditText>(R.id.editTextNumber2)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val resetButton = findViewById<Button>(R.id.ResetButton)
        myNumber.setText("10")

        saveButton.setOnClickListener {
            val returnIntent:Intent = Intent()
            val myNumText = myNumber.text
            var maxNum:Int = Integer.valueOf(myNumber.text.toString())
            returnIntent.putExtra("maxNumber", maxNum)
            setResult(RESULT_OK, returnIntent)
            Toast(this).showCustomToast(
                "Saved",
                this
            )
            finish()


        }

        cancelButton.setOnClickListener{
            val returnIntent:Intent = Intent()
            setResult(RESULT_CANCELED, returnIntent)
            finish()
        }

        resetButton.setOnClickListener{
            val returnIntent:Intent = Intent()
            myNumber.setText("10")
            returnIntent.putExtra("maxNumber", 10)
            setResult(RESULT_FIRST_USER, returnIntent)
            Toast(this).showCustomToast(
                "Ok",
                this
            )
            finish()

        }
     }

}
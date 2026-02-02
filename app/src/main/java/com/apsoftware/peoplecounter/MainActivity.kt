package com.apsoftware.peoplecounter

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*


var maxNum: Int = 10
var People = 0


class MainActivity : AppCompatActivity() {
    private lateinit var myTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get reference to button
        val btnClickMe = findViewById<Button>(R.id.button)
        myTextView = findViewById<TextView>(R.id.textView)
        val btnClickMe2 = findViewById<Button>(R.id.button2)

        val imageButton = findViewById<ImageButton>(R.id.imageButton7)


        //var maxNum: Int = 10

        imageButton.setOnClickListener {
            val intent:Intent = Intent (this, Settings::class.java)
            //maxNum = intent.getIntExtra("maxNumber", 0)
            myTextView.text = People.toString()
            startActivityForResult(intent, 12)
        }



            // set on-click listener
        btnClickMe.setOnClickListener {
            if (People >= maxNum ) {
                People = maxNum
                myTextView.text = People.toString()
                Toast(this).showCustomToast(
                        "Reached Max Capacity",
                        this
                )


            }else if (People == maxNum -4) {
                People += 1
                myTextView.text = People.toString()
                Toast(this).showCustomToast(
                        "3 More People Until Max Capacity",
                        this

                )
                //Toast.makeText(this@MainActivity, "Three more people to reach max", Toast.LENGTH_SHORT).show()
            }else if(People == maxNum -3) {

                People += 1
                myTextView.text = People.toString()
                Toast(this).showCustomToast(
                        "2 More People Until Max Capacity",
                        this
                )
            }else if (People == maxNum -2) {
                People += 1
                myTextView.text = People.toString()
                Toast(this).showCustomToast (
                        "1 More Person Until Max Capacity",
                        this
                )
            }else{
                People += 1
                myTextView.text = People.toString()
                //Toast.makeText(this@MainActivity, "Another person has entered", Toast.LENGTH_SHORT).show()
            }
        }


        btnClickMe2.setOnClickListener {
            if (People <=  0 ) {
                People = 0
                myTextView.text = People.toString()
                myTextView.text = People.toString()
                Toast(this).showCustomToast(
                        "There Are No People",
                        this
                )
            }else{
                People -= 1
                myTextView.text = People.toString()
            }


        }

        savedInstanceState?.getInt("count")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("count", People)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
                if (resultCode == Activity.RESULT_OK){
                    maxNum = data.getIntExtra("maxNumber", 6)
                }
                else if (resultCode == Activity.RESULT_FIRST_USER) {
                    maxNum = data.getIntExtra("maxNumber", 6)
                    People = 0
                    myTextView.text = People.toString()
                }
            }
        }
}

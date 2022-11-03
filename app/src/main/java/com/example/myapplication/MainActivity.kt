package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var name: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var checkBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        name = findViewById(R.id.name)
        lastName = findViewById(R.id.lastName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        checkBox = findViewById(R.id.checkBox)
        button =findViewById(R.id.button)


            button.setOnClickListener{
                if (name.length() < 3 ){
                    name.error = "უნდა შეიყვანოთ მინიმუმ 3 სიმბოლო"
                    return@setOnClickListener
                }
                if (lastName.length() < 5){
                    lastName.error = "უნდა შეიყვანოთ მინიმუმ 5 სიმბოლო"
                    return@setOnClickListener
                }
                if ("@" !in email.text.toString() || "." !in email.text.toString()){
                    email.error = "შეიყვანეთ სწორი email"
                    return@setOnClickListener
                }
                if(password.length() < 8 ){
                    password.error = "შეიყვანეთ მინიმუმ 8 სიმბოლო"
                    return@setOnClickListener
                }
                if(!(checkBox.isChecked)){
                    checkBox.error = "გთხოვთ მონიშნეთ ველი"
                    return@setOnClickListener

                }

                Toast.makeText(this, "თქვენ წარმატებით გაიარეთ რეგისტრაცია", Toast.LENGTH_SHORT).show()

            }


    }
}

package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import java.util.regex.Pattern.compile

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

            var emailRegex = compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+")
            val symbols = "0123456789"




        name = findViewById(R.id.name)
        lastName = findViewById(R.id.lastName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        checkBox = findViewById(R.id.checkBox)
        button = findViewById(R.id.button)



            button.setOnClickListener{
                if (name.length() < 3 || !name.text.any { it.isLetter() }){
                    name.error = "შეიყვანეთ სწორი მონაცემი "
                }
                else if (lastName.length() < 5 || !lastName.text.any { it.isLetter() }){
                    lastName.error = "შეიყვანეთ სწორი მონაცემი"
                }
                else if (!(emailRegex.matcher(email.text).matches())){
                    email.error = "შეიყვანეთ სწორი email"
                }
                else if(password.length() < 8 || !(password.text.any{it in symbols})){
                    password.error = "შეიყვანეთ მინიმუმ 8 სიმბოლო და ერთი ციფრი"
                }
                else if(!(checkBox.isChecked)){

                    Toast.makeText(this, "მონიშნეთ რომ ეტანხმებიტ პირობებს", Toast.LENGTH_SHORT).show()

                }
                else {
                    Toast.makeText(this, "თქვენ წარმატებით გაიარეთ რეგისტრაცია", Toast.LENGTH_SHORT)
                        .show()
                }

            }


    }

}

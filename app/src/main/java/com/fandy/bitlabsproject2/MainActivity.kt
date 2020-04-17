package com.fandy.bitlabsproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.edit_email
import kotlinx.android.synthetic.main.activity_main.view.error_name
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() {


    fun validatName() : Boolean{
        if (edit_name.text.length ==0 ){
            error_name.setText("Name Must be filled")
            return false
        }else {
            error_name.setText(null)
            return true
        }
    }

    fun validateEmail() : Boolean{
        if (edit_email.text.length ==0 ){
            error_email.setText("Email must be filled")
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(edit_email.text).matches()){
            error_email.setText("Must match Email pattern")
            return false
        } else {
            error_email.setText(null)
            return true
        }
    }

    fun validatePassword() : Boolean{
        if (edit_password.text.length ==0 ){
            error_pass.setText("Password must be filled")
            return false
        } else if(edit_password.text.length <8){
            error_pass.setText("Password must be 7 Character or longer")
            return false
        } else {
            error_pass.setText(null)
            return true
        }
    }
    fun validateGender() : Boolean{
        if (radio_group.checkedRadioButtonId == -1){
            error_gender.setText("Gender must be selected")
            return false
        } else {
            error_gender.setText(null)
            return true
        }

    }


    fun validate(){
        if (validatName() && validateEmail() && validatePassword() && validateGender()) {
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()
        }
    }
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener {
            validate()
        }
    }
}

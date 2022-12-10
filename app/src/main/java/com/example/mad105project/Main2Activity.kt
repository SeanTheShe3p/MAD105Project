package com.example.mad105project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var rdBtnAdd = findViewById<RadioButton>(R.id.radBtnAdd)
        var rdBtnSub = findViewById<RadioButton>(R.id.radBtnSub)

        var addItem = ""
        var subItem = ""

        var spnGroceries = findViewById<Spinner>(R.id.SpnShop)
        var showList = findViewById<Button>(R.id.btnShopConfirm)
        var openContacts = findViewById<Button>(R.id.btnOpenContacts)

        var groceryItems = arrayListOf<String>()

        showList.setOnClickListener{
            if (rdBtnAdd.isChecked){
                addItem = spnGroceries.selectedItem.toString()
                groceryItems += addItem
                var stringGrocery = groceryItems.toString()
                Toast.makeText(this,stringGrocery,Toast.LENGTH_LONG).show()
            }
            else if (rdBtnSub.isChecked){
                subItem = spnGroceries.selectedItem.toString()
                groceryItems -= subItem
                var stringGrocery = groceryItems.toString()
                Toast.makeText(this,stringGrocery,Toast.LENGTH_LONG).show()
            } else Toast.makeText(applicationContext,"err",Toast.LENGTH_LONG).show()
        }
        openContacts.setOnClickListener{
            val intentContactList = Intent(this,Main3Activity::class.java)
            startActivity(intentContactList)
        }
//        fun checkLogin(username:String, password:String):LoginSuccess {
//            val holdUsername = "Dave"
//            val holdPassword = "Password"
//
//            if (username != holdUsername) {
//                return LoginSuccess.username }
//            return if (password != holdPassword){
//                return LoginSuccess.password }
//            else LoginSuccess.noFail
//        }
//        when(checkLogin(username, password)){
//            LoginSuccess.username -> {
//                Toast.makeText(applicationContext, getString(R.string.errUsername),Toast.LENGTH_LONG).show()
//            }
//            LoginSuccess.password -> {
//                Toast.makeText(applicationContext, getString(R.string.errPassword),Toast.LENGTH_LONG).show()
//            }
//            else -> {
//                Toast.makeText(applicationContext, getString(R.string.successfulAttempt),Toast.LENGTH_LONG).show()
//            }
//        }

    }
}
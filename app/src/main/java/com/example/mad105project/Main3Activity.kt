package com.example.mad105project

import android.hardware.biometrics.BiometricManager.Strings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.jar.Attributes.Name


//class AddContact constructor(name:String, phone:String, email:String, address:String){
//}

class Main3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var entryName = findViewById<TextView>(R.id.editContactName)
        var entryPhone = findViewById<TextView>(R.id.editContactPhone)
        var entryEmail = findViewById<TextView>(R.id.editContactEmail)
        var entryAddress = findViewById<TextView>(R.id.editContactAddress)
        var entrySearch = findViewById<TextView>(R.id.editSearch)
        var saveContact = findViewById<Button>(R.id.btnSaveContact)
        var viewContact = findViewById<Button>(R.id.btnViewContact)

        var contactMap = mutableMapOf<String,String>()

        saveContact.setOnClickListener{
            var name = entryName.text.toString()
            var phone = entryPhone.text.toString()
            var email = entryEmail.text.toString()
            var address = entryAddress.text.toString()


            fun checkValidation():Boolean{
                if (entryName.text.toString().isEmpty()){
                    entryName.error = "Enter a name"
                    entryName.requestFocus()
                    return false
                }
                if (entryPhone.text.toString().isEmpty()){
                    entryPhone.error = "Enter a phone number"
                    entryPhone.requestFocus()
                    return false
                }
                Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show()
                    return true
            }
            if (checkValidation()){
                //contactMap.put(name, "Phone:"+phone+"Email:"+email+"Address:"+address)
                if(email.isBlank() && address.isBlank()){
                    contactMap.put(name, name + " +" + phone)
                }
                if (address.isBlank() && email.isNotBlank()){
                    contactMap.put(name,  name + " +" + phone + " " + email)
                }
                if (email.isBlank() && address.isNotBlank()){
                    contactMap.put(name,  name + " +" + phone + " " + address)
                }
                else {
                    contactMap.put(name,  name + " +" + phone + " " + email + " " + address)
                }
            }
        }

        viewContact.setOnClickListener{
            var searchName = entrySearch.text.toString()
            Toast.makeText(this, contactMap.get(searchName), Toast.LENGTH_LONG).show()
        }
    }
}
package com.example.mad105project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

enum class ScheduleAnswer constructor(answerValue:Int){
    dayPlan1(1),
    dayPlan2(2),
    dayPlan3(3),
    dayPlan4(4),
    dayPlan5(5),
    dayPlan6(6),
    dayPlan7(7),
    dayPlan8(8),
    dayPlan0(0)

}

class Main1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radBtn1 = findViewById<RadioButton>(R.id.radBtn1_1)
        var radBtn2 = findViewById<RadioButton>(R.id.radBtn1_2)
        var radBtn3 = findViewById<RadioButton>(R.id.radBtn2_1)
        var radBtn4 = findViewById<RadioButton>(R.id.radBtn2_2)
        var radBtn5 = findViewById<RadioButton>(R.id.radBtn3_1)
        var radBtn6 = findViewById<RadioButton>(R.id.radBtn3_2)

        var btnSchedule = findViewById<Button>(R.id.btnSchedule)

        var btnShop = findViewById<Button>(R.id.btnOpenShop)

        var ans1: Int = 0
        var ans2: Int = 0
        var ans3: Int = 0


        btnSchedule.setOnClickListener {
            if (radBtn1.isChecked) {
                ans1 = 1
            }
            if (radBtn2.isChecked) {
                ans1 = 2
            }
            if (radBtn3.isChecked) {
                ans2 = 1
            }
            if (radBtn4.isChecked) {
                ans2 = 2
            }
            if (radBtn5.isChecked) {
                ans3 = 1
            }
            if (radBtn6.isChecked) {
                ans3 = 2
            }
            fun checkAnswer(ans1: Int, ans2: Int, ans3: Int): ScheduleAnswer {
                if (ans1 == 1 && ans2 == 1 && ans3 == 1){
                    return ScheduleAnswer.dayPlan1}
                if (ans1 == 2 && ans2 == 1 && ans3 == 1){
                    return ScheduleAnswer.dayPlan2}
                if (ans1 == 1 && ans2 == 2 && ans3 == 1){
                    return ScheduleAnswer.dayPlan3}
                if (ans1 == 2 && ans2 == 2 && ans3 == 1){
                    return ScheduleAnswer.dayPlan4}
                if (ans1 == 1 && ans2 == 1 && ans3 == 2){
                    return ScheduleAnswer.dayPlan5}
                if (ans1 == 2 && ans2 == 1 && ans3 == 2){
                    return ScheduleAnswer.dayPlan6}
                if (ans1 == 1 && ans2 == 2 && ans3 == 2){
                    return ScheduleAnswer.dayPlan7}
                if (ans1 == 2 && ans2 == 2 && ans3 == 2){
                    return ScheduleAnswer.dayPlan8}
                else return ScheduleAnswer.dayPlan0
            }

                when (checkAnswer(ans1, ans2, ans3)) {
                    ScheduleAnswer.dayPlan1 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults1), Toast.LENGTH_LONG).show()//weekend, chores, needs social
                    }
                    ScheduleAnswer.dayPlan2 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults2), Toast.LENGTH_LONG).show()//work, chores, needs social
                    }
                    ScheduleAnswer.dayPlan3 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults3), Toast.LENGTH_LONG).show()//weekend, nothing, need social
                    }
                    ScheduleAnswer.dayPlan4 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults4), Toast.LENGTH_LONG).show()//work, nothing, need social
                    }
                    ScheduleAnswer.dayPlan5 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults5), Toast.LENGTH_LONG).show()//weekend, chores, movies and ice cream
                    }
                    ScheduleAnswer.dayPlan6 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults6), Toast.LENGTH_LONG).show()//work, chores, sleep
                    }
                    ScheduleAnswer.dayPlan7 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults7), Toast.LENGTH_LONG).show()//weekend, nothing, whatever
                    }
                    ScheduleAnswer.dayPlan8 -> {
                        Toast.makeText(this, getString(R.string.txtScheduleResults8), Toast.LENGTH_LONG).show()//work, nothing, eat a good dinner
                    }
                    else -> Toast.makeText(this, getString(R.string.txtScheduleResults0), Toast.LENGTH_LONG)
                        .show()
                }
            }
        btnShop.setOnClickListener{
            val intentShop = Intent(this,Main2Activity::class.java)
            startActivity(intentShop)
        }
        }
    }

//fun checkLogin(username:String, password:String):LoginSuccess {
//                val holdUsername = "Dave"
//                val holdPassword = "Password"
//
//                if (username != holdUsername) {
//                    return LoginSuccess.username }
//                return if (password != holdPassword){
//                    return LoginSuccess.password }
//                else LoginSuccess.noFail
//            }
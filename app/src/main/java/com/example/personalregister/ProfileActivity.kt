package com.example.personalregister

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

       val person=intent.getSerializableExtra("EXTRA_PERSON")as com.example.personalregister.Person
text_person_name.text=person.name.toString()
        text_person_email.text=person.email.toString()
        text_person_age.text=person.age.toString()
        text_person_phone.text=person.phone.toString()
       


    }
}
package com.example.personalregister

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.personalregister.R.id
import com.example.personalregister.R.layout
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var string: String
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_profile)

        val person =
            intent.getSerializableExtra("EXTRA_PERSON") as com.example.personalregister.Person
        text_person_name.text = person.name.toString()
        text_person_email.text = person.email.toString()
        text_person_age.text = person.age.toString()
        text_person_phone.text = person.phone.toString()


        textView = findViewById(id.text_person_phone)
        val textView: TextView = findViewById<TextView>(R.id.text_person_phone)

        text_person_email.setOnClickListener {
            composeEmail(arrayOf(person.email))
        }


        text_person_phone.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${text_person_phone.text}")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }


        }





    }

  fun composeEmail(arrayOf: Array<String>) {
      val intent = Intent(Intent.ACTION_SENDTO).apply {

          data = Uri.parse("mailto:")
          putExtra(Intent.EXTRA_EMAIL,arrayOf)
          //putExtra(Intent.EXTRA_SUBJECT, subject)
      }
      if (intent.resolveActivity(packageManager) != null) {
          startActivity(intent)
      }
    }


}
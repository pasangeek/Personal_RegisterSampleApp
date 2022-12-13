package com.example.personalregister

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //private lateinit var button: Button
    private lateinit var imageView: ImageView
    private val pickImage = 100
    private var imageUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      // button = findViewById(R.id.button_Image_pick)
      imageView = findViewById(R.id.imageView2)

btnApply.setOnClickListener {
    val name = etName.text.toString()
    val email = etEmailAddress.text.toString()
    val age = editTextAge.text.toString().toInt()
    val phone= Ephone.text.toString().toInt()
val profilePictureUri =imageUri.toString()

    val person=Person(name,email,age,phone,profilePictureUri )

    Intent(this,ProfileActivity::class.java).also {
       it.putExtra("EXTRA_PERSON",person)


        startActivity(it)
    }
}

        button_Image_pick.setOnClickListener {

             val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
             startActivityForResult(gallery, pickImage)
 }


     }

     public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if (resultCode == RESULT_OK && requestCode == pickImage) {
             imageUri = data?.data
             imageView.setImageURI(imageUri)

         }

    }

}
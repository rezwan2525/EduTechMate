package com.rezwan2525.edutechmate.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.ar.sceneform.rendering.ModelRenderable
import com.rezwan2525.edutechmate.R
import com.rezwan2525.edutechmate.commons.Constants
import com.rezwan2525.edutechmate.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    lateinit var name: String
    lateinit var phone:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveData()

        binding.tvUserName.setText(name)
        binding.tvPhoneNumber.setText(phone)

        binding.cardCCompiler.setOnClickListener{
            //Toast.makeText(this, "Clicked on OCR Compiler", Toast.LENGTH_LONG).show();
            Intent(this, CompilerActivity::class.java).apply{
                startActivity(this);
            }
        }

        binding.cardBiologyAr.setOnClickListener{
            //Toast.makeText(this, "Clicked on Biology AR", Toast.LENGTH_LONG).show();
            Intent(this, ArListActivity::class.java).apply{
                startActivity(this);
            }
        }
    }

    private fun retrieveData() {
        val pref = getSharedPreferences(Constants.SHARED_PREF_NAME, MODE_PRIVATE)
        phone = pref.getString(Constants.SHARED_PHONE, "+9100000000").toString()
        name = pref.getString(Constants.SHARED_NAME, "RapidAPIName").toString()
    }
}
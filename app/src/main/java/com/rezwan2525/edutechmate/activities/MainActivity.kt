package com.rezwan2525.edutechmate.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.ar.sceneform.rendering.ModelRenderable
import com.rezwan2525.edutechmate.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CardView>(R.id.card_c_compiler).setOnClickListener{
            Toast.makeText(this, "Clicked on OCR Compiler", Toast.LENGTH_LONG).show();
            Intent(this, CompilerActivity::class.java).apply{
                startActivity(this);
            }
        }

        findViewById<CardView>(R.id.card_biology_ar).setOnClickListener{
            Toast.makeText(this, "Clicked on Biology AR", Toast.LENGTH_LONG).show();
            Intent(this, ArListActivity::class.java).apply{
                startActivity(this);
            }
        }
    }
}
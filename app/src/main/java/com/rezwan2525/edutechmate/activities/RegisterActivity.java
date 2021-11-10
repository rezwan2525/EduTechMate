package com.rezwan2525.edutechmate.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.rezwan2525.edutechmate.R;
import com.rezwan2525.edutechmate.commons.Constants;

public class RegisterActivity extends AppCompatActivity {
    EditText mName, mPhone;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pref = getSharedPreferences(Constants.SHARED_PREF_NAME, MODE_PRIVATE);

        mName = findViewById(R.id.et_name);
        mPhone = findViewById(R.id.et_phone_number);

        //TESTING
        mName.setText("Rezwan");
        mPhone.setText("+8801842535625");

        if(isSavedAlready()){
            gotoMainActivity();
        }

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveNamePhone();
                gotoMainActivity();

            }
        });
    }

    private boolean isSavedAlready() {
        Log.d("TAG_REGISTER", pref.getString(Constants.SHARED_PHONE, ""));

        if(pref.getString(Constants.SHARED_PHONE, "").isEmpty() ||
                pref.getString(Constants.SHARED_NAME, "").isEmpty()
        ){
            return false;
        }
        return true;
    }

    private void saveNamePhone() {
        SharedPreferences.Editor editor= pref.edit();

        String name = mName.getText().toString();
        String phone = mPhone.getText().toString();

        editor.putString(Constants.SHARED_NAME, name);
        editor.putString(Constants.SHARED_PHONE, phone);

        editor.commit();
    }

    private void gotoMainActivity() {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText unameTxt,nameTxt,ageTxt,pswdTxt,emailTxt,repswdTxt;
    Button clearBtn,submitBtn;
    Boolean isAllFieldsChecked;
    Boolean emailFlag = false;
    Boolean nameFlag = false;
    Boolean pswdFlag = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearBtn = (Button) findViewById(R.id.clr_btn);
        submitBtn = (Button) findViewById(R.id.sub_btn);
        unameTxt = (TextInputEditText) findViewById(R.id.uname);
        nameTxt = (TextInputEditText) findViewById(R.id.name);
        ageTxt = (TextInputEditText) findViewById(R.id.age);
        pswdTxt = (TextInputEditText) findViewById(R.id.pswd);
        emailTxt = (TextInputEditText) findViewById(R.id.email);
        repswdTxt = (TextInputEditText) findViewById(R.id.repswd);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unameTxt.setText("");
                nameTxt.setText("");
                ageTxt.setText("");
                pswdTxt.setText("");
                emailTxt.setText("");
                repswdTxt.setText("");
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                String namePattern = "^[a-zA-Z ._]+";
                String emailId = emailTxt.getText().toString().trim();
                String name = nameTxt.getText().toString().trim();
                String pswd = pswdTxt.getText().toString().trim();
                String repswd = repswdTxt.getText().toString().trim();
                

                if (pswd.equals(repswd)){

                    pswdFlag=true;
                }else{
                    pswdFlag = false;
                }

                if (emailId.matches(emailPattern)){
                    emailFlag = true;
                }else{
                    emailFlag = false;
                }

                if (name.matches(namePattern)){
                    nameFlag = true;
                }else{
                    nameFlag = false;
                }
//                emailTxt.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//                        if (emailId.matches(emailPattern)){
//                            emailFlag = true;
//                        }
//                        else{
//                            emailFlag = false;
//                        }
//                    }
//                });

                isAllFieldsChecked = allFieldsCheckedFunction();

                if (isAllFieldsChecked){
                    Toast.makeText(MainActivity.this,"All is ok" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(intent);
                }

            }
        });

    }

    private Boolean allFieldsCheckedFunction() {

        if (unameTxt.length()==0){
            unameTxt.setError("Mandatory Field");
            return false;
        }
        if (nameTxt.length() == 0){
            nameTxt.setError("Mandatory Field");
            return false;
        }
        if (ageTxt.length() == 0){
            ageTxt.setError("Mandatory Field");
            return false;
        }
        if (pswdTxt.length() == 0){
            pswdTxt.setError("Mandatory Field");
            return false;
        }
        if (pswdTxt.length() > 16 || pswdTxt.length() < 8){
            pswdTxt.setError("Password length mus be between 8 and 16 characters");
            return false;
        }
        if (emailTxt.length() == 0){
            emailTxt.setError("Mandatory Field");
            return false;
        }
        if (emailFlag == false){
            emailTxt.setError("Enter Valid Email Id");
            return false;
        }
        if (nameFlag==false){
            nameTxt.setError("Name must only contain text");
            return false;
        }

        if (pswdFlag == false){
            repswdTxt.setError("Passwords must match");
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "on Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "on Back Pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "on Destroy", Toast.LENGTH_SHORT).show();
    }
}
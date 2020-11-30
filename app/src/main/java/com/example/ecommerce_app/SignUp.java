package com.example.ecommerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout edtname,edtusername,edtemail,edtphone,edtpass;
    Button btnsignup,btnalreadysignup;

    FirebaseDatabase rootNoods;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //Hooks
        edtname = findViewById(R.id.fullname);
        edtusername = findViewById(R.id.usernamesignup);
        edtphone = findViewById(R.id.phoneno);
        edtemail = findViewById(R.id.email);
        edtpass = findViewById(R.id.passswordignup);
        btnsignup = findViewById(R.id.signup);
        btnalreadysignup = findViewById(R.id.aleardyuser);


                rootNoods = FirebaseDatabase.getInstance();
                reference = rootNoods.getReference("users");

    }
    //===========Validation all EditText===========
    private boolean validationName(){
        String val = edtname.getEditText().getText().toString();
        if (val.isEmpty()){
            edtname.setError("Field cannot be empty");
            return false;
        }else {
            edtname.setError(null);
            edtname.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validationUsername(){
        String val = edtusername.getEditText().getText().toString().trim();
        String nowhitespace = "(?=\\s+$)";
        if (val.isEmpty()){
            edtusername.setError("Field cannot be empty");
            return false;
        }
        else if (val.length()>=15){
            edtusername.setError("Username too long");
            return false;
        }
        else if (val.matches(nowhitespace)){
            edtusername.setError("White Spaces are not allowed");
            return false;
        }
        else {
            edtusername.setError(null);
            return true;
        }
    }
    private boolean validationEmail(){
        String val = edtemail.getEditText().getText().toString();
        String emailPattren = "(a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+)";
        if (val.isEmpty()){
            edtemail.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(emailPattren)){
            edtemail.setError("Invalid email address");
            return false;
        }else {
            edtemail.setError(null);
            return true;
        }
    }
    private boolean validationPhonNo(){
        String val = edtname.getEditText().getText().toString();
        if (val.isEmpty()){
            edtname.setError("Field cannot be empty");
            return false;
        }else {
            edtname.setError(null);
            return true;
        }
    }
    private boolean validationPass(){
        String val = edtpass.getEditText().getText().toString();
        String passwordVal = "^"+
                //"(?=.*[0-9])"+          //at least 1 digits
               // "(?=.*[a-z])"+          //at least 1 upper case
              //  "(?=.*[A-Z])"+          //any letter
                "(?=.*[@#$%^&+=])"+     //at least 1 special character
                "(?=\\s+$)"+            //no White space
                ".{4,}"+                //at least 4 character
                "$";
        if (val.isEmpty()){
            edtname.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(passwordVal)){
            edtpass.setError("Password is too week");
            return false;
        }else {
            edtname.setError(null);
            return true;
        }
    }


    public void registerUser(View view){

        if (!validationName() ||!validationUsername() ||!validationEmail() ||!validationPhonNo() ||!validationPass() ){
            return;
        }


        //Get all Value
        String name = edtname.getEditText().getText().toString().trim();
        String username = edtusername.getEditText().getText().toString().trim();
        String email = edtemail.getEditText().getText().toString().trim();
        String phoneno = edtphone.getEditText().getText().toString().trim();
        String pass = edtpass.getEditText().getText().toString().trim();


        UserHelperClass userHelperClass = new UserHelperClass(name, username, email, phoneno, pass);

        reference.child(username).setValue(userHelperClass);
    }
}

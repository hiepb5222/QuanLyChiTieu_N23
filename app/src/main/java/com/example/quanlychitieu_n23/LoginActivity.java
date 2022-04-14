package com.example.quanlychitieu_n23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlychitieu_n23.Dao.UserDAo;
import com.example.quanlychitieu_n23.Dao.Database;
import com.example.quanlychitieu_n23.Entity.UserEntity;
import com.example.quanlychitieu_n23.ui.home.HomeFragment;
import java.lang.Runnable;


public class LoginActivity extends AppCompatActivity {
    EditText userid,password;
    Button login,signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid = findViewById(R.id.editTextTextEmailAddress1);
        password =findViewById(R.id.editTextTextPassword1);
        login = findViewById(R.id.buttonLogin1);
        signUp = findViewById(R.id.buttonSignIn1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String useridtext = userid.getText().toString();
                String passtext = password.getText().toString();
                if (useridtext.isEmpty() || passtext.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Chưa điền đầy đủ" ,Toast.LENGTH_SHORT).show();
                }
                else {
                    Database userDatabase = Database.getDatabase(getApplicationContext());
                    UserDAo userDAo = userDatabase.userDAo();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDAo.login(useridtext,passtext);
                            if(userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"II",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else
                            {
                                Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    }).start();
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            UserEntity userEntity = userDAo.login(useridtext,passtext);
//                            if(userEntity == null){
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Toast.makeText(getApplicationContext(),"II",Toast.LENGTH_SHORT).show();
//                                    }
//
//                                });
//                            }else{
//                                Intent intent= new Intent(LoginActivity.this,MainActivity.class);
//                                startActivity(intent);
//                            }
//                        }
//                    }).start();

                }
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignInActivity.class));
            }
        });

    }
}
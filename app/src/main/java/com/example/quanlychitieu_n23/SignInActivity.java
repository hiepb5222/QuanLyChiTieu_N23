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
import java.lang.Thread;
import java.lang.Runnable;

public class SignInActivity extends AppCompatActivity {
    EditText userid,password;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userid = findViewById(R.id.editTextTextEmailAddress);
        password =findViewById(R.id.editTextTextPassword);
        register = findViewById(R.id.buttonSignIn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUserID(userid.getText().toString());
                userEntity.setPassword(password.getText().toString());
                if (checkNull(userEntity)){
                    Database userDatabase =Database.getDatabase(getApplicationContext());
                    UserDAo userDAo = userDatabase.userDAo();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDAo.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SignInActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignInActivity.this,LoginActivity.class));
                                }
                            });
                        }
                    }).start();
                }
                else{
                    Toast.makeText(SignInActivity.this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    private Boolean checkNull(UserEntity userEntity){
        if(userEntity.getUserID().isEmpty() || userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}
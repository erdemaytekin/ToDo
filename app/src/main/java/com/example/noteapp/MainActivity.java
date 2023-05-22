package com.example.noteapp;



//Bu kod, bir Android uygulaması için MainActivity adlı bir sınıf tanımlar. 
   // Bu sınıf, bir AppCompatActivity’dir ve uygulamanın ana ekranını temsil eder. 
  //  onCreate yöntemi, kullanıcı arayüzünü oluşturur ve giriş ve kaydolma düğmelerine tıklama işleyicileri ekler.
   // Giriş düğmesine tıklanırsa, kullanıcının e-posta adresi ve şifresi doğrulanır.
 //   Eğer doğruysa, kullanıcı oturumu açılır ve ana sayfaya yönlendirilir. Aksi halde, bir hata mesajı görüntülenir. 
  //  Kaydolma düğmesine tıklanırsa, kullanıcı kaydolma sayfasına yönlendirilir. 
  //  onDestroy yöntemi, kullanıcı çıkış yapmış olur.



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.login);
        Button signupButton = findViewById(R.id.signup);
        EditText mail = findViewById(R.id.email_tf);
        EditText pass = findViewById(R.id.password_tf);
        dbHelper DbHelper = new dbHelper(getApplicationContext());




        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DbHelper.isUserValid(mail.getText().toString(),pass.getText().toString())){
                    UserSessionManager userSessionManager = new UserSessionManager(getApplicationContext());
                    userSessionManager.saveUserId(DbHelper.getUserIdFromUsername(mail.getText().toString()));

                   startActivity(new Intent(MainActivity.this, MainPage.class));



                }
                else{
                    Toast.makeText(MainActivity.this, "Yanlış e-mail veya şifre girişi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CreateUser.class));

            }
        });




    }
    public void onDestroy(){
        super.onDestroy();
        UserSessionManager userSessionManager = new UserSessionManager(getApplicationContext());
        userSessionManager.logout();
    }
}




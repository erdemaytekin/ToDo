package com.example.noteapp;


//Bu kod parçacığı, bir NewNote sınıfı tanımlar. 
   // Bu sınıf, AppCompatActivity sınıfından türetilmiştir ve bir Android aktivitesini temsil eder. Sınıfın içinde onCreate metodu bulunur.
    //Bu metod, aktivite oluşturulduğunda çağrılır.

//onCreate metodunun içinde, aktivitenin arayüzü R.layout.activity_new_note kaynağından yüklenir.
    //Daha sonra dbHelper ve UserSessionManager nesneleri oluşturulur. noteBody ve submit değişkenleri, arayüzdeki ilgili bileşenlere atanır.

//submit düğmesine bir OnClickListener atanır.
     //  Daha sonra MainPage aktivitesine geçiş yapılır ve mevcut aktivite sonlandırılır.








import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewNote extends AppCompatActivity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        dbHelper DbHelper = new dbHelper(getApplicationContext());
        EditText noteBody = findViewById(R.id.note_body);
        submit = findViewById(R.id.submit);
        UserSessionManager userSessionManager = new UserSessionManager(getApplicationContext());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteHead = ""; // Not başlığını burada elde edin
                String noteBodyText = noteBody.getText().toString(); // Not içeriğini alın
                int userId = userSessionManager.getUserId(); // Kullanıcı kimliğini alın

                DbHelper.addNote(noteHead, noteBodyText, userId);

                startActivity(new Intent(NewNote.this, MainPage.class));
                finish();
            }
        });
    }
}

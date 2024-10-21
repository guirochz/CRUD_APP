package com.example.app_busmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Esquecisenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esquecisenha);
    }

    public void abrindo_esqueci2(View view) {
        // Lógica para abrir a Home Activity
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
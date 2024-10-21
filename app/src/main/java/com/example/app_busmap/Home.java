package com.example.app_busmap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Certifique-se de que este é o layout correto

        // Inicialize a ImageView se necessário
        // ImageView ic_home3 = findViewById(R.id.ic_home3);
        // Você pode configurar listeners ou outras operações aqui, se precisar
    }

    // Método que será chamado quando a ImageView for clicada
    public void abrindo_perfil(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }
    public void abrindo_home(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void abrindo_favoritos(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }
    public void abrindo_historico(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Historico.class);
        startActivity(intent);
    }

    public void abrindo_graziela(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Linha.class);
        startActivity(intent);
    }

    public void abrindo_vale(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Linha2.class);
        startActivity(intent);
    }
    public void abrindo_tupanci(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Linha3.class);
        startActivity(intent);
    }
}

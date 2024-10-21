package com.example.app_busmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.app_busmap.db.LinhaBanco;
import com.example.app_busmap.dtos.LinhaDTO;

public class Linha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linha);

        String numero = getIntent().getExtras().getString("numero");

        try {
            LinhaDTO linha = LinhaBanco.obterLinhaPorNumero(getBaseContext(), numero);

            TextView linhaNumero = findViewById(R.id.Linha_numero);
            linhaNumero.setText("Linha" + linha.getNumero());
        }
        catch (Exception e) {

        }

    }

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
    public void abrindo_ruas(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Rua.class);
        startActivity(intent);
    }
    public void abrindo_pontos(View view) {
        // Lógica para abrir outra Activity ou qualquer outra ação
        Intent intent = new Intent(this, Ponto.class);
        startActivity(intent);
    }
}
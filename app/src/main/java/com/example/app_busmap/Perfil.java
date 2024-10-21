package com.example.app_busmap;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button; // Importar Button

public class Perfil extends AppCompatActivity {

    private TextView textNomeUsuario;
    private TextView textEmailUsuario;
    private Button botaoLogout; // Declarar o botão de logout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Inicializando os TextViews
        textNomeUsuario = findViewById(R.id.textNomeUsuario);
        textEmailUsuario = findViewById(R.id.textEmailUsuario);
        botaoLogout = findViewById(R.id.deslogar); // Inicializar o botão de logout

        // Recuperar os dados do SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        String nome = sharedPreferences.getString("nome", "Nome não encontrado");
        String email = sharedPreferences.getString("email", "Email não encontrado");

        // Exibir os dados nos TextViews
        textNomeUsuario.setText(nome);
        textEmailUsuario.setText(email);

        // Configurar o listener para o botão de logout
        botaoLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        SharedPreferences sharedPreferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.remove("email");
        editor.apply();

        Intent intent = new Intent(Perfil.this, Login.class);
        startActivity(intent);
        finish();
    }

    // Método que será chamado quando a ImageView for clicada
    public void abrindo_perfil(View view) {
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    public void abrindo_home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void abrindo_favoritos(View view) {
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }

    public void abrindo_fale(View view) {
        Intent intent = new Intent(this, Faleconosco.class);
        startActivity(intent);
    }
}

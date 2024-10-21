package com.example.app_busmap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private Button bt_entrar; // Adicionando a variável para o botão
    private EditText editUser; // Campo de Usuário
    private EditText editSenha; // Campo de Senha
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("email", null) != null) {
            Intent intent= new Intent(this, Home.class);
            startActivity(intent);
        }

        // Inicializando os componentes
        IniciarComponents();

        // Configurando o click listener para o text_tela_cadastro
        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });

        // Configurando o click listener para o botão bt_entrar
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pegando os valores de usuário e senha
                String usuario = editUser.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();

                // Verifica se o campo Usuário está vazio
                if (TextUtils.isEmpty(usuario)) {
                    editUser.setError("Email é obrigatório");
                    editUser.requestFocus();
                    return;
                }

                // Verifica se o campo Senha está vazio
                if (TextUtils.isEmpty(senha)) {
                    editSenha.setError("Senha é obrigatória");
                    editSenha.requestFocus();
                    return;
                }

                // Verifica se a senha contém pelo menos uma letra maiúscula, duas letras minúsculas, dois números e um caractere especial
                /*if (!senha.matches("^(?=.*[A-Z])(?=.*[a-z]{2})(?=.*[0-9]{2})(?=.*[@#$!]).+$")) {
                    editSenha.setError("A senha deve conter pelo menos uma letra maiúscula, duas letras minúsculas, dois números e um caractere especial(@#$!)");
                    editSenha.requestFocus();
                    return;
                }*/

                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        System.out.println(usuario);
                        Usuario usuario1 = CadastroBanco.logar(getBaseContext(), senha,usuario);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email",usuario1.getEmail());
                        editor.putString("nome",usuario1.getNome());
                        editor.apply();
                        abrindo_home(view);
                    }

                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario não encontrado", Toast.LENGTH_SHORT);
                    toast.show();
                }

                // Se passar pelas validações, chama a função para abrir a Home

            }
        });
    }

    // Método para inicializar os componentes
    private void IniciarComponents() {
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
        bt_entrar = findViewById(R.id.bt_entrar); // Inicializando o botão
        editUser = findViewById(R.id.edit_user); // Inicializando o campo de usuário
        editSenha = findViewById(R.id.edit_senha); // Inicializando o campo de senha
    }

    // Método para abrir a Home Activity
    public void abrindo_home(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    // Método para abrir a tela de "Esqueci minha senha"
    public void abrindo_esqueci(View view) {
        Intent intent = new Intent(this, Esquecisenha.class);
        startActivity(intent);
    }
}

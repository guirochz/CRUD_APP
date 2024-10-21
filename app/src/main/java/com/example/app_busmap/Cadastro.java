package com.example.app_busmap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler; // Importar o Handler
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Cadastro extends AppCompatActivity {

    private AppCompatEditText edtNome;
    private AppCompatEditText edtEmail;
    private AppCompatEditText edtSenha;
    private AppCompatButton botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edit_nome);
        edtEmail = findViewById(R.id.edit_email);
        edtSenha = findViewById(R.id.edit_senha);
        botaoCadastrar = findViewById(R.id.btn_cadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String nome = edtNome.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();

                // Validações
                if (nome.isEmpty()) {
                    Snackbar.make(botaoCadastrar, "Nome é obrigatório!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (email.isEmpty() || !email.contains("@")) {
                    Snackbar.make(botaoCadastrar, "Email inválido! Deve conter '@'.", Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (senha.length() < 6 || !senha.matches("\\d+")) {
                    Snackbar.make(botaoCadastrar, "Senha deve ter pelo menos 6 caracteres numéricos!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                // Chamar o método de inserção
                Usuario usuario = new Usuario(nome, email, senha);
                int res = CadastroBanco.inserirCadastro(usuario, getBaseContext());
                if (res <= 0) {
                    Snackbar.make(botaoCadastrar, "Inserção não realizada!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(botaoCadastrar, "Colaborador Inserido com Sucesso!", Snackbar.LENGTH_LONG).show();

                    // Usar um Handler para atrasar a execução
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Criar um Intent para abrir a tela de Login
                            Intent intent = new Intent(Cadastro.this, Login.class);
                            // Passar o nome do usuário como extra
                            intent.putExtra("nome", usuario.getNome());
                            // Iniciar a nova atividade
                            startActivity(intent);
                            // Finalizar a atividade de Cadastro
                            finish();
                        }
                    }, 3000); // Atraso de 3 segundos (3000 milissegundos)
                }
            }
        });
    }
}

package com.example.app_busmap;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;

public class CadastroBanco {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int inserirCadastro(Usuario usuario, Context ctx){
        int resposta = 0;

        try{
            PreparedStatement pst = ConexaoBanco.conectar(ctx).prepareStatement(
                    "Insert Into Usuario (nome, email, senha, statusUsuario, dataCadastro, nivelAcesso)"+
                            "values (?,?,?,?,?,?)"
            );

            String senha = Base64.getEncoder().encodeToString(usuario.getSenha().getBytes());
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, senha);
            pst.setInt(4, 1);
            pst.setDate(5, Date.valueOf(LocalDate.now().toString()));
            pst.setString(6, "USER");

            resposta = pst.executeUpdate();

        }catch (Exception e){
            e.getMessage();
        }
        return resposta;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Usuario logar(Context ctx, String senha, String email) throws Exception {
        try {
            PreparedStatement pst = ConexaoBanco.conectar(ctx).prepareStatement(
                    "select email, senha, nome from usuario where senha = ? and email = ?"
            );

            senha = Base64.getEncoder().encodeToString(senha.getBytes());
            System.out.println(senha);
            pst.setString(1, senha);
            pst.setString(2, email);
            System.out.println("aqui");


            ResultSet set = pst.executeQuery();
            System.out.println("aqui2");
            System.out.println(set);
            while (set.next()) {
                return new Usuario(set.getString(3), set.getString(1), set.getString(2));
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
           throw new Exception("Usuario não encontrado");
        }
        throw new Exception("Usuario não encontrado");
    }
}

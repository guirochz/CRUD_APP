package com.example.app_busmap.db;

import android.content.Context;

import com.example.app_busmap.ConexaoBanco;
import com.example.app_busmap.dtos.LinhaDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LinhaBanco {

    static public LinhaDTO obterLinhaPorNumero(Context ctx, String numero) throws Exception {

        try {
            PreparedStatement pst = ConexaoBanco.conectar(ctx).prepareStatement("select numero, empresa, nomeIda, nomeVolta, info from linha where numero = ?");
            pst.setString(1, numero);
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                return  new LinhaDTO(set.getString(3), set.getString(2), set.getString(1), set.getString(5), set.getString(4));
            }
        }
        catch (Exception e) {
            throw new Exception("linha não encontrada");
        }
        throw new Exception("linha não encontrada");
    }
    static public List<LinhaDTO> obterLinhas(Context ctx) {
        List<LinhaDTO> linhas = new ArrayList<>();

        try {
            PreparedStatement pst = ConexaoBanco.conectar(ctx).prepareStatement("select numero, empresa, nomeIda from linha");

            ResultSet set = pst.executeQuery();
            while (set.next()) {
                linhas.add(new LinhaDTO(set.getString(3), set.getString(2), set.getString(1)));
            }
        }
        catch (Exception e) {

        }
        return linhas;
    }

}

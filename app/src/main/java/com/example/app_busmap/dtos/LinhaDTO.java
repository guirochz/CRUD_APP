package com.example.app_busmap.dtos;

public class LinhaDTO {
    private String nomeIda;
    private String empresa;
    private String numero;

    private String info;

    public LinhaDTO(String nomeIda, String empresa, String numero) {
        this.nomeIda = nomeIda;
        this.empresa = empresa;
        this.numero = numero;
    }

    public String getNomeIda() {
        return nomeIda;
    }

    public void setNomeIda(String nomeIda) {
        this.nomeIda = nomeIda;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

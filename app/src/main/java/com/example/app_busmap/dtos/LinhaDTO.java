package com.example.app_busmap.dtos;

public class LinhaDTO {
    private String nomeIda;
    private String empresa;
    private String numero;

    private String info;

    private String nomeVolta;

    public LinhaDTO(String nomeIda, String empresa, String numero) {
        this.nomeIda = nomeIda;
        this.empresa = empresa;
        this.numero = numero;
    }

    public LinhaDTO(String nomeIda, String empresa, String numero, String info, String nomeVolta) {
        this.nomeIda = nomeIda;
        this.empresa = empresa;
        this.numero = numero;
        this.info = info;
        this.nomeVolta = nomeVolta;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNomeVolta() {
        return nomeVolta;
    }

    public void setNomeVolta(String nomeVolta) {
        this.nomeVolta = nomeVolta;
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

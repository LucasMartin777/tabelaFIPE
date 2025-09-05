package br.com.alura.models;


import com.fasterxml.jackson.annotation.JsonAlias;

public class DadosModelosCarrosAnos {
    @JsonAlias("codigo")
    private String codigo;   // mantém como String para Jackson

    @JsonAlias("nome")
    private String nome;

    public DadosModelosCarrosAnos() {
    } // Jackson precisa disso

    public String getNome() {
        return nome;
    }

    // Getter convertido → retorna 19981 em vez de "1998-1"
    public Integer getCodigo() {
        return Integer.parseInt(codigo.replace("-", ""));
    }

    // Getter opcional → mantém valor original do JSON
    public String getCodigoOriginal() {
        return codigo;


    }
}


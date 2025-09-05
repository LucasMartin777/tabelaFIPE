package br.com.alura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosCarroFinal {
    @JsonAlias("Valor")
    String valor;
    @JsonAlias("Marca")
    String marca;
    @JsonAlias("Modelo")
    String modelo;
    @JsonAlias("AnoModelo")
    Integer anoModelo;
    @JsonAlias("Combustivel")
    String combustivel;
    @JsonAlias("CodigoFipe")
    String codigoFipe;
    @JsonAlias("MesReferencia")
    String mesReferencia;
    @JsonAlias("SinglaCombustivel")
    String siglaCombustivel;

    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public Integer getCodigo() {
        return Integer.parseInt(codigoFipe.replace("-", ""));
    }

    // Getter opcional → mantém valor original do JSON
    public String getCodigoOriginal() {
        return codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    @Override
    public String toString() {
        return "valor= " + valor + '\n' +
                "marca= " + marca + '\n' +
                "modelo= " + modelo + '\n' +
                "anoModelo= " + anoModelo + '\n' +
                "combustivel= " + combustivel + '\n' +
                "codigoFipe= " + codigoFipe + '\n' +
                "mesReferencia= " + mesReferencia + '\n' +
                "siglaCombustivel= " + siglaCombustivel;
    }


}


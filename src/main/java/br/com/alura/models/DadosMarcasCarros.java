package br.com.alura.models;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcasCarros(@JsonAlias("codigo") Integer codigo,
                                @JsonAlias("nome") String nome) {
}

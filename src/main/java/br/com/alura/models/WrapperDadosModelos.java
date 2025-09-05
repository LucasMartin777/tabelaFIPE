package br.com.alura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WrapperDadosModelos(List<DadosModelosCarros> modelos,
                                  List<DadosModelosCarrosAnos> anos) {
}

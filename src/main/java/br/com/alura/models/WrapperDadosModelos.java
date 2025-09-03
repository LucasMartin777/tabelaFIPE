package br.com.alura.models;

import java.util.List;

public record WrapperDadosModelos(List<DadosModelosCarros> modelos,
                                  List<DadosModelosCarros> anos) {
}

package br.com.alura.principal;

import br.com.alura.models.*;
import br.com.alura.service.ConsumoApi;
import br.com.alura.service.ConverteDados;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    String tipoVeiculo = "";

    public static void main(String[] args) {

    }

    public void exibirMenu() {
        System.out.println("Por gentileza, informe o tipo de veiculo:\n1 - carro\n  \n2 - moto\n  \n3 - caminhao");
        int numeroSelecionado = leitura.nextInt();
        if (numeroSelecionado == 1) {
            tipoVeiculo = "carros/marcas";
        } else if (numeroSelecionado == 2) {
            tipoVeiculo = "motos/marcas";
        } else if (numeroSelecionado == 3) {
            tipoVeiculo = "caminhoes/marcas";

        }
        var json = consumo.conexao(ENDERECO + tipoVeiculo);
        List<DadosMarcasCarros> dados = conversor.obterLista(json, DadosMarcasCarros.class);
//        System.out.println(dados);

        Map<Integer, String> escolhaCarro = dados.stream()
                .collect(Collectors.toMap(DadosMarcasCarros::codigo, DadosMarcasCarros::nome));


        escolhaCarro.forEach((codigo, nome) -> System.out.println(codigo + " - " + nome));


        System.out.println("Por gentileza, informe a marca do veiculo:");
        int numeroSelecionado2 = leitura.nextInt();
        var json2 = consumo.conexao(ENDERECO + tipoVeiculo + "/" + numeroSelecionado2 + "/" + "modelos");

//        System.out.println(json2);

        WrapperDadosModelos dados2 = conversor.obterDados(json2, WrapperDadosModelos.class);

        Map<Integer, String> escolhaCarro2 = dados2.modelos().stream()
                .collect(Collectors.toMap(DadosModelosCarros::codigo, DadosModelosCarros::nome));


        escolhaCarro2.forEach((codigo, nome) -> System.out.println(codigo + " - " + nome));


        System.out.println("Por gentileza, informe o modelo do veiculo:");


        leitura.nextLine();
        String numeroSelecionado3 = leitura.nextLine();


        var json3 = consumo.conexao(ENDERECO + tipoVeiculo + "/" + numeroSelecionado2 + "/" + "modelos" + "/" + numeroSelecionado3 + "/" + "anos");

        List<DadosModelosCarrosAnos> dados4 = conversor.obterLista(json3, DadosModelosCarrosAnos.class);


        dados4.forEach(modelo -> System.out.println(modelo.getCodigo() + " - " + modelo.getNome()));


        System.out.println("Por gentileza, escolha o ano do seu carro:\n");


        String numeroSelecionado4 = leitura.nextLine();


        var json4 = consumo.conexao(ENDERECO + tipoVeiculo + "/" + numeroSelecionado2 + "/" + "modelos" + "/" + numeroSelecionado3 + "/" + "anos" + "/" + "1992-1");

        List<DadosCarroFinal> dados5 = conversor.obterLista(json4, DadosCarroFinal.class);

        System.out.println(dados5);

//        dados5.forEach(modelo -> System.out.println(modelo.getCodigo() + " - " + modelo.getNome()));


    }

}

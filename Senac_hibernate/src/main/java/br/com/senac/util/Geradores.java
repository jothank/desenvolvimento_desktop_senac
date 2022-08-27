/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jonathan.costa1
 */
public class Geradores {

    /**
     * qtd é a quantidade de números que serão gerados.
     *
     * @param qtd
     * @return exemplo qtd = 3 -> "123"
     */
    public static String gerarNumero(int qtd) {
        String numero = "";
        for (int i = 0; i < qtd; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }

    public static String gerarTelefoneFixo() {
        //(99) 9999-9999
        String telFixo = "(48) 3" + gerarNumero(3) + "-" + gerarNumero(4);
        return telFixo;
    }

    public static String gerarTelefoneCelular() {
        //(99) 99999-9999
        String telCel = "(48) 9" + gerarNumero(4) + "-" + gerarNumero(4);
        return telCel;
    }

    public static String gerarCpf() {
        //999.999.999-99
        String cpf = gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
        return cpf;
    }

    public static String gerarCnpj() {
        //99.999.999/9999-99
        String cnpj = gerarNumero(2) + "." + gerarNumero(3) + "." + gerarNumero(3) + "/" + gerarNumero(4) + "-" + gerarNumero(2);
        return cnpj;
    }

    public static String gerarCep() {
        //99.999-999
        String cep = gerarNumero(2) + "." + gerarNumero(3) + "-" + gerarNumero(3);
        return cep;
    }

    public static String gerarSenha(int qtd) {
        String[] caracteres = {"$", "_", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String senha = "";
        int indice;
        int tamanhoLista = caracteres.length;
        for (int i = 0; i < qtd; i++) {
            indice = (int) (Math.random() * tamanhoLista);
            senha += caracteres[indice];
        }
        return senha;
    }

    public static String gerarNome() {
        String[] nomes = {"Pedro", "Paulo", "Thiago", "Gustavo", "Mauricio", "Jonathan", "Silvio", "Rafael", "José", "João",
            "Ana", "Flavia", "Jessica", "Natalia", "Carla", "Maria", "Roberta", "Nina", "Rosa", "Elisa"};
        int indice = (int) (Math.random() * nomes.length);
        return nomes[indice];
    }

    public static String gerarNome2() {
        List<String> nomes = Arrays.asList("Pedro", "Paulo", "Thiago", "Gustavo", "Mauricio", "Jonathan", "Silvio", "Rafael", "José", "João",
                "Ana", "Flavia", "Jessica", "Natalia", "Carla", "Maria", "Roberta", "Nina", "Rosa", "Elisa");
        Collections.shuffle(nomes);
        return nomes.get(0) + " " + gerarSobrenome();
    }

    private static String gerarSobrenome() {
        List<String> sobrenomes = Arrays.asList("Abreu", "Costa", "Cardoso", "Oliviera", "Silva", "Vidal", "Albuquerque", "Freitas", "Amorim", "Gonçalves",
                "Souza", "Medeiros", "Machado", "Santos", "Almeida", "Braga", "Heinzen", "Alves", "Ribeiro", "Siqueira ");
        Collections.shuffle(sobrenomes);
        return sobrenomes.get(0);
    }

    public static String gerarLogin() {
        List<String> logins = Arrays.asList("Pedro", "Paulo", "Thiago", "Gustavo", "Mauricio", "Jonathan", "Silvio", "Rafael", "José", "João",
                "Ana", "Flavia", "Jessica", "Natalia", "Carla", "Maria", "Roberta", "Nina", "Rosa", "Elisa");
        Collections.shuffle(logins);
        return "@" + logins.get(0).toLowerCase();
    }

    public static String gerarCidade() {
        List<String> cidades = Arrays.asList("São José", "Florianopolis", "Palhoça", "Biguaçu", "Santo Amaro", "Tijucas", "Paris", "Londres", "Berlim", "Nova York",
                "Toronto", "Sydney", "Roma", "Lisboa", "Milão", "Tokyo", "Pequim", "Moscou", "Istambul", "Salvador");
        Collections.shuffle(cidades);
        return cidades.get(0);
    }

    public static String gerarBairro() {
        List<String> bairros = Arrays.asList("Roçado", "Kobrasol", "Campinas", "Estreito", "Coqueiros", "Centro");
        Collections.shuffle(bairros);
        return bairros.get(0);
    }

    public static String gerarUf() {
        List<String> ufs = Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        Collections.shuffle(ufs);
        return ufs.get(0);

    }
}

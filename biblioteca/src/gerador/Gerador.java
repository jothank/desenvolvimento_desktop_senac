package gerador;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Random;

public class Gerador {

    //receber da outra classe quantidade de numeros que quero gerar e trazer 3 numeros strings
    public static String gerarNumero(int quantidade) {
        String numero = "";
        for (int i = 0; i < quantidade; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }

    public static String gerarNumero() {
        String gerarNumero = gerarNumero(1);
        return gerarNumero;

    }

    public static String gerarTelefoneFixo() {
        String telefoneFixo = "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
        return telefoneFixo;
    }

    public static String gerarTelefoneCelular() {
        String telefoneCelular = "(48)9" + gerarNumero(4) + "-" + gerarNumero(4);
        return telefoneCelular;
    }

    public static String gerarCPF() {
        String cpf = gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);
        return cpf;
    }

    public static String gerarCNPJ() {
        String cnpj = gerarNumero(2) + "." + gerarNumero(3) + "." + gerarNumero(3) + "/" + gerarNumero(4) + "-" + gerarNumero(2);
        return cnpj;
    }

    public static String gerarCEP() {
        String cep = gerarNumero(5) + "-" + gerarNumero(3);
        return cep;
    }

    public static String gerarSenha() {
        Random ran = new Random();
        String[] letras = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String senhaFinal = "";

        int quantidadeSenha = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de caracteres para sua senha: "));

        for (int i = 0; i < quantidadeSenha; i++) {
            int a = ran.nextInt(letras.length);
            senhaFinal += letras[a];
        }
        return senhaFinal;
    }

    public static String gerarNomes() {
        String[] nomes = {"Jonathan", "Pedro", "Thiago"};
        int indice = (int) (Math.random() * nomes.length);
        return nomes[indice];
    }

    public static String gerarNomes2() {
        List<String> nomes = Arrays.asList("Jonathan", "Pedro", "Thiago", "apple", "mango", "papaya", "banana", "guava", "pineapple", "Abbott", "Abernathy", "Abshire", "Adams", "Altenwerth", "Anderson", "Ankunding", "Armstrong", "Auer", "Aufderhar");
        Collections.shuffle(nomes);
        return nomes.get(0);
    }

    private static String gerarSobrenome() {
        List<String> sobreNome = Arrays.asList("Jonathan", "Pedro", "Thiago", "apple", "mango", "papaya", "banana", "guava", "pineapple", "Abbott", "Abernathy", "Abshire", "Adams", "Altenwerth", "Anderson", "Ankunding", "Armstrong", "Auer", "Aufderhar");
        Collections.shuffle(sobreNome);
        return sobreNome.get(0);
    }

    public static String gerarUF() {
        String[] uf = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        int indice = (int) (Math.random() * uf.length);
        return uf[indice];
    }

    public static String gerarBairro() {
        String[] bairro = {"Canasvieira", "Centro", "Aririu", "Serraria", "Forquilhas"};
        int indice = (int) (Math.random() * bairro.length);
        return bairro[indice];
    }

    public static String gerarCidade() {
        String[] cidade = {"Palhoça", "", "Florianopolis", "São José", "Biguaçu"};
        int indice = (int) (Math.random() * cidade.length);
        return cidade[indice];
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Nomes: " + gerarNomes2() + " " + gerarSobrenome()
                + "\nCPF: " + gerarCPF()
                + "\nCNPJ: " + gerarCNPJ()
                + "\nCEP: " + gerarCEP()
                + "\nEstado : " + gerarUF()
                + "\nCidade : " + gerarCidade()
                + "\nBairro : " + gerarBairro()
                + "\nTelefone Fixo: " + gerarTelefoneFixo()
                + "\nTelefone Celular: " + gerarTelefoneCelular());
        JOptionPane.showMessageDialog(null, "Login: " + gerarNomes()
                + "\nSenha: " + gerarSenha());
    }

}

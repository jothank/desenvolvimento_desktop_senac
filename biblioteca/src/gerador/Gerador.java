package gerador;

import javax.swing.JOptionPane;

public class Gerador {

    //receber da outra classe quantidade de numeros que quero gerar e trazer 3 numeros strings
    public static String gerarNumero(int quantidade) {
        String numero = "";
        for (int i = 0; i < quantidade; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
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

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Telefone Fixo: " + gerarTelefoneFixo());
        JOptionPane.showMessageDialog(null, "Telefone Celular: " + gerarTelefoneCelular());
        JOptionPane.showMessageDialog(null, "CPF: " + gerarCPF());

    }

}

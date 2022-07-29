package aula01;

import aula01_service.Calculadora;
import java.util.Random;
import javax.swing.JOptionPane;

public class Exemplo01 {

    public static void main(String[] args) {

        Random random = new Random();

        int valor1 = 10;
        int valor2 = 7;
        int valor3 = 12;
        String frase = "Simples como amar";
        int num_int = random.nextInt(9);

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));

        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));

        JOptionPane.showMessageDialog(null, "Soma de " + num1 + " com numero " + num2 + " é = " + (num1 + num2));

        Calculadora calculadora = new Calculadora();

        calculadora.somar(num_int, num_int, num_int);

        calculadora.exibir_frase(frase);

        calculadora.numero(num_int);

    }

}

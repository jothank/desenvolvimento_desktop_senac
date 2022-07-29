package aula01_service;

public class Calculadora {

    public int somar(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    public int exibir_frase(String exibir) {
        int quantidade = exibir.length();
        System.out.println(quantidade);
        return 0;
    }

    public int numero(int random_num) {
        System.out.println(random_num);
        return 0;
    }

}

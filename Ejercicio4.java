package controller.ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

    public static void ini() {
        ejecutar();
    }

    private static int generateNumerador(int n) {
        if (n <= 1) {
            return 1;
        }
        int fibo1 = 1, fibo2 = 1, fibonacci = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }

    private static int generateDenominador(int n) {
        return 2 * n + 1;
    }

    private static int generateExponente(int n) {
        return 2 * (n + 1);
    }

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de términos de la serie: ");
        String numero = sc.nextLine();
        int numeroserie = Integer.parseInt(numero);
        StringBuilder serie = new StringBuilder();
        
        double suma = 0.0;
        int signo = 1;
        int count = 0;

        for (int i = 0; i < numeroserie; i++) {
            int numerador = generateNumerador(i);
            int denominador = generateDenominador(i);
            int exponente = generateExponente(i);
            double termino = Math.pow((double) numerador / denominador, exponente);

            if (count == 2) {
                signo *= -1;  
                count = 0;  
            }

            if (signo == -1) {
                serie.append(" - (").append(numerador).append("/").append(denominador).append(")^").append(exponente);
                suma -= termino;
            } else {
                if (i > 0 && serie.length() > 0) {
                    serie.append(" + ");
                }
                serie.append("(").append(numerador).append("/").append(denominador).append(")^").append(exponente);
                suma += termino;
            }

            count++;
        }

        System.out.println("La serie es:");
        System.out.println(serie.toString());
        System.out.println("La suma de la serie es: " + suma);
        sc.close();
    }
}

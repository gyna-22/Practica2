package views;

import controller.ejercicios.*;
import java.util.Scanner;

public class Mainpractica2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("----- EJERCICIOS -----");
            System.out.println("1. Ventas de autos");
            System.out.println("2. Llamadas internacionales");
            System.out.println("3. Consumo de agua potable");
            System.out.println("4. Serie matemática");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    Ejercicio1 ejercicio1 = new Ejercicio1();
                    ejercicio1.ini();
                    continuar = false;  
                    break;
                case 2:
                    Ejercicio2 ejercicio2 = new Ejercicio2();
                    ejercicio2.ini();
                    continuar = false;  
                    break;
                case 3:
                    Ejercicio3 ejercicio3 = new Ejercicio3();
                    ejercicio3.ini();
                    continuar = false;  
                    break;
                case 4:
                    Ejercicio4 ejercicio4 = new Ejercicio4();
                    ejercicio4.ini();
                    continuar = false;  
                    break;
                case 0: 
                    continuar = false; 
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                    break;
            }
        }

        sc.close();
    }
}

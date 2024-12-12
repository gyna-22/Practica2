package controller.ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

    public static void ini() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el consumo en m³:");
        double consumo = sc.nextDouble();
        
        System.out.println("Es contribuyente de tercera edad (si/no):");
        boolean terceraEdad = sc.next().equalsIgnoreCase("si");
        
        System.out.println("Tiene discapacidad (si/no):");
        boolean discapacidad = sc.next().equalsIgnoreCase("si");
        
        double porcentajeDiscapacidad = 0;
        if (discapacidad) {
            System.out.println("Ingrese el porcentaje de discapacidad:");
            porcentajeDiscapacidad = sc.nextDouble();
        }
        

        double valorAguaPotable = calcularValorAgua(consumo);
        double descuento = calcularDescuento(valorAguaPotable, consumo, terceraEdad, discapacidad, porcentajeDiscapacidad);
        double impuestoAlcantarillado = valorAguaPotable * 0.35;
        double tasaRecoleccionBasura = 0.75;
        double tasaProcesamientoDatos = 0.50;
        
        double total = valorAguaPotable - descuento + impuestoAlcantarillado + tasaRecoleccionBasura + tasaProcesamientoDatos;

        System.out.println("Valor del servicio de agua potable: $" + valorAguaPotable);
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Impuesto de alcantarillado: $" + impuestoAlcantarillado);
        System.out.println("Tasa por recolección de basura: $" + tasaRecoleccionBasura);
        System.out.println("Tasa por costo de procesamiento de datos: $" + tasaProcesamientoDatos);
        System.out.println("Total a pagar: $" + total);
    }

    public static double calcularValorAgua(double consumo) {
        double valor = 0;
        if (consumo <= 15) {
            valor = 3.00;
        } else if (consumo <= 25) {
            valor = 3.00 + (consumo - 15) * 0.10;
        } else if (consumo <= 40) {
            valor = 3.00 + 10 * 0.10 + (consumo - 25) * 0.20;
        } else if (consumo <= 60) {
            valor = 3.00 + 10 * 0.10 + 15 * 0.20 + (consumo - 40) * 0.30;
        } else {
            valor = 3.00 + 10 * 0.10 + 15 * 0.20 + 20 * 0.30 + (consumo - 60) * 0.35;
        }
        return valor;
    }

    public static double calcularDescuento(double valorAguaPotable, double consumo, boolean terceraEdad, boolean discapacidad, double porcentajeDiscapacidad) {
        if (terceraEdad) {
            if (consumo <= 15) {
                return valorAguaPotable * 0.50;
            } else {
                return valorAguaPotable * 0.30;
            }
        } else if (discapacidad) {
            return 3.00 * (porcentajeDiscapacidad / 100);
        }
        return 0;
    }

}

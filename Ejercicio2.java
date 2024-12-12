package controller.ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

    public static void ini(){
        int clave, min; 
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Lista para llamada telefonica extranjera ---");

        for (Zona zona : Zona.values()){
         System.out.println(zona.toString()+  " " + " " + zona.clave + " " + " " + zona.precioMinutoUSD );
        }

        String titulo = "Ingrese la clave: ";
        System.out.println(titulo);
        clave = sc.nextInt();

        String titulo1 = "Ingrese en tiempo en minutos hablado: ";
        System.out.println(titulo1);
        min = sc.nextInt();

        totalMinporclave(clave, min);
    }

    public static void totalMinporclave(int clave, int min){
        Zona zona = Zona.buscarPorClave(clave);
        if (zona == null) System.out.println("La clave ingresada no existe ");

        System.out.println("Su tarifa final es: " + min * zona.precioMinutoUSD);
    } 

    
    public static enum Zona {
        
        AMERICA_DEL_NORTE(12, 2.75),
        AMERICA_CENTRAL(15, 1.89),
        AMERICA_DEL_SUR(18, 1.60),
        EUROPA(19, 3.5),
        ASIA(23, 4.5),
        AFRICA(25, 3.1),
        OCEANIA(29, 3),
        RESTO_DEL_MUNDO(31, 6);

        private final int clave;
        private final double precioMinutoUSD;

        Zona(int clave, double precioMinutoUSD) {
            this.clave = clave;
            this.precioMinutoUSD = precioMinutoUSD;
        }

        public int getClave() { return clave; }
        public double getPrecioMinutoUSD() { return precioMinutoUSD; }

        public static Zona buscarPorClave(int clave) {
            for (Zona zona : Zona.values()) {
                if (zona.getClave() == clave) {
                    return zona;
                }
            }
            return null;
        }
    }
}

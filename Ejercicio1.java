package controller.ejercicios;

import java.util.Scanner;

public class Ejercicio1 {
    public static void ini() {
	
	    double sueldo = 2500;		
	
        Reporte reporte = new Reporte();        
			
        Scanner sc = new Scanner(System.in);
        int cont = 1;
        String titulo = "Ingrese el precio final del auto: " + cont;
        System.out.println(titulo);
        while (sc.hasNextDouble()){            
            double precio = sc.nextDouble();            

            reporte.ventaTotalAutos += precio;
            reporte.comisionTotalPorAutos += calcularComisionesAutos(precio);

            System.out.println("Auto registrado con exito. ¿Desea registrar otro? (si/no)");
            String respuesta = sc.next();
            if (!respuesta.equalsIgnoreCase("si")) {
                break;
            }            
            cont++;            
            System.out.println("Ingrese el precio final del auto: " + cont);
        };            

        reporte.totalAutos = cont;        
        reporte.comisionTotalPorVentas = calcularComisionesPorVentas(reporte.ventaTotalAutos);
        reporte.sueldoTotal = sueldo + reporte.comisionTotalPorAutos + reporte.comisionTotalPorVentas;

        System.out.println("Total de autos vendidos: " + reporte.totalAutos);
        System.out.println("Total de ventas: " + reporte.ventaTotalAutos);
        System.out.println("Sueldo: " + sueldo);
        System.out.println("Total de comisiones por autos: " + reporte.comisionTotalPorAutos);
        System.out.println("Total de comisiones por ventas: " + reporte.comisionTotalPorVentas);
        System.out.println("Sueldo total: " + reporte.sueldoTotal);
    }	        

    public static double calcularComisionesAutos(double valorAuto ){
        double comisionPorAuto = 250;
        double totalMaxComision = 10000;
        if(valorAuto > totalMaxComision){
            return comisionPorAuto;
        }
        return 0;
    }

    public static double calcularComisionesPorVentas(double ventaTotalAutos){
        return ventaTotalAutos * 0.05;
    }
    
	public static class Reporte{
        public int totalAutos = 0;
        public double ventaTotalAutos = 0;
        public double sueldoTotal = 0;
        public double comisionTotalPorAutos = 0;
        public double comisionTotalPorVentas = 0;
    }
}



    


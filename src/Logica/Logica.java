package Logica;
import java.util.ArrayList;

import Utilidades.Utilidad;

public class Logica {

    private ArrayList<Integer> array1 = new ArrayList<>();
    private ArrayList<Integer> array2 = new ArrayList<>();
    private ArrayList<Integer> array3 = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public void Llenado(){
        long startTime = System.nanoTime(); // Tiempo de inicio
        array1 = Utilidad.Llenado(10000); // Llamada a la función
        long endTime = System.nanoTime(); // Tiempo de finalización

        // Calcular el tiempo transcurrido en nanosegundos
        long duration = endTime - startTime;
        double durationInSeconds = duration / 1_000_000_000.0;

        System.out.println("Tiempo de ejecución: " + durationInSeconds + " segundos");
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
    }

    public void Mostrar(){

        String s = "[";
        for (Integer x : array1) {
            s+=x+", ";
        }
        s+="]";
        Utilidad.Listar(s, "Array de 10000");

    }

}

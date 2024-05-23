package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Utilidades.Utilidad;

public class Logica {

    private ArrayList<Integer> burbuja = new ArrayList<>();
    private ArrayList<Integer> seleccion = new ArrayList<>();
    private ArrayList<Integer> quitsort = new ArrayList<>();
    private ArrayList<Integer> mergesort = new ArrayList<>();

    @SuppressWarnings("unchecked")
    // Resive la lista a llenar y el tamaño de datos por parametro
    public void Llenado(ArrayList<Integer> lista, int tamaño) {
        long startTime = System.nanoTime(); // Tiempo de inicio
        lista = Utilidad.Llenado(tamaño); // Llamada a la función
        long endTime = System.nanoTime(); // Tiempo de finalización

        // Calcular el tiempo transcurrido en nanosegundos
        long duration = endTime - startTime;
        double durationInSeconds = duration / 1_000_000_000.0;

        System.out.println("Tiempo de ejecución: " + durationInSeconds + " segundos");
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
    }

    // Resive la lista a mostrar por parametro
    public void Mostrar(ArrayList<Integer> lista) {

        String s = "[";
        for (Integer x : lista) {
            s += x + ", ";
        }
        s += "]";
        Utilidad.Listar(s, "Array de" + lista.size());

    }

    public void inicioPrueba() {
        Creat x = new Creat();
        int[] vectIndice = { 100, 1000, 10000 };
        Long[] vectTiempo = new Long[4];
        x.delete();
        auxBurbuja(vectIndice,vectTiempo);
        auxseleccion(vectIndice, vectTiempo);
        auxQuitSort(vectIndice, vectTiempo);
        auxzMergeSort(vectIndice, vectTiempo);
    }

    private void auxBurbuja(int[] vectIndice, Long[] vectTiempo){
        Creat creat = new Creat();
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                burbuja = Utilidad.Llenado(vectIndice[i]); 
                long startTime = System.nanoTime(); // Tiempo de inicio
                burbuja(burbuja);// Llamada a la función
                long endTime = System.nanoTime(); // Tiempo de finalización
                // Calcular el tiempo transcurrido en nanosegundos
               vectTiempo[i] = endTime - startTime;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            } else {
            long prom = (vectTiempo[0]+vectTiempo[1]+vectTiempo[2])/3;
                vectTiempo[i]=prom ;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            }

        }

    }

    private void auxseleccion(int[] vectIndice, Long[] vectTiempo){
        Creat creat = new Creat();
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                burbuja = Utilidad.Llenado(vectIndice[i]); 
                long startTime = System.nanoTime(); // Tiempo de inicio
                seleccion(seleccion);// Llamada a la función
                long endTime = System.nanoTime(); // Tiempo de finalización
                // Calcular el tiempo transcurrido en nanosegundos
               vectTiempo[i] = endTime - startTime;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            } else {
            long prom = (vectTiempo[0]+vectTiempo[1]+vectTiempo[2])/3;
                vectTiempo[i]=prom ;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            }

        }

    }

    @SuppressWarnings("unchecked")
    private void auxQuitSort(int[] vectIndice, Long[] vectTiempo){
        Creat creat = new Creat();
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                burbuja = Utilidad.Llenado(vectIndice[i]); 
                long startTime = System.nanoTime(); // Tiempo de inicio
                sort(quitsort);// Llamada a la función
                long endTime = System.nanoTime(); // Tiempo de finalización
                // Calcular el tiempo transcurrido en nanosegundos
               vectTiempo[i] = endTime - startTime;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            } else {
            long prom = (vectTiempo[0]+vectTiempo[1]+vectTiempo[2])/3;
                vectTiempo[i]=prom ;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            }

        }

    }

    @SuppressWarnings("unchecked")
    private void auxzMergeSort(int[] vectIndice, Long[] vectTiempo){
        Creat creat = new Creat();
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                burbuja = Utilidad.Llenado(vectIndice[i]); 
                long startTime = System.nanoTime(); // Tiempo de inicio
                Msort(mergesort);// Llamada a la función
                long endTime = System.nanoTime(); // Tiempo de finalización
                // Calcular el tiempo transcurrido en nanosegundos
               vectTiempo[i] = endTime - startTime;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            } else {
            long prom = (vectTiempo[0]+vectTiempo[1]+vectTiempo[2])/3;
                vectTiempo[i]=prom ;
                creat.escribir("1",""+i,vectTiempo[i].toString());
            }

        }

    }


    // Resive la lista a ordemar por parametro
    public void burbuja(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
    }

    // Resive la lista a ordemar por parametro
    public void seleccion(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j) < lista.get(minIdx)) {
                    minIdx = j;
                }
            }
            Collections.swap(lista, i, minIdx);
        }
    }

     // Método público que inicia el proceso de ordenamiento
     public void sort(ArrayList<Integer> lista) {
        if (lista == null || lista.size() < 2) {
            return;  // No hay nada que ordenar
        }
        quickSort(lista, 0, lista.size() - 1);
    }

    // Resive la lista a ordear por parametro
    private void quickSort(ArrayList<Integer> lista, int low, int high) {
        if (low < high) {
            int pi = partition(lista, low, high);
            quickSort(lista, low, pi - 1);
            quickSort(lista, pi + 1, high);
        }
    }

    private int partition(ArrayList<Integer> lista, int low, int high) {
        int pivot = lista.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (lista.get(j) < pivot) {
                i++;
                Collections.swap(lista, i, j);
            }
        }
        Collections.swap(lista, i + 1, high);
        return i + 1;
    }

    // Método público que inicia el proceso de ordenamiento
    public void Msort(ArrayList<Integer> lista) {
        if (lista == null || lista.size() < 2) {
            return; // No hay nada que ordenar
        }
        mergeSort(lista, 0, lista.size() - 1); // Envia la lista y los limites de ordenamiento.
    }

    // Método recursivo para dividir la lista
    public void mergeSort(ArrayList<Integer> lista, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(lista, l, m);
            mergeSort(lista, m + 1, r);
            merge(lista, l, m, r);
        }
    }

    // Método para combinar las sublistas ordenadas
    private void merge(ArrayList<Integer> lista, int l, int m, int r) {
        // Crear sublistas usando subList
        List<Integer> L = new ArrayList<>(lista.subList(l, m + 1));
        List<Integer> R = new ArrayList<>(lista.subList(m + 1, r + 1));

        int i = 0, j = 0;
        int k = l;

        // Mezclar las dos sublistas
        while (i < L.size() && j < R.size()) {
            if (L.get(i) <= R.get(j)) {
                lista.set(k, L.get(i));
                i++;
            } else {
                lista.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L (si los hay)
        while (i < L.size()) {
            lista.set(k, L.get(i));
            i++;
            k++;
        }

        // Copiar los elementos restantes de R (si los hay)
        while (j < R.size()) {
            lista.set(k, R.get(j));
            j++;
            k++;
        }
    }

}

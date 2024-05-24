package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import Utilidades.Utilidad;

public class Logica {

    private ArrayList<Integer> burbuja = new ArrayList<>();
    private ArrayList<Integer> seleccion = new ArrayList<>();
    private ArrayList<Integer> quitsort = new ArrayList<>();
    private ArrayList<Integer> mergesort = new ArrayList<>();
    private Integer[] Vseleccion;

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
        int op = 0;
        x.delete();
        auxOrdenamiento(vectIndice, vectTiempo);
       // ordenamientoArrayVect(vectIndice, vectTiempo);
        // do {
        // op = Integer.parseInt(JOptionPane.showInputDialog(null, "---Menu para ver
        // Arrays---\n"
        // + "1.Array Burbuja.\n"
        // + "2.Array Seleccion.\n"
        // + "3.Array QuickSort.\n"
        // + "4.Array MergeSort.\n"
        // + "0.Salir.\n"));
        // switch (op) {
        // case 1:
        // Mostrar(burbuja);
        // break;
        // case 2:
        // Mostrar(seleccion);
        // break;
        // case 3:
        // Mostrar(quitsort);
        // break;
        // case 4:
        // Mostrar(mergesort);
        // break;
        // case 0:
        // JOptionPane.showInternalMessageDialog(null, "Chao...");
        // break;
        // default:
        // break;
        // }

        // } while (op != 0);
    }

    // ingresa por paramtro el tipo de ordenamiento y dos vectores para manejar
    // tamaño y tiempos
    private void auxOrdenamiento(int[] vectIndice, Long[] vectTiempo) {
        Creat creat = new Creat();
        long endTime = 0;
        long startTime = 0;
        String[] ord = { "Burbuja", "Seleccion", "Quitsort", "Mergesort","Vector Seleccion " };
        for (int k = 0; k < 5; k++) {

            for (int j = 0; j < 3; j++) {

                for (int i = 0; i < 3; i++) {
                    ArrayList lista = Utilidad.Llenado(vectIndice[j]);
                    switch (k) {
                        case 0:
                            burbuja = lista;
                            startTime = System.nanoTime(); // Tiempo de inicio
                            burbuja(burbuja);// Llamada a la función
                            endTime = System.nanoTime(); // Tiempo de finalización
                            // Calcular el tiempo transcurrido en nanosegundos
                            vectTiempo[i] = endTime - startTime;
                            // Guardar los datos en archivo plano.
                            creat.escribir(ord[k], "" + i, vectIndice[j], vectTiempo[i].toString());
                            break;

                        case 1:
                            seleccion = lista;
                            startTime = System.nanoTime(); // Tiempo de inicio
                            seleccion(seleccion);// Llamada a la función
                            endTime = System.nanoTime(); // Tiempo de finalización
                            // Calcular el tiempo transcurrido en nanosegundos
                            vectTiempo[i] = endTime - startTime;
                            // Guardar los datos en archivo plano.
                            creat.escribir(ord[k], "" + i, vectIndice[j], vectTiempo[i].toString());
                            break;
                        case 2:
                            quitsort = lista;
                            startTime = System.nanoTime(); // Tiempo de inicio
                            sort(quitsort);// Llamada a la función
                            endTime = System.nanoTime(); // Tiempo de finalización
                            // Calcular el tiempo transcurrido en nanosegundos
                            vectTiempo[i] = endTime - startTime;
                            // Guardar los datos en archivo plano.
                            creat.escribir(ord[k], "" + i, vectIndice[j], vectTiempo[i].toString());
                            break;
                        case 3:
                            mergesort = lista;
                            startTime = System.nanoTime(); // Tiempo de inicio
                            Msort(mergesort);// Llamada a la función
                            endTime = System.nanoTime(); // Tiempo de finalización
                            // Calcular el tiempo transcurrido en nanosegundos
                            vectTiempo[i] = endTime - startTime;
                            // Guardar los datos en archivo plano.
                            creat.escribir(ord[k], "" + i, vectIndice[j], vectTiempo[i].toString());
                            break;
                        case 4:
                        Vseleccion = Utilidad.llenado(vectIndice[j]);
                        startTime = System.nanoTime(); // Tiempo de inicio
                        seleccion();// Llamada a la función
                        endTime = System.nanoTime(); // Tiempo de finalización
                        // Calcular el tiempo transcurrido en nanosegundos
                        vectTiempo[i] = endTime - startTime;
                        // Guardar los datos en archivo plano.
                        creat.escribir(ord[k], "" + i, vectIndice[j], vectTiempo[i].toString());
                            break;
                        default:
                            break;
                    }

                }
                long prom = (vectTiempo[0] + vectTiempo[1] + vectTiempo[2]) / 3;
                vectTiempo[3] = prom;
                creat.escribir(ord[k], "Promedio", vectIndice[j], vectTiempo[3].toString());

            }
        }
    }

    private void ordenamientoArrayVect(int[] vectIndice, Long[] vectTiempo) {
        Creat creat = new Creat();
        long endTime = 0;
        long startTime = 0;
        for (int j = 0; j < 3; j++) {

            for (int i = 0; i < 3; i++) {
                Vseleccion = Utilidad.llenado(vectIndice[j]);
                startTime = System.nanoTime(); // Tiempo de inicio
                seleccion();// Llamada a la función
                endTime = System.nanoTime(); // Tiempo de finalización
                // Calcular el tiempo transcurrido en nanosegundos
                vectTiempo[i] = endTime - startTime;
                // Guardar los datos en archivo plano.
                creat.escribir("Vector Seleccion ", "" + i, vectIndice[j], vectTiempo[i].toString());

            }
            long prom = (vectTiempo[0] + vectTiempo[1] + vectTiempo[2]) / 3;
            vectTiempo[3] = prom;
            creat.escribir("Vector Seleccion ", "" + 3, vectIndice[j], vectTiempo[3].toString());

        }

    }

    private void seleccion() {
        int n = Vseleccion.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (Vseleccion[j] < Vseleccion[minIdx]) {
                    minIdx = j;
                }
            }
            // Intercambia el elemento mínimo con el primer elemento de la sublista
            int temp = Vseleccion[minIdx];
            Vseleccion[minIdx] = Vseleccion[i];
            Vseleccion[i] = temp;
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
            return; // No hay nada que ordenar
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

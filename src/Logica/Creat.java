
package Logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creat {
      // Ruta relativa al archivo
    private String Archivo = "archivo.txt";
    
    public void escribir(String a, String b, String c){
            // Contenido a escribir
            String contenido = a+";"+b+";"+c;
            
            // Abre el archivo en modo 'append' para añadir contenido al final
            try (FileWriter archivo = new FileWriter(Archivo, true)) {
                // Escribe la línea con el formato especificado y un salto de línea
                archivo.write(contenido + "\n");
                System.out.println("Línea añadida al archivo: " + contenido);
            } catch (IOException e) {
                // Manejo de la excepción en caso de error
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    

    public void delete(){
        File archivo = new File(Archivo);
        archivo.delete();
    }
    
}




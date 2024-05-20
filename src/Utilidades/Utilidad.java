package Utilidades;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Utilidad {
    
    public static ArrayList Llenado(int max){
        ArrayList<Integer> x = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            x.add((int) (Math.random()*max)+1);
        }

        return x;
    }

    public static void Listar(String s, String titulo){
        int p = 500, t = 300;
        JTextArea textArea = new JTextArea(s);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(p, t));
        JOptionPane.showMessageDialog(null, scrollPane, titulo, 1);
    }
}

package DesarrolloDeInterfaces.Swing.EjercicioTarta;



import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JFrame;

import javax.swing.JPanel;



public class GraficoTarta extends JPanel {



    private int[] valores;

    private Color[] colores = {

            Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE,

            Color.CYAN, Color.MAGENTA, Color.PINK, Color.YELLOW

    };



    public GraficoTarta(int[] valores) {

        this.valores = valores;

    }



    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);



        int suma = 0;

        for (int v : valores) suma += v;



        if (suma == 0) return;



        int inicio = 0;

        int ancho = 300;

        int alto = 300;

        int x = 50;

        int y = 50;



        for (int i = 0; i < valores.length; i++) {

            int angulo = (int) Math.round(360.0 * valores[i] / suma);

            g.setColor(colores[i % colores.length]);

            g.fillArc(x, y, ancho, alto, inicio, angulo);

            inicio += angulo;

        }

    }

}
package DesarrolloDeInterfaces.Swing.EjercicioTarta;

import javax.swing.*;



import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class VentanaEstadistica extends JFrame {



    private JTextField[] campos;

    private JButton boton;



    public VentanaEstadistica() {

        setTitle("Gráfico Estadístico (Tarta)");

        setSize(400, 300);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);



        JLabel titulo = new JLabel("Introduce valores numéricos:");

        titulo.setBounds(20, 10, 200, 25);

        add(titulo);



        // --- Crea 5 campos por ejemplo ---

        campos = new JTextField[5];

        for (int i = 0; i < campos.length; i++) {

            campos[i] = new JTextField();

            campos[i].setBounds(20, 40 + i * 30, 100, 25);

            add(campos[i]);

        }



        boton = new JButton("Generar gráfico");

        boton.setBounds(150, 200, 150, 30);

        add(boton);



        boton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                generarGrafico();

            }

        });

    }



    private void generarGrafico() {

        try {

            int[] datos = new int[campos.length];

            for (int i = 0; i < campos.length; i++) {

                datos[i] = Integer.parseInt(campos[i].getText());

            }



            JFrame grafico = new JFrame("Gráfico de Tarta");

            grafico.setSize(450, 450);

            grafico.add(new GraficoTarta(datos));

            grafico.setVisible(true);



        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, 

                    "Error: ingresa solo números válidos",

                    "Valor incorrecto",

                    JOptionPane.ERROR_MESSAGE);

        }

    }



    public static void main(String[] args) {

        VentanaEstadistica v = new VentanaEstadistica();

        v.setVisible(true);

    }

}
package DesarrolloDeInterfaces.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ElijoFlowLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElijoFlowLayout v = new ElijoFlowLayout();
					v.getContentPane().setLayout(new FlowLayout());
					
					JButton boton = new JButton("boton");
					JTextField textField = new JTextField(10);
					JCheckBox checkbox = new JCheckBox("check box");
					JLabel etiqueta = new JLabel("Etiqueta");
					
					v.getContentPane().add(boton);
					v.getContentPane().add(textField);
					v.getContentPane().add(checkbox);
					v.getContentPane().add(etiqueta);
					
					v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //s
					
					
					v.pack();
					v.setVisible(true);
					
					JButton componenteCentralImportante = new JButton("boton");
					JTextField barraHerramientasSuperior = new JTextField(10);
					JCheckBox botonesDeAbajo = new JCheckBox("check box");
					JLabel Indicelzquierdo = new JLabel("Etiqueta");
					JButton MenuDerecha = new JButton("boton");
					
					v.setLayout(new BorderLayout());
					v.setLayout (new BorderLayout());
					v.add (componenteCentralImportante, BorderLayout.CENTER);
					v.add (barraHerramientasSuperior, BorderLayout.NORTH);
					v.add (botonesDeAbajo, BorderLayout.SOUTH);
					v.add (Indicelzquierdo, BorderLayout.WEST);
					v.add (MenuDerecha, BorderLayout.EAST);
					
					JPanel barraHermientas = new JPanel();
					barraHermientas.setLayout(new FlowLayout());
					barraHermientas.add(new JButton("boton1"));
					JButton botonN =new JButton("boton n");
					barraHermientas.add(botonN);
					JFrame ventana = new JFrame();
					ventana.getContentPane().setLayout(new BorderLayout());
					v.getContentPane().add(botonN, BorderLayout.NORTH);
					ventana.getContentPane().add(boton);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ElijoFlowLayout() {
		
		
		
	
		
	}

}

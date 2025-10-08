package DesarrolloDeInterfaces.Swing;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.Action;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;

import javax.swing.JTextField;

import javax.swing.JLabel;

public class Prueba_2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		Prueba_2 ej = new Prueba_2();

		ej.setBounds(0, 0, 300, 200);

		ej.setResizable(false);

		ej.setVisible(true);

		ej.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	JTextField textField1;

	JButton boton2;

	public Prueba_2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Programacion en java");

		lblNewLabel.setBounds(10, 5, 111, 30);

		contentPane.add(lblNewLabel);

		getContentPane().setLayout(null);

		textField1 = new JTextField();

		textField1.setBounds(129, 10, 152, 25);

		getContentPane().add(textField1);

		boton2 = new JButton("Aceptar");

		boton2.setBounds(10, 46, 100, 30);

		getContentPane().add(boton2);

		boton2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == boton2) {

			String cadena = textField1.getText();

			setTitle(cadena);

		}

	}
}

//		public void actionPerformed(ActionEvent e) {

//			if(e.getSource()==boton2){

//				System.exit(0);

//				}

//		}

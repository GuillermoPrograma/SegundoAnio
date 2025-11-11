package DesarrolloDeInterfaces.Swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class CambioMenuyCombobox extends JFrame implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioMenuyCombobox frame = new CambioMenuyCombobox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField textField1;

	private JButton boton2;
	private JLabel lblTitulo;
	
	private JMenuBar opciones;
	private JMenu menu1;
	private JMenuItem mi1,mi2,mi3,mi4,mi5;

	/**
	 * Create the frame.
	 */
	public CambioMenuyCombobox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		getContentPane().setLayout(null);

		textField1 = new JTextField();

		textField1.setBounds(244, 160, 152, 25);

		getContentPane().add(textField1);

		boton2 = new JButton("Aceptar");

		boton2.setBounds(275, 208, 100, 30);

		getContentPane().add(boton2);

		comboBox = new JComboBox();
		comboBox.setBounds(37, 80, 152, 43);
		contentPane.add(comboBox);
		comboBox.addItem("rojo");
		comboBox.addItem("azul");
		comboBox.addItem("amarillo");
		comboBox.addItem("verde");
		comboBox.addItemListener(this);
		;

		boton2.addActionListener(this);

		lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(73, 39, 57, 30);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitulo.setForeground(Color.RED);
		contentPane.add(lblTitulo);
		
		opciones = new JMenuBar();
		menu1 = new JMenu("opciones");
		opciones.add(menu1);
		
		mi1 = new JMenuItem("Rojo");
		mi1.addActionListener(this);
		menu1.add(mi1);
		
		mi2 = new JMenuItem("Verde");
		mi2.addActionListener(this);
		menu1.add(mi2);
		
		mi3 = new JMenu("Azul");
		mi3.addActionListener(this);
		menu1.add(mi3);
		
		mi4 = new JMenuItem("Celeste");
		mi4.addActionListener(this);
		mi3.add(mi4);
		
		mi5 = new JMenuItem("Azul Electrico");
		mi5.addActionListener(this);
		mi3.add(mi5);
		
		
		setJMenuBar(opciones);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton2) {

			String cadena = textField1.getText();

			setTitle(cadena);

		}
		if (e.getSource() == mi1) {

			getContentPane().setBackground(Color.red);

		}
		if (e.getSource() == mi2) {

			getContentPane().setBackground(Color.green);

		}
		
		
		if (e.getSource() == mi4) {

			getContentPane().setBackground(new Color(135, 206, 235));

		}
		
		if (e.getSource() == mi5) {

			getContentPane().setBackground(new Color(44, 117, 255));

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == comboBox) {
			String color = (String) comboBox.getSelectedItem();
			switch (color) {
			case "rojo":
				lblTitulo.setForeground(Color.RED);
				break;
			case "azul":
				lblTitulo.setForeground(Color.BLUE);
				break;
			case "verde":
				lblTitulo.setForeground(Color.GREEN);
				break;
			case "amarillo":
				lblTitulo.setForeground(Color.YELLOW);
				break;
			}

		}
	}
}

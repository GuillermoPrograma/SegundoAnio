package DesarrolloDeInterfaces.Swing.EjemploExamen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DesarrolloDeInterfaces.Swing.Ejercicio1.LoExporto;



public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1,m2,m3,m4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		mb = new JMenuBar();
		setJMenuBar (mb);
		menu1 = new JMenu("Elegir");
		mb.add(menu1);
		mi1 = new JMenuItem ("Agregar Empleado");
		mi1.addActionListener(this);
		menu1.add(mi1);
		m2 = new JMenuItem ("Ver Empleado");
		menu1.add(m2);
		m3 = new JMenuItem ("Guardar Archivos");
		menu1.add(m3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Menu(e);
	}
	private void Menu(ActionEvent e) {
		if(e.getSource() == mi1) 
		{
			JFrame elijoEmpleado = new ElijoEmpleado();
			elijoEmpleado.setVisible(true);
			dispose(); 
		}
		
		if(e.getSource() == m2) 
		{
			JFrame enseñoEmpleado = new EnseñoEmpleados();
			enseñoEmpleado.setVisible(true);
			dispose();   
		}
		if(e.getSource() == m3) 
		{
			JFrame loExporto = new LoExporto();
			loExporto.setVisible(true);
			dispose();
		}
	}

}

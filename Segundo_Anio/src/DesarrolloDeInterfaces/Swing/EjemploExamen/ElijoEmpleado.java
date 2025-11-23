package DesarrolloDeInterfaces.Swing.EjemploExamen;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ElijoEmpleado extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreTexto;
	private JTextField nombreApellidos;
	private JTextField salaroTexto;
	private JTextField seguridadSocialTexto;
	private JTextField irpfTexto;
	private JButton botonAgregar;
	private JButton botonLimpiar;
	private List<Empleado> empleadosLista = new ArrayList();
	private JComboBox comboBox;
	private JRadioButton botonMasculino;
	private JRadioButton botonFemenino;
	private JTextArea otrosIngresos;
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1,m2,m3,m4;
	private JLabel avisoTexto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElijoEmpleado frame = new ElijoEmpleado();
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
	public ElijoEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mb = new JMenuBar();
		setJMenuBar (mb);
		menu1 = new JMenu("Elegir");
		mb.add(menu1);
		mi1 = new JMenuItem ("Agregar Empleado");
		mi1.addActionListener(this);
		menu1.add(mi1);
		m2 = new JMenuItem ("Ver Empleado");
		m2.addActionListener(this);
		menu1.add(m2);
		m3 = new JMenuItem ("Guardar Archivos");
		m3.addActionListener(this);
		menu1.add(m3);
		
		nombreApellidos = new JTextField();
		nombreApellidos.setBounds(337, 64, 201, 20);
		contentPane.add(nombreApellidos);
		nombreApellidos.setColumns(10);

		nombreTexto = new JTextField();
		nombreTexto.setBounds(38, 64, 119, 20);
		contentPane.add(nombreTexto);
		nombreTexto.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre Empleado");
		lblNewLabel.setBounds(38, 28, 119, 14);
		contentPane.add(lblNewLabel);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(415, 28, 119, 14);
		contentPane.add(lblApellidos);

		JLabel lblNewLabel_1 = new JLabel("Genero");
		lblNewLabel_1.setBounds(68, 118, 48, 14);
		contentPane.add(lblNewLabel_1);

		ButtonGroup bg = new ButtonGroup();

		botonMasculino = new JRadioButton("Masculino");
		botonMasculino.setBounds(47, 139, 110, 22);
		botonMasculino.setSelected(true);
		contentPane.add(botonMasculino);
		bg.add(botonMasculino);
		
		botonFemenino = new JRadioButton("Femenino");
		botonFemenino.setBounds(47, 164, 82, 14);
		contentPane.add(botonFemenino);
		bg.add(botonFemenino);

		JLabel lblNewLabel_2 = new JLabel("Salario*Dia");
		lblNewLabel_2.setBounds(415, 107, 97, 14);
		contentPane.add(lblNewLabel_2);

		salaroTexto = new JTextField();
		salaroTexto.setColumns(10);
		salaroTexto.setBounds(337, 129, 201, 20);
		contentPane.add(salaroTexto);

		JLabel lblNewLabel_3 = new JLabel("Otros ingresos");
		lblNewLabel_3.setBounds(410, 181, 72, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Pago Seguridad Social");
		lblNewLabel_4.setBounds(56, 265, 110, 14);
		contentPane.add(lblNewLabel_4);

		seguridadSocialTexto = new JTextField();
		seguridadSocialTexto.setColumns(10);
		seguridadSocialTexto.setBounds(10, 290, 201, 20);
		contentPane.add(seguridadSocialTexto);

		JLabel lblNewLabel_5 = new JLabel("IRPF");
		lblNewLabel_5.setBounds(417, 265, 48, 14);
		contentPane.add(lblNewLabel_5);

		irpfTexto = new JTextField();
		irpfTexto.setColumns(10);
		irpfTexto.setBounds(337, 290, 201, 20);
		contentPane.add(irpfTexto);

		botonAgregar = new JButton("Agregar");
		botonAgregar.addActionListener(this);
		botonAgregar.setBounds(41, 388, 116, 20);
		contentPane.add(botonAgregar);

		botonLimpiar = new JButton("Limpiar");
		botonLimpiar.addActionListener(this);
		botonLimpiar.setBounds(389, 387, 116, 20);
		contentPane.add(botonLimpiar);

		otrosIngresos = new JTextArea();
		otrosIngresos.setBounds(356, 212, 182, 42);
		contentPane.add(otrosIngresos);

		JLabel lblNewLabel_6 = new JLabel("Pueblo");
		lblNewLabel_6.setBounds(68, 202, 48, 14);
		contentPane.add(lblNewLabel_6);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Villalba", "MatalElPino", "Rozas" }));
		comboBox.setBounds(47, 227, 82, 22);
		contentPane.add(comboBox);
		
		avisoTexto = new JLabel("Aviso");
		avisoTexto.setVisible(false);
		avisoTexto.setBounds(242, 391, 97, 14);
		contentPane.add(avisoTexto);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Menu(e);		
		
		if (e.getSource() == botonAgregar) {

			String nombretextoEmpl = ComprueboNombre();
			if(nombretextoEmpl == null)
				return;

			String nombreApellidoEmpleado = ComprueboApellido();
			if(nombreApellidoEmpleado == null)
				return;
			
			Double salarioEmpleado;
			Double seguridadSocialEmpleado;
			Double irpftextoEmpleado;
			
			try {
				salarioEmpleado = Double.parseDouble(salaroTexto.getText());
				seguridadSocialEmpleado = Double.parseDouble(seguridadSocialTexto.getText());
				irpftextoEmpleado = Double.parseDouble(irpfTexto.getText());
				
			} catch (Exception ex) {
				avisoTexto.setText("El Salario, la Seguirdad Social y el IRPF tienen que ser números");
				avisoTexto.setVisible(true);
				avisoTexto.setForeground(Color.red);
				return;
			}
			String genero;
			if(botonMasculino.isSelected()) 
				genero = "Masculino";
			
			else
				genero = "Femenino";
			
			String ingresosTexto = "";
			if(otrosIngresos != null) 
			ingresosTexto = otrosIngresos.getText().toString();
			
		MetodosComun.añadoEmpleado(new Empleado(nombretextoEmpl, nombreApellidoEmpleado,comboBox.getSelectedItem().toString(),genero,ingresosTexto,
				seguridadSocialEmpleado,irpftextoEmpleado,salarioEmpleado));
		
		Limpio();
		
		avisoTexto.setText("Creado Correctamente");
		avisoTexto.setVisible(true);
		avisoTexto.setForeground(Color.green);
			
		
			

		}
		if(e.getSource() == botonLimpiar) 
		{
			Limpio();
		}
		
	}

	private void Limpio() {
		nombreApellidos.setText("");
		nombreTexto.setText("");
		salaroTexto.setText("");
		seguridadSocialTexto.setText("");
		irpfTexto.setText("");
		otrosIngresos.setText("");
	}

	private String ComprueboApellido() {
		if (nombreApellidos.getText().trim().length() < 5) {
			avisoTexto.setText("Apellido inválido");
			avisoTexto.setVisible(true);
			avisoTexto.setForeground(Color.red);
			return  null;
		}
		else {
		String nombreApellidoEmpleado = nombreApellidos.getText().trim();
		return nombreApellidoEmpleado;
		}
	}

	private String ComprueboNombre() {
		if (nombreTexto.getText().length() < 3 || nombreTexto.getText().length() > 15) {
			avisoTexto.setText("Nombre inválido");
			avisoTexto.setVisible(true);
			avisoTexto.setForeground(Color.red);
			return null;
		}
		String nombretextoEmpl = nombreTexto.getText();
		return nombretextoEmpl;
	}

	private void Menu(ActionEvent e) {
		if(e.getSource() == mi1) 
		{
			JOptionPane.showMessageDialog(this, "Estas en ya en el Menu Seleccionado", "Error",
					JOptionPane.WARNING_MESSAGE);
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

	@Override
	public void itemStateChanged(ItemEvent e) {

		
		
	}
}

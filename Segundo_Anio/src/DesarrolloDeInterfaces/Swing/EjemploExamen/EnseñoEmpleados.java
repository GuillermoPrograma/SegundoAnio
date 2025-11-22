package DesarrolloDeInterfaces.Swing.EjemploExamen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DesarrolloDeInterfaces.Swing.Ejercicio1.LoExporto;

import javax.swing.JTable;

public class EnseñoEmpleados extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
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
					EnseñoEmpleados frame = new EnseñoEmpleados();
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
	public EnseñoEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(10, 11, 416, 241);
		contentPane.add(table);
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

		List<Empleado> empleadosLista = MetodosComun.listaEmpleados;

		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "nombre", "apellidos", "pueblo", "Genero",
				"Salario*dia", "otros ingresos", "Pago S. Social", "IRPF" }, 0);
		for (Empleado e : empleadosLista) {
			modelo.addRow(new Object[] { e.getNombre(), e.getApellidos(), e.getPueblo(), e.getGenero(), e.getSalario(),
					e.getOtrosIngresos(), e.getPagoSeguridadSocial(), e.getIrpf() });
		}
		table.setModel(modelo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
			  
			JOptionPane.showMessageDialog(this, "Estas en ya en el Menu Seleccionado", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		if(e.getSource() == m3) 
		{
			JFrame loExporto = new LoExporto();
			loExporto.setVisible(true);
			dispose();
		}
	}
}

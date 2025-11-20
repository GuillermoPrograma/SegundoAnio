package DesarrolloDeInterfaces.Swing.EjemploExamen;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class EnseñoEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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

		List<Empleado> empleadosLista = MetodosComun.listaEmpleados;

		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "nombre", "apellidos", "pueblo", "Genero",
				"Salario*dia", "otros ingresos", "Pago S. Social", "IRPF" }, 0);
		for (Empleado e : empleadosLista) {
			modelo.addRow(new Object[] { e.getNombre(), e.getApellidos(), e.getPueblo(), e.getGenero(), e.getSalario(),
					e.getOtrosIngresos(), e.getPagoSeguridadSocial(), e.getIrpf() });
		}

	}
}

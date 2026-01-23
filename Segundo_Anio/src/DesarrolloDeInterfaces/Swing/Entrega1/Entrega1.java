package DesarrolloDeInterfaces.Swing.Entrega1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;

public class Entrega1 extends JFrame implements ActionListener, ItemListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JTextField textoAsunto;
	private JTextField cantidad;
	private JButton añadir;
	private JButton editar;
	private JButton eliminar;
	JSpinner año;
	JSpinner dia;
	JSpinner mes;
	private JLabel asuntoWarning;
	private int diaDefinitivo;
	private double cantidadDefinitivo;
	private int añodefinitivo;
	private String asuntoCorrecto;
	private int mesDefintivo;
	boolean diaCorrecto = false;
	boolean hayotro = true;
	DefaultListModel<Factura> modeloLista = new DefaultListModel<>();
	JList<Factura> nombreLista = new JList<>(modeloLista);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrega1 frame = new Entrega1();
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
	public Entrega1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Asunto :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setBounds(10, 36, 46, 14);
		contentPane.add(lblFecha);

		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 61, 65, 14);
		contentPane.add(lblCantidad);

		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 86, 65, 14);
		contentPane.add(lblTipo);

		textoAsunto = new JTextField();
		textoAsunto.setBounds(85, 8, 86, 20);
		contentPane.add(textoAsunto);
		textoAsunto.setColumns(10);

		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(85, 58, 86, 20);
		contentPane.add(cantidad);

		comboBox = new JComboBox();
		comboBox.setBounds(85, 86, 86, 21);
		contentPane.add(comboBox);
		comboBox.addItem("Empresas");
		comboBox.addItem("Particulares");

		dia = new JSpinner(new SpinnerNumberModel(8, 1, 31, 1));
		dia.setBounds(85, 33, 86, 20);
		contentPane.add(dia);

		mes = new JSpinner(new SpinnerNumberModel(5, 1, 12, 1));
		mes.setBounds(181, 33, 86, 20);
		contentPane.add(mes);

		año = new JSpinner(new SpinnerNumberModel(2020, 2020, 2100, 1));
		año.setBounds(277, 33, 86, 20);
		contentPane.add(año);

		nombreLista.setBounds(10, 123, 257, 112);
		contentPane.add(nombreLista);

		añadir = new JButton("Añadir/Actualizar");
		añadir.setBounds(277, 115, 126, 33);
		contentPane.add(añadir);
		añadir.addActionListener(this);

		editar = new JButton("Editar");
		editar.setBounds(277, 158, 126, 33);
		contentPane.add(editar);
		editar.addActionListener(this);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(277, 202, 126, 33);
		contentPane.add(eliminar);
		eliminar.addActionListener(this);
		asuntoWarning = new JLabel("El asunto debe tener entre 1 y 10 carácteres");
		asuntoWarning.setVisible(false);
		asuntoWarning.setForeground(new Color(255, 0, 0));
		asuntoWarning.setBounds(85, 246, 278, 14);
		contentPane.add(asuntoWarning);

		comboBox.addItemListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == añadir) {
			asuntoWarning.setForeground(Color.red);
			asuntoWarning.setVisible(false);
			hayotro = false;
			for (int i = 0; i < modeloLista.getSize(); i++) {
				if (textoAsunto.getText().equals(modeloLista.getElementAt(i).getAsunto())) {
					hayotro = true;
					break;
				}
			}

			if (hayotro) {
				asuntoWarning.setText("Hay otro archivo creado");
				asuntoWarning.setVisible(true);
				return;
			}

			if (textoAsunto.getText().length() < 10 && textoAsunto.getText().length() > 1) {
				asuntoCorrecto = textoAsunto.getText();
				asuntoWarning.setVisible(false);

			} else {
				asuntoWarning.setVisible(true);
				return;
			}
			if ((int) año.getValue() >= 2020) {
				añodefinitivo = (Integer) año.getValue();

				mesDefintivo = (int) mes.getValue();
				int d = (int) dia.getValue();
				switch (mesDefintivo) {
				case 1: // Enero
				case 3: // Marzo
				case 5: // Mayo
				case 7: // Julio
				case 8: // Agosto
				case 10: // Octubre
				case 12: // Diciembre
					if (d <= 31) {
						diaDefinitivo = d;
						diaCorrecto = true;
					} else {
						asuntoWarning.setText("dia Inválido");
						asuntoWarning.setVisible(true);
						diaCorrecto = false;
					}
					break;

				case 4: // Abril
				case 6: // Junio
				case 9: // Septiembre
				case 11: // Noviembre
					if (d <= 30) {
						diaDefinitivo = d;
					} else {
						asuntoWarning.setText("dia Inválido");
						asuntoWarning.setVisible(true);
						diaCorrecto = false;
					}
					break;

				case 2: // Febrero
					if (d <= 28) {

						diaDefinitivo = d;
					} else {
						asuntoWarning.setText("dia Inválido");
						asuntoWarning.setVisible(true);
						diaCorrecto = false;
					}
					break;

				default:

					break;
				}

			} else {
				asuntoWarning.setText("Fecha Incorrecta");
				asuntoWarning.setVisible(true);
				return;
			}
			try {
				cantidadDefinitivo = Double.parseDouble(cantidad.getText());
				if (cantidadDefinitivo == 0) {
					return;
				}
			} catch (NumberFormatException ex) {
				asuntoWarning.setText("Cantidad Inválida");
				asuntoWarning.setVisible(true);
				return;
			}
			if (diaCorrecto == true && hayotro == false) {
				Factura f = new Factura(asuntoCorrecto, diaDefinitivo, mesDefintivo, añodefinitivo, cantidadDefinitivo,
						comboBox.getSelectedItem().toString());
				modeloLista.addElement(f);
				textoAsunto.setText("");
				año.setValue(2020);
				mes.setValue(5);
				dia.setValue(8);
				cantidad.setText("");
				textoAsunto.setText("");
				asuntoWarning.setText("Archivo creado correctamente");
				asuntoWarning.setForeground(Color.blue);
				asuntoWarning.setVisible(true);
			}
		}

		if (e.getSource() == editar) {
			int index = nombreLista.getSelectedIndex();

			Factura vuelve = nombreLista.getModel().getElementAt(index);
			textoAsunto.setText(vuelve.getAsunto());
			año.setValue(vuelve.getAño());
			mes.setValue(vuelve.getMes());
			dia.setValue(vuelve.getDia());
			cantidad.setText(Double.toString(vuelve.getCantidad()));
			modeloLista.remove(index);
		}
		if (e.getSource() == eliminar) {
			System.out.println("paso");
			int index = nombreLista.getSelectedIndex();

			modeloLista.remove(index);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {

	}
}

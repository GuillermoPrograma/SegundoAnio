package DesarrolloDeInterfaces.Swing.Ejercicio1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;

public class Ejercicio1 extends JFrame implements ItemListener, ChangeListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JComboBox menuLocalidad;
	private JRadioButton a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4;
	private ButtonGroup procesadorGrupo, memoriaGrupo, monitorGrupo, discoDuroGrupo;
	JCheckBox opcion1;
	JCheckBox opcion2;
	JCheckBox opcion3;
	JCheckBox opcion4;
	JTextField textNombre = new JTextField();
	DefaultListModel<String> modeloLista = new DefaultListModel<>();
	JList<String> nombreLista = new JList<>(modeloLista);
	private JButton añadir;
	private JButton buscar;
	private JButton eliminar;
	private JButton cancelar;
	private JButton salir;
	private boolean activo = false;
	JComponent[] componentes;
	String procesadorEleccion;
	String memoriaEleccion;
	String monitorEleccion;
	String discoDuroEleccion;
	String[] opcionesEleccion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {// ss
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);
		JLabel nombre = new JLabel("Nombre del cliente");
		nombre.setBounds(10, 20, 100, 30);

		textNombre.setBounds(120, 25, 100, 20);
		contentPane.add(textNombre);

		contentPane.add(nombre);
		JLabel localidad = new JLabel("Localidad");
		localidad.setBounds(10, 51, 100, 30);
		contentPane.add(localidad);

		JLabel listaClientes = new JLabel("Lista de clientes");
		listaClientes.setBounds(278, 25, 78, 20);
		getContentPane().add(listaClientes);

		 menuLocalidad = new JComboBox();

		menuLocalidad.setBounds(120, 56, 78, 20);
		contentPane.add(menuLocalidad);
		menuLocalidad.addItem("Villalba");
		menuLocalidad.addItem("Rozas");
		menuLocalidad.addItem("Moral");
		menuLocalidad.addItem("Madrid");
		menuLocalidad.addItemListener(this);

		JLabel procesador = new JLabel("Procesador");
		procesador.setFont(new Font("Tahoma", Font.BOLD, 11));
		procesador.setBounds(10, 112, 78, 20);
		contentPane.add(procesador);

		JLabel memoria = new JLabel("Memoria");
		memoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		memoria.setBounds(120, 112, 78, 20);
		contentPane.add(memoria);

		JLabel monitor = new JLabel("Monitor");
		monitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		monitor.setBounds(208, 112, 60, 20);
		contentPane.add(monitor);

		JLabel discoDuro = new JLabel("Disco Duro");
		discoDuro.setFont(new Font("Tahoma", Font.BOLD, 11));
		discoDuro.setBounds(278, 112, 67, 20);
		contentPane.add(discoDuro);

		JLabel opciones = new JLabel("opciones");
		opciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		opciones.setBounds(364, 112, 60, 20);
		contentPane.add(opciones);
		procesadorGrupo = new ButtonGroup();
		memoriaGrupo = new ButtonGroup();
		monitorGrupo = new ButtonGroup();
		discoDuroGrupo = new ButtonGroup();
		a1 = new JRadioButton("P4 3.0 Gb");
		a1.setBounds(10, 139, 78, 30);
		contentPane.add(a1);
		a1.addChangeListener(this);
		procesadorGrupo.add(a1);

		a2 = new JRadioButton("P4 3.2 Gb");
		a2.setBounds(10, 172, 78, 30);
		contentPane.add(a2);
		a2.addChangeListener(this);
		procesadorGrupo.add(a2);
		a2.setSelected(true);

		a3 = new JRadioButton("P4 Celeron");
		a3.setBounds(10, 205, 78, 30);
		contentPane.add(a3);
		a3.addChangeListener(this);
		procesadorGrupo.add(a3);

		a4 = new JRadioButton("AMD 650");
		a4.setBounds(10, 238, 100, 30);
		contentPane.add(a4);
		a4.addChangeListener(this);
		procesadorGrupo.add(a4);

		b1 = new JRadioButton("120 MB");
		b1.setBounds(110, 139, 78, 30);
		contentPane.add(b1);
		b1.addChangeListener(this);
		memoriaGrupo.add(b1);

		b2 = new JRadioButton("256 MB");
		b2.setBounds(110, 172, 78, 30);
		contentPane.add(b2);
		b2.addChangeListener(this);
		memoriaGrupo.add(b2);

		b3 = new JRadioButton("512 MB");
		b3.setBounds(110, 205, 78, 30);
		contentPane.add(b3);
		b3.addChangeListener(this);
		memoriaGrupo.add(b3);

		b4 = new JRadioButton("1024 MB");
		b4.setBounds(112, 238, 78, 30);
		contentPane.add(b4);
		b4.addChangeListener(this);
		memoriaGrupo.add(b4);
		b4.setSelected(true);

		c1 = new JRadioButton("15 \"");
		c1.setBounds(190, 139, 78, 30);
		contentPane.add(c1);
		c1.addChangeListener(this);
		monitorGrupo.add(c1);

		c2 = new JRadioButton("17 \"");
		c2.setBounds(190, 172, 78, 30);
		contentPane.add(c2);
		c2.addChangeListener(this);
		monitorGrupo.add(c2);

		c3 = new JRadioButton("TFT 15\"");
		c3.setBounds(190, 205, 78, 30);
		contentPane.add(c3);
		c3.addChangeListener(this);
		monitorGrupo.add(c3);

		c4 = new JRadioButton("TFT 17\"");
		c4.setBounds(192, 238, 78, 30);
		contentPane.add(c4);
		c4.addChangeListener(this);
		monitorGrupo.add(c4);
		c4.setSelected(true);

		d1 = new JRadioButton("60 GB");
		d1.setBounds(278, 139, 78, 30);
		contentPane.add(d1);
		d1.addChangeListener(this);
		discoDuroGrupo.add(d1);

		d2 = new JRadioButton("80 GB");
		d2.setBounds(278, 172, 78, 30);
		contentPane.add(d2);
		d2.addChangeListener(this);
		discoDuroGrupo.add(d2);

		d3 = new JRadioButton("120GB");
		d3.setBounds(278, 205, 78, 30);
		contentPane.add(d3);
		d3.addChangeListener(this);
		discoDuroGrupo.add(d3);

		d4 = new JRadioButton("200 GB");
		d4.setBounds(278, 238, 78, 30);
		contentPane.add(d4);
		d4.addChangeListener(this);
		discoDuroGrupo.add(d4);
		d4.setSelected(true);

		opcion1 = new JCheckBox("Grabadora DVD");
		opcion1.setBounds(362, 139, 116, 30);
		opcion1.addChangeListener(this);
		contentPane.add(opcion1);
		opcion1.setSelected(true);

		opcion2 = new JCheckBox("Wifi");
		opcion2.setBounds(364, 172, 48, 30);
		opcion2.addChangeListener(this);
		contentPane.add(opcion2);
		opcion2.setSelected(true);

		opcion3 = new JCheckBox("Sintonizador TV");
		opcion3.setBounds(364, 205, 114, 30);
		opcion3.addChangeListener(this);
		contentPane.add(opcion3);

		opcion4 = new JCheckBox("BackupRestore");
		opcion4.setBounds(364, 238, 120, 30);
		opcion4.addChangeListener(this);
		contentPane.add(opcion4);

		añadir = new JButton("añadir");

		añadir.setBounds(17, 275, 93, 34);
		añadir.addActionListener(this);
		contentPane.add(añadir);

		buscar = new JButton("buscar");

		buscar.setBounds(127, 275, 93, 34);
		buscar.addActionListener(this);
		contentPane.add(buscar);

		eliminar = new JButton("eliminar");

		eliminar.setBounds(241, 275, 93, 34);
		eliminar.addActionListener(this);
		contentPane.add(eliminar);

		cancelar = new JButton("cancelar");

		cancelar.setBounds(374, 275, 100, 30);
		cancelar.addActionListener(this);
		contentPane.add(cancelar);

		salir = new JButton("salir");

		salir.setBounds(374, 310, 100, 30);
		salir.addActionListener(this);
		contentPane.add(salir);
		nombreLista.setBounds(366, 27, 112, 74);
		JScrollPane scrollLista = new JScrollPane(nombreLista);
		scrollLista.setBounds(366, 27, 112, 74);
		contentPane.add(scrollLista);
		componentes = new JComponent[] { a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4, opcion1,
				opcion2, opcion3, opcion4, añadir, buscar, eliminar, menuLocalidad };

		for (JComponent component : componentes) {
			component.setEnabled(false);
		}
		textNombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cadena = textNombre.getText().trim();
				if (!cadena.isEmpty()) {
					modeloLista.addElement(cadena);
					textNombre.setText("");
					for (JComponent component : componentes) {
						component.setEnabled(true);
					}
				}
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == menuLocalidad) {
			String localidad = (String) menuLocalidad.getSelectedItem();
			switch (localidad) {
			case "Villalba":
				menuLocalidad.setForeground(Color.RED);
				break;
			case "Rozas":
				menuLocalidad.setForeground(Color.BLUE);
				break;
			case "Moral":
				menuLocalidad.setForeground(Color.GREEN);
				break;
			case "Madrid":
				menuLocalidad.setForeground(Color.YELLOW);
				break;
			}
			}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		String[]opciones =new String[4];
		int contador = 0;
		if(opcion1 != null &&opcion1.isSelected()) 
			opciones[contador] = opcion1.getName();
			contador++;
		if(opcion2 != null && opcion2.isSelected())
			opciones[contador] = opcion2.getName();
			contador++;
		if(opcion3 != null && opcion3.isSelected())
			opciones[contador] = opcion3.getName();
			contador++;
		if(opcion4 != null &&opcion4.isSelected())
			opciones[contador] = opcion4.getName();
			contador++;
			
			
			
		// Aqui los RadioButtons
		if (e.getSource() == a1 || e.getSource() == a2 || e.getSource() == a3 || e.getSource() == a4) {
			JRadioButton boton = (JRadioButton) e.getSource(); // creo un boton para sacarle luego el nombre, es una
																// manera de intentar hacer menos código
			procesadorEleccion = boton.getText();
		}
		if (e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4) {
			JRadioButton boton = (JRadioButton) e.getSource();
			memoriaEleccion = boton.getText();
		}
		if (e.getSource() == c1 || e.getSource() == c2 || e.getSource() == c3 || e.getSource() == c4) {
			JRadioButton boton = (JRadioButton) e.getSource();
			monitorEleccion = boton.getText();
		}
		if (e.getSource() == d1 || e.getSource() == d2 || e.getSource() == d3 || e.getSource() == d4) {
			JRadioButton boton = (JRadioButton) e.getSource();
			discoDuroEleccion = boton.getText();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salir) {
			System.exit(0);
		}
		if (e.getSource() == eliminar) {
			String cadena = textNombre.getText().trim();
			modeloLista.removeElement(cadena);
			textNombre.setText("");
			if (modeloLista.isEmpty()) {
				for (JComponent component : componentes) {
					component.setEnabled(false);
				}
			}
		}
		if (e.getSource() == buscar) {
			String cadena = textNombre.getText().trim();
			nombreLista.setSelectedValue(cadena, true);
			textNombre.setText("");

		}
		if (e.getSource() == cancelar) {
			modeloLista.removeAllElements();
			textNombre.setText("");
			for (JComponent component : componentes) {
				component.setEnabled(false);
			}
		}
		

	}

}

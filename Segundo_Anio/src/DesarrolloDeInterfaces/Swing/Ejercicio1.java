package DesarrolloDeInterfaces.Swing;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private JRadioButton a1, a2 , a3, a4,b1, b2, b3, b4 , c1, c2 , c3 ,c4 , d1, d2 ,d3 ,d4;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		JLabel nombre = new JLabel ("Nombre del cliente");
		nombre.setBounds(10,20,100,30);
		 
		
		textNombre.setBounds(120,25,100,20);
		getContentPane().add(textNombre);
		getContentPane().add(nombre);
		JLabel localidad = new JLabel("Localidad");
		localidad.setBounds(10,51,100,30);
		getContentPane().add(localidad);
		
		JLabel listaClientes = new JLabel("Lista de clientes");
		listaClientes.setBounds(278,25,78,20);
		getContentPane().add(listaClientes);
		
		JComboBox menuLocalidad = new JComboBox();
		
		menuLocalidad.setBounds(120, 56, 78, 20);
		contentPane.add(menuLocalidad);
		menuLocalidad.addItem("Villalba");
		menuLocalidad.addItem("Rozas");
		menuLocalidad.addItem("Moral");
		menuLocalidad.addItem("Madrid");
		menuLocalidad.addItemListener(this);
		
		JLabel procesador = new JLabel ("Procesador");
		procesador.setFont(new Font("Tahoma", Font.BOLD, 11));
		procesador.setBounds(10,112,78,20);
		getContentPane().add(procesador);
		
		JLabel memoria = new JLabel ("Memoria");
		memoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		memoria.setBounds(120,112,78,20);
		getContentPane().add(memoria);
		
		JLabel monitor = new JLabel("Monitor");
		monitor.setFont(new Font("Tahoma", Font.BOLD, 11));
		monitor.setBounds(208,112,60,20);
		getContentPane().add(monitor);
		
		JLabel discoDuro = new JLabel("Disco Duro");
		discoDuro.setFont(new Font("Tahoma", Font.BOLD, 11));
		discoDuro.setBounds(278,112,67,20);
		getContentPane().add(discoDuro);
		JLabel opciones = new JLabel("opciones");
		opciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		opciones.setBounds(364,112,60,20);
		getContentPane().add(opciones);
		procesadorGrupo = new ButtonGroup();
		memoriaGrupo = new ButtonGroup();
		monitorGrupo = new ButtonGroup();
		discoDuroGrupo = new ButtonGroup();
		a1 = new JRadioButton("P4 3.0 Gb");
		a1.setBounds(10,139,78,30);
		getContentPane().add(a1);
		a1.addChangeListener(this);
		procesadorGrupo.add(a1);
		
		a2 = new JRadioButton("P4 3.2 Gb");
		a2.setBounds(10,172,78,30);
		getContentPane().add(a2);
		a2.addChangeListener(this);
		procesadorGrupo.add(a2);
		
		a3 = new JRadioButton("P4 Celeron");
		a3.setBounds(10,205,78,30);
		getContentPane().add(a3);
		a3.addChangeListener(this);
		procesadorGrupo.add(a3);
		
		a4 = new JRadioButton("AMD 650");
		a4.setBounds(10,238,100,30);
		getContentPane().add(a4);
		a4.addChangeListener(this);
		procesadorGrupo.add(a4);
		
		
		b1 = new JRadioButton("120 MB");
		b1.setBounds(110,139,78,30);
		getContentPane().add(b1);
		b1.addChangeListener(this);
		memoriaGrupo.add(b1);
		
		b2 = new JRadioButton("256 MB");
		b2.setBounds(110,172,78,30);
		getContentPane().add(b2);
		b2.addChangeListener(this);
		memoriaGrupo.add(b2);
		
		b3 = new JRadioButton("512 MB");
		b3.setBounds(110,205,78,30);
		getContentPane().add(b3);
		b3.addChangeListener(this);
		memoriaGrupo.add(b3);
		
		b4 = new JRadioButton("1024 MB");
		b4.setBounds(112,238,78,30);
		getContentPane().add(b4);
		b4.addChangeListener(this);
		memoriaGrupo.add(b4);
		
		c1 = new JRadioButton("15 \"");
		c1.setBounds(190,139,78,30);
		getContentPane().add(c1);
		c1.addChangeListener(this);
		monitorGrupo.add(c1);
		
		c2 = new JRadioButton("17 \"");
		c2.setBounds(190,172,78,30);
		getContentPane().add(c2);
		c2.addChangeListener(this);
		monitorGrupo.add(c2);
		
		c3 = new JRadioButton("TFT 15\"");
		c3.setBounds(190,205,78,30);
		getContentPane().add(c3);
		c3.addChangeListener(this);
		monitorGrupo.add(c3);
		
		c4 = new JRadioButton("TFT 17\"");
		c4.setBounds(192,238,78,30);
		getContentPane().add(c4);
		c4.addChangeListener(this);
		monitorGrupo.add(c4);
		
		d1 = new JRadioButton("60 GB");
		d1.setBounds(278,139,78,30);
		getContentPane().add(d1);
		d1.addChangeListener(this);
		discoDuroGrupo.add(d1);
		
		d2 = new JRadioButton("80 GB");
		d2.setBounds(278,172,78,30);
		getContentPane().add(d2);
		d2.addChangeListener(this);
		discoDuroGrupo.add(d2);
		
		d3 = new JRadioButton("120GB");
		d3.setBounds(278,205,78,30);
		getContentPane().add(d3);
		d3.addChangeListener(this);
		discoDuroGrupo.add(d3);
		
		d4 = new JRadioButton("200 GB");
		d4.setBounds(278,238,78,30);
		getContentPane().add(d4);
		d4.addChangeListener(this);
		discoDuroGrupo.add(d4);
		
		opcion1 = new JCheckBox ("Grabadora DVD");
		opcion1.setBounds(362,139,116,30);
		opcion1.addChangeListener(this);
		contentPane.add(opcion1);
		
		opcion2 = new JCheckBox ("Wifi");
		opcion2.setBounds(364,172,48,30);
		opcion2.addChangeListener(this);
		contentPane.add(opcion2);
		
		opcion3 = new JCheckBox ("Sintonizador TV");
		opcion3.setBounds(364,205,114,30);
		opcion3.addChangeListener(this);
		contentPane.add(opcion3);
		
		opcion4 = new JCheckBox ("BackupRestore");
		opcion4.setBounds(364,238,120,30);
		opcion4.addChangeListener(this);
		contentPane.add(opcion4);
		
		añadir = new JButton ("añadir");
		añadir.setEnabled(true);;
		añadir.setBounds(10,275,78,34);
		añadir.addActionListener(this);
		contentPane.add(añadir);

		buscar = new JButton ("buscar");
		buscar.setEnabled(true);;
		buscar.setBounds(98,275,78,34);
		buscar.addActionListener(this);
		contentPane.add(buscar);
		
		eliminar = new JButton ("eliminar");
		eliminar.setEnabled(true);;
		eliminar.setBounds(190,275,78,34);
		eliminar.addActionListener(this);
		contentPane.add(eliminar);
		
		cancelar = new JButton ("cancelar");
		cancelar.setEnabled(true);;
		cancelar.setBounds(374,275,100,30);
		cancelar.addActionListener(this);
		contentPane.add(cancelar);;
		
		salir = new JButton ("salir");
		salir.setEnabled(true);;
		salir.setBounds(374,310,100,30);
		salir.addActionListener(this);
		contentPane.add(salir);
		nombreLista.setBounds(366,27,112,74);
		contentPane.add(nombreLista);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == añadir) 
		{
			String cadena = textNombre.getText();

			modeloLista.addElement(cadena);
            textNombre.setText("");
		}
	}

}

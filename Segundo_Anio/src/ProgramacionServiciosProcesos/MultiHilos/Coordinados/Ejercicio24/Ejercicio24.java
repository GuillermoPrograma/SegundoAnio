package ProgramacionServiciosProcesos.MultiHilos.Coordinados.Ejercicio24;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class Ejercicio24 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHilo1;
	private JTextField txtHilo2;
	private List<JButton> listaBotones = new ArrayList();
	private JButton botonComienzo;
	JButton botonReanudoHilo1;
	JButton botonReanudoHilo2;
	JButton botonSuspendo1;
	JButton botonSuspendo2;
	JButton btnFinalizarActividad;
	MyHilo h1 = new MyHilo();
	MyHilo h2 = new MyHilo();
	JLabel etiquetaHilo1;
	JLabel etiquetaHilo2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio24 frame = new Ejercicio24();
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
	public Ejercicio24() {
		
		
		
		h1.Suspende();
		h2.Suspende();
		
		h1.start();
		h2.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonComienzo = new JButton("Comenzar Actividad");
		botonComienzo.setBounds(124, 11, 181, 22);
		contentPane.add(botonComienzo);
		botonComienzo.addActionListener(this);	
		
		
		
		botonReanudoHilo1 = new JButton("Reanudar");
		botonReanudoHilo1.setBounds(41, 51, 88, 22);
		contentPane.add(botonReanudoHilo1);
		botonReanudoHilo1.addActionListener(this);
		botonReanudoHilo1.setEnabled(false);
		listaBotones.add(botonReanudoHilo1);
		
		botonReanudoHilo2 = new JButton("Reanudar");
		botonReanudoHilo2.setBounds(307, 51, 88, 22);
		contentPane.add(botonReanudoHilo2);
		botonReanudoHilo2.addActionListener(this);
		botonReanudoHilo2.setEnabled(false);
		listaBotones.add(botonReanudoHilo2);
		
		botonSuspendo1 = new JButton("Suspender");
		botonSuspendo1.setBounds(41, 106, 88, 22);
		contentPane.add(botonSuspendo1);
		botonSuspendo1.addActionListener(this);
		botonSuspendo1.setEnabled(false);
		listaBotones.add(botonSuspendo1);
		
		
		botonSuspendo2 = new JButton("Suspender");
		botonSuspendo2.setBounds(307, 106, 88, 22);
		contentPane.add(botonSuspendo2);
		botonSuspendo2.addActionListener(this);
		botonSuspendo2.setEnabled(false);
		listaBotones.add(botonSuspendo2);
		
		txtHilo1 = new JTextField();
		txtHilo1.setText("HILO 1");
		txtHilo1.setBounds(41, 155, 96, 20);
		contentPane.add(txtHilo1);
		txtHilo1.setColumns(10);
		
		txtHilo2 = new JTextField();
		txtHilo2.setText("HILO 2");
		txtHilo2.setColumns(10);
		txtHilo2.setBounds(307, 155, 96, 20);
		contentPane.add(txtHilo2);
		
		btnFinalizarActividad = new JButton("Finalizar Actividad");
		btnFinalizarActividad.addActionListener(this);
		btnFinalizarActividad.setBounds(124, 214, 181, 22);
		contentPane.add(btnFinalizarActividad);
		
		etiquetaHilo1 = new JLabel("Hilo1 suspendido");
		etiquetaHilo1.setBounds(51, 189, 88, 14);
		contentPane.add(etiquetaHilo1);
		
		etiquetaHilo2 = new JLabel("Hilo2 suspendido");
		etiquetaHilo2.setBounds(307, 189, 88, 14);
		contentPane.add(etiquetaHilo2);

	}
	
	PrintStream ps1 = new PrintStream(new OutputStream() {
	    private StringBuilder buffer = new StringBuilder();

	    @Override
	    public void write(int b) {
	        char c = (char) b;
	        if (c == '\n') { //Si es el salto de linea
	            String numero = buffer.toString();
	            buffer.setLength(0); //Limpio
	            SwingUtilities.invokeLater(() -> txtHilo1.setText(numero)); //Aqui Escribo el nuevo
	        } else {
	            buffer.append(c); //Si son dos o tres digitos
	        }
	    }
	});
	
	PrintStream ps2 = new PrintStream(new OutputStream() {
	    private StringBuilder buffer = new StringBuilder();

	    @Override
	    public void write(int b) {
	        char c = (char) b;
	        if (c == '\n') {
	            String numero = buffer.toString();
	            buffer.setLength(0);
	            SwingUtilities.invokeLater(() -> txtHilo2.setText(numero));
	        } else {
	            buffer.append(c);
	        }
	    }
	});

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonComienzo) 
		{
			for(JButton boton : listaBotones) 
			{
				boton.setEnabled(true);
			}
			botonComienzo.setEnabled(false);
		}
		if(e.getSource() == botonReanudoHilo1) 
		{
			h2.Suspende();
			h1.Reanuda();
			etiquetaHilo1.setText("Hilo1 En Movimiento");
			etiquetaHilo2.setText("Hilo2 Suspendido");
			System.setOut(ps1);
		}
		
		if(e.getSource() == botonReanudoHilo2) 
		{
			h2.Reanuda();
			h1.Suspende();
			etiquetaHilo1.setText("Hilo1 Suspendido");
			etiquetaHilo2.setText("Hilo2 En Movimiento");
			System.setOut(ps2);
		}
		if(e.getSource() == botonSuspendo1) 
		{
			h1.Suspende();
			etiquetaHilo1.setText("Hilo1 Suspendido");
			
		}
		if(e.getSource() == botonSuspendo2) 
		{
			h2.Suspende();
			etiquetaHilo2.setText("Hilo2 Suspendido");
			
		}
		if(e.getSource() == btnFinalizarActividad) 
		{
			System.exit(0);
		}
		
		
		
	}
}

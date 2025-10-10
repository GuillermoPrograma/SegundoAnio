package DesarrolloDeInterfaces.Swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Prueba6 extends JFrame implements ChangeListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba6 frame = new Prueba6();
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
	private JCheckBox check1;
	private JButton boton1;
	public Prueba6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Esta de acuerdo con las normas del servicio?");

		lblNewLabel.setBounds(20, 5, 300, 30);

		contentPane.add(lblNewLabel);

		check1 = new JCheckBox ("Acepto");
		check1.setBounds(10,50,200,30);
		check1.addChangeListener(this);
		contentPane.add(check1);
		
		boton1 = new JButton ("Continuar");
		boton1.setEnabled(false);;
		boton1.setBounds(10,105,200,30);
		boton1.addActionListener(this);
		contentPane.add(boton1);
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(check1.isSelected()) 
		{
			boton1.setEnabled(true);
		}
		else
			boton1.setEnabled(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) 
		{
			System.exit(0);
		}
		
	}

}

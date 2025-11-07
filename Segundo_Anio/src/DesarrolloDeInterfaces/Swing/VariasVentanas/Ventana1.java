package DesarrolloDeInterfaces.Swing.VariasVentanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame implements ActionListener {

	
	private JButton btnNewButton;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
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
	public Ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    btnNewButton = new JButton("Ir a Ventana 2");
	    
		
		btnNewButton.setBounds(147, 143, 127, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) 
		{
			JFrame ventana2 = new Ventana2();
			ventana2.setVisible(true);
			dispose(); 
		}
		
	}}

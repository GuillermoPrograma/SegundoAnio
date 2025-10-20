package DesarrolloDeInterfaces.Swing;

import java.awt.EventQueue;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Prueba7_RadioButton extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba7_RadioButton frame = new Prueba7_RadioButton();
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
	private JRadioButton boton1, boton2 , boton3;
	private ButtonGroup bg; //PARA QUE SE MAQUE DE UNO EN UNO
	public Prueba7_RadioButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		bg = new ButtonGroup();
		boton1 = new JRadioButton("640*480");
		boton1.setBounds(10,20,100,30);
		boton1.addChangeListener(this);
		getContentPane().add(boton1);
		bg.add(boton1);
		boton2 = new JRadioButton("800*600");
		boton2.setBounds(10,70,100,30);
		boton2.addChangeListener(this);
		getContentPane().add(boton2);
		bg.add(boton2);
		boton3 = new JRadioButton("1024*768");
		boton3.setBounds(10,120,100,30);
		boton3.addChangeListener(this);
		getContentPane().add(boton3);
		bg.add(boton3);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(boton1.isSelected()) 
		{
			setSize(640,480);
		}
		if(boton2.isSelected()) 
		{
			setSize(800,600);
		}
		if(boton3.isSelected()) 
		{
			setSize(1024,780);
		}
		
	}

	
	

}

package DesarrolloDeInterfaces.Swing;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Prueba5 extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba5 frame = new Prueba5();
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
	private JCheckBox check1,check2,check3;
	public Prueba5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		check1 = new JCheckBox("Ingles");
		check1.setBounds(10,10,150,30);
		check1.addChangeListener(this);
		add(check1);//el add sin nada es para añadir dirctamente a la ventana
		check2 = new JCheckBox("Frances");
		check2.setBounds(10,50,150,30);
		check2.addChangeListener(this);
		add(check2);//el add sin nada es para añadir dirctamente a la ventana
		check3 = new JCheckBox("Aleman");
		check3.setBounds(10,90,150,30);
		check3.addChangeListener(this);
		add(check3);//el add sin nada es para añadir dirctamente a la ventana
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		String titulo ="";
		if (check1.isSelected()== true) 
		{
			titulo = "Titulo : " + check1.getText();
			setTitle(titulo);
		}
		if (check2.isSelected()== true) 
		{
			titulo = "Titulo : " + check2.getText();
			setTitle(titulo);
		}
		if (check3.isSelected()== true) 
		{
			titulo = "Titulo : " + check3.getText();
			setTitle(titulo);
		}
		
	}

}

package DesarrolloDeInterfaces.Swing.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DesarrolloDeInterfaces.Swing.VariasVentanas.Ventana1;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginVentana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private List<String> usuarios = new ArrayList<>();
	private List<String> contraseñas = new ArrayList<>();
	private JButton enviarBoton;
	JButton registrarseBoton;
	int indexusuario = -1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVentana frame = new LoginVentana();
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
	public LoginVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 enviarBoton = new JButton("Entrar");
		enviarBoton.setBounds(65, 227, 89, 23);
		contentPane.add(enviarBoton);
		enviarBoton.addActionListener(this);
		
		textField = new JTextField();
		textField.setBounds(102, 53, 230, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 152, 230, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		lblNewLabel.setBounds(102, 28, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		lblContrasea.setBounds(102, 122, 100, 14);
		contentPane.add(lblContrasea);
		
		 registrarseBoton = new JButton("Registrarse");
		
		registrarseBoton.setBounds(299, 227, 89, 23);
		contentPane.add(registrarseBoton);
		registrarseBoton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registrarseBoton) 
		{
			if(!textField_1.getText().isEmpty() && !textField.getText().isEmpty()) 
			{
				usuarios.add(textField.getText());
				contraseñas.add(textField_1.getText());
				JOptionPane.showMessageDialog(this, "Usuario Registrado", "Correcto",
						JOptionPane.INFORMATION_MESSAGE);
				textField.setText("");
				textField_1.setText("");
			}
			else {JOptionPane.showMessageDialog(this, "Usuario o Contraseña Vacíos", "Cuidado",
					JOptionPane.WARNING_MESSAGE);}
			
		}
		if(e.getSource() == enviarBoton ) 
		{
			if(!textField_1.getText().isEmpty() && !textField.getText().isEmpty()) 
			{
				for(String usuario : usuarios) 
				{
					
					if(textField.getText().equals(usuario)) 
					{
						 indexusuario = usuarios.indexOf(usuario); //Si es correcto miramos si en las dos arrays está el usuario y la contraseña en el miso punto
					}
					
					
				}
				if(indexusuario != -1 && contraseñas.get(indexusuario).equals(textField_1.getText())) 
				{
					Saludo ventana1 = new Saludo();
					ventana1.setVisible(true);
					dispose();
				}
				else{JOptionPane.showMessageDialog(this, "Usuario o Contraseña Incorrectos", "Cuidado",
						JOptionPane.WARNING_MESSAGE);}
				
				
				
			}
			else {JOptionPane.showMessageDialog(this, "Usuario o Contraseña Vacíos", "Cuidado",
					JOptionPane.WARNING_MESSAGE);}
			
			
		}
		
	}
}

package DesarrolloDeInterfaces.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 524);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(74, 167, -98, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Arial", Font.BOLD, 17));
		textField.setBounds(20, 30, 574, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton uno = new JButton("1");
		uno.setFont(new Font("Arial", Font.BOLD, 17));
		uno.setBounds(205, 116, 78, 78);
		contentPane.add(uno);
		
		JButton dos = new JButton("2");
		dos.setFont(new Font("Arial", Font.BOLD, 17));
		dos.setBounds(311, 116, 78, 78);
		contentPane.add(dos);
		
		JButton tres = new JButton("3");
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tres.setFont(new Font("Arial", Font.BOLD, 17));
		tres.setBounds(414, 116, 78, 78);
		contentPane.add(tres);
		
		JButton seis = new JButton("6");
		seis.setFont(new Font("Arial", Font.BOLD, 17));
		seis.setBounds(414, 205, 78, 78);
		contentPane.add(seis);
		
		JButton cinco = new JButton("5");
		cinco.setFont(new Font("Arial", Font.BOLD, 17));
		cinco.setBounds(311, 205, 78, 78);
		contentPane.add(cinco);
		
		JButton cuatro = new JButton("4");
		cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cuatro.setFont(new Font("Arial", Font.BOLD, 17));
		cuatro.setBounds(205, 205, 78, 78);
		contentPane.add(cuatro);
		
		JButton siete = new JButton("7");
		siete.setFont(new Font("Arial", Font.BOLD, 17));
		siete.setBounds(205, 299, 78, 78);
		contentPane.add(siete);
		
		JButton ocho = new JButton("8");
		ocho.setFont(new Font("Arial", Font.BOLD, 17));
		ocho.setBounds(311, 299, 78, 78);
		contentPane.add(ocho);
		
		JButton nueve = new JButton("9");
		nueve.setFont(new Font("Arial", Font.BOLD, 17));
		nueve.setBounds(414, 299, 78, 78);
		contentPane.add(nueve);
		
		JButton cero = new JButton("0");
		cero.setFont(new Font("Arial", Font.BOLD, 17));
		cero.setBounds(99, 116, 83, 167);
		contentPane.add(cero);
		
		JButton sumar = new JButton("+");
		sumar.setFont(new Font("Arial", Font.BOLD, 17));
		sumar.setBounds(516, 116, 78, 78);
		contentPane.add(sumar);
		
		JButton restar = new JButton("-");
		restar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		restar.setFont(new Font("Arial", Font.BOLD, 17));
		restar.setBounds(516, 205, 78, 78);
		contentPane.add(restar);
		
		JButton multiplicar = new JButton("*");
		multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		multiplicar.setFont(new Font("Arial", Font.BOLD, 17));
		multiplicar.setBounds(516, 299, 78, 78);
		contentPane.add(multiplicar);
		
		JButton dividir = new JButton("/");
		dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dividir.setFont(new Font("Arial", Font.BOLD, 17));
		dividir.setBounds(516, 398, 78, 79);
		contentPane.add(dividir);
		
		JButton igual = new JButton("=");
		igual.setFont(new Font("Arial", Font.BOLD, 17));
		igual.setBounds(20, 398, 472, 79);
		contentPane.add(igual);
		
		JButton decimal = new JButton(",");
		decimal.setFont(new Font("Arial", Font.BOLD, 17));
		decimal.setBounds(99, 299, 83, 78);
		contentPane.add(decimal);
		
		JButton reset = new JButton("CE");
		reset.setBackground(Color.LIGHT_GRAY);
		reset.setFont(new Font("Arial", Font.BOLD, 17));
		reset.setBounds(20, 114, 65, 261);
		contentPane.add(reset);

	}
}

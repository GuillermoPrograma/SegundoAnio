package DesarrolloDeInterfaces.Swing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class Correo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton BotonEnvio;
	JTextArea textArea;
	private JButton btnPalabraClave;
	private JLabel labelTextoPalabra;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Correo frame = new Correo();
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
	public Correo() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel ParaLabel = new JLabel("Para");
		ParaLabel.setBounds(65, 55, 35, 41);
		ParaLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		contentPane.add(ParaLabel);

		JLabel labelcc = new JLabel("Cc");
		labelcc.setBounds(77, 107, 23, 41);
		labelcc.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		contentPane.add(labelcc);

		JLabel labelcco = new JLabel("Cco");
		labelcco.setBounds(73, 161, 27, 41);
		labelcco.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		contentPane.add(labelcco);

		JLabel labelAsunto = new JLabel("Asunto");
		labelAsunto.setBounds(50, 213, 50, 41);
		labelAsunto.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
		contentPane.add(labelAsunto);

		textField = new JTextField();
		textField.setBounds(110, 69, 594, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(110, 121, 594, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(110, 173, 594, 20);
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(110, 225, 594, 20);
		textField_3.setColumns(10);
		contentPane.add(textField_3);

		textArea = new JTextArea();

		BotonEnvio = new JButton("Enviar");
		BotonEnvio.setBounds(729, 89, 123, 34);
		BotonEnvio.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		contentPane.add(BotonEnvio);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(34, 295, 818, 139);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);

		btnPalabraClave = new JButton("Palabra clave");
		btnPalabraClave.setBounds(729, 198, 123, 34);
		btnPalabraClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPalabraClave.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		contentPane.add(btnPalabraClave);

		labelTextoPalabra = new JLabel("");
		labelTextoPalabra.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		labelTextoPalabra.setBounds(110, 265, 594, 19);
		contentPane.add(labelTextoPalabra);

		btnPalabraClave.addActionListener(this);
		BotonEnvio.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == BotonEnvio) {

			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textArea.setText("");

		}
		if (e.getSource() == btnPalabraClave) {
			if(textArea.getText().contains("Palabra"))
			{
				labelTextoPalabra.setText("Palabra correcta");
				labelTextoPalabra.setForeground(Color.GREEN);
			}
			else {
				labelTextoPalabra.setText("Palabra incorrecta");
				labelTextoPalabra.setForeground(Color.red);
			}
			
		}

	}
}

package DesarrolloDeInterfaces.Swing.TresEnRaya;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TresRaya extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton[][] matriz;
	boolean turnoAzul = false;
	boolean ganado = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresRaya frame = new TresRaya();
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
	public TresRaya() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3));
		
		

		matriz = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton b = new JButton();
				matriz[i][j] = b;
				contentPane.add(b);
				b.addActionListener(this);
			}

		}
		
		
		

		rellenoMatriz();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				JButton boton = matriz[i][j];
				if(e.getSource() == boton && boton.getText().equals("") ) 
				{
					if(turnoAzul == false) //Empieza el rojo 
					{
						matriz[i][j].setText("X");
						matriz[i][j].setForeground(Color.red);
						turnoAzul = true;
					}
					else 
					{
						//Turno Azul
						matriz[i][j].setText("O");
						matriz[i][j].setForeground(Color.blue);
						turnoAzul = false;
					}
					
					if(matriz[i][0].getText().equals("X") && matriz[i][1].getText().equals("X") && matriz[i][2].getText().equals("X")) 
					{
						ganado = true;
					}
					if(matriz[i][0].getText().equals("O") && matriz[i][1].getText().equals("O") && matriz[i][2].getText().equals("O")) 
					{
						ganado = true;
					}
					if(matriz[j][0].getText().equals("X") && matriz[j][1].getText().equals("X") && matriz[j][2].getText().equals("X")) 
					{
						ganado = true;
					}
					if(matriz[j][0].getText().equals("O") && matriz[j][1].getText().equals("O") && matriz[j][2].getText().equals("O")) 
					{
						ganado = true;
					}
					if(ganado == true) 
					{
						System.out.println("Juego acabado");
					}
					
				}
					
				}
				 
			}
		
		
	}

	public void rellenoMatriz() {

	}

}

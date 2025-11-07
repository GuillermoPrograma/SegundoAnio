package DesarrolloDeInterfaces.Swing.TresEnRaya;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

		JButton a1 = new JButton("");
		contentPane.add(a1);
		a1.addActionListener(this);
		JButton a2 = new JButton("");
		contentPane.add(a2);
		a2.addActionListener(this);
		JButton a3 = new JButton("");
		contentPane.add(a3);
		a3.addActionListener(this);
		JButton b1 = new JButton("");
		contentPane.add(b1);
		b1.addActionListener(this);
		JButton b2 = new JButton("");
		contentPane.add(b2);
		b2.addActionListener(this);
		JButton b3 = new JButton("");
		contentPane.add(b3);
		b3.addActionListener(this);
		JButton c1 = new JButton("");
		contentPane.add(c1);
		c1.addActionListener(this);
		JButton c2 = new JButton("");
		contentPane.add(c2);
		c2.addActionListener(this);
		JButton c3 = new JButton("");
		contentPane.add(c3);
		c3.addActionListener(this);

		matriz = new JButton[3][3];
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				
			}

		}

		rellenoMatriz();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void rellenoMatriz() {

	}

}

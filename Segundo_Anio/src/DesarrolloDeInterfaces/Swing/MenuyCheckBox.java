package DesarrolloDeInterfaces.Swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuyCheckBox extends JFrame implements ActionListener, ChangeListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Color azulCeleste = new Color(135, 206, 235);
	Color azulElectrico = new Color(44, 117, 255);
	Color purpura = new Color(128, 0, 128);
	Color verdoso = new Color(0, 128, 128);
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1,m2,m3,m4;
	private JMenu menu2;
	private JCheckBox check1,check2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuyCheckBox frame = new MenuyCheckBox();
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
	
	public MenuyCheckBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout (null);
		mb = new JMenuBar();
		setJMenuBar (mb);
		menu1 = new JMenu("Opciones");
		mb.add(menu1);
		menu2 = new JMenu("Azul");
		check1 = new JCheckBox("Azul Verdoso");
		check1.addChangeListener(this);
		menu2.add(check1);
		check2 = new JCheckBox("Purpura");
		check2.addChangeListener(this);
		menu2.add(check2);
		mi1 = new JMenuItem ("Rojo");
		mi1.addActionListener(this);
		menu1.add(mi1);
		m2 = new JMenuItem ("verde");
		m2.addActionListener(this);
		menu1.add(m2);
		menu1.add(menu2);
		m3 = new JMenuItem ("Celeste");
		m3.addActionListener(this);
		menu2.add(m3);
		m4 = new JMenuItem("Eléctrico");
		m4.addActionListener(this);
		menu2.add(m4);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Container c=this.getContentPane();

		if(e.getSource()==mi1) {

			c.setBackground(Color.RED);

		}if(e.getSource()==m2) {

			c.setBackground(Color.GREEN);

		}if(e.getSource()==m3) {

			c.setBackground(azulCeleste);

		}
		if(e.getSource()==m4) {

			c.setBackground(azulElectrico);

		}
	
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Container c=this.getContentPane();
		
		if(check1.isSelected())
			c.setBackground(verdoso);
		if(check2.isSelected())
			c.setBackground(purpura);
		
		
	}
	}

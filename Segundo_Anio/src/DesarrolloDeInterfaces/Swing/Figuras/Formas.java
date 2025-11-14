package DesarrolloDeInterfaces.Swing.Figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static java.awt.Font.PLAIN;
public class Formas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formas frame = new Formas();
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
	public Formas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initPantalla();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		
		
		
		
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		//Degradado Fondo
		 GradientPaint gp2 = new GradientPaint(400, 350, Color.LIGHT_GRAY, 300, 550, Color.BLUE);
        g2d.setPaint(gp2);
        g2d.fillRect(0, 0, getWidth(), getHeight()); 
		
		
		//linea
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(1));
		g2d.drawLine(30, 70, 770, 70);
		
		
		g2d.setColor(Color.CYAN);
		g2d.drawRoundRect(420, 100, 350, 60, 50, 50);
		
		//rectangulo redondeado
		g2d.setColor(Color.blue);
		g2d.fillRect(30, 100, 350, 60);
		g2d.setColor(Color.black);
		g2d.drawRect(30, 100, 350, 60);
		
		//Arco
		g2d.setColor(Color.pink);
		g2d.drawArc(30, 200, 100, 100, 180, -90);
		
		//circulo
		g2d.setColor(Color.red);
		g2d.drawOval(100, 200, 100, 100);
		
		//Óvalo (relleno y borde)
		g2d.setColor(Color.yellow);
		g2d.fillOval(240, 200, 150, 100);
		g2d.setColor(Color.black);
		g2d.drawOval(240, 200, 150, 100);
		
		//Poligono 3 lados
		int[] triangulo_x = {450, 510, 570};
		int[] triangulo_y = {300, 200, 300};
		g2d.setColor(Color.orange);
		g2d.drawPolygon(triangulo_x, triangulo_y, 3);
		
		//poligono (5 lados con relleno y borde)
		int[]pentagono_x = {670, 650, 700, 750, 730};
		int[]pentagono_y = {300, 245, 200, 245, 300};
		g2d.setColor(Color.magenta);
		g2d.fillPolygon(pentagono_x, pentagono_y, 5);
		g2d.setColor(Color.black);
		g2d.drawPolygon(pentagono_x, pentagono_y, 5);
		
		//Texto
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Arial",PLAIN,32));
		g2d.drawString("Esto es un texto", 30, 400);
		//Imagen
		Toolkit t = Toolkit.getDefaultToolkit();
		Image imagen = t.getImage("C:\\Users\\alumno\\Downloads\\leon.jpg");
		g2d.drawImage(imagen, 30, 450, 200, 200, this);
		
		
		//Degradado
		GradientPaint gp = new GradientPaint(400, 350, Color.red, 770, 550, Color.green);
		g2d.setPaint(gp);
		g2d.fillRect(400, 350, 370, 200);
		
		
		
	}

	private void initPantalla()  
	{
		setTitle("Ejemplo 19");
		setSize(800,600);
		setResizable(false);
	}
	
}

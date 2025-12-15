package DesarrolloDeInterfaces.Swing.EjemploExamen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class LoExporto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private List<Empleado> empleadosLista = MetodosComun.listaEmpleados;
	private JMenuBar mb;
	private JMenu menu1;
	private JMenuItem mi1,m2,m3;
	private JButton botonBinario;
	private JButton botontxt;
	private JButton botonXML;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoExporto frame = new LoExporto();
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
	public LoExporto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mb = new JMenuBar();
		setJMenuBar (mb);
		menu1 = new JMenu("Elegir");
		mb.add(menu1);
		mi1 = new JMenuItem ("Agregar Empleado");
		mi1.addActionListener(this);
		menu1.add(mi1);
		m2 = new JMenuItem ("Ver Empleado");
		m2.addActionListener(this);
		menu1.add(m2);
		m3 = new JMenuItem ("Guardar Archivos");
		m3.addActionListener(this);
		menu1.add(m3);
		
		JLabel lblNewLabel = new JLabel("En que lo quieres exportar");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(168, 30, 223, 14);
		contentPane.add(lblNewLabel);
		
		 botonXML = new JButton("En XML");
		botonXML.setBounds(100, 115, 372, 22);
		contentPane.add(botonXML);
		botonXML.addActionListener(this);
		

		botonBinario = new JButton("En Binario");
		botonBinario.setBounds(100, 171, 372, 22);
		contentPane.add(botonBinario);
		botonBinario.addActionListener(this);
		
		 botontxt = new JButton("En un Txt");
		botontxt.setBounds(100, 228, 372, 22);
		contentPane.add(botontxt);
		botontxt.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Menu(e);
		if(e.getSource() == botonXML) 
		{
				generarXML();
				
		
		}
		if(e.getSource() == botontxt) 
		{
			loExportoaTXT();
		}
		if(e.getSource() == botonBinario) 
		{
			LoExportoaBinario();
		}
	}
	
	public void loExportoaTXT() 
	{
		 File f = new File("Empleado.txt");
		
		try(FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw))
		{
			
			pw.println("Empleadostxt :");
			for(Empleado e: empleadosLista) 
			{
				pw.println(e);
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

	    public void generarXML() {
	        try {
	            // 1. Crear el builder
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.newDocument();

	            // 2. Crear nodo raíz
	            Element root = doc.createElement("empleados");
	            doc.appendChild(root);

	            // 3. Crear elementos por cada empleado
	            for (Empleado emp : empleadosLista) {
	                Element empleado = doc.createElement("empleado");
	                root.appendChild(empleado);

	                Element nombre = doc.createElement("nombre");
	                nombre.setTextContent(emp.getNombre());
	                empleado.appendChild(nombre);

	                Element apellidos = doc.createElement("apellidos");
	                apellidos.setTextContent(emp.getApellidos());
	                empleado.appendChild(apellidos);

	                Element pueblo = doc.createElement("pueblo");
	                pueblo.setTextContent(emp.getPueblo());
	                empleado.appendChild(pueblo);

	                Element genero = doc.createElement("genero");
	                genero.setTextContent(emp.getGenero());
	                empleado.appendChild(genero);

	                Element otrosIngresos = doc.createElement("otrosIngresos");
	                otrosIngresos.setTextContent(emp.getOtrosIngresos());
	                empleado.appendChild(otrosIngresos);

	                Element seguridadSocial = doc.createElement("pagoSeguridadSocial");
	                seguridadSocial.setTextContent(emp.getPagoSeguridadSocial().toString());
	                empleado.appendChild(seguridadSocial);

	                Element irpf = doc.createElement("irpf");
	                irpf.setTextContent(emp.getIrpf().toString());
	                empleado.appendChild(irpf);

	                Element salario = doc.createElement("salario");
	                salario.setTextContent(emp.getSalario().toString());
	                empleado.appendChild(salario);
	            }

	            // 4. Guardar el XML en archivo
	            TransformerFactory tf = TransformerFactory.newInstance();
	            Transformer transformer = tf.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("empleados.xml"));

	            transformer.transform(source, result);

	            System.out.println("XML generado correctamente.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	public void LoExportoaBinario() 
	{
		 File f = new File("Empleado.dat");
		try(FileOutputStream fo = new FileOutputStream(f);ObjectOutputStream salidaDatos = new ObjectOutputStream (fo);)
		{
			salidaDatos.writeObject(empleadosLista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void Menu(ActionEvent e) {
		if(e.getSource() == mi1) 
		{
			JFrame elijoEmpleado = new ElijoEmpleado();
			elijoEmpleado.setVisible(true);
			dispose(); 
		}
		
		if(e.getSource() == m2) 
		{
			  
			JFrame enseñoEmpleado = new EnseñoEmpleados();
			enseñoEmpleado.setVisible(true);
			dispose();   
		}
		if(e.getSource() == m3) 
		{
			JOptionPane.showMessageDialog(this, "Estas en ya en el Menu Seleccionado", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}

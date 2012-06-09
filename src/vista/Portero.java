package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;


public class Portero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel eventos_ddia;
	private JLabel eventos_pro;
	private JPanel contenido_eventosDia;
	private JPanel contenido_eventosProx;
	
	
	public JPanel getContenido_eventosProx() {
		return contenido_eventosProx;
	}


	private JTaskPaneGroup visitantes;
	private JTextArea nombre;
	private JTextArea fecha;
	private JLabel Ayuda; 
	private JLabel Opt;
	private JButton Elegir;
	private JList list;
	private JButton Cancelar;
	private JTextArea ubicacion;
	private JTextField fe;
	private JTextField n;
	private String escoge;
	private String prox;
	private JList list_1 ;
	private JTaskPaneGroup eventos;
	private DefaultTableModel dm;
	private DefaultTableModel dmi;
	
	private TableRowSorter<TableModel> modeloOrdenado;

	
	public TableRowSorter<TableModel> getModeloOrdenado() {
		return modeloOrdenado;
	}


	public JTaskPaneGroup getEventos() {
		return eventos;
	}


	public void setModeloOrdenado(TableRowSorter<TableModel> modeloOrdenado) {
		this.modeloOrdenado = modeloOrdenado;
	}


	public JTextArea getUb() {
		return ub;
	}


	private JTextArea ub;
	private JPanel panel_regvis;
	private JLabel label_8;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel faltantes;
	private JLabel registra_visita ;
	private JTable table;
	private JTable table_alt;
	private JPanel regVisImp;
	private JLabel registra_visita_imprevista;
	private String regi_vis;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField nom;
	private JTextField ap;
	private JLabel lblRazon;
	private JTable tabImp;
	private JTextArea usua;
	private String regi_vis_imp;
	private JButton btnRegistrar;
	private JComboBox sex;
	private JTextArea raz;
	private JTable tableImp;
	
	
	public JTextArea getRaz() {
		return raz;
	}


	public JComboBox getSex() {
		return sex;
	}


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}


	public JTable getTable_alt() {
		return table_alt;
	}

	public String getRegi_vis_imp() {
		return regi_vis_imp;
	}


	public JTable getTable() {
		return table;
	}


	public String getRegi_vis() {
		return regi_vis;
	}


	public JPanel getPanel_regvis() {
		return panel_regvis;
	}


	


	public JLabel getLabel_8() {
		return label_8;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}


	public JLabel getLblNewLabel_3() {
		return faltantes;
	}


	public JLabel getRegistra_visita() {
		return registra_visita;
	}


	public String getEscoge() {
		return escoge;
	}


	public String getProx() {
		return prox;
	}


	public Portero() {
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Portero");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 1086, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		regi_vis_imp = 
		            "<html><p>"+
		            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
		            "<b>Registrar visitas imprevistas </b></u><br></font>"+
		            "";		
		
		escoge = 
	            "<html><p>"+
	            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
	            "<b>Eventos del dia</b></u><br></font>"+
	            "";
	  
	     prox = 
	            "<html><p>"+
	            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
	            "<b>Eventos proximos</b></u><br></font>"+
	            "";

	     regi_vis = 
		            "<html><p>"+
		            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
		            "<b>Registrar visitas</b></u><br></font>"+
		            "";
		
        try
		{
		
		    JFrame.setDefaultLookAndFeelDecorated(true);
		
		    JDialog.setDefaultLookAndFeelDecorated(true);
		
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	
		}
	
		catch (Exception e)
		
		{
		
		    e.printStackTrace();
	
		}
		  
		  contenido_eventosProx = new JPanel();
		  contenido_eventosProx.setVisible(false);
		  
		  regVisImp = new JPanel();
		  regVisImp.setVisible(false);
		  regVisImp.setBounds(319, 76, 732, 545);
		  contentPane.add(regVisImp);
		  regVisImp.setLayout(null);
		  regVisImp.setBackground(Color.WHITE);
		  
		  usua = new JTextArea();
		  usua.setEnabled(false);
		  usua.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));
		  usua.setDisabledTextColor(UIManager.getColor("Table.dropLineShortColor"));
		  usua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		  usua.setBounds(552, 60, 145, 20);
		  regVisImp.add(usua);
		  
		  btnRegistrar = new JButton(" Registrar");
		  btnRegistrar.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Sign-Add-icon.png")));
		  btnRegistrar.setBounds(552, 140, 145, 31);
		  regVisImp.add(btnRegistrar);
		  
		  sex = new JComboBox();
		  sex.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
		  sex.setBounds(383, 60, 137, 20);
		  regVisImp.add(sex);
		  
		  JLabel lblSexo = new JLabel("Sexo");
		  lblSexo.setBounds(383, 35, 46, 14);
		  regVisImp.add(lblSexo);
		  
		  raz = new JTextArea();
		  raz.setLineWrap(true);
		  raz.setWrapStyleWord(true);
		  raz.setBorder(new LineBorder(UIManager.getColor("Table.gridColor"), 1, true));
		  raz.setBounds(39, 130, 481, 52);
		  regVisImp.add(raz);
		  
		  lblRazon = new JLabel("Raz\u00F3n de entrada");
		  lblRazon.setBounds(40, 105, 657, 14);
		  regVisImp.add(lblRazon);
		  
		  ap = new JTextField();
		  ap.setColumns(10);
		  ap.setBounds(209, 60, 145, 20);
		  regVisImp.add(ap);
		  
		  JLabel lblPorteroQuePermitio = new JLabel("Usuario que permiti\u00F3 la visita");
		  lblPorteroQuePermitio.setBounds(552, 35, 137, 14);
		  regVisImp.add(lblPorteroQuePermitio);
		  
		  JScrollPane scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBackground(Color.WHITE);
		  scrollPane_2.getViewport().setBackground(SystemColor.menu);
		  scrollPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Invitados imprevistos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(133, 140, 158)));
		  scrollPane_2.setBounds(31, 208, 678, 307);
		  regVisImp.add(scrollPane_2);
		  
	        tableImp = new JTable(dmi){
				private static final long serialVersionUID = 1L;
				
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			  };
	        tableImp.setRowMargin(6);
	       
	       
	        	  
	        	  scrollPane_2.setViewportView(tableImp);
	        	  
	        	  nom = new JTextField();
	        	  nom.setColumns(10);
	        	  nom.setBounds(39, 60, 145, 20);
	        	  regVisImp.add(nom);
	        	  
	        	  JLabel lblNombre_1 = new JLabel("Nombre");
	        	  lblNombre_1.setBounds(39, 35, 93, 14);
	        	  regVisImp.add(lblNombre_1);
	        	  
	        	  JLabel lblApellido = new JLabel("Apellido");
	        	  lblApellido.setBounds(209, 35, 144, 14);
	        	  regVisImp.add(lblApellido);
	        	  
	        	  JLabel label_6 = new JLabel("");
	        	  label_6.setForeground(SystemColor.textHighlight);
	        	  label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
	        	  label_6.setBounds(603, 45, 94, 14);
	        	  regVisImp.add(label_6);
	        	  
	        	  JLabel label_7 = new JLabel("");
	        	  label_7.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/content.png")));
	        	  label_7.setBounds(0, 0, 732, 551);
	        	  regVisImp.add(label_7);
		  
		  contenido_eventosDia = new JPanel();
		  contenido_eventosDia.setEnabled(false);
		  contenido_eventosDia.setBackground(SystemColor.window) ;
		  contenido_eventosDia.setBounds(319, 76, 732, 545);
		  contentPane.add(contenido_eventosDia);
		  contenido_eventosDia.setLayout(null);
		  
		  Elegir = new JButton(" Elegir");
		  Elegir.setEnabled(false);
		  Elegir.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Action-ok-icon.png")));
		  
		  list = new JList();
		  list.setFont(new Font("Tahoma", Font.BOLD, 11));
		  list.setBorder(new TitledBorder(null, "listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  list.setBounds(33, 33, 327, 479);
		  contenido_eventosDia.add(list);
		  
		  Cancelar = new JButton(" Cancelar");
		  Cancelar.setEnabled(false);
		  Cancelar.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
		  Cancelar.setBounds(560, 343, 134, 30);
		  contenido_eventosDia.add(Cancelar);
		  Elegir.setBounds(397, 343, 134, 30);
		  contenido_eventosDia.add(Elegir);
		  
		 
		  ubicacion = new JTextArea();
		  ubicacion.setLineWrap(true);
		  ubicacion.setWrapStyleWord(true);
		  ubicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		  ubicacion.setDisabledTextColor(Color.DARK_GRAY);
		  ubicacion.setBackground(Color.WHITE);
		  ubicacion.setEnabled(false);
		  ubicacion.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));
		  ubicacion.setBounds(481, 253, 184, 62);
		  contenido_eventosDia.add(ubicacion);
		 		  
		  
		  JLabel lblLugar = new JLabel("Ubicaci\u00F3n");
		  lblLugar.setBounds(425, 253, 46, 14);
		  contenido_eventosDia.add(lblLugar);
		  
		  JSeparator separator_1 = new JSeparator();
		  separator_1.setBounds(383, 112, 319, 2);
		  contenido_eventosDia.add(separator_1);
		  
		  JLabel lblFecha = new JLabel("Fecha");
		  lblFecha.setBounds(425, 192, 46, 14);
		  contenido_eventosDia.add(lblFecha);
		  
		  JLabel lblNombre = new JLabel("Nombre");
		  lblNombre.setBounds(425, 138, 46, 14);
		  contenido_eventosDia.add(lblNombre);
		  
		  fecha = new  JTextArea();
		  fecha.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));;
		  fecha.setDisabledTextColor(Color.DARK_GRAY);
		  fecha.setEnabled(false);
		  fecha.setColumns(10);
		  fecha.setBounds(481, 192, 184, 20);
		  contenido_eventosDia.add(fecha);
		  
		  nombre = new JTextArea();
		  nombre.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));
		  nombre.setDisabledTextColor(Color.DARK_GRAY);
		  nombre.setEnabled(false);
		  nombre.setBounds(481, 138, 184, 20);
		  contenido_eventosDia.add(nombre);
		  nombre.setColumns(10);
		  
		  JLabel lblEventoActual = new JLabel("Evento actual seleccionado ");
		  lblEventoActual.setFont(new Font("Tahoma", Font.BOLD, 11));
		  lblEventoActual.setBounds(471, 82, 164, 30);
		  contenido_eventosDia.add(lblEventoActual);
		  
		  JLabel lblNewLabel_1 = new JLabel("");
		  lblNewLabel_1.setIcon(new ImageIcon(Portero.class.getResource("/Vista/imagenes/content.png")));
		  lblNewLabel_1.setBounds(0, 0, 732, 551);
		  contenido_eventosDia.add(lblNewLabel_1);
		  
		  
		  
		  dmi=new DefaultTableModel(
				  	null,
				  	new String[] {
				  		"Nombre","Apellido","Sexo", "Razon de entrada"
				  	}
				  );
		  
		  panel_regvis = new JPanel();
		  panel_regvis.setLayout(null);
		  panel_regvis.setBackground(Color.WHITE);
		  panel_regvis.setBounds(319, 76, 732, 545);
		  contentPane.add(panel_regvis);
		  
		 
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBorder(new TitledBorder(null, "Lista de invitados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  scrollPane_1.setBackground(Color.WHITE);
		  scrollPane_1.setBounds(34, 84, 663, 438);
		  panel_regvis.add(scrollPane_1);
		 
		  dm=new DefaultTableModel(
				  	null,
				  	new String[] {
				  		"ID invitado","ID evento","Nombre", "Apellido", "Sexo","Evento","Asistió?"
				  	}
				  );
		  
		  
		  
		    String[] DATA = {"No", "Si"};
	        comboBox = new JComboBox();
	        comboBox.setModel(new DefaultComboBoxModel(DATA));
	        DefaultCellEditor defaultCellEditor1=new DefaultCellEditor(comboBox);
	        table = new JTable(dm){
				private static final long serialVersionUID = 1L;
				
				public boolean isCellEditable(int row, int col) {
					return col == 6;
				}
			  };
	        table.getColumnModel().getColumn(6).setCellEditor(defaultCellEditor1);
	        setOcultarColumnasJTable(table,new int[]{0,1});
	               
		 
		  scrollPane_1.setViewportView(table);
		  
		  textField_2 = new JTextField();
		  textField_2.setBounds(179, 42, 184, 20);
		  panel_regvis.add(textField_2);
		  textField_2.setColumns(10);
		  
		  JLabel lblBuscarInvitados = new JLabel("Buscar Invitados");
		  lblBuscarInvitados.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Actions-edit-find-user-icon.png")));
		  lblBuscarInvitados.setBounds(45, 36, 125, 32);
		  panel_regvis.add(lblBuscarInvitados);
		  
		  lblNewLabel_2 = new JLabel("Cantidad de invitados que faltan por llegar:");
		  lblNewLabel_2.setBounds(383, 45, 222, 14);
		  panel_regvis.add(lblNewLabel_2);
		  
		  faltantes = new JLabel("");
		  faltantes.setFont(new Font("Tahoma", Font.BOLD, 11));
		  faltantes.setForeground(UIManager.getColor("Table.selectionBackground"));
		  faltantes.setBounds(603, 45, 94, 14);
		  panel_regvis.add(faltantes);
		  
		  label_8 = new JLabel("");
		  label_8.setVisible(false);
		  label_8.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/content.png")));
		  label_8.setBounds(0, 0, 732, 551);
		  panel_regvis.add(label_8);
		  
		  contenido_eventosProx.setBounds(319, 76, 732, 545);
		  contentPane.add(contenido_eventosProx);
		  contenido_eventosProx.setLayout(null);
		  contenido_eventosProx.setBackground(Color.WHITE);
		  
		  list_1 = new JList();
		  list_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		  list_1.setBorder(new TitledBorder(null, "Listado de eventos proximos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  list_1.setBounds(33, 33, 327, 479);
		  contenido_eventosProx.add(list_1);
		  
		  ub = new JTextArea();
		  ub.setWrapStyleWord(true);
		  ub.setLineWrap(true);
		  ub.setDisabledTextColor(Color.DARK_GRAY);
		  ub.setEnabled(false);
		  ub.setEditable(false);
		  ub.setBackground(UIManager.getColor("TextField.disabledBackground"));
		  ub.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));
		  ub.setBounds(486, 294, 184, 62);
		  contenido_eventosProx.add(ub);
		  
		  JLabel label_1 = new JLabel("Ubicaci\u00F3n");
		  label_1.setBounds(430, 294, 46, 14);
		  contenido_eventosProx.add(label_1);
		  
		  JSeparator separator_2 = new JSeparator();
		  separator_2.setBounds(383, 152, 319, 2);
		  contenido_eventosProx.add(separator_2);
		  
		  JLabel label_2 = new JLabel("Fecha");
		  label_2.setBounds(430, 233, 46, 14);
		  contenido_eventosProx.add(label_2);
		  
		  JLabel label_3 = new JLabel("Nombre");
		  label_3.setBounds(430, 179, 46, 14);
		  contenido_eventosProx.add(label_3);
		  
		  fe = new JTextField();
		  fe.setEnabled(false);
		  fe.setDisabledTextColor(Color.DARK_GRAY);
		  fe.setColumns(10);
		  fe.setBounds(486, 233, 184, 20);
		  contenido_eventosProx.add(fe);
		  
		  n = new JTextField();
		  n.setEnabled(false);
		  n.setDisabledTextColor(Color.DARK_GRAY);
		  n.setColumns(10);
		  n.setBounds(486, 179, 184, 20);
		  contenido_eventosProx.add(n);
		  
		  JLabel lblDatosDelEvento = new JLabel("Datos del evento seleccionado");
		  lblDatosDelEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		  lblDatosDelEvento.setBounds(462, 122, 172, 30);
		  contenido_eventosProx.add(lblDatosDelEvento);
		  
		  JLabel label_5 = new JLabel("");
		  label_5.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/content.png")));
		  label_5.setBounds(0, 0, 732, 551);
		  contenido_eventosProx.add(label_5);
        
		  Ayuda = new JLabel("Ayuda");
		  Ayuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  Ayuda.setFont(new Font("Tahoma", Font.BOLD, 12));
		  Ayuda.setForeground(Color.WHITE);
		  Ayuda.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Categories-system-help-icon.png")));
		  Ayuda.setBounds(842, 12, 106, 61);
		  contentPane.add(Ayuda);
		  
		  JSeparator separator = new JSeparator();
		  separator.setOrientation(SwingConstants.VERTICAL);
		  separator.setForeground(Color.LIGHT_GRAY);
		  separator.setBounds(949, 24, 19, 45);
		  contentPane.add(separator);
		  
		  Opt = new JLabel("Opciones");
		  Opt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  Opt.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Categories-applications-system-icon.png")));
		  Opt.setFont(new Font("Tahoma", Font.BOLD, 12));
		  Opt.setForeground(Color.WHITE);
		  Opt.setBounds(958, 11, 112, 62);
		  contentPane.add(Opt);
		  
		  JTaskPane menu = new JTaskPane();
		  menu.setBounds(22, 76, 274, 545);
		  contentPane.add(menu);
		  
		  Font f=new Font("Tahoma", Font.BOLD, 11);
		  
		   eventos_ddia= new JLabel(" Eventos del dia");
		   eventos_ddia.setMinimumSize(new Dimension(20, 20));
		   eventos_ddia.setPreferredSize(new Dimension(73, 40));
		  
		   
		   eventos_pro=new JLabel("Eventos pr\u00F3ximos");
		   eventos_pro.setForeground(Color.BLACK);
		   eventos_pro.setFont(f);
		   eventos_pro.setMaximumSize(new Dimension(20, 8));
		   eventos_pro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		   eventos_pro.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/prox.png")));
		   
		   eventos_ddia.setForeground(Color.BLACK);
		   eventos_ddia.setFont(f);
		   eventos_ddia.setMaximumSize(new Dimension(1, 8));
		   eventos_ddia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		   eventos_ddia.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/1333846050_calendar.png")));
	
		  eventos= new JTaskPaneGroup();
		  eventos.setTitle("Eventos");
		  eventos.getContentPane().add(eventos_ddia);
		  eventos.getContentPane().add(eventos_pro);
		  eventos.setScrollOnExpand(true);
		  eventos.setBounds(10, 112, 295, 312);
		
		  
		  visitantes = new JTaskPaneGroup();
		  visitantes.setVisible(false);
		  visitantes.setEnabled(false);
		  visitantes.setTitle("Visitantes");
		  visitantes.setBounds(40, 193, 219, 52);
		   
		   // registra visita
		   
		    registra_visita = new JLabel();
		    registra_visita.setPreferredSize(new Dimension(0, 40));
		    registra_visita.setText("Registrar visitas");
		    registra_visita.setForeground(Color.BLACK);
		    registra_visita.setFont(f);
		    registra_visita.setMaximumSize(new Dimension(20, 8));
		    registra_visita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    registra_visita.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/revis.png")));
		    
		     
		     
		     visitantes.add(registra_visita);
		  
		   /// registra visitas imprevistas
		  
		   registra_visita_imprevista = new JLabel();
		
		   registra_visita_imprevista.setText("Registrar visitas imprevistas");
		   registra_visita_imprevista.setForeground(Color.BLACK);
		   registra_visita_imprevista.setFont(f);
		   registra_visita_imprevista.setMaximumSize(new Dimension(20, 8));
		   registra_visita_imprevista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		   registra_visita_imprevista.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Apps-preferences-desktop-user-icon.png")));
		   
	 
		  visitantes.add(registra_visita_imprevista);
		  
		  menu.add(eventos);
		  menu.add(visitantes);
		
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(0, 0, 0, 0);
		  getContentPane().add(scrollPane);
		
		  JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setBounds(0, 0, 1078, 657);
		  lblNewLabel.setIcon(new ImageIcon(Portero.class.getResource("/Vista/imagenes/fondo.png")));
		  lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		  contentPane.add(lblNewLabel);
		  setLocation(110,70);
	}
	
	public void LimpiarJTableVisita(){
		
		int a =dm.getRowCount()-1;
		System.out.println("Tabla"+a);
		for(int i=a; i>=0;i--){
		System.out.println("i"+i);
		dm.removeRow(i );
		}
		}
	
	public void LimpiarJTableVisitaImp(){
		
		int a =dmi.getRowCount()-1;
		System.out.println("Tabla"+a);
		for(int i=a; i>=0;i--){
		System.out.println("i"+i);
		dmi.removeRow(i );
		   }
		}
	
	  public DefaultTableModel getDmi() {
		return dmi;
	}


	public JComboBox getComboBox_1() {
		return comboBox_1;
	}


	public JTextField getNom() {
		return nom;
	}


	public JTextField getAp() {
		return ap;
	}


	public JLabel getLblRazon() {
		return lblRazon;
	}

	public JTable getTableImp() {
		return tableImp;
	}


	public JTextArea getUsua() {
		return usua;
	}


	public JPanel getRegVisImp() {
		return regVisImp;
	}


	public JLabel getRegistra_visita_imprevista() {
		return registra_visita_imprevista;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}


	public JLabel getFaltantes() {
		return faltantes;
	}


	public DefaultTableModel getDm() {
		return dm;
	}


	@SuppressWarnings("unused")
	private void setOcultarColumnasJTable(JTable tbl, int columna[])
      {
          for(int i=0;i<columna.length;i++)
          {
               tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
               tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
               tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
               tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
          }
      }

	public JList getList_1() {
		return list_1;
	}


	public JTextField getFe() {
		return fe;
	}


	public JTextField getN() {
		return n;
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public JLabel getEventos_ddia() {
		return eventos_ddia;
	}


	public JLabel getEventos_pro() {
		return eventos_pro;
	}


	public JPanel getContenido_eventosDia() {
		return contenido_eventosDia;
	}


	public JTextArea getNombre() {
		return nombre;
	}


	public JTextArea getFecha() {
		return fecha;
	}


	public JLabel getAyuda() {
		return Ayuda;
	}


	public JLabel getInfo() {
		return Opt;
	}


	public JLabel getOpt() {
		return Opt;
	}


	public JList getList() {
		return list;
	}


	public JButton getCancelar() {
		return Cancelar;
	}


	public JTextArea getUbicacion() {
		return ubicacion;
	}


	public JTextField getTextField() {
		return fe;
	}


	public JTextField getTextField_1() {
		return n;
	}


	public JTaskPaneGroup getVisitantes() {
		return visitantes;
	}


	public JButton getElegir() {
		return Elegir;
	}


	public DefaultTableModel setDm() {
		// TODO Auto-generated method stub
		return null;
	}
}


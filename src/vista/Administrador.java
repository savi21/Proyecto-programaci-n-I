package vista;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import org.freixas.jcalendar.JCalendarCombo;

import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;

public class Administrador extends JFrame{

	/**
	 * 
	 */
	
	//Atributos
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_1,textField_21,textField_5,textField_6,textField_7,textField_11,textField_12;
	private JCalendarCombo textField;
	private JButton cancelar,editar,agregar,grabar, borrar;
	private JTextArea textField_13;
	private JTaskPaneGroup mantenimientos, reportes;//aqui y ya le hice el metodo
	private JLabel  mantenusr;
	private JLabel mantenInv;
	private JLabel mantenEv;
	private JLabel mantenInvitacion;
	private JPanel mant_usr;
	private JLabel label_4,labelReportes;//aqui ya lo hice el; metodo
	private JPanel panel,generar_reportes;
	private JComboBox perfil, comboBox_11,textField_8,textField_9;
	private JCheckBox textField_10;;
	private DefaultTableModel modelo_usr, modelo_ev,modelo_inv, modelo_invitaciones;
	private JTable table1,table_2,table_3;
	private JPanel mant_Event,mant_inv,mant_invitados;
	private JTextField user;
	private JTextField names;
	private JTextField last;
	private JTextField pass;
	private JButton btnNuevo,btnNuevo_inv,btnNuevo_invitaciones;
	private JButton btnEditar,btnEditar_inv,btnEditar_invitaciones;
	private JLabel lblId;
	private JTextField ID;
	private JButton btnGrabar,btnGrabar_inv,btnGrabar_invitaciones;
	private JButton btnCancelar,btnCancelar_inv,btnCancelar_invitaciones;
	private JScrollPane scrollPane_11;
	private JTable tabla_usr,table_reporte1,table_reporte2,table_reporte3,table_reporte4,table_reporte5,table_reporte6;
	private String mtusr;
	private String mtEv;
	private String mtinvitaciones;
	private String mtinv;
	private JButton btnBorrar,btnBorrar_inv,btnBorrar_invitaciones;
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
	private JLabel Info;
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
	private DefaultTableModel dmi,modelo_reporte1,modelo_reporte2,modelo_reporte3,modelo_reporte4,modelo_reporte5,modelo_reporte6, dm;
	
	private TableRowSorter<TableModel> modeloOrdenado;

	//Para ordenar la tabla
	public TableRowSorter<TableModel> getModelSorter() {
		return modeloOrdenado;
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
	private JTextArea usua;
	private String regi_vis_imp;
	private JButton btnRegistrar;
	private JComboBox sex;
	private JTextArea raz;
	private JTable tableImp;
	private JLabel lblNewLabel_2_1;
	
	
	//Metodos getter y setters
	
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


	public JTable getTable1() {
		return table1;
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


	public JTextField getTextField_21() {
		return textField_21;
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
	

	
	public String getEscoge1() {
		return escoge;
	}


	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getMant_Event() {
		return mant_Event;
	}
	
	public JTextField getNombre_ev(){
		return textField_1;
	}
	
	public JTextField getUbicacion_ev(){
		return textField_21;
	}
	
	public JCalendarCombo getFecha_ev(){
		return textField;
	}
	
	public JTextField getID_ev(){
		return textField_11;
	}
	
	public JTextField getNombre_inv(){
		return textField_5;
	}
	
	public JTextField getApellido_inv(){
		return textField_6;
	}
	
	public JTextField getTelefono_inv(){
		return textField_7;
	}
	
	public JTextField getID_inv(){
		return textField_12;
	}
	
	public JTextArea getDireccion_inv(){
		return textField_13;
	}
	
	public JComboBox getSexo_inv(){
		return comboBox_11;
	}
	public JCheckBox getAsistencia_invitaciones(){
		return textField_10;
	}
	public JComboBox getInvitado_invitaciones(){
		return textField_8;
	}
	public JComboBox getEvento_invitaciones(){
		return textField_9;
	}
	
	public JPanel getMant_invitaciones() {
		return mant_inv;
	}
	
	public JPanel getMant_inv() {
		return mant_invitados;
	}
	
	public JLabel getMantenEv() {
		return mantenEv;
	}
	
	public JTable getTabla_usr() {
		return tabla_usr;
	}



	public JLabel getMantenInvitaciones() {
		return mantenInvitacion;
	}

	public JLabel getMantenInv() {
		return mantenInv;
	}
	
	public JLabel getEventos_ddia() {
		return eventos_ddia;
	}


	public JLabel getEventos_pro() {
		return eventos_pro;
	}


	public JLabel getAyuda() {
		return Ayuda;
	}


	public JLabel getInfo() {
		return Info;
	}


	public JTaskPaneGroup getEventos() {
		return eventos;
	}


	public JTaskPaneGroup getMantenimientos() {
		return mantenimientos;
	}
	
	public JTaskPaneGroup getReportes() {
		return reportes;
	}


	public JLabel getLabel_4() {
		return label_4;
	}


	public JPanel getPanel() {
		return panel;
	}


	public JTextField getTextField() {
		return user;
	}


	public JTextField getTextField_1() {
		return names;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public JTextField getTextField_3() {
		return pass;
	}


	public JButton getBtnAgregar() {
		return btnNuevo;
	}
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}


	public JButton getBtnEditar() {
		return btnEditar;
	}
	
	public JButton getBtnGrabar() {
		return btnGrabar;
	}
	
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	
	public JButton getAgregar() {
		return agregar;
	}
	
	public JButton getBorrar() {
		return borrar;
	}
	
	
	public JButton getEditar() {
		return editar;
	}
	
	public JButton getGrabar() {
		return grabar;
	}
	
	
	public JButton getCancelar() {
		return cancelar;
	}
	
	public JButton getCancelarr(){
		return Cancelar;
	}
	
	public JButton getBtnAgregar_inv() {
		return btnNuevo_inv;
	}
	
	public JButton getBtnBorrar_inv() {
		return btnBorrar_inv;
	}
	
	
	public JButton getBtnEditar_inv() {
		return btnEditar_inv;
	}
	
	public JButton getBtnGrabar_inv() {
		return btnGrabar_inv;
	}
	
	
	public JButton getBtnCancelar_inv() {
		return btnCancelar_inv;
	}
	
	
	public JButton getBtnAgregar_invitaciones() {
		return btnNuevo_invitaciones;
	}
	
	public JButton getBtnBorrar_invitaciones() {
		return btnBorrar_invitaciones;
	}
	
	
	public JButton getBtnEditar_invitaciones() {
		return btnEditar_invitaciones;
	}
	
	public JButton getBtnGrabar_invitaciones() {
		return btnGrabar_invitaciones;
	}
	
	
	public JButton getBtnCancelar_invitaciones() {
		return btnCancelar_invitaciones;
	}
	

	public JLabel getLblId() {
		return lblId;
	}
	

	public JTextField getTextField_4() {
		return ID;
	}



	public JScrollPane getScrollPane_1() {
		return scrollPane_11;
	}


	public JTable getTable() {
		return table;
	}
	
	public JTable getTable_ev() {
		return table1;
	}
	
	public JTable getTable_inv() {
		return table_2;
	}
	
	public JTable getTable_invitaciones() {
		return table_3;
	}

	public JLabel getLabelReportes(){
		return labelReportes;
	}
	
	public JPanel getGenerarReportes(){
		return generar_reportes;
	}
	
	public JTable getTableReporte1() {
		return table_reporte1;
	}
	
	public JTable getTableReporte2() {
		return table_reporte2;
	}
	
	public JTable getTableReporte3() {
		return table_reporte3;
	}
	
	public JTable getTableReporte4() {
		return table_reporte4;
	}
	
	public JTable getTableReporte5() {
		return table_reporte5;
	}
	
	public JTable getTableReporte6() {
		return table_reporte6;
	}
	
	public DefaultTableModel getModeloReporte1(){
		return modelo_reporte1;
	}
	
	public DefaultTableModel getModeloReporte2(){
		return modelo_reporte2;
	}
	
	public DefaultTableModel getModeloReporte3(){
		return modelo_reporte3;
	}
	
	public DefaultTableModel getModeloReporte4(){
		return modelo_reporte4;
	}
	
	public DefaultTableModel getModeloReporte5(){
		return modelo_reporte5;
	}
	
	public DefaultTableModel getModeloReporte6(){
		return modelo_reporte6;
	}


	
	public Administrador() {
		
		//Look and feel
		
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

		
		//Propiedades de la ventana 
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Adiministrador");
		setResizable(false);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 1086, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Font f=new Font("Tahoma", Font.BOLD, 11);
		 dmi=new DefaultTableModel(
				  	null,
				  	new String[] {
				  		"Nombre","Apellido","Sexo", "Razon de entrada"
				  	}
				  );
		 
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
		
		
		//Subrayado de los subitems
		
		escoge = 
		            "<html><p>"+
		            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
		            "<b>Eventos del dia</b></u><br></font>"+
		            "";
		 prox = "<html><p>"+
		            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
				    "<b>Eventos proximos</b></u><br></font>"+
		            "";
		
		 regi_vis = 
		            "<html><p>"+
		            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
		            "<b>Registrar visitas</b></u><br></font>"+
		            "";
		   
		regi_vis_imp = 
		            "<html><p>"+
		            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
		            "<b>Registrar visitas imprevistas </b></u><br></font>"+
		            "";
		 
		final String gen_reportes = 
				"<html><p>"+
						"<font size=\"2.3\" face=\"Tahoma\"><u>"+
						"<b>Generar Reportes</b></u><br></font>"+
						"";
		
		 mtusr = 
	            "<html><p>"+
	            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
	            "<b>Mantenimiento de Usuarios </b></u><br></font>"+
	            "";
		 
		mtEv=
				 "<html><p>"+
				            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
				            "<b>Mantenimiento de Eventos </b></u><br></font>"+
				            "";
		
		mtinvitaciones=
				 "<html><p>"+
				            "<font size=\"2.3\" face=\"Tahoma\"><u>"+
				            "<b>Mantenimiento de Invitaciones </b></u><br></font>"+
				            "";
		
		mtinv=
				"<html><p>"+
						"<font size=\"2.3\" face=\"Tahoma\"><u>"+
						"<b>Mantenimiento de Invitados </b></u><br></font>"+
						"";
	      
	      contenido_eventosDia = new JPanel();
	      contenido_eventosDia.setVisible(false);
	      
	        
	        contenido_eventosProx = new JPanel();
	        contenido_eventosProx.setVisible(false);
	        
	        regVisImp = new JPanel();
	        regVisImp.setVisible(false);
	        
	        panel_regvis = new JPanel();
	        panel_regvis.setVisible(false);
	        panel_regvis.setLayout(null);
	        panel_regvis.setBackground(Color.WHITE);
	        panel_regvis.setBounds(319, 76, 732, 545);
	        contentPane.add(panel_regvis);
	        
 
	        
	        JScrollPane scrollPane_1 = new JScrollPane();
	        scrollPane_1.setRequestFocusEnabled(false);
	      
	        scrollPane_1.setBorder(new TitledBorder(null, "Lista de invitados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        scrollPane_1.setBackground(Color.WHITE);
	        scrollPane_1.setBounds(34, 84, 663, 438);
	        panel_regvis.add(scrollPane_1);
	        table = new JTable(dm){
		private static final long serialVersionUID = 1L;
		
		public boolean isCellEditable(int row, int col) {
			return col == 6;
		}
	  };
	        table.getColumnModel().getColumn(6).setCellEditor(defaultCellEditor1);
	        setOcultaColumnas(table,new int[]{0,1});
	        	        
 
  scrollPane_1.setViewportView(table);
  
  textField_2 = new JTextField();
  textField_2.setBounds(160, 42, 203, 20);
  panel_regvis.add(textField_2);
  textField_2.setColumns(10);
  
  JLabel lblBuscarInvitados = new JLabel("Buscar Invitados");
  lblBuscarInvitados.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-edit-find-user-icon.png")));
  lblBuscarInvitados.setBounds(34, 38, 116, 32);
  panel_regvis.add(lblBuscarInvitados);
  
  lblNewLabel_2_1 = new JLabel("Cantidad de invitados que faltan por llegar:");
  lblNewLabel_2_1.setBounds(383, 45, 222, 14);
  panel_regvis.add(lblNewLabel_2_1);
  
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
	        
	        JScrollPane scrollPane_21 = new JScrollPane();
	        scrollPane_21.setBackground(Color.WHITE);
	        scrollPane_21.getViewport().setBackground(SystemColor.menu);
	        scrollPane_21.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Invitados imprevistos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(133, 140, 158)));
	        scrollPane_21.setBounds(31, 208, 678, 307);
	        regVisImp.add(scrollPane_21);
	        
	          tableImp = new JTable(dmi){
		private static final long serialVersionUID = 1L;
		
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	  };
	          tableImp.setRowMargin(6);
	          
	          
	           	  
	           	  scrollPane_21.setViewportView(tableImp);
	           	  
	           	  nom = new JTextField();
	           	  nom.setColumns(10);
	           	  nom.setBounds(39, 60, 145, 20);
	           	  regVisImp.add(nom);
	           	  
	           	  JLabel lblNombre_11 = new JLabel("Nombre");
	           	  lblNombre_11.setBounds(39, 35, 93, 14);
	           	  regVisImp.add(lblNombre_11);
	           	  
	           	  JLabel lblApellido1 = new JLabel("Apellido");
	           	  lblApellido1.setBounds(209, 35, 144, 14);
	           	  regVisImp.add(lblApellido1);
	           	  
	           	  JLabel label_6 = new JLabel("");
	           	  label_6.setForeground(SystemColor.textHighlight);
	           	  label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
	           	  label_6.setBounds(603, 45, 94, 14);
	           	  regVisImp.add(label_6);
	           	  
	           	  JLabel label_7 = new JLabel("");
	           	  label_7.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/content.png")));
	           	  label_7.setBounds(0, 0, 732, 551);
	           	  regVisImp.add(label_7);
	        
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
	        ub.setLineWrap(true);
	        ub.setWrapStyleWord(true);
	        ub.setEnabled(false);
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
	        fe.setColumns(10);
	        fe.setBounds(486, 233, 184, 20);
	        contenido_eventosProx.add(fe);
	        
	        n = new JTextField();
	        n.setEnabled(false);
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
	      ubicacion.setWrapStyleWord(true);
	      ubicacion.setLineWrap(true);
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
	      fecha.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));
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
	      
		//Panel de mantenimiento de usuario
	      
	      mant_usr = new JPanel();
	      mant_usr.setBackground(Color.WHITE);
	      mant_usr.setBounds(319, 76, 732, 545);
	      contentPane.add(mant_usr);
	      mant_usr.setLayout(null);
	      //Tabla de mantenimiento de usr
	      modelo_usr=new DefaultTableModel(null, new String[]{"ID","Nombre","Apellido","Usuario","Perfil de Usuario"});
	      tabla_usr = new JTable(modelo_usr){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col) {
				return false;
			}
	      };
	      tabla_usr.setBounds(new Rectangle(10, 64,667, 275));
	      
	     
	      
		//Scroll de la tabla
	      
		scrollPane_11 = new JScrollPane(tabla_usr);
		scrollPane_11.setBounds(32, 207, 665, 304);
		scrollPane_11.setBackground(Color.WHITE);
		scrollPane_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(133, 140, 158)));
		
		//Aqui se le agrega el scroll al panel
		
		mant_usr.add(scrollPane_11);
		
		             //Botones del panel mantenimiento de usuario
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(576, 159, 121, 33);
		mant_usr.add(btnCancelar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-ok-icon.png")));
		btnGrabar.setEnabled(false);
		btnGrabar.setBounds(304, 159, 126, 33);
		mant_usr.add(btnGrabar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-document-edit-icon.png")));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(168, 159, 126, 33);
		mant_usr.add(btnEditar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Sign-Add-icon.png")));
		
		btnNuevo.setBounds(32, 159, 112, 33);
		mant_usr.add(btnNuevo);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-edit-delete-shred-icon.png")));
		btnBorrar.setEnabled(false);
		btnBorrar.setBounds(440, 159, 112, 33);
		mant_usr.add(btnBorrar);
		
		//Panel donde van los datos
		
		panel = new JPanel();
		panel.setBounds(22, 11, 687, 137);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mant_usr.add(panel);
		panel.setLayout(null);
		
		//Componentes del panel 
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(109, 65, 46, 14);
		panel.add(lblNombre_1);
		
		user = new JTextField();
		user.setEnabled(false);
		user.setBounds(416, 30, 136, 20);
		panel.add(user);
		user.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(109, 95, 46, 14);
		panel.add(lblApellido);
		
		names = new JTextField();
		names.setEnabled(false);
		names.setColumns(10);
		names.setBounds(175, 61, 136, 20);
		panel.add(names);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(350, 33, 46, 14);
		panel.add(lblUsuario);
		
		last = new JTextField();
		last.setEnabled(false);
		last.setColumns(10);
		last.setBounds(175, 92, 136, 20);
		panel.add(last);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(350, 65, 56, 14);
		panel.add(lblContrasea);
		
		pass = new JTextField();
		pass.setEnabled(false);
		pass.setColumns(10);
		pass.setBounds(416, 60, 136, 20);
		panel.add(pass);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(350, 94, 46, 14);
		panel.add(lblPerfil);
		
	   perfil = new JComboBox();
	   perfil.setEnabled(false);
	   perfil.setModel(new DefaultComboBoxModel(new String[] {"Portero", "Administrador"}));
	   perfil.setBounds(416, 91, 136, 20);
	   panel.add(perfil);
	   
	   lblId = new JLabel("ID ");
	   lblId.setEnabled(false);
	   lblId.setBounds(109, 34, 56, 14);
	   panel.add(lblId);
	   
	   ID = new JTextField();
	   ID.setText("0");
	   ID.setDisabledTextColor(Color.GRAY);
	   ID.setEnabled(false);
	   ID.setBounds(175, 30, 136, 20);
	   panel.add(ID);
	   ID.setColumns(10);
	   
	   label_4 = new JLabel("");
	   label_4.setBounds(0, 0, 732, 545);
	   label_4.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/content.png")));
	   mant_usr.add(label_4);
	   
	 //mantenimiento de invitado//

	   	mant_invitados = new JPanel();
	   	mant_invitados.setVisible(false);
	   	mant_invitados.setBackground(Color.WHITE);
	   	mant_invitados.setBounds(319, 76, 732, 545);
	   	contentPane.add(mant_invitados);
	   	mant_invitados.setLayout(null);
	   	
	   	JPanel panel = new JPanel();
	    panel.setBounds(22, 11, 687, 170);
	    panel.setBackground(Color.WHITE);
	    panel.setBorder(new TitledBorder(null, "Datos de Invitados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    mant_invitados.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblNombre_2 = new JLabel("Nombre");
	    lblNombre_2.setBounds(32, 76, 46, 14);
	    panel.add(lblNombre_2);
	    
	    textField_5 = new JTextField();
	    textField_5.setBounds(88, 73, 214, 20);
	    textField_5.setEnabled(false);
	    panel.add(textField_5);
	    textField_5.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Apellidos");
	    lblNewLabel_2.setBounds(32, 117, 46, 14);
	    panel.add(lblNewLabel_2);
	    
	    textField_6 = new JTextField();
	    textField_6.setText("");
	    textField_6.setEnabled(false);
	    textField_6.setBounds(88, 114, 214, 20);
	    panel.add(textField_6);
	    textField_6.setColumns(10);
	    
	    JLabel lblTelefono = new JLabel("Telefono");
	    lblTelefono.setBounds(368, 76, 46, 14);
	    panel.add(lblTelefono);
	    MaskFormatter mascara = null;
	    try {
			mascara = new MaskFormatter("(###)###-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	    textField_7 = new JFormattedTextField(mascara);
	    textField_7.setBounds(424, 73, 165, 20);
	    textField_7.setEnabled(false);
	    panel.add(textField_7);
	    textField_7.setColumns(10);
	    
	    JLabel lblID = new JLabel("ID");
	    lblID.setBounds(32, 33, 46, 14);
	    panel.add(lblID);
	    
	    textField_12 = new JTextField();
	    textField_12.setText("0");
	    textField_12.setBounds(88, 30, 80, 20);
	    textField_12.setEnabled(false);
	    panel.add(textField_12);
	    textField_12.setColumns(10);
	    
	    JLabel lblDireccion = new JLabel("Direccion");
	    lblDireccion.setBounds(368, 117, 46, 14);
	    panel.add(lblDireccion);
	    
	    textField_13 = new JTextArea();
	    textField_13.setBounds(424, 114, 165, 42);
	    textField_13.setEnabled(false);
	    panel.add(textField_13);
	    textField_13.setColumns(10);
	    textField_13.setRows(5);
	    textField_13.setBorder(new LineBorder(UIManager.getColor("Table.gridColor")));
	    
	    comboBox_11 = new JComboBox();
	    comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Femenino", "Masculino"}));
	    comboBox_11.setEnabled(false);
	    comboBox_11.setBounds(424, 30, 165, 20);
	    panel.add(comboBox_11);
	    
	    JLabel lblNewLabel_3 = new JLabel("Sexo");
	    lblNewLabel_3.setBounds(368, 33, 46, 14);
	    panel.add(lblNewLabel_3);
	    
	    JScrollPane scrol= new JScrollPane();
	    scrol.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    scrol.setBounds(22, 232, 664, 288);
	    mant_invitados.add(scrol);
	    mant_invitados.add(scrol);
	    
	    table_2 = new JTable();
	    modelo_inv=new DefaultTableModel(null,new String[] {"ID","Nombre", "Apellidos", "Sexo", "Direccion", "Telefono"});
	    table_2.setModel(modelo_inv);
	    scrol.setViewportView(table_2);
	    
		  //aki van los botones de la ventana mantenimiento de invitados
	    
		btnCancelar_inv = new JButton("Cancelar");
		btnCancelar_inv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
		btnCancelar_inv.setEnabled(false);
		btnCancelar_inv.setBounds(576, 190, 110, 33);
		mant_invitados.add(btnCancelar_inv);
		
		btnGrabar_inv = new JButton("Grabar");
		btnGrabar_inv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-ok-icon.png")));
		btnGrabar_inv.setEnabled(false);
		btnGrabar_inv.setBounds(304, 190, 102, 33);
		mant_invitados.add(btnGrabar_inv);
		
		btnEditar_inv = new JButton("Editar");
		btnEditar_inv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-document-edit-icon.png")));
		btnEditar_inv.setEnabled(false);
		btnEditar_inv.setBounds(168, 190, 102, 33);
		mant_invitados.add(btnEditar_inv);
		
		btnNuevo_inv = new JButton("Nuevo");
		btnNuevo_inv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Sign-Add-icon.png")));
		btnNuevo_inv.setBounds(32, 190, 102, 33);
		mant_invitados.add(btnNuevo_inv);
		
		btnBorrar_inv = new JButton("Borrar");
		btnBorrar_inv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-edit-delete-shred-icon.png")));
		btnBorrar_inv.setEnabled(false);
		btnBorrar_inv.setBounds(440, 190, 102, 33);
		mant_invitados.add(btnBorrar_inv);
	   
	   // mantenimiento de invitaciones//

		mant_inv = new JPanel();
		mant_inv.setBackground(Color.WHITE);
		mant_inv.setBounds(319, 76, 732, 545);
		contentPane.add(mant_inv);
		mant_inv.setLayout(null);
		mant_inv.setVisible(false);
		  
		JPanel panelmant = new JPanel();
		panelmant.setBounds(22, 11, 687, 137);
		panelmant.setBackground(Color.WHITE);
		panelmant.setBorder(new TitledBorder(null, "Mantenimiento de Invitaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mant_inv.add(panelmant);
		panelmant.setLayout(null);
		  
	    JLabel lblNewLabel_4 = new JLabel("Invitado ");
	    lblNewLabel_4.setBounds(126, 41, 68, 14);
	    panelmant.add(lblNewLabel_4);
	  
	    textField_8 = new JComboBox();
	    textField_8.setEnabled(false);
	    textField_8.setBounds(191, 38, 230, 20);
	    panelmant.add(textField_8);
		  
	    JLabel lblNewLabel_5 = new JLabel("Evento");
	    lblNewLabel_5.setBounds(126, 79, 46, 14);
	    panelmant.add(lblNewLabel_5);
	  
	    textField_9 = new JComboBox();
	    textField_9.setEnabled(false);
	    textField_9.setBounds(190, 76, 231, 20);
	    panelmant.add(textField_9);
		  
		
		textField_10 = new JCheckBox("Asistencia");
		textField_10.setEnabled(false);
		textField_10.setBounds(502, 59, 86, 20);
		panelmant.add(textField_10);
		  
	    JScrollPane scroll = new JScrollPane();
	    scroll.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    scroll.setBounds(22, 206, 687, 312);
	    mant_inv.add(scroll);
		  
	    table_3 = new JTable();
	    modelo_invitaciones=new DefaultTableModel(null,new String[] {"Evento", "Invitado","Asistencia"});
	    table_3.setModel(modelo_invitaciones);
		 scroll.setViewportView(table_3);
		 
		 
		  //aki van los botones de la ventana mantenimiento de invitaciones
		 
		 btnCancelar_invitaciones = new JButton("Cancelar");
		 btnCancelar_invitaciones.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
		btnCancelar_invitaciones.setEnabled(false);
		btnCancelar_invitaciones.setBounds(576, 165, 109, 33);
		mant_inv.add(btnCancelar_invitaciones);
		
		btnGrabar_invitaciones = new JButton("Grabar");
		btnGrabar_invitaciones.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-ok-icon.png")));
		btnGrabar_invitaciones.setEnabled(false);
		btnGrabar_invitaciones.setBounds(304, 165, 109, 30);
		mant_inv.add(btnGrabar_invitaciones);
		
		btnEditar_invitaciones = new JButton("Editar");
		btnEditar_invitaciones.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-document-edit-icon.png")));
		btnEditar_invitaciones.setEnabled(false);
		btnEditar_invitaciones.setBounds(168, 165, 109, 33);
		mant_inv.add(btnEditar_invitaciones);
		
		btnNuevo_invitaciones = new JButton("Nuevo");
		btnNuevo_invitaciones.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Sign-Add-icon.png")));
		btnNuevo_invitaciones.setBounds(32, 165, 109, 33);
		mant_inv.add(btnNuevo_invitaciones);
		
		btnBorrar_invitaciones = new JButton("Borrar");
		btnBorrar_invitaciones.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-edit-delete-shred-icon.png")));
		btnBorrar_invitaciones.setEnabled(false);
		btnBorrar_invitaciones.setBounds(440, 165, 109, 30);
		mant_inv.add(btnBorrar_invitaciones);
		  
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(0, 0, 732, 545);
		 mant_inv.add(lblNewLabel);
		 lblNewLabel.setIcon(new ImageIcon(Administrador.class.getResource("/Vista/imagenes/content.png")));
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		  
	 //mantenimiento del evento, hay que arreglarle los bordes , pues no aparecen igual que en los demas paneles//
	   
	      mant_Event = new JPanel();
	      mant_Event.setBackground(Color.WHITE);
	      mant_Event.setBounds(319, 76, 732, 545);
	      contentPane.add(mant_Event);
	      mant_Event.setLayout(null);
	      mant_Event.setVisible(false);
	      
	        JPanel panelMevent = new JPanel();
	        //panelMevent.setVisible(false);
	        panelMevent.setBounds(22, 11, 687, 144);
	        panelMevent.setBackground(Color.WHITE);
	        panelMevent.setBorder(new TitledBorder(null, "Datos del Evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        mant_Event.add(panelMevent);
	        panelMevent.setLayout(null);
	        
	 //label y textFiled de mantenimiento de eventos//
	 
	          JLabel Nombre_event = new JLabel("Nombre");
	          //Nombre_event.setVisible(false);
              Nombre_event.setBounds(418, 33, 105, 14);
	          panelMevent.add(Nombre_event);
	          
	          //text field de la fecha
	             textField = new JCalendarCombo();
	             //textField.setVisible(false);
	             textField.setEnabled(false);
	             textField.setBounds(487, 88, 136, 20);
	             panelMevent.add(textField);
	             textField.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
	             
	                JLabel ubicacion_1 = new JLabel("Ubicacion");
	                //ubicacion_1.setVisible(false);
	                ubicacion_1.setBounds(66, 100, 46, 14);
	                panelMevent.add(ubicacion_1);
	                //textfield de nombre
	                textField_1 = new JTextField();
	                //textField_1.setVisible(false);
	                textField_1.setEnabled(false);
	                textField_1.setColumns(10);
	                textField_1.setBounds(487, 30, 136, 20);
	                panelMevent.add(textField_1);
	                
	                //textfiel   ubicacion
	                textField_21 = new JTextField();
	                //textField_2.setVisible(false);
	                textField_21.setEnabled(false);
	                textField_21.setColumns(10);
	                textField_21.setBounds(162, 88, 180, 38);
	                panelMevent.add(textField_21);
	                
	                JScrollPane scrollPane_2 = new JScrollPane();
	                //scrollPane_2.setVisible(false);
	                scrollPane_2.setWheelScrollingEnabled(false);
	                scrollPane_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	                scrollPane_2.setBounds(22, 202, 687, 318);
	                mant_Event.add(scrollPane_2);
	                
	                //botones de mantenimiento de eventos//

	                cancelar = new JButton("Cancelar");
	                cancelar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
	                cancelar.setEnabled(false);
	                cancelar.setBounds(576, 166, 109, 33);
	                mant_Event.add(cancelar);
	                
	                grabar = new JButton("Grabar");
	                grabar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Action-ok-icon.png")));
	                grabar.setEnabled(false);
	                grabar.setBounds(304, 166, 109, 33);
	                mant_Event.add(grabar);
	                
	                editar = new JButton("Editar");
	                editar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-document-edit-icon.png")));
	                editar.setEnabled(false);
	                editar.setBounds(168, 166, 109, 33);
	                mant_Event.add(editar);
	                
	                agregar = new JButton("Nuevo");
	                agregar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Sign-Add-icon.png")));
	                agregar.setBounds(32, 166, 109, 33);
	                mant_Event.add(agregar);
	                
	        		borrar = new JButton("Borrar");
	        		borrar.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Actions-edit-delete-shred-icon.png")));
	        		borrar.setEnabled(false);
	        		borrar.setBounds(440, 166, 109, 33);
	        		mant_Event.add(borrar);
	        		
	                
	    JLabel Direccion = new JLabel("Direccion");
	    panelMevent.add(Direccion);
	    
	    //text field de id
	    
	    textField_11 = new JTextField();
	    textField_11.setBounds(162, 30, 178, 25);
	    textField_11.setText("0");
	    textField_11.setEnabled(false);
	    panelMevent.add(textField_11);
	    textField_11.setColumns(10);
	    
	    JLabel lblNewLabel_7 = new JLabel("Fecha");
	    lblNewLabel_7.setBounds(418, 91, 46, 14);
	    panelMevent.add(lblNewLabel_7);
	    
	    JLabel lblNewLabel_8 = new JLabel("ID");
	    lblNewLabel_8.setEnabled(false);
	    lblNewLabel_8.setBounds(66, 33, 110, 14);
	    panelMevent.add(lblNewLabel_8);
	    
	    //tabla de mantenimiento de eventos//
	    
	    
	    table1 = new JTable();
	    modelo_ev =new DefaultTableModel(null,new String[] {"ID", "Nombre del Evento", "Ubicacion", "Fecha"});
	    table1.setModel(modelo_ev);
	    table1.getColumnModel().getColumn(0).setPreferredWidth(54);
	    table1.getColumnModel().getColumn(1).setPreferredWidth(112);
	    table1.getColumnModel().getColumn(3).setPreferredWidth(83);
	    
	        //scroll//
	        
	    scrollPane_2.setViewportView(table1);
	    
	    scrollPane_2.setBounds(22, 202, 687, 318);
	    scrollPane_2.setBackground(Color.WHITE);
	    scrollPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(133, 140, 158)));
	    scrollPane_2.setBounds(22, 202, 687, 318);
	    scrollPane_2.setBackground(Color.WHITE);
	    scrollPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(133, 140, 158)));
		  
		  JSeparator separator = new JSeparator();
		  separator.setOrientation(SwingConstants.VERTICAL);
		  separator.setForeground(Color.LIGHT_GRAY);
		  separator.setBounds(949, 24, 19, 45);
		  contentPane.add(separator);
		  
		  Opt = new JLabel("Opciones");
		  Opt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  Opt.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Categories-applications-system-icon.png")));
		  Opt.setFont(new Font("Tahoma", Font.BOLD, 12));
		  Opt.setForeground(Color.WHITE);
		  Opt.setBounds(958, 11, 112, 62);
		  contentPane.add(Opt);
		
		  Ayuda = new JLabel("Ayuda");
		  Ayuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  Ayuda.setFont(new Font("Tahoma", Font.BOLD, 12));
		  Ayuda.setForeground(Color.WHITE);
		  Ayuda.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/Categories-system-help-icon.png")));
		  Ayuda.setBounds(842, 12, 106, 61);
		  contentPane.add(Ayuda);
		  
		  //Reportes
		    generar_reportes = new JPanel();
		   	generar_reportes.setVisible(false);
		   	generar_reportes.setBackground(Color.WHITE);
		   	generar_reportes.setBounds(319, 76, 732, 550);
		   	contentPane.add(generar_reportes);
		   	generar_reportes.setLayout(null);
		   	
		   	JPanel reporte_asistencia = new JPanel();
		   	reporte_asistencia.setBackground(Color.WHITE);
		   	reporte_asistencia.setBounds(15, 10, 690, 170);
		   	reporte_asistencia.setBorder(new TitledBorder(null, "Asistencia por Evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		   	generar_reportes.add(reporte_asistencia);
		   	reporte_asistencia.setLayout(null);
		   			    
		    JScrollPane scroll_reporte1= new JScrollPane();
		    scroll_reporte1.setBounds(20, 30, 300, 120);
		    reporte_asistencia.add(scroll_reporte1);
		    
		    table_reporte1 = new JTable();
		    modelo_reporte1=new DefaultTableModel(null,new String[] {"Evento", "# Asistencia", "# Inesperados"});
		    table_reporte1.setModel(modelo_reporte1);
		    scroll_reporte1.setViewportView(table_reporte1);
		    
		    JScrollPane scroll_reporte2= new JScrollPane();
		    scroll_reporte2.setBounds(360, 30, 300, 120);
		    reporte_asistencia.add(scroll_reporte2);
		    
		    table_reporte2 = new JTable();
		    modelo_reporte2=new DefaultTableModel(null,new String[] {"Evento", "% Asistencia"});
		    table_reporte2.setModel(modelo_reporte2);
		    scroll_reporte2.setViewportView(table_reporte2);
		    
		    JPanel reporte_sexo = new JPanel();
		    reporte_sexo.setBackground(Color.WHITE);
		    reporte_sexo.setBounds(15, 190, 690, 170);
		    reporte_sexo.setBorder(new TitledBorder(null, "Asistencia por Genero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		    generar_reportes.add(reporte_sexo);
		    reporte_sexo.setLayout(null);
		    
		    JScrollPane scroll_reporte3= new JScrollPane();
		    scroll_reporte3.setBounds(20, 30, 300, 120);
		    reporte_sexo.add(scroll_reporte3);
		    
		    table_reporte3 = new JTable();
		    modelo_reporte3=new DefaultTableModel(null,new String[] {"Evento", "# Mujeres"});
		    table_reporte3.setModel(modelo_reporte3);
		    scroll_reporte3.setViewportView(table_reporte3);
		    
		    JScrollPane scroll_reporte4= new JScrollPane();
		    scroll_reporte4.setBounds(360, 30, 300, 120);
		    reporte_sexo.add(scroll_reporte4);
		    
		    table_reporte4 = new JTable();
		    modelo_reporte4=new DefaultTableModel(null,new String[] {"Evento", "# Hombres"});
		    table_reporte4.setModel(modelo_reporte4);
		    scroll_reporte4.setViewportView(table_reporte4);
		    
		    JPanel reporte_visitas = new JPanel();//panel de los eventos mas visitados y los dia en los que mas se visitan
		    reporte_visitas.setBackground(Color.WHITE);
		    reporte_visitas.setBounds(15, 370, 690, 170);
		    reporte_visitas.setBorder(new TitledBorder(null, "Mas Visitados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		    generar_reportes.add(reporte_visitas);
		    reporte_visitas.setLayout(null);
		    
		    JScrollPane scroll_reporte5= new JScrollPane();
		    scroll_reporte5.setBounds(20, 30, 300, 120);
		    reporte_visitas.add(scroll_reporte5);
		    
		    table_reporte5 = new JTable();
		    modelo_reporte5=new DefaultTableModel(null,new String[] {"Evento", "# Asistencia","# Inesperados"});
		    table_reporte5.setModel(modelo_reporte5);
		    scroll_reporte5.setViewportView(table_reporte5);
		    
		    JScrollPane scroll_reporte6= new JScrollPane();
		    scroll_reporte6.setBounds(360, 30, 300, 120);
		    reporte_visitas.add(scroll_reporte6);
		    
		    table_reporte6 = new JTable();
		    modelo_reporte6=new DefaultTableModel(null,new String[] {"Dia", "# Asistencia"});
		    table_reporte6.setModel(modelo_reporte6);
		    scroll_reporte6.setViewportView(table_reporte6);
		    
		  
		  labelReportes = new JLabel();
		  labelReportes.setText("Generar Reportes");
		  labelReportes.setForeground(Color.BLACK);
		  labelReportes.setFont(f);
		  labelReportes.setMaximumSize(new Dimension(20, 8));
		  labelReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  labelReportes.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/report-icon.png")));
		  labelReportes.addMouseListener(new MouseAdapter() {
		 
		     	public void mouseEntered(MouseEvent e) {
		     		labelReportes.setText(gen_reportes);
		     	}
		     	
		     	public void mouseExited(MouseEvent e) {
		     		labelReportes.setText("Generar Reportes");
		     	}
		     });
		     
		  
		  
		  reportes = new JTaskPaneGroup();
		  reportes.setExpanded(false);
		  reportes.setTitle("Reportes");
		  reportes.add(labelReportes);
		  
	    //Menu de la izquierda
		  
		JTaskPane menu = new JTaskPane();
		menu.setBounds(22, 76, 274, 545);
		contentPane.add(menu);
	
		
		//Submenu mantenimientos
		
		mantenimientos= new JTaskPaneGroup();
		mantenimientos.setTitle("Mantenimientos");
		mantenimientos.setScrollOnExpand(true);
		mantenimientos.setBounds(10, 112, 295, 312);
	  
	    
	  //Subitem mantenimiento usuario
		
		 mantenusr= new JLabel("Mantenimiento de Usuarios");
		 mantenusr.setForeground(Color.BLUE);
		 mantenusr.setFont(f);
		 mantenusr.setMaximumSize(new Dimension(20, 8));
		 mantenusr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 mantenusr.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/mant.png")));
		 
		 
		 //Agregando el subitem al submenu
		//mantenimiento Invitado
		 
		 mantenInv=new JLabel("Mantenimiento de Invitados");
		 mantenInv.setForeground(Color.BLACK);
		 mantenInv.setFont(f);
		 mantenInv.setMaximumSize(new Dimension(20, 8));
		 mantenInv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 mantenInv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/mant.png")));
		 
		 //mantenimiento Evento
		 
		 mantenEv=new JLabel("Mantenimiento de Eventos");
		 mantenEv.setForeground(Color.BLACK);
		 mantenEv.setFont(f);
		 mantenEv.setMaximumSize(new Dimension(20, 8));
		 mantenEv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 mantenEv.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/mant.png")));
		
		 //mantenimiento de Invitaciones
		 
		 mantenInvitacion=new JLabel("Mantenimiento de Invitaciones");
		 mantenInvitacion.setForeground(Color.BLACK);
		 mantenInvitacion.setFont(f);
		 mantenInvitacion.setMaximumSize(new Dimension(20, 8));
		 mantenInvitacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 mantenInvitacion.setIcon(new ImageIcon(Administrador.class.getResource("/vista/imagenes/mant.png")));
		 
		 
		mantenimientos.getContentPane().add(mantenusr);
		mantenimientos.getContentPane().add(mantenInv);
		mantenimientos.getContentPane().add(mantenEv);
		mantenimientos.getContentPane().add(mantenInvitacion);
		  
		  
		  //Donde se agregan los submenus
		  
		    menu.add(mantenimientos);
		    
		//Forma parte del fondo    
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 0, 0);
		getContentPane().add(scrollPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1078, 657);
		lblNewLabel.setIcon(new ImageIcon(Portero.class.getResource("/Vista/imagenes/fondo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
	

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
            "";;
  
  
  
 

  Ayuda = new JLabel("Ayuda");
  Ayuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  Ayuda.setFont(new Font("Tahoma", Font.BOLD, 12));
  Ayuda.setForeground(Color.WHITE);
  Ayuda.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Categories-system-help-icon.png")));
  Ayuda.setBounds(842, 12, 106, 61);
  contentPane.add(Ayuda);
  
  JSeparator separator1 = new JSeparator();
  separator1.setOrientation(SwingConstants.VERTICAL);
  separator1.setForeground(Color.LIGHT_GRAY);
  separator1.setBounds(949, 24, 19, 45);
  contentPane.add(separator1);
  
  Info = new JLabel("Opciones");
  Info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  Info.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Categories-applications-system-icon.png")));
  Info.setFont(new Font("Tahoma", Font.BOLD, 12));
  Info.setForeground(Color.WHITE);
  Info.setBounds(958, 11, 112, 62);
  contentPane.add(Info);
  

  
  Font f1=new Font("Tahoma", Font.BOLD, 11);
  
   eventos_ddia= new JLabel("Eventos del dia");
   eventos_ddia.setMinimumSize(new Dimension(20, 20));
   eventos_ddia.setPreferredSize(new Dimension(73, 40));
  
   
   eventos_pro=new JLabel("Eventos pr\u00F3ximos");
   eventos_pro.setForeground(Color.BLACK);
   eventos_pro.setFont(f1);
   eventos_pro.setMaximumSize(new Dimension(20, 8));
   eventos_pro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   eventos_pro.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/prox.png")));
   
   eventos_ddia.setForeground(Color.BLACK);
   eventos_ddia.setFont(f1);
   eventos_ddia.setMaximumSize(new Dimension(1, 8));
   eventos_ddia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   eventos_ddia.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/1333846050_calendar.png")));

  eventos= new JTaskPaneGroup();
  eventos.setExpanded(false);
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
    registra_visita.setFont(f1);
    registra_visita.setMaximumSize(new Dimension(20, 8));
    registra_visita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    registra_visita.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/revis.png")));
    
     
     
     visitantes.add(registra_visita);
  
   /// registra visitas imprevistas
  
   registra_visita_imprevista = new JLabel();

   registra_visita_imprevista.setText("Registrar visitas imprevistas");
   registra_visita_imprevista.setForeground(Color.BLACK);
   registra_visita_imprevista.setFont(f1);
   registra_visita_imprevista.setMaximumSize(new Dimension(20, 8));
   registra_visita_imprevista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   registra_visita_imprevista.setIcon(new ImageIcon(Portero.class.getResource("/vista/imagenes/Apps-preferences-desktop-user-icon.png")));
   

  visitantes.add(registra_visita_imprevista);
  
  menu.add(reportes);
  menu.add(eventos);
  menu.add(visitantes);
	

  JScrollPane scrollPane1 = new JScrollPane();
  scrollPane1.setBounds(0, 0, 0, 0);
  getContentPane().add(scrollPane1);

  JLabel lblNewLabel1 = new JLabel("");
  lblNewLabel1.setBounds(0, 0, 1078, 657);
  lblNewLabel1.setIcon(new ImageIcon(Portero.class.getResource("/Vista/imagenes/fondo.png")));
  lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
  contentPane.add(lblNewLabel1);
  setLocation(110,70);
  
  
}

public JLabel getOpt() {
		return Opt;
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
private void setOcultaColumnas(JTable tbl, int colum[])
{
  for(int i=0;i<colum.length;i++)
  {
       tbl.getColumnModel().getColumn(colum[i]).setMaxWidth(0);
       tbl.getColumnModel().getColumn(colum[i]).setMinWidth(0);
       tbl.getTableHeader().getColumnModel().getColumn(colum[i]).setMaxWidth(0);
       tbl.getTableHeader().getColumnModel().getColumn(colum[i]).setMinWidth(0);
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


public JPanel getContenido_eventosDia() {
return contenido_eventosDia;
}


public JTextArea getNombre() {
return nombre;
}


public JTextArea getFecha() {
return fecha;
}


public JList getList() {
return list;
}


public JTextArea getUbicacion() {
return ubicacion;
}

public JButton getElegir() {
return Elegir;
}


public DefaultTableModel setDm() {
// TODO Auto-generated method stub
return null;
}
	

	public DefaultTableModel getModelo_usr() {
		return modelo_usr;
	}
	
	public DefaultTableModel getModelo_ev() {
		return modelo_ev;
	}
	
	public DefaultTableModel getModelo_inv() {
		return modelo_inv;
	}
	
	public DefaultTableModel getModelo_invitaciones() {
		return modelo_invitaciones;
	}


	public JTextField getNames() {
		return names;
	}


	public void setNames(JTextField names) {
		this.names = names;
	}


	public JButton getBtnNuevo() {
		return btnNuevo;
	}


	public JComboBox getPerfil() {
		return perfil;
	}


	public JTextField getUser() {
		return user;
	}



	public JTextField getLast() {
		return last;
	}


	public JTextField getPass() {
		return pass;
	}


	public JTextField getID() {
		return ID;
	}


	public String getMtusr() {
		return mtusr;
	}
	
	
	public String getMtEv() {
		return mtEv;
	}
	
	
	public String getMtInvitaciones() {
		return mtinvitaciones;
	}
	
	
	public String getMtInv() {
		return mtinv;
	}


	public JLabel getMantenusr() {
		return mantenusr;
	}


	public JPanel getMant_usr() {
		return mant_usr;
	}


	public JTaskPaneGroup getVisitantes() {
		return visitantes;
	}
	}	


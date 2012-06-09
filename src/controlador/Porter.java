package controlador;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modelo.Entity_Eventos;
import modelo.Entity_VisitaImp;
import vista.Opciones;
import vista.Portero;

public class Porter extends Usuario{
	
    private String varSesion;
	
	public String getVarSesion() {
		return varSesion;
	}

	public void setVarSesion(String varSesion) {
		this.varSesion = varSesion;
	}
	

	public void Mode(){
		

    setP(new Portero());
    setEe(new Entity_Eventos());
    getP().setTitle("Bienvenidos portero "+getVarSesion());
    
    //Boton opciones
    
	getP().getOpt().addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			final Opciones op=new Opciones();
			
			op.getLblCerrarSesion().addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent arg0){
					
	            int confirmacion = JOptionPane.showConfirmDialog(null,
               "¿Esta seguro de que desea cerrar sesión?");
				if (confirmacion == 0) {
					getP().dispose();
					op.dispose();
					new Controles();
				
				}
			}});
			
			op.getBtnCancelar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					op.dispose();
					
				}
			});
			
			op.getLblInfo().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0){
					op.getLblNewLabel().setVisible(true);
					op.getTxtpnIndigoEventsEs().setVisible(true);
					op.getBtnVolverAtrs().setVisible(true);
					op.getLblInfo().setVisible(false);
					op.getLblNewLabel().setVisible(false);
					op.getBtnCancelar().setVisible(false);
					op.getLblCerrarSesion().setVisible(false);
					
					op.getBtnVolverAtrs().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							op.getLblNewLabel().setVisible(false);
							op.getTxtpnIndigoEventsEs().setVisible(false);
							op.getBtnVolverAtrs().setVisible(false);
							op.getLblCerrarSesion().setVisible(true);
							op.getLblInfo().setVisible(true);
							op.getLblNewLabel().setVisible(true);
							op.getBtnCancelar().setVisible(true);
						}
					});
					
					
					
				}
			
			});
		}

	});
 
    
    //Eventos del dia
	
    getP().getEventos_ddia().setForeground(Color.blue);
    getP().getEventos_pro().setForeground(Color.black);
    getP().getContenido_eventosDia().setVisible(true);
    getP().getContenido_eventosProx().setVisible(false);
    getP().getPanel_regvis().setVisible(false);
    getP().getList().setListData(getM().listaEventos());
    getP().getList_1().setListData(getM().listaEventosPro());
    
    getP().getList().addListSelectionListener(new ListSelectionListener() {
	
		public void valueChanged(ListSelectionEvent arg0) {
			getP().getElegir().setEnabled(true);
			String value=(String)getP().getList().getSelectedValue();
			String delim = "-";
		    setField1( value.split(delim));
		    try{
			setEe(getM().llenaCampos_de_listaEventos(Integer.parseInt(getField1()[0]), getField1()[1]));
			getP().getNombre().setText(getEe().getNombre());
			getP().getFecha().setText((String)getEe().getFecha().toString());
			getP().getUbicacion().setText(getEe().getUbicacion());
			}
		    catch(Exception e){
		    	
		    }
		}

		
	});
    
   
    getP().getEventos_ddia().addMouseListener(new MouseAdapter() {
    	
	 	public void mouseEntered(MouseEvent e) {
	 		getP().getEventos_ddia().setText(getP().getEscoge());
	 	}
	 	public void mouseClicked(MouseEvent arg0) {
	 		
	 		getP().getRegistra_visita().setForeground(Color.black);
	   		getP().getEventos_ddia().setForeground(Color.blue);
	   		getP().getEventos_pro().setForeground(Color.black);
	   		getP().getRegistra_visita_imprevista().setForeground(Color.black);
	 		getP().getContenido_eventosDia().setVisible(true);
	 		getP().getContenido_eventosProx().setVisible(false);
	 		getP().getPanel_regvis().setVisible(false);
	 		getP().getRegVisImp().setVisible(false);
	 										 	
	 	}
	 
	 	public void mouseExited(MouseEvent e) {
	 		getP().getEventos_ddia().setText("Eventos del dia");
	 	}
	 });
    
    //Eventos proximos
    
    getP().getEventos_pro().addMouseListener(new MouseAdapter() {
	   	@Override
	   	public void mouseClicked(MouseEvent arg0) {
	   		
	   		getP().getRegistra_visita().setForeground(Color.black);
	   		getP().getEventos_ddia().setForeground(Color.black);
	   		getP().getEventos_pro().setForeground(Color.blue);
	   		getP().getRegistra_visita_imprevista().setForeground(Color.black);
	   		getP().getContenido_eventosProx().setVisible(true);
	   		getP().getContenido_eventosDia().setVisible(false);
	   		getP().getPanel_regvis().setVisible(false);
	   		getP().getRegVisImp().setVisible(false);
	    	
		        getP().getList_1().addListSelectionListener(new ListSelectionListener() {
			
				public void valueChanged(ListSelectionEvent arg1) {
					setEe(new Entity_Eventos());
					String value1=(String)getP().getList_1().getSelectedValue();
					String delim1 = "-";
				    String[] field2 = value1.split(delim1);
				    try{
					setEe(getM().llenaCampos_de_listaEventosPro(Integer.parseInt(field2[0]), field2[1]));
					getP().getN().setText(getEe().getNombre());
					getP().getFe().setText((String)getEe().getFecha().toString());
					getP().getUb().setText(getEe().getUbicacion());
					}
				    catch(Exception e){
				    	
				    }
				}

				
			});                     
	   		
	   	}
	   	@Override
	   
	   	public void mouseEntered(MouseEvent e) {
	   		getP().getEventos_pro().setText(getP().getProx());
	   		
	   	}
	   	@Override
	   	public void mouseExited(MouseEvent e) {
	   		getP().getEventos_pro().setText("Eventos proximos");
	   	}
	   });
    
    //Registro de visitas
    
        getP().getRegistra_visita().addMouseListener(new MouseAdapter() {
	   	
	   	public void mouseClicked(MouseEvent arg0) {
	   		getP().getRegistra_visita().setForeground(Color.blue);
	   		getP().getEventos_ddia().setForeground(Color.black);
	   		getP().getEventos_pro().setForeground(Color.black);
	   		getP().getRegistra_visita_imprevista().setForeground(Color.black);
	   		getP().getContenido_eventosProx().setVisible(false);
	   		getP().getContenido_eventosDia().setVisible(false);
		        getP().getPanel_regvis().setVisible(true);
		       getP().getRegVisImp().setVisible(false);
	   		
	   	}
	   
	   	public void mouseEntered(MouseEvent e) {
	   		getP().getRegistra_visita().setText(getP().getRegi_vis());
	   	}
	   	@Override
	   	public void mouseExited(MouseEvent e) {
	   		getP().getRegistra_visita().setText("Registrar visitas");
	   	}
	   });
    
    
    
    getP().getElegir().addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent arg0) {
			
			getP().getCancelar().setEnabled(true);
			getP().getRegistra_visita().setForeground(Color.blue);
			getP().getEventos_ddia().setForeground(Color.black);
			getP().getTable().setModel(getM().llenaTabla_listaInvitados(getP().getDm(), Integer.parseInt(getField1()[0])));
			
			getP().getTableImp().setModel(getM().llenaTListaInvImp(getP().getDmi(), Integer.parseInt(getField1()[0])));
			SelectListener s =new SelectListener(getP().getTable());
			
            getP().getTable().addPropertyChangeListener(new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent arg0) {
				
						
				    int u=getP().getTable().getEditingRow();
					if (u!=-1){
						String k=getP().getComboBox().getSelectedItem().toString();
						
						String As = "";
						String Ac="";
					       
			            As=getP().getTable().getValueAt(u,1).toString();
			            Ac=getP().getTable().getValueAt(u,0).toString();
			            
			            setIdE(Integer.parseInt(As));
			          ;
			            int idI=Integer.parseInt(Ac);
			             getM().actualizaTEvento(idI,getIdE(), k);
			             getP().getFaltantes().setText(Integer.toString(getM().cuentaTEvento(getIdE())));
			       
					}
				}
				
			});
            
         
			 getP().getTextField_2().addKeyListener(new KeyAdapter() {
				  	@Override
				  	public void keyReleased(KeyEvent arg0) {
				  		//Filtro para el buscador
				  		getP().setModeloOrdenado(new TableRowSorter<TableModel>(getP().getDm()));
						getP().getTable().setRowSorter(getP().getModeloOrdenado());
						getP().getModeloOrdenado().setRowFilter(RowFilter.regexFilter(getP().getTextField_2().getText(), 2,3));				
				  	}
				  });
			 
	        setEi(new Entity_VisitaImp());
	        getEi().setId_Evento(getIdE());
			getP().getFaltantes().setText(Integer.toString(getM().cuentaTEvento(Integer.parseInt(getField1()[0]))));
			getP().getVisitantes().setVisible(true);	
			getP().getPanel_regvis().setVisible(true);
			getP().getContenido_eventosDia().setVisible(false);
			getP().getContenido_eventosProx().setVisible(false);
			getP().getList().setEnabled(false);
			getP().getElegir().setEnabled(false);
			
			
		}
	});
    
    //Visitas imprevistas
    
    getP().getRegistra_visita_imprevista().addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent arg0) {
    		getP().getRegistra_visita().setForeground(Color.black);
	   		getP().getEventos_ddia().setForeground(Color.black);
	   		getP().getEventos_pro().setForeground(Color.black);
	   		getP().getRegistra_visita_imprevista().setForeground(Color.blue);
	   		getP().getContenido_eventosProx().setVisible(false);
	   		getP().getContenido_eventosDia().setVisible(false);
		        getP().getPanel_regvis().setVisible(false);
		        getP().getRegVisImp().setVisible(true);
		        getP().getUsua().setText(getVarSesion());
		       
	   		
	   	}
	   
	   	public void mouseEntered(MouseEvent e) {
	   		getP().getRegistra_visita_imprevista().setText(getP().getRegi_vis_imp());
	   	}
	   	@Override
	   	public void mouseExited(MouseEvent e) {
	   		getP().getRegistra_visita_imprevista().setText("Registrar visitas imprevistas");
	   	}
	   });

    getP().getBtnRegistrar().addActionListener(new ActionListener() {
    	
	  	public void actionPerformed(ActionEvent e) {
	  	getEi().setNombre(getP().getNom().getText());
	  	getEi().setApellido(getP().getAp().getText());
	  	getEi().setSexo(getP().getSex().getSelectedItem().toString());
	  	getEi().setRazon(getP().getRaz().getText());
	  	getEi().setUsuario(getP().getUsua().getText());
	  	getEi().setId_Evento(Integer.parseInt( getField1()[0]));
	  	
	  	getM().regInvitadoImp(getEi());
	  	
	  	getP().LimpiarJTableVisitaImp();
	  	DefaultTableModel md=new DefaultTableModel();
	  	
	  	md=getM().llenaTListaInvImp(getP().getDmi(),Integer.parseInt( getField1()[0]));
	  	getP().getTableImp().setModel(md);
	  	getP().getRaz().setText("");
	  	getP().getSex().setSelectedIndex(0);
	  	getP().getAp().setText("");
	  	getP().getNom().setText("");
	  	
	   }
	  });
   
    
    getP().getCancelar().addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
	     getP().getVisitantes().setVisible(false);		
		 getP().LimpiarJTableVisita();
		 getP().LimpiarJTableVisitaImp();
		 getP().getCancelar().setEnabled(false);
		 getP().getList().setEnabled(true);
		 getP().getElegir().setEnabled(true);
			
		}
	});
    
    getP().getAyuda().addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent arg0){
    		
    			try{
    			File f = new File("ayuda (2).htm");
    			Desktop.getDesktop().open(f);
    			}
    			catch (Exception e){
    			e.printStackTrace();
    			}

    			}	
    	});
    
}





}


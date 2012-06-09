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
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modelo.Entity_Eventos;
import modelo.Entity_Invitaciones;
import modelo.Entity_Invitados;
import modelo.Entity_Usuarios;
import modelo.Entity_VisitaImp;
import modelo.Mantenimiento_Eventos;
import modelo.Mantenimiento_Invitados;
import modelo.Mantenimiento_Usuarios;
import modelo.Mantenimiento_invitaciones;
import modelo.Reportes;
import vista.Administrador;
import vista.Opciones;

public class Admin extends Usuario {

	private String varSesion;

	public String getVarSesion() {
		return varSesion;
	}

	public void setVarSesion(String varSesion) {
		this.varSesion = varSesion;
	}

	public void Mode() {

		setA(new Administrador());
		getA().setTitle("Bienvenidos administrador "+getVarSesion());
		// eventos de mantenimiento de user
		setMu(new Mantenimiento_Usuarios());
		getMu().listaUsuarios(getA().getModelo_usr()); // aqui se carga la lista
														// desde que corra la
														// aplicacion

		getA().getOpt().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				final Opciones op=new Opciones();
				
				op.getLblCerrarSesion().addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent arg0){
						
		            int confirmacion = JOptionPane.showConfirmDialog(null,
                   "¿Esta seguro de que desea cerrar sesión?");
					if (confirmacion == 0) {
						getA().dispose();
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

		getA().getMantenusr().addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				getA().getMantenusr().setText(getA().getMtusr());
			}

			public void mouseClicked(MouseEvent arg0) {
				// Colores labels
				getA().getRegistra_visita().setForeground(Color.black);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getEventos_pro().setForeground(Color.black);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.blue);
				getA().getMantenInv().setForeground(Color.black);
				getA().getMantenEv().setForeground(Color.black);
				getA().getMantenInvitaciones().setForeground(Color.black);

				// Visibilidad de los paneles
				getA().getGenerarReportes().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_Event().setVisible(false);
				getA().getMant_inv().setVisible(false);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_usr().setVisible(true);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);

				getMu().listaUsuarios(getA().getModelo_usr());// esta linea
																// actualiza la
																// tabla de
																// usuarios en
																// la interfaz
			}

			public void mouseExited(MouseEvent e) {
				getA().getMantenusr().setText("Mantenimiento de Usuarios");
			}
		});

		getA().getTabla_usr().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (getA().getTabla_usr().getSelectedRow() >= 0) {// si hay un
																	// usuario
																	// selecionado
																	// se
																	// habilitara
																	// el boton
																	// editar
					getA().getBtnEditar().setEnabled(true);
					getA().getBtnBorrar().setEnabled(true);
					getA().getBtnNuevo().setEnabled(false);
					getA().getBtnCancelar().setEnabled(true);
					getA().getBtnGrabar().setEnabled(false);
					getA().getNames().setEnabled(false);
					getA().getLast().setEnabled(false);
					getA().getUser().setEnabled(false);
					getA().getPass().setEnabled(false);
					getA().getPerfil().setEnabled(false);
					getA().getNames().setText("");
					getA().getLast().setText("");
					getA().getUser().setText("");
					getA().getPass().setText("");
					getA().getPerfil().setSelectedIndex(0);
				}

			}
		});

		getA().getBtnNuevo().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNames().setEnabled(true);
				getA().getLast().setEnabled(true);
				getA().getUser().setEnabled(true);
				getA().getPass().setEnabled(true);
				getA().getPerfil().setEnabled(true);
				getA().getBtnEditar().setEnabled(false);
				getA().getBtnBorrar().setEnabled(false);
				getA().getBtnNuevo().setEnabled(false);
				getA().getBtnCancelar().setEnabled(true);
				getA().getBtnGrabar().setEnabled(true);

			}
		});

		getA().getBtnGrabar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (getA().getID().getText().equals("0")) {// si es igual a 0
															// quiere decir que
															// es nuevo y que lo
															// va a guardar en
															// base de datos
					Entity_Usuarios usuario = new Entity_Usuarios();
					usuario.setNombre(getA().getNames().getText());// le va
																	// asettear
																	// el nombre
																	// escrito
																	// en el
																	// textfiel,
																	// igual
																	// pasa con
																	// los demas
					usuario.setApellido(getA().getLast().getText());
					usuario.setUsuario(getA().getUser().getText());
					usuario.setContraseña(getA().getPass().getText());
					usuario.setPerfil_usuario(getA().getPerfil()
							.getSelectedItem().toString());
					getMu().introData(usuario);
				} else {
					Entity_Usuarios usuario = new Entity_Usuarios();
					usuario.setID_Usuarios(Integer.parseInt(getA().getID()
							.getText()));// combierte a entero el Id que esta en
											// el text fiel y se lo pas al
											// usuario
					usuario.setNombre(getA().getNames().getText());// le va
																	// asettear
																	// el nombre
																	// escrito
																	// en el
																	// textfiel,
																	// igual
																	// pasa con
																	// los demas
					usuario.setApellido(getA().getLast().getText());
					usuario.setUsuario(getA().getUser().getText());
					usuario.setContraseña(getA().getPass().getText());
					usuario.setPerfil_usuario(getA().getPerfil()
							.getSelectedItem().toString());
					getMu().editaData(usuario);
				}
				getMu().listaUsuarios(getA().getModelo_usr());

				getA().getNames().setEnabled(false);
				getA().getLast().setEnabled(false);
				getA().getUser().setEnabled(false);
				getA().getPass().setEnabled(false);
				getA().getPerfil().setEnabled(false);
				getA().getNames().setText("");
				getA().getLast().setText("");
				getA().getUser().setText("");
				getA().getPass().setText("");
				getA().getPerfil().setSelectedIndex(0);
				getA().getBtnNuevo().setEnabled(true);
				getA().getBtnCancelar().setEnabled(false);
				getA().getBtnGrabar().setEnabled(false);
				getA().getBtnEditar().setEnabled(false);
				getA().getBtnBorrar().setEnabled(false);

			}
		});

		getA().getBtnEditar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNames().setEnabled(true);
				getA().getLast().setEnabled(true);
				getA().getUser().setEnabled(true);
				getA().getPass().setEnabled(true);
				getA().getPerfil().setEnabled(true);
				getA().getBtnEditar().setEnabled(false);
				getA().getBtnBorrar().setEnabled(false);
				getA().getBtnNuevo().setEnabled(false);
				getA().getBtnCancelar().setEnabled(true);
				getA().getBtnGrabar().setEnabled(true);
				Entity_Usuarios eu = new Entity_Usuarios();
				eu.setID_Usuarios(Integer.parseInt(getA().getModelo_usr()
						.getValueAt(getA().getTabla_usr().getSelectedRow(), 0)
						.toString()));// esto me devuelve el id del usuario
										// selccionado
				getMu().buscaData(eu);// eso me va a llenar todos los campos del
										// usuario
				getA().getID().setText(eu.getID_Usuarios() + "");// esto se usa
																	// para
																	// comvertir
																	// de entero
																	// a String
				getA().getNames().setText(eu.getNombre());
				getA().getLast().setText(eu.getApellido());
				getA().getUser().setText(eu.getUsuario());
				getA().getPass().setText(eu.getContraseña());
				getA().getPerfil().setSelectedItem(eu.getPerfil_usuario());// seleciona
																			// el
																			// elemento
																			// que
																			// tenga
																			// ese
																			// texto
			}
		});

		getA().getBtnCancelar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNames().setEnabled(false);
				getA().getLast().setEnabled(false);
				getA().getUser().setEnabled(false);
				getA().getPass().setEnabled(false);
				getA().getPerfil().setEnabled(false);
				getA().getNames().setText("");
				getA().getLast().setText("");
				getA().getUser().setText("");
				getA().getPass().setText("");
				getA().getPerfil().setSelectedIndex(0);
				getA().getBtnNuevo().setEnabled(true);
				getA().getBtnCancelar().setEnabled(false);
				getA().getBtnGrabar().setEnabled(false);
				getA().getBtnEditar().setEnabled(false);
				getA().getBtnBorrar().setEnabled(false);

			}
		});

		getA().getBtnBorrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro de que desea Eliminar este Usuario?");
				if (confirmacion == 0) {
					Entity_Usuarios eu = new Entity_Usuarios();
					eu.setID_Usuarios(Integer.parseInt(getA()
							.getModelo_usr()
							.getValueAt(getA().getTabla_usr().getSelectedRow(),
									0).toString()));// esto me devuelve el id
													// del usuario selccionado
					getMu().borraData(eu);
				}
				getA().getNames().setEnabled(false);
				getA().getLast().setEnabled(false);
				getA().getUser().setEnabled(false);
				getA().getPass().setEnabled(false);
				getA().getPerfil().setEnabled(false);
				getA().getNames().setText("");
				getA().getLast().setText("");
				getA().getUser().setText("");
				getA().getPass().setText("");
				getA().getPerfil().setSelectedIndex(0);
				getA().getBtnNuevo().setEnabled(true);
				getA().getBtnCancelar().setEnabled(false);
				getA().getBtnGrabar().setEnabled(false);
				getA().getBtnEditar().setEnabled(false);
				getA().getBtnBorrar().setEnabled(false);
				getMu().listaUsuarios(getA().getModelo_usr());
			}
		});

		// termina los eventos de user

		// eventos de mantenimiento de eventos

		final Mantenimiento_Eventos me = new Mantenimiento_Eventos();

		getA().getMantenEv().addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				getA().getMantenEv().setText(getA().getMtEv());
			}

			public void mouseClicked(MouseEvent arg0) {
				// Colores labels
				getA().getRegistra_visita().setForeground(Color.black);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getEventos_pro().setForeground(Color.black);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.black);
				getA().getMantenInv().setForeground(Color.black);
				getA().getMantenEv().setForeground(Color.blue);
				getA().getMantenInvitaciones().setForeground(Color.black);

				// Visibilidad de los paneles
				getA().getGenerarReportes().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_Event().setVisible(true);
				getA().getMant_inv().setVisible(false);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);

				me.listaData(getA().getModelo_ev());// para que se cargue cuando
													// le den clic a
													// mantenimiento de eventos
			}

			public void mouseExited(MouseEvent e) {
				getA().getMantenEv().setText("Mantenimiento de Eventos");
			}
		});

		getA().getTable_ev().addMouseListener(new MouseAdapter() { // este
																	// metodo se
																	// va a
																	// ejecutar
																	// cuando
																	// clicke a
																	// un
																	// elemento
																	// de la
																	// tabla
					public void mouseClicked(MouseEvent me) {
						if (getA().getTable_ev().getSelectedRow() >= 0) {// si
																			// hay
																			// un
																			// usuario
																			// selecionado
																			// se
																			// avilitara
																			// el
																			// boton
																			// editar
							getA().getEditar().setEnabled(true);
							getA().getBorrar().setEnabled(true);
							getA().getAgregar().setEnabled(false);
							getA().getCancelar().setEnabled(true);
							getA().getGrabar().setEnabled(false);
							getA().getNombre_ev().setEnabled(false);
							getA().getUbicacion_ev().setEnabled(false);
							getA().getFecha_ev().setEnabled(false);
							getA().getID_ev().setText("0");
							getA().getNombre_ev().setText("");
							getA().getUbicacion_ev().setText("");
							getA().getFecha_ev().setDate(new Date());

						}
					}
				});

		getA().getAgregar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNombre_ev().setEnabled(true);
				getA().getUbicacion_ev().setEnabled(true);
				getA().getFecha_ev().setEnabled(true);
				getA().getEditar().setEnabled(false);
				getA().getBorrar().setEnabled(false);
				getA().getAgregar().setEnabled(false);
				getA().getCancelar().setEnabled(true);
				getA().getGrabar().setEnabled(true);
			}
		});

		getA().getGrabar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (getA().getID_ev().getText().equals("0")) {// si es igual a 0
																// quiere decir
																// que es nuevo
																// y que lo va a
																// guardar en
																// base de datos
					Entity_Eventos evento = new Entity_Eventos();
					evento.setNombre(getA().getNombre_ev().getText());// le va
																		// asettear
																		// el
																		// nombre
																		// escrito
																		// en el
																		// textfiel,
																		// igual
																		// pasa
																		// con
																		// los
																		// demas
					evento.setUbicacion(getA().getUbicacion_ev().getText());
					evento.setFecha(getA().getFecha_ev().getDate());
					me.introData(evento);
				} else {
					Entity_Eventos evento = new Entity_Eventos();
					evento.setID_Eventos(Integer.parseInt(getA().getID_ev()
							.getText()));
					evento.setNombre(getA().getNombre_ev().getText());// le va
																		// asettear
																		// el
																		// nombre
																		// escrito
																		// en el
																		// textfiel,
																		// igual
																		// pasa
																		// con
																		// los
																		// demas
					evento.setUbicacion(getA().getUbicacion_ev().getText());
					evento.setFecha(getA().getFecha_ev().getDate());
					me.editaData(evento);
				}
				me.listaData(getA().getModelo_ev());

				getA().getNombre_ev().setEnabled(false);
				getA().getUbicacion_ev().setEnabled(false);
				getA().getFecha_ev().setEnabled(false);
				getA().getID_ev().setText("0");
				getA().getNombre_ev().setText("");
				getA().getUbicacion_ev().setText("");
				getA().getFecha_ev().setDate(new Date());
				getA().getAgregar().setEnabled(true);
				getA().getCancelar().setEnabled(false);
				getA().getGrabar().setEnabled(false);
				getA().getEditar().setEnabled(false);
				getA().getBorrar().setEnabled(false);

			}
		});

		getA().getEditar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNombre_ev().setEnabled(true);
				getA().getUbicacion_ev().setEnabled(true);
				getA().getFecha_ev().setEnabled(true);
				getA().getEditar().setEnabled(false);
				getA().getBorrar().setEnabled(false);
				getA().getAgregar().setEnabled(false);
				getA().getCancelar().setEnabled(true);
				getA().getGrabar().setEnabled(true);
				Entity_Eventos ee = new Entity_Eventos();
				ee.setID_Eventos(Integer.parseInt(getA().getModelo_ev()
						.getValueAt(getA().getTable_ev().getSelectedRow(), 0)
						.toString()));// esto me devuelve el id del usuario
										// selccionado
				me.buscaData(ee);// eso me va a llenar todos los campos del
									// usuario
				getA().getID_ev().setText(ee.getID_Eventos() + "");// esto se
																	// usa para
																	// comvertir
																	// de entero
																	// a String
				getA().getNombre_ev().setText(ee.getNombre());
				getA().getUbicacion_ev().setText(ee.getUbicacion());
				getA().getFecha_ev().setDate(ee.getFecha());

			}
		});

		getA().getCancelar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNombre_ev().setEnabled(false);
				getA().getUbicacion_ev().setEnabled(false);
				getA().getFecha_ev().setEnabled(false);
				getA().getID_ev().setText("0");
				getA().getNombre_ev().setText("");
				getA().getUbicacion_ev().setText("");
				getA().getFecha_ev().setDate(new Date());
				getA().getAgregar().setEnabled(true);
				getA().getCancelar().setEnabled(false);
				getA().getGrabar().setEnabled(false);
				getA().getEditar().setEnabled(false);
				getA().getBorrar().setEnabled(false);

			}
		});

		getA().getBorrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro de que desea Eliminar este Evento?");
				if (confirmacion == 0) {
					Entity_Eventos ee = new Entity_Eventos();
					ee.setID_Eventos(Integer.parseInt(getA()
							.getModelo_ev()
							.getValueAt(getA().getTable_ev().getSelectedRow(),
									0).toString()));// esto me devuelve el id
													// del usuario selccionado
					me.borraData(ee);
				}
				getA().getNombre_ev().setEnabled(false);
				getA().getUbicacion_ev().setEnabled(false);
				getA().getFecha_ev().setEnabled(false);
				getA().getID_ev().setText("0");
				getA().getNombre_ev().setText("");
				getA().getUbicacion_ev().setText("");
				getA().getFecha_ev().setDate(new Date());
				getA().getAgregar().setEnabled(true);
				getA().getCancelar().setEnabled(false);
				getA().getGrabar().setEnabled(false);
				getA().getEditar().setEnabled(false);
				getA().getBorrar().setEnabled(false);
				me.listaData(getA().getModelo_ev());
			}
		});

		// termina los eventos de eventos

		// eventos de mantenimiento de invitados

		final Mantenimiento_Invitados mi = new Mantenimiento_Invitados();

		getA().getMantenInv().addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				getA().getMantenInv().setText(getA().getMtInv());
			}

			public void mouseClicked(MouseEvent arg0) {
				// Colores labels
				getA().getRegistra_visita().setForeground(Color.black);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getEventos_pro().setForeground(Color.black);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.black);
				getA().getMantenInv().setForeground(Color.blue);
				getA().getMantenEv().setForeground(Color.black);
				getA().getMantenInvitaciones().setForeground(Color.black);

				// Visibilidad de los paneles

				getA().getGenerarReportes().setVisible(false);
				getA().getMant_Event().setVisible(false);
				getA().getMant_inv().setVisible(true);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);

				mi.listaData(getA().getModelo_inv());
			}

			public void mouseExited(MouseEvent e) {
				getA().getMantenInv().setText("Mantenimiento de Invitados");
			}
		});

		getA().getTable_inv().addMouseListener(new MouseAdapter() { // este
																	// metodo se
																	// va a
																	// ejecutar
																	// cuando
																	// clicke a
																	// un
																	// elemento
																	// de la
																	// tabla
					public void mouseClicked(MouseEvent mi) {
						if (getA().getTable_inv().getSelectedRow() >= 0) {// si
																			// hay
																			// un
																			// usuario
																			// selecionado
																			// se
																			// avilitara
																			// el
																			// boton
																			// editar
							getA().getBtnEditar_inv().setEnabled(true);
							getA().getBtnBorrar_inv().setEnabled(true);
							getA().getBtnAgregar_inv().setEnabled(false);
							getA().getBtnCancelar_inv().setEnabled(true);
							getA().getBtnGrabar_inv().setEnabled(false);
							getA().getNombre_inv().setEnabled(false);
							getA().getApellido_inv().setEnabled(false);
							getA().getSexo_inv().setEnabled(false);
							getA().getDireccion_inv().setEnabled(false);
							getA().getTelefono_inv().setEnabled(false);
							getA().getID_inv().setText("0");
							getA().getNombre_inv().setText("");
							getA().getApellido_inv().setText("");
							getA().getSexo_inv().setSelectedItem("");
							getA().getDireccion_inv().setText("");
							getA().getTelefono_inv().setText("");

						}
					}
				});

		getA().getBtnAgregar_inv().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNombre_inv().setEnabled(true);
				getA().getApellido_inv().setEnabled(true);
				getA().getSexo_inv().setEnabled(true);
				getA().getDireccion_inv().setEnabled(true);
				getA().getTelefono_inv().setEnabled(true);
				getA().getBtnEditar_inv().setEnabled(false);
				getA().getBtnBorrar_inv().setEnabled(false);
				getA().getBtnAgregar_inv().setEnabled(false);
				getA().getBtnCancelar_inv().setEnabled(true);
				getA().getBtnGrabar_inv().setEnabled(true);

			}
		});

		getA().getBtnGrabar_inv().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (getA().getID_inv().getText().equals("0")) {// si es igual a
																// 0 quiere
																// decir que es
																// nuevo y que
																// lo va a
																// guardar en
																// base de datos
					Entity_Invitados invitados = new Entity_Invitados();
					invitados.setNombre(getA().getNombre_inv().getText());// le
																			// va
																			// asettear
																			// el
																			// nombre
																			// escrito
																			// en
																			// el
																			// textfiel,
																			// igual
																			// pasa
																			// con
																			// los
																			// demas
					invitados.setApellido(getA().getApellido_inv().getText());
					invitados.setSexo(getA().getSexo_inv().getSelectedItem()
							.toString());
					invitados.setDireccion(getA().getDireccion_inv().getText());
					invitados.setTelefono(getA().getTelefono_inv().getText());
					mi.introData(invitados);
				} else {
					Entity_Invitados invitados = new Entity_Invitados();
					invitados.setID_invitado(Integer.parseInt(getA()
							.getID_inv().getText()));
					invitados.setNombre(getA().getNombre_inv().getText());// le
																			// va
																			// asettear
																			// el
																			// nombre
																			// escrito
																			// en
																			// el
																			// textfiel,
																			// igual
																			// pasa
																			// con
																			// los
																			// demas
					invitados.setApellido(getA().getApellido_inv().getText());
					invitados.setSexo(getA().getSexo_inv().getSelectedItem()
							.toString());
					invitados.setDireccion(getA().getDireccion_inv().getText());
					invitados.setTelefono(getA().getTelefono_inv().getText());
					mi.editaData(invitados);
				}
				mi.listaData(getA().getModelo_inv());

				getA().getNombre_inv().setEnabled(false);
				getA().getApellido_inv().setEnabled(false);
				getA().getSexo_inv().setEnabled(false);
				getA().getDireccion_inv().setEnabled(false);
				getA().getTelefono_inv().setEnabled(false);
				getA().getID_inv().setText("0");
				getA().getNombre_inv().setText("");
				getA().getApellido_inv().setText("");
				getA().getSexo_inv().setSelectedItem("");
				getA().getDireccion_inv().setText("");
				getA().getTelefono_inv().setText("");
				getA().getBtnAgregar_inv().setEnabled(true);
				getA().getBtnCancelar_inv().setEnabled(false);
				getA().getBtnGrabar_inv().setEnabled(false);
				getA().getBtnEditar_inv().setEnabled(false);
				getA().getBtnBorrar_inv().setEnabled(false);

			}
		});

		getA().getBtnEditar_inv().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNombre_inv().setEnabled(true);
				getA().getApellido_inv().setEnabled(true);
				getA().getSexo_inv().setEnabled(true);
				getA().getDireccion_inv().setEnabled(true);
				getA().getTelefono_inv().setEnabled(true);
				getA().getBtnEditar_inv().setEnabled(false);
				getA().getBtnBorrar_inv().setEnabled(false);
				getA().getBtnAgregar_inv().setEnabled(false);
				getA().getBtnCancelar_inv().setEnabled(true);
				getA().getBtnGrabar_inv().setEnabled(true);
				Entity_Invitados ei = new Entity_Invitados();
				ei.setID_invitado(Integer.parseInt(getA().getModelo_inv()
						.getValueAt(getA().getTable_inv().getSelectedRow(), 0)
						.toString()));// esto me devuelve el id del usuario
										// selccionado
				mi.buscaData(ei);// eso me va a llenar todos los campos del
									// usuario
				getA().getID_inv().setText(ei.getID_invitado() + "");// esto se
																		// usa
																		// para
																		// comvertir
																		// de
																		// entero
																		// a
																		// String
				getA().getNombre_inv().setText(ei.getNombre());
				getA().getApellido_inv().setText(ei.getApellido());
				getA().getSexo_inv().setSelectedItem(ei.getSexo());
				getA().getDireccion_inv().setText(ei.getDireccion());
				getA().getTelefono_inv().setText(ei.getTelefono());// seleciona
																	// el
																	// elemento
																	// que tenga
																	// ese texto
			}
		});

		getA().getBtnCancelar_inv().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				getA().getNombre_inv().setEnabled(false);
				getA().getApellido_inv().setEnabled(false);
				getA().getSexo_inv().setEnabled(false);
				getA().getDireccion_inv().setEnabled(false);
				getA().getTelefono_inv().setEnabled(false);
				getA().getNombre_inv().setText("");
				getA().getApellido_inv().setText("");
				getA().getSexo_inv().setSelectedItem("");
				getA().getDireccion_inv().setText("");
				getA().getTelefono_inv().setText("");
				getA().getBtnAgregar_inv().setEnabled(true);
				getA().getBtnCancelar_inv().setEnabled(false);
				getA().getBtnGrabar_inv().setEnabled(false);
				getA().getBtnEditar_inv().setEnabled(false);
				getA().getBtnBorrar_inv().setEnabled(false);

			}
		});

		getA().getBtnBorrar_inv().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro de que desea Eliminar este Invitado?");
				if (confirmacion == 0) {
					Entity_Invitados ein = new Entity_Invitados();
					ein.setID_invitado(Integer.parseInt(getA()
							.getModelo_inv()
							.getValueAt(getA().getTable_inv().getSelectedRow(),
									0).toString()));// esto me devuelve el id
													// del usuario selccionado
					mi.borraData(ein);
				}
				getA().getNombre_inv().setEnabled(false);
				getA().getApellido_inv().setEnabled(false);
				getA().getSexo_inv().setEnabled(false);
				getA().getDireccion_inv().setEnabled(false);
				getA().getTelefono_inv().setEnabled(false);
				getA().getNombre_inv().setText("");
				getA().getApellido_inv().setText("");
				getA().getSexo_inv().setSelectedItem("");
				getA().getDireccion_inv().setText("");
				getA().getBtnAgregar_inv().setEnabled(true);
				getA().getBtnCancelar_inv().setEnabled(false);
				getA().getBtnGrabar_inv().setEnabled(false);
				getA().getBtnEditar_inv().setEnabled(false);
				getA().getBtnBorrar_inv().setEnabled(false);
				mi.listaData(getA().getModelo_inv());
			}
		});

		// termina los eventos de invitados

		// Aqui empiesa el mantenimiento de invitaciones

		final Mantenimiento_invitaciones min = new Mantenimiento_invitaciones();

		getA().getMantenInvitaciones().addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				getA().getMantenInvitaciones().setText(
						getA().getMtInvitaciones());
			}

			public void mouseClicked(MouseEvent arg0) {
				// Colores labels
				getA().getRegistra_visita().setForeground(Color.black);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getEventos_pro().setForeground(Color.black);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.black);
				getA().getMantenInv().setForeground(Color.black);
				getA().getMantenEv().setForeground(Color.black);
				getA().getMantenInvitaciones().setForeground(Color.blue);

				// Visibilidad de los paneles
				getA().getGenerarReportes().setVisible(false);
				getA().getMant_invitaciones().setVisible(true);
				getA().getMant_Event().setVisible(false);
				getA().getMant_inv().setVisible(false);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);

				min.listaData(getA().getModelo_invitaciones());
				min.listaInvitados(getA().getInvitado_invitaciones());
				min.listaEventos(getA().getEvento_invitaciones());
			}

			public void mouseExited(MouseEvent e) {
				getA().getMantenInvitaciones().setText(
						"Mantenimiento de Invitaciones");
			}
		});

		getA().getTable_invitaciones().addMouseListener(new MouseAdapter() { // este
																				// metodo
																				// se
																				// va
																				// a
																				// ejecutar
																				// cuando
																				// clicke
																				// a
																				// un
																				// elemento
																				// de
																				// la
																				// tabla
					public void mouseClicked(MouseEvent mi) {
						if (getA().getTable_invitaciones().getSelectedRow() >= 0) {// si
																					// hay
																					// un
																					// usuario
																					// selecionado
																					// se
																					// avilitara
																					// el
																					// boton
																					// editar
							getA().getBtnEditar_invitaciones().setEnabled(true);
							getA().getBtnBorrar_invitaciones().setEnabled(true);
							getA().getBtnAgregar_invitaciones().setEnabled(
									false);
							getA().getBtnCancelar_invitaciones().setEnabled(
									true);
							getA().getBtnGrabar_invitaciones()
									.setEnabled(false);
							getA().getEvento_invitaciones().setEnabled(false);
							getA().getInvitado_invitaciones().setEnabled(false);
							getA().getAsistencia_invitaciones().setEnabled(
									false);
							getA().getEvento_invitaciones().setSelectedItem("");
							getA().getInvitado_invitaciones().setSelectedItem(
									"");
							getA().getAsistencia_invitaciones().setSelected(
									false);

						}
					}
				});

		getA().getBtnAgregar_invitaciones().addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						getA().getEvento_invitaciones().setEnabled(true);
						getA().getInvitado_invitaciones().setEnabled(true);
						getA().getAsistencia_invitaciones().setEnabled(false);
						getA().getBtnEditar_invitaciones().setEnabled(false);
						getA().getBtnBorrar_invitaciones().setEnabled(false);
						getA().getBtnAgregar_invitaciones().setEnabled(false);
						getA().getBtnCancelar_invitaciones().setEnabled(true);
						getA().getBtnGrabar_invitaciones().setEnabled(true);

					}
				});

		getA().getBtnGrabar_invitaciones().addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						if (!getA().getAsistencia_invitaciones().isEnabled()) {// si
																				// es
																				// igual
																				// a
																				// 0
																				// quiere
																				// decir
																				// que
																				// es
																				// nuevo
																				// y
																				// que
																				// lo
																				// va
																				// a
																				// guardar
																				// en
																				// base
																				// de
																				// datos
							Entity_Invitaciones invitaciones = new Entity_Invitaciones();
							invitaciones
									.setID_Invitado(((Entity_Invitados) getA()
											.getInvitado_invitaciones()
											.getSelectedItem())
											.getID_invitado());
							invitaciones.setID_Evento(((Entity_Eventos) getA()
									.getEvento_invitaciones().getSelectedItem())
									.getID_Eventos());
							String cambio = "No";
							if (getA().getAsistencia_invitaciones()
									.isSelected()) {
								cambio = "Si";
							}
							invitaciones.setAsistencia(cambio);
							min.introData(invitaciones);
						} else {
							Entity_Invitaciones invitaciones = new Entity_Invitaciones();
							invitaciones
									.setID_Invitado(((Entity_Invitados) getA()
											.getInvitado_invitaciones()
											.getSelectedItem())
											.getID_invitado());
							invitaciones.setID_Evento(((Entity_Eventos) getA()
									.getEvento_invitaciones().getSelectedItem())
									.getID_Eventos());
							String cambio = "No";
							if (getA().getAsistencia_invitaciones()
									.isSelected()) {
								cambio = "Si";
							}
							invitaciones.setAsistencia(cambio);
							min.editaData(invitaciones);
						}
						min.listaData(getA().getModelo_invitaciones());

						getA().getEvento_invitaciones().setEnabled(false);
						getA().getInvitado_invitaciones().setEnabled(false);
						getA().getAsistencia_invitaciones().setEnabled(false);
						getA().getEvento_invitaciones().setSelectedItem("");
						getA().getInvitado_invitaciones().setSelectedItem("");
						getA().getAsistencia_invitaciones().setSelected(false);
						getA().getBtnAgregar_invitaciones().setEnabled(true);
						getA().getBtnCancelar_invitaciones().setEnabled(false);
						getA().getBtnGrabar_invitaciones().setEnabled(false);
						getA().getBtnEditar_invitaciones().setEnabled(false);
						getA().getBtnBorrar_invitaciones().setEnabled(false);

					}
				});
		//

		getA().getBtnEditar_invitaciones().addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						getA().getEvento_invitaciones().setEnabled(true);
						getA().getInvitado_invitaciones().setEnabled(true);
						getA().getAsistencia_invitaciones().setEnabled(true);
						getA().getBtnEditar_invitaciones().setEnabled(false);
						getA().getBtnBorrar_invitaciones().setEnabled(false);
						getA().getBtnAgregar_invitaciones().setEnabled(false);
						getA().getBtnCancelar_invitaciones().setEnabled(true);
						getA().getBtnGrabar_invitaciones().setEnabled(true);
						Entity_Invitaciones ein = new Entity_Invitaciones();
						Entity_Invitados invitado = (Entity_Invitados) getA()
								.getModelo_invitaciones().getValueAt(
										getA().getTable_invitaciones()
												.getSelectedRow(), 1);
						ein.setID_Invitado((invitado).getID_invitado());
						Entity_Eventos evento = (Entity_Eventos) getA()
								.getModelo_invitaciones().getValueAt(
										getA().getTable_invitaciones()
												.getSelectedRow(), 0);
						ein.setID_Evento((evento).getID_Eventos());
						min.buscaData(ein);
						getA().getEvento_invitaciones().setSelectedItem(evento);
						getA().getInvitado_invitaciones().setSelectedItem(
								invitado);
						getA().getAsistencia_invitaciones().setSelected(
								ein.getAsistencia().equals("Si"));
					}
				});

		getA().getBtnCancelar_invitaciones().addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						getA().getEvento_invitaciones().setEnabled(false);
						getA().getInvitado_invitaciones().setEnabled(false);
						getA().getAsistencia_invitaciones().setEnabled(false);
						getA().getEvento_invitaciones().setSelectedItem("");
						getA().getInvitado_invitaciones().setSelectedItem("");
						getA().getAsistencia_invitaciones().setSelected(false);
						getA().getBtnAgregar_invitaciones().setEnabled(true);
						getA().getBtnCancelar_invitaciones().setEnabled(false);
						getA().getBtnGrabar_invitaciones().setEnabled(false);
						getA().getBtnEditar_invitaciones().setEnabled(false);
						getA().getBtnBorrar_invitaciones().setEnabled(false);

					}
				});

		getA().getBtnBorrar_invitaciones().addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						int confirmacion = JOptionPane
								.showConfirmDialog(null,
										"¿Esta seguro de que desea Eliminar esta Invitacion?");
						if (confirmacion == 0) {
							Entity_Invitaciones ein = new Entity_Invitaciones();
							Entity_Invitados invitado = (Entity_Invitados) getA()
									.getModelo_invitaciones().getValueAt(
											getA().getTable_invitaciones()
													.getSelectedRow(), 1);
							ein.setID_Invitado((invitado).getID_invitado());
							Entity_Eventos evento = (Entity_Eventos) getA()
									.getModelo_invitaciones().getValueAt(
											getA().getTable_invitaciones()
													.getSelectedRow(), 0);
							ein.setID_Evento((evento).getID_Eventos());
							min.borraData(ein);
						}
						min.listaData(getA().getModelo_invitaciones());
						getA().getEvento_invitaciones().setEnabled(false);
						getA().getInvitado_invitaciones().setEnabled(false);
						getA().getAsistencia_invitaciones().setEnabled(false);
						getA().getEvento_invitaciones().setSelectedItem("");
						getA().getInvitado_invitaciones().setSelectedItem("");
						getA().getAsistencia_invitaciones().setSelected(false);
						getA().getBtnAgregar_invitaciones().setEnabled(true);
						getA().getBtnCancelar_invitaciones().setEnabled(false);
						getA().getBtnGrabar_invitaciones().setEnabled(false);
						getA().getBtnEditar_invitaciones().setEnabled(false);
						getA().getBtnBorrar_invitaciones().setEnabled(false);
					}
				});

		// Comienzan los eventos de reportes

		getA().getLabelReportes().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				getA().getGenerarReportes().setVisible(true);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);
				getA().getMant_Event().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_inv().setVisible(false);
				Reportes.getCantidadEvento(getA().getModeloReporte1());
				Reportes.getPorcientoEvento(getA().getModeloReporte2());
				Reportes.getEventosMujeres(getA().getModeloReporte3());
				Reportes.getEventosHombres(getA().getModeloReporte4());
				Reportes.getMasVisitados(getA().getModeloReporte5());
				Reportes.getEventosDiarios(getA().getModeloReporte6());
			}
		});

		// terminan los eventos de reportes

		// Funciones del portero

		setEe(new Entity_Eventos());

		getA().getPanel_regvis().setVisible(false);
		/*
		 * getA().getList().setListData(getM().listaEventos());
		 * getA().getList_1().setListData(getM().listaEventosPro());
		 */

		//Aqui se carga la lista de eventos de hoy
		
		getA().getList().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {

				if ((String) getA().getList().getSelectedValue() != null) {
					getA().getElegir().setEnabled(true);
					String value = (String) getA().getList().getSelectedValue();
					String delimiter = "-";
					setField1(value.split(delimiter));
					try {
						setEe(getM().llenaCampos_de_listaEventos(
								Integer.parseInt(getField1()[0]),
								getField1()[1]));
						getA().getNombre().setText(getEe().getNombre());
						getA().getFecha().setText(
								(String) getEe().getFecha().toString());
						getA().getUbicacion().setText(getEe().getUbicacion());
					} catch (Exception e) {

					}
				}

				/**/
			}

		});

		getA().getEventos_ddia().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				getA().getEventos_ddia().setText(getA().getEscoge());
			}

			public void mouseClicked(MouseEvent arg0) {
				// Colores labels
				getA().getRegistra_visita().setForeground(Color.black);
				getA().getEventos_ddia().setForeground(Color.blue);
				getA().getEventos_pro().setForeground(Color.black);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.black);
				getA().getMantenInv().setForeground(Color.black);
				getA().getMantenEv().setForeground(Color.black);
				getA().getMantenInvitaciones().setForeground(Color.black);
				getA().getList().setListData(getM().listaEventos());
				// Visibilidad de los paneles
				getA().getGenerarReportes().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_Event().setVisible(false);
				getA().getMant_inv().setVisible(false);
				getA().getContenido_eventosDia().setVisible(true);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);

			}

			public void mouseExited(MouseEvent e) {
				getA().getEventos_ddia().setText("Eventos del dia");
			}

		});

		getA().getEventos_pro().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// Colores labels
				getA().getRegistra_visita().setForeground(Color.black);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getEventos_pro().setForeground(Color.blue);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.black);
				getA().getMantenInv().setForeground(Color.black);
				getA().getMantenEv().setForeground(Color.black);
				getA().getMantenInvitaciones().setForeground(Color.black);
				getA().getList_1().setListData(getM().listaEventosPro());

				// Visibilidad de los paneles

				getA().getGenerarReportes().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_Event().setVisible(false);
				getA().getMant_inv().setVisible(false);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(true);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(false);
				getA().getRegVisImp().setVisible(false);
				
				//Lista de eventos proximos

				getA().getList_1().addListSelectionListener(
						new ListSelectionListener() {

							public void valueChanged(ListSelectionEvent arg1) {
								if ((String) getA().getList_1()
										.getSelectedValue() != null) {
									setEe(new Entity_Eventos());
									String value1 = (String) getA().getList_1()
											.getSelectedValue();
									String delimit = "-";
									String[] field2 = value1.split(delimit);
									try {
										setEe(getM()
												.llenaCampos_de_listaEventosPro(
														Integer.parseInt(field2[0]),
														field2[1]));
										getA().getN().setText(
												getEe().getNombre());
										getA().getFe().setText(
												(String) getEe().getFecha()
														.toString());
										getA().getUb().setText(
												getEe().getUbicacion());
									} catch (Exception e) {

									}
								}
								/**/
							}

						});

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				getA().getEventos_pro().setText(getA().getProx());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				getA().getEventos_pro().setText("Eventos proximos");
			}
		});

		getA().getRegistra_visita().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				getA().getRegistra_visita().setForeground(Color.blue);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getEventos_pro().setForeground(Color.black);
				getA().getRegistra_visita_imprevista().setForeground(
						Color.black);
				getA().getMantenusr().setForeground(Color.black);
				getA().getMantenInv().setForeground(Color.black);
				getA().getMantenEv().setForeground(Color.black);
				getA().getMantenInvitaciones().setForeground(Color.black);

				// Visibilidad de los paneles

				getA().getGenerarReportes().setVisible(false);
				getA().getMant_invitaciones().setVisible(false);
				getA().getMant_Event().setVisible(false);
				getA().getMant_inv().setVisible(false);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getMant_usr().setVisible(false);
				getA().getPanel_regvis().setVisible(true);
				getA().getRegVisImp().setVisible(false);

			}

			public void mouseEntered(MouseEvent e) {
				getA().getRegistra_visita().setText(getA().getRegi_vis());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				getA().getRegistra_visita().setText("Registrar visitas");
			}
		});

		
		//Visitas imprevistas
		
		getA().getElegir().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				getA().getRegistra_visita().setForeground(Color.blue);
				getA().getEventos_ddia().setForeground(Color.black);
				getA().getTable().setModel(
						getM().llenaTabla_listaInvitados(getA().getDm(),
								Integer.parseInt(getField1()[0])));
				getA().getTableImp().setModel(
						getM().llenaTListaInvImp(getA().getDmi(),
								Integer.parseInt(getField1()[0])));
				SelectListener s = new SelectListener(getA().getTable());

				getA().getTable().addPropertyChangeListener(
						new PropertyChangeListener() {

							@Override
							public void propertyChange(PropertyChangeEvent evt) {

								int u = getA().getTable().getEditingRow();
								if (u != -1) {
									String k = getA().getComboBox()
											.getSelectedItem().toString();

									String As = "";
									String Ac = "";

									As = getA().getTable().getValueAt(u, 1)
											.toString();
									Ac = getA().getTable().getValueAt(u, 0)
											.toString();
									setIdE(Integer.parseInt(As));
									int idI = Integer.parseInt(Ac);
									System.out.println(k);
									getM().actualizaTEvento(idI, getIdE(), k);
									getA().getFaltantes().setText(
											Integer.toString(getM()
													.cuentaTEvento(getIdE())));

								}
							}
						});

				getA().getTextField_2().addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						//Filtro para el buscador
						getA().setModeloOrdenado(
								new TableRowSorter<TableModel>(getA().getDm()));
						getA().getTable().setRowSorter(
								getA().getModelSorter());
						getA().getModelSorter().setRowFilter(
								RowFilter.regexFilter(getA().getTextField_2()
										.getText(), 2, 3));
					}
				});

				setEi(new Entity_VisitaImp());
				getEi().setId_Evento(getIdE());
				getA().getFaltantes().setText(
						Integer.toString(getM().cuentaTEvento(
								Integer.parseInt(getField1()[0]))));
				getA().getVisitantes().setVisible(true);
				getA().getPanel_regvis().setVisible(true);
				getA().getContenido_eventosDia().setVisible(false);
				getA().getContenido_eventosProx().setVisible(false);
				getA().getList().setEnabled(false);
				getA().getElegir().setEnabled(false);
				getA().getCancelarr().setEnabled(true);

			}
		});

		getA().getRegistra_visita_imprevista().addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						getA().getRegistra_visita().setForeground(Color.black);
						getA().getEventos_ddia().setForeground(Color.black);
						getA().getEventos_pro().setForeground(Color.black);
						getA().getRegistra_visita_imprevista().setForeground(
								Color.blue);
						getA().getMantenusr().setForeground(Color.black);
						getA().getMantenInv().setForeground(Color.black);
						getA().getMantenEv().setForeground(Color.black);
						getA().getMantenInvitaciones().setForeground(
								Color.black);

						// Visibilidad de los paneles

						getA().getGenerarReportes().setVisible(false);
						getA().getMant_invitaciones().setVisible(false);
						getA().getMant_Event().setVisible(false);
						getA().getMant_inv().setVisible(false);
						getA().getContenido_eventosDia().setVisible(false);
						getA().getContenido_eventosProx().setVisible(false);
						getA().getMant_usr().setVisible(false);
						getA().getPanel_regvis().setVisible(false);
						getA().getRegVisImp().setVisible(true);
						getA().getUsua().setText(getVarSesion());

					}

					public void mouseEntered(MouseEvent e) {
						getA().getRegistra_visita_imprevista().setText(
								getA().getRegi_vis_imp());
					}

					@Override
					public void mouseExited(MouseEvent e) {
						getA().getRegistra_visita_imprevista().setText(
								"Registrar visitas imprevistas");
					}
				});

		getA().getBtnRegistrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getEi().setNombre(getA().getNom().getText());
				getEi().setApellido(getA().getAp().getText());
				getEi().setSexo(getA().getSex().getSelectedItem().toString());
				getEi().setRazon(getA().getRaz().getText());
				getEi().setUsuario(getVarSesion());
				getEi().setId_Evento(Integer.parseInt(getField1()[0]));
				getM().regInvitadoImp(getEi());
				getA().LimpiarJTableVisitaImp();
				getA().getDm().setRowCount(0);
				DefaultTableModel md = new DefaultTableModel();
				md = getM().llenaTListaInvImp(getA().getDmi(),
						Integer.parseInt(getField1()[0]));
				getA().getTableImp().setModel(md);
				getA().getRaz().setText("");
				getA().getSex().setSelectedIndex(0);
				getA().getAp().setText("");
				getA().getNom().setText("");

			}
		});
		
		//Ayuda y cancelar

		getA().getCancelarr().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getA().getVisitantes().setVisible(false);
				getA().LimpiarJTableVisita();
				getA().LimpiarJTableVisitaImp();
				getA().getCancelarr().setEnabled(false);
				getA().getList().setEnabled(true);
				getA().getElegir().setEnabled(false);

			}
		});
		
		 getA().getAyuda().addMouseListener(new MouseAdapter() {
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

};

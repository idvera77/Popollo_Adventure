package popollo_adventures;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import clases.Heroe;
import componentes.Botones;
import componentes.PanelTexto;
import componentes.Paneles;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class Tienda extends Paneles{
	public Tienda(JFrame ventana, Heroe heroe, Connection connect) {
		Paneles panelTienda=this;
		
		PanelTexto mostrarDinero = new PanelTexto();
		mostrarDinero.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		mostrarDinero.setBounds(10, 40, 109, 25);
		mostrarDinero.setText(" Oro: "+Integer.toString(heroe.getDinero()));
		add(mostrarDinero);
		
		PanelTexto panelPrecioObjeto = new PanelTexto();
		panelPrecioObjeto.setText("Precio");
		panelPrecioObjeto.setBounds(302, 96, 54, 23);
		add(panelPrecioObjeto);
		
		PanelTexto panelComprar = new PanelTexto();
		panelComprar.setText("Comprar");
		panelComprar.setBounds(186, 96, 76, 23);
		add(panelComprar);
		
		PanelTexto panelCantidad = new PanelTexto();
		panelCantidad.setText("Cantidad");
		panelCantidad.setBounds(60, 96, 72, 23);
		add(panelCantidad);
		
		PanelTexto cantidadBombaP = new PanelTexto();
		cantidadBombaP.setText(Integer.toString(heroe.getObjetosArray().get(0).getCantidad()));
		cantidadBombaP.setBounds(91, 160, 54, 25);
		add(cantidadBombaP);
		
		PanelTexto cantidadBombaG = new PanelTexto();
		cantidadBombaG.setText(Integer.toString(heroe.getObjetosArray().get(1).getCantidad()));
		cantidadBombaG.setBounds(91, 192, 41, 23);
		add(cantidadBombaG);
		
		PanelTexto cantidadPocion = new PanelTexto();
		cantidadPocion.setText(Integer.toString(heroe.getObjetosArray().get(2).getCantidad()));
		cantidadPocion.setBounds(91, 128, 41, 23);
		add(cantidadPocion);
		
		PanelTexto precioBombaP = new PanelTexto();
		precioBombaP.setText(Integer.toString(heroe.getObjetosArray().get(0).getPrecio()));
		precioBombaP.setBounds(319, 160, 41, 23);
		add(precioBombaP);
		
		PanelTexto precioBombaG = new PanelTexto();
		precioBombaG.setText(Integer.toString(heroe.getObjetosArray().get(1).getPrecio()));
		precioBombaG.setBounds(319, 192, 41, 23);
		add(precioBombaG);
		
		PanelTexto precioPocion = new PanelTexto();
		precioPocion.setText(Integer.toString(heroe.getObjetosArray().get(2).getPrecio()));
		precioPocion.setBounds(319, 128, 41, 23);
		add(precioPocion);
		
		PanelTexto panelAtributosActual = new PanelTexto();
		panelAtributosActual.setText("Actual");
		panelAtributosActual.setBounds(73, 260, 59, 23);
		add(panelAtributosActual);
		
		PanelTexto panelMejorar = new PanelTexto();
		panelMejorar.setText("Mejorar");
		panelMejorar.setBounds(191, 260, 109, 23);
		add(panelMejorar);
		
		PanelTexto panelPrecioAtributo = new PanelTexto();
		panelPrecioAtributo.setText("Precio");
		panelPrecioAtributo.setBounds(310, 260, 54, 23);
		add(panelPrecioAtributo);
		
		PanelTexto precioSalud = new PanelTexto();
		precioSalud.setText("750");
		precioSalud.setBounds(322, 290, 33, 23);
		add(precioSalud);
		
		PanelTexto precioFuerza = new PanelTexto();
		precioFuerza.setText("1000");
		precioFuerza.setBounds(319, 322, 41, 23);
		add(precioFuerza);
		
		PanelTexto precioMagia = new PanelTexto();
		precioMagia.setText("1500");
		precioMagia.setBounds(319, 354, 41, 23);
		add(precioMagia);
		
		PanelTexto precioDefensa = new PanelTexto();
		precioDefensa.setText("1000");
		precioDefensa.setBounds(319, 386, 41, 23);
		add(precioDefensa);
		
		PanelTexto precioAgilidad = new PanelTexto();
		precioAgilidad.setText("1000");
		precioAgilidad.setBounds(319, 417, 41, 23);
		add(precioAgilidad);
		
		PanelTexto saludActual = new PanelTexto();
		saludActual.setText(Integer.toString(heroe.getSaludMaxima()));
		saludActual.setBounds(91, 290, 41, 23);
		add(saludActual);
		
		PanelTexto fuerzaActual = new PanelTexto();
		fuerzaActual.setText(Integer.toString(heroe.getFuerza()));
		fuerzaActual.setBounds(91, 322, 41, 23);
		add(fuerzaActual);
		
		PanelTexto magiaActual = new PanelTexto();
		magiaActual.setText(Integer.toString(heroe.getMagia()));
		magiaActual.setBounds(91, 354, 41, 23);
		add(magiaActual);
		
		PanelTexto defensaActual = new PanelTexto();
		defensaActual.setText(Integer.toString(heroe.getDefensa()));
		defensaActual.setBounds(91, 386, 41, 23);
		add(defensaActual);
		
		PanelTexto agilidadActual = new PanelTexto();
		agilidadActual.setText(Integer.toString(heroe.getAgilidad()));
		agilidadActual.setBounds(91, 417, 41, 23);
		add(agilidadActual);
		
		//Añadiendo botones
		//Eventos de botones
		Botones comprarBombaP = new Botones("Bomba Pequeña");
		comprarBombaP.setBounds(147, 160, 149, 25);
		add(comprarBombaP);
		
		Botones comprarBombaG = new Botones("Bomba Grande");
		comprarBombaG.setBounds(147, 192, 149, 25);
		add(comprarBombaG);
		
		Botones comprarPocion = new Botones("Pocion");
		comprarPocion.setBounds(147, 128, 149, 25);
		add(comprarPocion);
		
		Botones mejorarSalud = new Botones("Pocion");
		mejorarSalud.setText("Salud Maxima +20");
		mejorarSalud.setBounds(141, 290, 159, 25);
		add(mejorarSalud);
		
		Botones mejorarFuerza = new Botones("Fuerza +5");
		mejorarFuerza.setBounds(141, 322, 159, 25);
		add(mejorarFuerza);
		
		Botones mejorarMagia = new Botones("Magia +1");
		mejorarMagia.setBounds(141, 354, 159, 25);
		add(mejorarMagia);
		
		Botones mejorarAgilidad = new Botones("Agilidad +2");
		mejorarAgilidad.setBounds(141, 417, 159, 25);
		add(mejorarAgilidad);
		
		Botones mejorarDefensa = new Botones("Defensa +2");
		mejorarDefensa.setBounds(141, 386, 159, 25);
		add(mejorarDefensa);
		
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
			
		//Eventos de botones
		comprarBombaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		comprarBombaG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
			}
		});
		
		comprarPocion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heroe.setDinero(200);
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mapa panelMapa =new Mapa(ventana, connect);
				ventana.setContentPane(panelMapa);
				panelTienda.setVisible(false);
			}
		});
		
		JLabel cuadro1 = new JLabel("");
		cuadro1.setBackground(new Color(204, 204, 204));
		cuadro1.setOpaque(true);
		cuadro1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cuadro1.setBounds(51, 86, 327, 145);
		add(cuadro1);
	
		JLabel cuadro2 = new JLabel("");
		cuadro2.setBackground(new Color(204, 204, 204));
		cuadro2.setOpaque(true);
		cuadro2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cuadro2.setBounds(51, 242, 327, 221);
		add(cuadro2);		
		
		//Imagen de fondo
		JLabel imagenTienda = new JLabel("");
		imagenTienda.setBounds(0, 0, 1008, 536);
		imagenTienda.setIcon(new ImageIcon("./imagenes/tienda.jpg"));
		add(imagenTienda);
	}
}	

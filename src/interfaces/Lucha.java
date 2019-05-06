package interfaces;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


import componentes.Botones;
import componentes.BotonesCombate;
import componentes.LabelTexto;
import componentes.Paneles;
import general.Combate;
import general.Musica;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Font;


public class Lucha extends Paneles{
	private Ventana ventana;
	private JTextField textField;
	public Lucha lucha;
	public JProgressBar vidaHeroe;
	public JProgressBar vidaEnemigo;
	public LabelTexto registroBatallaHeroe;
	public LabelTexto registroBatallaEnemigo;
	
	public Lucha(Ventana v) {
		super();
		this.ventana=v;
		

		
		//Imagenes
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(".\\imagenes\\luchaPopollo.png");
		imagenes[1] = new ImageIcon(".\\imagenes\\Morrigan.png");
		imagenes[2] = new ImageIcon(".\\imagenes\\dancer low.png");	
		imagenes[3] = new ImageIcon(".\\imagenes\\luchaPoring.png");
		
		//sonidos
		String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String ataqueHeroeSonido = "./sonidos/Atacar.wav";
        String rutaSonidoFisicoEnemigo = "./sonidos/FisicoEnemigo.wav";
        String rutaSonidoHabilidadesObjetos = "./sonidos/HabilidadesObjetos.wav";
        String rutaSonidoDefensa = "./sonidos/Defensa.wav";
        String rutaSonidoCuraciones = "./sonidos/Curaciones.wav";
        
        //Barras de salud
		this.vidaHeroe = new JProgressBar(0, ventana.heroe.getSaludMaxima());
		vidaHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaHeroe.setStringPainted(true);
		vidaHeroe.setString(Integer.toString(ventana.heroe.getSalud()));
		vidaHeroe.setForeground(Color.RED);
		vidaHeroe.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaHeroe.setBounds(20, 290, 241, 34);
		vidaHeroe.setValue(ventana.heroe.getSalud());
		add(vidaHeroe);
		
		this.vidaEnemigo = new JProgressBar(0, ventana.enemigosArray.get(0).getSaludMaxima());
		vidaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaEnemigo.setStringPainted(true);
		vidaEnemigo.setString(Integer.toString(ventana.enemigosArray.get(0).getSalud()));
		vidaEnemigo.setForeground(Color.RED);
		vidaEnemigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaEnemigo.setBounds(747, 290, 241, 34);
		vidaEnemigo.setValue(ventana.enemigosArray.get(0).getSalud());
		add(vidaEnemigo);
		
		//Paneles Texto
		LabelTexto registroBatallaHeroe = new LabelTexto();
		registroBatallaHeroe.setBounds(281, 120, 446, 103);
		add(registroBatallaHeroe);
		
		LabelTexto registroBatallaEnemigo = new LabelTexto();
		registroBatallaEnemigo.setBounds(281, 221, 446, 103);
		add(registroBatallaEnemigo);
		
		LabelTexto Versus = new LabelTexto();
		Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		Versus.setText("<html><center>"+ventana.heroe.getNombre()+"&ensp;Versus&ensp;"+ventana.enemigosArray.get(0).getNombre()+"</b></center></html>");
		Versus.setBounds(281, 49, 446, 58);
		add(Versus);
		
		//Botones
		BotonesCombate botonAtacar = new BotonesCombate("");
		botonAtacar.setIcon(new ImageIcon("./imagenes/botonEspada.png"));
		botonAtacar.setBounds(252, 347, 115, 115);
		add(botonAtacar);
		
		BotonesCombate botonDefender = new BotonesCombate("");
		botonDefender.setIcon(new ImageIcon("./imagenes/botonEscudo.png"));
		botonDefender.setBounds(381, 347, 115, 115);
		add(botonDefender);
		
		
		BotonesCombate botonHabilidades = new BotonesCombate("");
		botonHabilidades.setIcon(new ImageIcon("./imagenes/botonMagia.png"));
		botonHabilidades.setBounds(511, 347, 115, 115);
		add(botonHabilidades);
		
		BotonesCombate botonObjetos = new BotonesCombate("");
		botonObjetos.setIcon(new ImageIcon("./imagenes/botonObjeto.png"));
		botonObjetos.setBounds(642, 347, 115, 115);
		add(botonObjetos);
		
		Botones boton1Habilidad = new Botones("1");
		boton1Habilidad.setVisible(false);
		boton1Habilidad.setBounds(317, 347, 115, 115);
		add(boton1Habilidad);
		
		Botones boton2Habilidad = new Botones("2");
		boton2Habilidad.setVisible(false);
		boton2Habilidad.setBounds(446, 347, 115, 115);
		add(boton2Habilidad);
		
		Botones boton3Habilidad = new Botones("3");
		boton3Habilidad.setVisible(false);
		boton3Habilidad.setBounds(577, 347, 115, 115);
		add(boton3Habilidad);
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(20, 482, 215, 23);
		add(botonAtras);
		
		
		//Imagenes
		JLabel iconoDefensaHeroe = new JLabel("");
		iconoDefensaHeroe.setBounds(152, 166, 158, 170);
		iconoDefensaHeroe.setIcon(new ImageIcon("./imagenes/miniEscudo.png"));
		iconoDefensaHeroe.setVisible(false);
		add(iconoDefensaHeroe);
		
		JLabel iconoDefensaEnemigo = new JLabel("");
		iconoDefensaEnemigo.setBounds(688, 166, 158, 170);
		iconoDefensaEnemigo.setIcon(new ImageIcon("./imagenes/miniEscudo.png"));
		iconoDefensaEnemigo.setVisible(false);
		add(iconoDefensaEnemigo);
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenHeroe = new JLabel("");
		imagenHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenHeroe.setBounds(10, 36, 261, 300);
		imagenHeroe.setIcon(imagenes[0]);
		add(imagenHeroe);
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenEnemigo = new JLabel("");
		imagenEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenEnemigo.setBounds(737, 36, 261, 300);
		imagenEnemigo.setIcon(imagenes[3]);
		add(imagenEnemigo);
		
		//Imagen de fondo
		JLabel imagenBatalla = new JLabel("");
		imagenBatalla.setBounds(0, 0, 1008, 536);
		imagenBatalla.setIcon(new ImageIcon("./imagenes/batalla.jpg"));
		add(imagenBatalla);	

		
		//Eventos de botones
		botonAtacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atacarHeroe(ataqueHeroeSonido, registroBatallaHeroe, registroBatallaEnemigo);
				
			}
		});
		
		botonDefender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconoDefensaHeroe.setVisible(true);
			}
		});
		
		botonHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonAtacar.setVisible(false);
				botonDefender.setVisible(false);
				botonHabilidades.setVisible(false);
				botonObjetos.setVisible(false);
				boton1Habilidad.setVisible(true);
				boton2Habilidad.setVisible(true);
				boton3Habilidad.setVisible(true);
			}
		});
		
		botonObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonAtacar.setVisible(false);
				botonDefender.setVisible(false);
				botonHabilidades.setVisible(false);
				botonObjetos.setVisible(false);
				boton1Habilidad.setVisible(true);
				boton2Habilidad.setVisible(true);
				boton3Habilidad.setVisible(true);
			}
		});
		
		boton1Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boton1Habilidad.setVisible(false);
				boton2Habilidad.setVisible(false);
				boton3Habilidad.setVisible(false);
				botonAtacar.setVisible(true);
				botonDefender.setVisible(true);
				botonHabilidades.setVisible(true);
				botonObjetos.setVisible(true);
			}
		});
		
		boton2Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boton1Habilidad.setVisible(false);
				boton2Habilidad.setVisible(false);
				boton3Habilidad.setVisible(false);
				botonAtacar.setVisible(true);
				botonDefender.setVisible(true);
				botonHabilidades.setVisible(true);
				botonObjetos.setVisible(true);
			}
		});
	
		boton3Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boton1Habilidad.setVisible(false);
				boton2Habilidad.setVisible(false);
				boton3Habilidad.setVisible(false);
				botonAtacar.setVisible(true);
				botonDefender.setVisible(true);
				botonHabilidades.setVisible(true);
				botonObjetos.setVisible(true);
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Batalla");
			}
		});
					
		}	
		
		public void vidaHeroe() {
			vidaHeroe.setValue(ventana.heroe.getSalud());
			vidaHeroe.setString(Integer.toString(ventana.heroe.getSalud()));
		}
		
		public void vidaEnemigo() {
			vidaEnemigo.setValue(ventana.enemigosArray.get(0).getSalud());
			vidaEnemigo.setString(Integer.toString(ventana.enemigosArray.get(0).getSalud()));
		}
		
		public void atacarHeroe(String ataqueHeroeSonido, LabelTexto registroBatallaHeroe, LabelTexto registroBatallaEnemigo) {
			ventana.heroe.atacar(ventana.heroe, ventana.enemigosArray.get(0));
			registroBatallaHeroe.setText("<html><center><b>"+ventana.heroe.getNombre()
					+" inflige "+ventana.heroe.getFuerza()+" puntos de daño.<br>"
					+ventana.enemigosArray.get(0).getNombre()+"&ensp;bloquea&ensp;"+ventana.enemigosArray.get(0).getDefensa()+"&ensp;puntos de daño."
					+"</center></b></html>");
			vidaEnemigo();
			general.Musica.sonidosBoton(ataqueHeroeSonido);
			ataqueEnemigo(registroBatallaEnemigo);
			vidaHeroe();
		}
		
		public void ataqueEnemigo(LabelTexto registroBatallaEnemigo) {
	        String rutaCancionVictoria = "./sonidos/Victoria.wav";


        int aleatorio;
        boolean Victoria=false;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;
        
		if(ventana.enemigosArray.get(0).getSalud()>0){
            //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
            if(defensaEnemigo==true){
                    ventana.enemigosArray.get(0).BloqueoOff(ventana.enemigosArray.get(0));
                    defensaEnemigo=false;
                }
            
                aleatorio = NumeroAleatorio(0, 6);
                if(aleatorio<=3){
                    ventana.enemigosArray.get(0).atacar(ventana.enemigosArray.get(0), ventana.heroe);
                    registroBatallaEnemigo.setText("<html><center><b>"+ventana.enemigosArray.get(0).getNombre()
	    				+" inflige "+ventana.enemigosArray.get(0).getFuerza()+"&ensp;puntos de daño.<br>"
	    				+ventana.heroe.getNombre()+"&ensp;bloquea&ensp;"+ventana.heroe.getDefensa()+"&ensp;puntos de daño."
	    				+"</center></b></html>");
                    vidaHeroe();
                }else if(aleatorio==4){
                    System.out.println("\tDecide usar bloqueo!\n");
                    System.out.println("- Su defensa natural se multiplica por 2 durante un turno.");
                    ventana.enemigosArray.get(0).Bloqueo(ventana.enemigosArray.get(0));
                    defensaEnemigo=true;
                    vidaHeroe();
                }else{
                    System.out.println("\tDecide usar una habilidad!\n");
                    ventana.enemigosArray.get(0).usarHabilidadesEnemigos(ventana.heroe);
                    vidaHeroe();
                }
            }else{
                Victoria=true;
                System.out.println("\n\t!!!"+ventana.enemigosArray.get(0).getNombre()+" Derrotado!!!"
                        +" Recibes "+ventana.enemigosArray.get(0).getDinero()+" Monedas de oro y "
                        + ventana.enemigosArray.get(0).getExperiencia()+" puntos de experiencia.");
                ventana.heroe.subirNivel(ventana.enemigosArray.get(0).getExperiencia());
                ventana.heroe.setDinero(ventana.heroe.getDinero()+ventana.enemigosArray.get(0).getDinero());
                if(defensaEnemigo==true){
                	ventana.enemigosArray.get(0).BloqueoOff(ventana.enemigosArray.get(0));
                    defensaEnemigo=false;
                }
                Musica.iniciarMusica(rutaCancionVictoria);
            }
	}
	
    public static int NumeroAleatorio(int minimo,int maximo){
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
     }
}









/*
 * public static void batalla(Heroe heroe, Enemigo enemigo, JLabel iconoDefensaHeroe, JLabel IconoDefensaEnemigo, J){

        //Sonidos Combate
        String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String rutaSonidoFisicoAliado = "./sonidos/Atacar.wav";
        String rutaSonidoFisicoEnemigo = "./sonidos/FisicoEnemigo.wav";
        String rutaSonidoHabilidadesObjetos = "./sonidos/HabilidadesObjetos.wav";
        String rutaSonidoDefensa = "./sonidos/Defensa.wav";
        String rutaSonidoCuraciones = "./sonidos/Curaciones.wav";

        Scanner sc=new Scanner(System.in);

        int aleatorio;
        boolean Victoria=false;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;


        do{
            //TURNO ALIADO
            //Comprobacion de que el heroe tiene mas de 0 puntos de salud.
            if(heroe.getSalud()>0){
            	if(defensaHeroe==true){
                    heroe.BloqueoOff(heroe);
                    iconoDefensaHeroe.setVisible(false);
                    
                    defensaHeroe=false;
                }
                try {
                    int opcion=Integer.parseInt(sc.nextLine());

                    switch(opcion){
                        case 1:
                            heroe.atacar(heroe, enemigo);
                            Musica.iniciarSonidos(rutaSonidoFisicoAliado);
                            Thread.sleep(350);
                            break;
                        case 2:
                            System.out.println("- La defensa natural se multiplica por 2 durante un turno.\n");
                            heroe.Bloqueo(heroe);
                            defensaHeroe=true;
                            Musica.iniciarSonidos(rutaSonidoDefensa);
                            Thread.sleep(350);
                            break;
                        case 3:
                            heroe.mostrarHabilidades();
                            heroe.usarHabilidades(enemigo);
                            Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                            Thread.sleep(350);
                            break;
                        case 4:
                            heroe.mostrarObjetos();
                            heroe.usarObjetos(enemigo);
                            Musica.iniciarSonidos(rutaSonidoCuraciones);
                            Thread.sleep(350);
                            break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("\n\tDERROTA - Juega mejor la proxima vez ^_^\n");
                System.exit(0);
            }
            //TURNO ENEMIGO
            //Comprobacion de que el heroe tiene mas de 0 puntos de salud.
            if(enemigo.getSalud()>0){
                //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
                if(defensaEnemigo==true){
                        enemigo.BloqueoOff(enemigo);
                        IconoDefensaEnemigo.setVisible(false);
                        defensaEnemigo=false;
                    }
                try {
                    aleatorio = NumeroAleatorio(0, 6);
                    if(aleatorio<=3){
                        System.out.println("\tDecide atacar!\n");
                        enemigo.atacar(enemigo, heroe);
                        Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                        Thread.sleep(150);
                    }else if(aleatorio==4){
                        System.out.println("\tDecide usar bloqueo!\n");
                        System.out.println("- Su defensa natural se multiplica por 2 durante un turno.");
                        enemigo.Bloqueo(enemigo);
                        defensaEnemigo=true;
                        Musica.iniciarSonidos(rutaSonidoDefensa);
                        Thread.sleep(150);
                    }else{
                        System.out.println("\tDecide usar una habilidad!\n");
                        enemigo.usarHabilidadesEnemigos(heroe);
                        Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                        Thread.sleep(150);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    Victoria=true;
                    System.out.println("\n\t!!!"+enemigo.getNombre()+" Derrotado!!!"
                            +" Recibes "+enemigo.getDinero()+" Monedas de oro y "
                            + enemigo.getExperiencia()+" puntos de experiencia.");
                    heroe.subirNivel(enemigo.getExperiencia());
                    heroe.setDinero(heroe.getDinero()+enemigo.getDinero());
                    if(defensaEnemigo==true){
                        enemigo.BloqueoOff(enemigo);
                        defensaEnemigo=false;
                    }
                    Musica.iniciarMusica(rutaCancionVictoria);
                }
        }while(!Victoria);
        enemigo.restablecerEnemigo();
    }

    public static int NumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
    }
 */

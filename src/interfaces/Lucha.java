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
	public LabelTexto registroBatalla;
	
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
		
		LabelTexto registroBatalla = new LabelTexto();
		registroBatalla.setBounds(281, 118, 446, 206);
		add(registroBatalla);
		
		LabelTexto Versus = new LabelTexto();
		Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		Versus.setText("<html><center>"+ventana.heroe.getNombre()+"&ensp;Versus&ensp;"+ventana.enemigosArray.get(0).getNombre()+"</b></center></html>");
		Versus.setBounds(281, 49, 446, 58);
		add(Versus);
		Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		
		Botones botonAtacar = new Botones("");
		botonAtacar.setBounds(145, 367, 165, 23);
		add(botonAtacar);
		
		JButton botonDefender = new JButton("");
		botonDefender.setBackground(new Color(240,240,240));
		botonDefender.setBorderPainted(false);
		botonDefender.setIcon(new ImageIcon("./imagenes/botonEscudo.png"));
		botonDefender.setBounds(336, 335, 115, 115);
		add(botonDefender);
		
		
		Botones botonHabilidades = new Botones("");
		botonHabilidades.setBounds(495, 367, 165, 23);
		add(botonHabilidades);
		
		Botones botonObjetos = new Botones("");
		botonObjetos.setBounds(670, 367, 165, 23);
		add(botonObjetos);
		
		Botones boton1Habilidad = new Botones("1");
		boton1Habilidad.setVisible(false);
		boton1Habilidad.setBounds(242, 367, 165, 23);
		add(boton1Habilidad);
		
		Botones boton2Habilidad = new Botones("2");
		boton2Habilidad.setVisible(false);
		boton2Habilidad.setBounds(417, 367, 165, 23);
		add(boton2Habilidad);
		
		Botones boton3Habilidad = new Botones("3");
		boton3Habilidad.setVisible(false);
		boton3Habilidad.setBounds(592, 367, 165, 23);
		add(boton3Habilidad);
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		
		//Imagenes
		JLabel iconoDefensaHeroe = new JLabel("");
		iconoDefensaHeroe.setBounds(152, 166, 158, 170);
		iconoDefensaHeroe.setIcon(new ImageIcon("./imagenes/Escudo.png"));
		iconoDefensaHeroe.setVisible(false);
		add(iconoDefensaHeroe);
		
		JLabel iconoDefensaEnemigo = new JLabel("");
		iconoDefensaEnemigo.setBounds(688, 166, 158, 170);
		iconoDefensaEnemigo.setIcon(new ImageIcon("./imagenes/Escudo.png"));
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
		
		//Eventos de botones
				botonAtacar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						atacarHeroe(ataqueHeroeSonido, registroBatalla);
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
	
	public void atacarHeroe(String ataqueHeroeSonido, LabelTexto registroBatalla) {
		ventana.heroe.atacar(ventana.heroe, ventana.enemigosArray.get(0));
		registroBatalla.setText("<html><center><b>"+ventana.heroe.getNombre()
				+"&ensp;inflige una cantidad de "+ventana.heroe.getFuerza()+" puntos de daño."
				+"</html>");
		vidaEnemigo();
		general.Musica.sonidosBoton(ataqueHeroeSonido);
		ataqueEnemigo();
		vidaHeroe();
	}
	
	public void ataqueEnemigo() {
        String rutaCancionVictoria = "./sonidos/Victoria.wav";
        String rutaSonidoFisicoEnemigo = "./sonidos/FisicoEnemigo.wav";
        String rutaSonidoHabilidadesObjetos = "./sonidos/HabilidadesObjetos.wav";
        String rutaSonidoDefensa = "./sonidos/Defensa.wav";


        int aleatorio;
        boolean Victoria=false;
        boolean defensaHeroe=false;
        boolean defensaEnemigo=false;
        
		ventana.enemigosArray.get(0).atacar(ventana.enemigosArray.get(0),ventana.heroe);
		if(ventana.enemigosArray.get(0).getSalud()>0){
            //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
            if(defensaEnemigo==true){
                    ventana.enemigosArray.get(0).BloqueoOff(ventana.enemigosArray.get(0));
                    defensaEnemigo=false;
                }
            try {
                System.out.println("----------------------------------------------");
                System.out.println("Turno de "+(ventana.enemigosArray.get(0).getNombre()+" - Vida restante: "+(ventana.enemigosArray.get(0).getSalud()+"/"+ventana.enemigosArray.get(0).getSaludMaxima())));
                aleatorio = NumeroAleatorio(0, 6);
                if(aleatorio<=3){
                    System.out.println("\tDecide atacar!\n");
                    ventana.enemigosArray.get(0).atacar(ventana.enemigosArray.get(0), ventana.heroe);
                    Musica.iniciarSonidos(rutaSonidoFisicoEnemigo);
                    Thread.sleep(150);
                }else if(aleatorio==4){
                    System.out.println("\tDecide usar bloqueo!\n");
                    System.out.println("- Su defensa natural se multiplica por 2 durante un turno.");
                    ventana.enemigosArray.get(0).Bloqueo(ventana.enemigosArray.get(0));
                    defensaEnemigo=true;
                    Musica.iniciarSonidos(rutaSonidoDefensa);
                    Thread.sleep(150);
                }else{
                    System.out.println("\tDecide usar una habilidad!\n");
                    ventana.enemigosArray.get(0).usarHabilidadesEnemigos(ventana.heroe);
                    Musica.iniciarSonidos(rutaSonidoHabilidadesObjetos);
                    Thread.sleep(150);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
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

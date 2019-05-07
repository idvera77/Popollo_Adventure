package interfaces;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import clases.Personaje;
import componentes.Botones;
import componentes.BotonesCombate;
import componentes.LabelTexto;
import componentes.Paneles;
import general.Musica;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Font;


public class Lucha extends Paneles{
	private Ventana ventana;
	private JTextField textField;
	public Lucha lucha;
	private JProgressBar vidaHeroe, vidaEnemigo;
	public LabelTexto registroBatallaHeroe, registroBatallaEnemigo, registroVictoriaDerrota;
	private Botones botonSalir, botonAtras;
	private BotonesCombate botonAtacar, botonDefender, botonHabilidades, botonObjetos, boton1Habilidad, 
		boton2Habilidad, boton3Habilidad, boton1Objeto, boton2Objeto, boton3Objeto;
	private JLabel iconoDefensaHeroe, iconoDefensaEnemigo;
	private String cancionVictoria, ataqueHeroeSonido, habilidadesObjetosSonido, defensaSonido, curacionSonido;
	private int aleatorio;
    private boolean defensaHeroe=false;
    private boolean defensaEnemigo=false;
    
	public Lucha(Ventana v) {
		super();
		this.ventana=v;
		int aleatorio;

		//Imagenes
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(".\\imagenes\\luchaPopollo.png");
		imagenes[1] = new ImageIcon(".\\imagenes\\Morrigan.png");
		imagenes[2] = new ImageIcon(".\\imagenes\\dancer low.png");	
		imagenes[3] = new ImageIcon(".\\imagenes\\luchaPoring.png");
		
		//sonidos
		cancionVictoria = "./sonidos/Victoria.wav";
        ataqueHeroeSonido = "./sonidos/Atacar.wav";
        habilidadesObjetosSonido = "./sonidos/HabilidadesObjetos.wav";
        defensaSonido = "./sonidos/Defensa.wav";
        curacionSonido = "./sonidos/Curaciones.wav";
        
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
		
		//Botones
		botonSalir = new Botones("Salir del juego");
		botonSalir.setVisible(false);
		botonSalir.setBounds(395, 267, 215, 23);
		add(botonSalir);
		
		botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(395, 267, 215, 23);
		botonAtras.setVisible(false);
		add(botonAtras);
		
		botonAtacar = new BotonesCombate("");
		botonAtacar.setIcon(new ImageIcon("./imagenes/botonEspada.png"));
		botonAtacar.setBounds(252, 347, 115, 115);
		add(botonAtacar);
		
		botonDefender = new BotonesCombate("");
		botonDefender.setIcon(new ImageIcon("./imagenes/botonEscudo.png"));
		botonDefender.setBounds(381, 347, 115, 115);
		add(botonDefender);
		
		botonHabilidades = new BotonesCombate("");
		botonHabilidades.setIcon(new ImageIcon("./imagenes/botonMagia.png"));
		botonHabilidades.setBounds(511, 347, 115, 115);
		add(botonHabilidades);
		
		botonObjetos = new BotonesCombate("");
		botonObjetos.setIcon(new ImageIcon("./imagenes/botonObjeto.png"));
		botonObjetos.setBounds(642, 347, 115, 115);
		add(botonObjetos);
		
		boton1Habilidad = new BotonesCombate("1");
		boton1Habilidad.setVisible(false);
		boton1Habilidad.setBounds(317, 347, 115, 115);
		add(boton1Habilidad);
		
		boton2Habilidad = new BotonesCombate("2");
		boton2Habilidad.setVisible(false);
		boton2Habilidad.setBounds(446, 347, 115, 115);
		add(boton2Habilidad);
		
		boton3Habilidad = new BotonesCombate("3");
		boton3Habilidad.setVisible(false);
		boton3Habilidad.setBounds(577, 347, 115, 115);
		add(boton3Habilidad);
		
		boton1Objeto = new BotonesCombate("1");
		boton1Objeto.setVisible(false);
		boton1Objeto.setBounds(317, 347, 115, 115);
		add(boton1Objeto);
		
		boton2Objeto = new BotonesCombate("2");
		boton2Objeto.setVisible(false);
		boton2Objeto.setBounds(446, 347, 115, 115);
		add(boton2Objeto);
		
		boton3Objeto = new BotonesCombate("3");
		boton3Objeto.setVisible(false);
		boton3Objeto.setBounds(577, 347, 115, 115);
		add(boton3Objeto);
		
		//Imagenes
		iconoDefensaHeroe = new JLabel("");
		iconoDefensaHeroe.setBounds(152, 166, 158, 170);
		iconoDefensaHeroe.setIcon(new ImageIcon("./imagenes/miniEscudo.png"));
		iconoDefensaHeroe.setVisible(false);
		add(iconoDefensaHeroe);
		
		iconoDefensaEnemigo = new JLabel("");
		iconoDefensaEnemigo.setBounds(688, 166, 158, 170);
		iconoDefensaEnemigo.setIcon(new ImageIcon("./imagenes/miniEscudo.png"));
		iconoDefensaEnemigo.setVisible(false);
		add(iconoDefensaEnemigo);
		
		//Paneles Texto
		registroVictoriaDerrota = new LabelTexto();
		registroVictoriaDerrota.setOpaque(false);
		registroVictoriaDerrota .setBounds(281, 120, 446, 204);
		add(registroVictoriaDerrota );
		
		registroBatallaHeroe = new LabelTexto();
		registroBatallaHeroe.setBounds(281, 120, 446, 103);
		add(registroBatallaHeroe);
		
		registroBatallaEnemigo = new LabelTexto();
		registroBatallaEnemigo.setBounds(281, 221, 446, 103);
		add(registroBatallaEnemigo);
		
		LabelTexto Versus = new LabelTexto();
		Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		Versus.setText("<html><center>"+ventana.heroe.getNombre()+" Versus "+ventana.enemigosArray.get(0).getNombre()+"</b></center></html>");
		Versus.setBounds(281, 49, 446, 58);
		add(Versus);
		
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
				atacar(ventana.getHeroe(), ventana.enemigosArray.get(0), registroBatallaHeroe);
				general.Musica.sonidosBoton(ataqueHeroeSonido);
				ataqueEnemigo();
				iconoDefensaHeroe.setVisible(false);
			}
		});
		
		botonDefender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usarDefensa();
				general.Musica.sonidosBoton(defensaSonido);
			}
		});
		
		botonHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mostrarHabilidades(registroBatallaHeroe);
				mostrarBotonHabilidades();
				iconoDefensaHeroe.setVisible(false);
			}
		});
		
		botonObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mostrarHabilidades(registroBatallaHeroe);
				mostrarBotonObjetos();	
				iconoDefensaHeroe.setVisible(false);
			}
		});
		
		boton1Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotonHabilidades();
			}
		});
		
		boton2Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotonHabilidades();
			}
		});
	
		boton3Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotonHabilidades();
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Batalla");
			}
		});
		
		boton1Objeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotonObjetos();
			}
		});
		
		boton2Objeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotonObjetos();
			}
		});
		
		boton3Objeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotonObjetos();
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Batalla");
			}
		});
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ventana.getConnect()!=null) {
					try {
						ventana.connect.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
					System.exit(0);  
			}
		});
		
	}
		
		/**
		 * Funcion que nos permite mostrar los botones asignados a las habilidades.
		 */
		public void mostrarBotonHabilidades() {
			botonAtacar.setVisible(false);
			botonDefender.setVisible(false);
			botonHabilidades.setVisible(false);
			botonObjetos.setVisible(false);
			boton1Habilidad.setVisible(true);
			boton2Habilidad.setVisible(true);
			boton3Habilidad.setVisible(true);
		}
		
		/**
		 * Funcion que nos oculta los botones asignados a las habilidades.
		 */
		public void ocultarBotonHabilidades() {
			boton1Habilidad.setVisible(false);
			boton2Habilidad.setVisible(false);
			boton3Habilidad.setVisible(false);
			botonAtacar.setVisible(true);
			botonDefender.setVisible(true);
			botonHabilidades.setVisible(true);
			botonObjetos.setVisible(true);
		}
		
		/**
		 * Funcion que nos permite mostrar los botones asignados a los objetos.
		 */
		public void mostrarBotonObjetos() {
			botonAtacar.setVisible(false);
			botonDefender.setVisible(false);
			botonHabilidades.setVisible(false);
			botonObjetos.setVisible(false);
			boton1Objeto.setVisible(true);
			boton2Objeto.setVisible(true);
			boton3Objeto.setVisible(true);
		}
		
		/**
		 * Funcion que nos permite ocultar los botones asignados a los objetos.
		 */
		public void ocultarBotonObjetos() {
			boton1Objeto.setVisible(false);
			boton2Objeto.setVisible(false);
			boton3Objeto.setVisible(false);
			botonAtacar.setVisible(true);
			botonDefender.setVisible(true);
			botonHabilidades.setVisible(true);
			botonObjetos.setVisible(true);
		}
		
		public void ocultarTodo() {
			boton1Objeto.setVisible(false);
			boton2Objeto.setVisible(false);
			boton3Objeto.setVisible(false);
			botonAtacar.setVisible(false);
			botonDefender.setVisible(false);
			botonHabilidades.setVisible(false);
			botonObjetos.setVisible(false);
		}
		
		/**
		 * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante.
		 */
		public void vidaHeroe() {
			vidaHeroe.setValue(ventana.heroe.getSalud());
			vidaHeroe.setString(Integer.toString(ventana.heroe.getSalud()));
		}
		
		/**
		 * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante.
		 */
		public void vidaEnemigo() {
			vidaEnemigo.setValue(ventana.enemigosArray.get(0).getSalud());
			vidaEnemigo.setString(Integer.toString(ventana.enemigosArray.get(0).getSalud()));
		}
		
		/**
		 * Conjunto de instrucciones asociados al boton de defensa.
		 */
		public void usarDefensa() {
			iconoDefensaHeroe.setVisible(true);
			defensaHeroe=true;
			registroBatallaHeroe.setText("<html><center><b>"+ventana.heroe.getNombre()
					+" BLOQUEO!<br> Tu defensa natural se multiplica por 2 durante este turno."
					+"</center></b></html>");
			ventana.heroe.Bloqueo(ventana.heroe);
			ataqueEnemigo();
		}
		
		/**
		 * Funcion que recoge todas las acciones del enemigo y las condiciones de victoria o derrota.
		 */
		public void ataqueEnemigo() {
			//Comprobacion de que el enemigo tiene la salud suficiente para continuar el combate, de lo contrario ocurre la victoria.
			if(ventana.enemigosArray.get(0).getSalud()>0){
	            //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
	            if(defensaEnemigo==true){
	               ventana.enemigosArray.get(0).BloqueoOff(ventana.enemigosArray.get(0));
	               iconoDefensaEnemigo.setVisible(false);
	               defensaEnemigo=false;
	            }
	            //Tirada aleatoria para sacar la accion del enemigo (ataque, defender o uso de habilidades)
	            //ATAQUE BASICO
                aleatorio = NumeroAleatorio(0, 6);
                if(aleatorio<=3){
                    atacar(ventana.enemigosArray.get(0), ventana.heroe, registroBatallaEnemigo);
                //DEFENSA
                }else if(aleatorio==4){
                	registroBatallaEnemigo.setText("<html><center><b>"+ventana.enemigosArray.get(0).getNombre()
						+" decide usar bloqueo!<br> Su defensa natural se multiplica por 2 durante un turno."
						+"</center></b></html>");
                	iconoDefensaEnemigo.setVisible(true);
                    ventana.enemigosArray.get(0).Bloqueo(ventana.enemigosArray.get(0));
                    defensaEnemigo=true;
                //HABILIDADES    
                }else{
                    ventana.enemigosArray.get(0).usarHabilidadesEnemigos(ventana.heroe, registroBatallaEnemigo);
                }
	            }else{
	            	//Si ganamos el combate debemos comprobar si tenemos la defensa activa del hereoe y el enemigo para desactivarla 
	            	//de lo contrario al inicio del siguiente combate el parametro defensa estara aumentado *2
	            	if(defensaEnemigo==true){
	                	ventana.enemigosArray.get(0).BloqueoOff(ventana.enemigosArray.get(0));
	                	iconoDefensaEnemigo.setVisible(false);
	                    defensaEnemigo=false;   
	                }
	            	if(defensaHeroe==true){
	            		ventana.heroe.BloqueoOff(ventana.heroe);
	                 	iconoDefensaHeroe.setVisible(false);
	                    defensaHeroe=false;   
	                }
	            	
	            	registroVictoriaDerrota.setText("<html><center><b>!!!VICTORIA!!!<br> Recibes "+ventana.enemigosArray.get(0).getDinero()+" Monedas de oro y "
	                 		+ ventana.enemigosArray.get(0).getExperiencia()+" puntos de experiencia."
	     					+"</center></b></html>");
	            	registroVictoriaDerrota.setOpaque(true);
	            	ventana.heroe.subirNivel(ventana.enemigosArray.get(0).getExperiencia());
	            	ventana.heroe.setDinero(ventana.heroe.getDinero()+ventana.enemigosArray.get(0).getDinero());
	            	ventana.enemigosArray.get(0).restablecerEnemigo();
	            	ocultarTodo();
	            	 	
	            	Musica.sonidosBoton(cancionVictoria);
	            	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	botonAtras.setVisible(true);
	            	
	            }
				//Al final de cada turno quitamos al heroe la defensa aumentada.
				vidaHeroe();
				if(defensaHeroe==true){
			      ventana.heroe.BloqueoOff(ventana.heroe);
			      defensaHeroe=false;   
			    }
				//Al final del turno enemigo comprobamos si el heroe no tiene la suficiente vida para mostrar un GameOVer.
				if(ventana.heroe.getSalud()<=0) {
					registroVictoriaDerrota.setText("<html><center><b>!!!DERROTA!!!<br> Esfuerzate mas la proxima vez."
		 					+"</center></b></html>");
					ocultarTodo();
		            registroVictoriaDerrota.setOpaque(true);
		            botonSalir.setVisible(true);
				}	
		}
	
    
	    /**
	     * Funcion para golpear con ataques fisicos. Dependiendo de la agilidad de ambos cambian los resultados.
	     * @param personajeX Es el personaje que ataca y hace daño.
	     * @param personajeY Es el personaje que recibe el daño.
	     * @param registro Guarda la informacion para mostrarla en un JLabelText
	     */
	    public void atacar(Personaje personajeX, Personaje personajeY, LabelTexto registro){
	        int dañar;
	        int aleatorio, aleatorio1;
	        if(personajeX.getAgilidad()>personajeY.getAgilidad()){
	        	aleatorio = NumeroAleatorio(0, 3);
	            if(aleatorio==0){
	                dañar = personajeX.getFuerza()*2;
	                personajeY.daño(personajeY,dañar);
	                registro.setText("<html><center><b>!!GOLPE CRITICO!!<br>"+personajeX.getNombre()
						+" inflige "+personajeX.getFuerza()*2+" puntos de daño.<br>"
						+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño."
						+"</center></b></html>");
	                	vidaEnemigo();
	            }else{
	                dañar = personajeX.getFuerza();
	                personajeY.daño(personajeY,dañar);
	                registro.setText("<html><center><b>"+personajeX.getNombre()
						+" inflige "+personajeX.getFuerza()+" puntos de daño.<br>"
						+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño."
						+"</center></b></html>");
	                	vidaEnemigo();
	            }
	        }else if(personajeX.getAgilidad()==personajeY.getAgilidad()){
	            dañar = personajeX.getFuerza();
	            personajeY.daño(personajeY,dañar);
	            registro.setText("<html><center><b>"+personajeX.getNombre()
					+" inflige "+personajeX.getFuerza()+" puntos de daño.<br>"
					+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño."
					+"</center></b></html>");
	            	vidaEnemigo();
	        }else{
	        	aleatorio1 = NumeroAleatorio(0, 3);
	            if(aleatorio1==0){
	            	registro.setText("<html><center><b>Ataque Fallado!!!</center></b></html>");
	            }else{
	                dañar = personajeX.getFuerza();
	                personajeY.daño(personajeY,dañar);
	                registro.setText("<html><center><b>"+personajeX.getNombre()
					+" inflige "+personajeX.getFuerza()+" puntos de daño.<br>"
					+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño."
					+"</center></b></html>");
	                vidaEnemigo();
	            }
	        }
	    }

		/*
		 * Funcion que nos ayuda a generar numeros aleatorios necesarios para calculos de daño.
		 */
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

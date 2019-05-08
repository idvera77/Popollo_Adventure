package interfaces;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import clases.Enemigo;
import clases.Heroe;
import clases.Personaje;
import componentes.Botones;
import componentes.BotonesCombate;
import componentes.LabelTexto;
import componentes.Paneles;
import general.Musica;

import javax.swing.JProgressBar;
import java.awt.Font;


public class Lucha extends Paneles{
	public Ventana ventana;
	public int adversario;
	private Heroe heroe;
	private ImageIcon[] imagenEnemigoDerrota;
	public JProgressBar vidaHeroe, vidaEnemigo;
	public LabelTexto registroBatallaHeroe, registroBatallaEnemigo, registroVictoriaDerrota;
	private Botones botonSalir, botonAtras;
	private BotonesCombate botonAtacar, botonDefender, botonHabilidades, botonObjetos, boton1Habilidad, 
		boton2Habilidad, boton3Habilidad, boton1Objeto, boton2Objeto, boton3Objeto;
	public JLabel iconoDefensaHeroe, iconoDefensaEnemigo, imagenEnemigo;
	private String cancionVictoria, ataqueHeroeSonido, habilidadesObjetosSonido, defensaSonido, curacionSonido;
	private int aleatorio;
    private boolean defensaHeroe=false;
    private boolean defensaEnemigo=false;
    
	public Lucha(Ventana v, int adversario) {
		super();
		this.ventana=v;
		this.adversario=adversario;
		this.heroe=ventana.heroe;
	
		
		//Imagenes
		ImageIcon[] imagenEnemigoBatalla = new ImageIcon[4];
		imagenEnemigoBatalla[0] = new ImageIcon(".\\imagenes\\poiG.gif");
		imagenEnemigoBatalla[1] = new ImageIcon(".\\imagenes\\Morrigan.png");
		
		imagenEnemigoDerrota = new ImageIcon[4];
		imagenEnemigoDerrota[0] = new ImageIcon(".\\imagenes\\poiD.png");
		imagenEnemigoDerrota[1] = new ImageIcon(".\\imagenes\\Morrigan.png");
		
		//sonidos
		cancionVictoria = "./sonidos/Victoria.wav";
        ataqueHeroeSonido = "./sonidos/Atacar.wav";
        habilidadesObjetosSonido = "./sonidos/HabilidadesObjetos.wav";
        defensaSonido = "./sonidos/Defensa.wav";
        curacionSonido = "./sonidos/Curaciones.wav";
		
		//Paneles Texto
		registroVictoriaDerrota = new LabelTexto();
		registroVictoriaDerrota.setOpaque(false);
		registroVictoriaDerrota .setBounds(281, 120, 446, 204);
		add(registroVictoriaDerrota );
        
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
		
		this.vidaEnemigo = new JProgressBar(0, ventana.enemigosArray.get(adversario).getSaludMaxima());
		vidaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaEnemigo.setStringPainted(true);
		vidaEnemigo.setString(Integer.toString(ventana.enemigosArray.get(adversario).getSalud()));
		vidaEnemigo.setForeground(Color.RED);
		vidaEnemigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaEnemigo.setBounds(747, 290, 241, 34);
		vidaEnemigo.setValue(ventana.enemigosArray.get(adversario).getSalud());
		add(vidaEnemigo);
		
		//Botones
		botonSalir = new Botones("Salir del juego");
		botonSalir.setVisible(false);
		botonSalir.setBounds(395, 277, 215, 23);
		add(botonSalir);
		
		botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(395, 277, 215, 23);
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
		boton2Habilidad.setIcon(new ImageIcon("./imagenes/flechaHelada.png"));
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
		
		registroBatallaHeroe = new LabelTexto();
		registroBatallaHeroe.setBounds(281, 120, 446, 103);
		add(registroBatallaHeroe);
		
		registroBatallaEnemigo = new LabelTexto();
		registroBatallaEnemigo.setBounds(281, 221, 446, 103);
		add(registroBatallaEnemigo);
		
		LabelTexto Versus = new LabelTexto();
		Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		Versus.setText("<html><center>"+ventana.heroe.getNombre()+" Versus "+ventana.enemigosArray.get(adversario).getNombre()+"</b></center></html>");
		Versus.setBounds(281, 49, 446, 58);
		add(Versus);
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenHeroe = new JLabel("");
		imagenHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenHeroe.setBounds(10, 36, 261, 300);
		imagenHeroe.setIcon(new ImageIcon(".\\imagenes\\popolloG.gif"));
		add(imagenHeroe);
		
		//JLabel donde se muestra las imagenes de la galeria
		imagenEnemigo = new JLabel("");
		imagenEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenEnemigo.setBounds(737, 36, 261, 300);
		imagenEnemigo.setIcon(imagenEnemigoBatalla[adversario]);
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
				usarAtaque();
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
				ventana.heroe.mostrarHabilidadesCombate(registroBatallaHeroe);
				mostrarBotonHabilidades();
				iconoDefensaHeroe.setVisible(false);
			}
		});
		
		botonObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				ventana.heroe.mostrarObjetosCombate(registroBatallaHeroe);
				mostrarBotonObjetos();
				iconoDefensaHeroe.setVisible(false);

			}
		});
		
		boton1Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usarHabilidadHeroe(0);
			}
		});
		
		boton2Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usarHabilidadHeroe(1);
			}
		});
	
		boton3Habilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usarHabilidadHeroe(2);
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
				usarObjetosHeroe(0);
			}
		});
		
		boton2Objeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usarObjetosHeroe(1);
			}
		});
		
		boton3Objeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usarObjetosHeroe(2);
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
	 * Anotacion: Puedo hacer paneles con estos botones pero quizas juego con ellos mas adelante por separado.
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
	
	/**
	 * Funcion que oculta todos los botones
	 */
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
	 * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante del heroe.
	 */
	public void vidaHeroe() {
		vidaHeroe.setValue(ventana.heroe.getSalud());
		vidaHeroe.setString(Integer.toString(ventana.heroe.getSalud()));
	}
	
	/**
	 * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante del enemigo.
	 */
	public void vidaEnemigo() {
		vidaEnemigo.setValue(ventana.enemigosArray.get(adversario).getSalud());
		vidaEnemigo.setString(Integer.toString(ventana.enemigosArray.get(adversario).getSalud()));
	}
	
	/**
	 * Conjunto de instrucciones asociadas al boton de ataque
	 */
	public void usarAtaque(){
		atacar(ventana.getHeroe(), ventana.enemigosArray.get(adversario), registroBatallaHeroe);
		general.Musica.sonidosBoton(ataqueHeroeSonido);
		ataqueEnemigo();
		iconoDefensaHeroe.setVisible(false);
	}
	
	/**
	 * Conjunto de instrucciones asociados al boton de defensa
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
	 * Conjunto de funciones para el uso de habilidades
	 * @param numero Indica la habilidad a usar
	 */
	public void usarHabilidadHeroe(int numero) {
			ocultarBotonHabilidades();
			heroe.usarHabilidades(numero, ventana.enemigosArray.get(adversario), registroBatallaHeroe, habilidadesObjetosSonido, curacionSonido);
			vidaEnemigo();
			ataqueEnemigo();	
	}
		
	/**
	 * Conjunto de funciones para el uso de objetos
	 * @param numero Indica el objeto a usar
	 */
	public void usarObjetosHeroe(int numero) {
			ocultarBotonObjetos();
			ventana.heroe.usarObjetos(numero, ventana.enemigosArray.get(adversario), registroBatallaHeroe, habilidadesObjetosSonido, curacionSonido);
			vidaEnemigo();
			ataqueEnemigo();
	}

	/**
	 * Funcion que recoge todas las acciones del enemigo y las condiciones de victoria o derrota.
	 */
	public void ataqueEnemigo() {
		//Comprobacion de que el enemigo tiene la salud suficiente para continuar el combate, de lo contrario ocurre la victoria.
		if(ventana.enemigosArray.get(adversario).getSalud()>0){
            //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
            if(defensaEnemigo==true){
               ventana.enemigosArray.get(adversario).BloqueoOff(ventana.enemigosArray.get(adversario));
               iconoDefensaEnemigo.setVisible(false);
               defensaEnemigo=false;
            }
            //Tirada aleatoria para sacar la accion del enemigo (ataque, defender o uso de habilidades)
            //ATAQUE BASICO
            aleatorio = NumeroAleatorio(0, 6);
            if(aleatorio<=3){
                atacar(ventana.enemigosArray.get(adversario), ventana.heroe, registroBatallaEnemigo);
            //DEFENSA
            }else if(aleatorio==4){
            	registroBatallaEnemigo.setText("<html><center><b>"+ventana.enemigosArray.get(adversario).getNombre()
					+" decide usar bloqueo!<br> Su defensa natural se multiplica por 2 durante un turno."
					+"</center></b></html>");
            	iconoDefensaEnemigo.setVisible(true);
                ventana.enemigosArray.get(adversario).Bloqueo(ventana.enemigosArray.get(adversario));
                defensaEnemigo=true;
            //HABILIDADES    
            }else{
                ventana.enemigosArray.get(adversario).usarHabilidadesEnemigos(ventana.heroe, registroBatallaEnemigo);
            }
            }else{
            	//Si ganamos el combate debemos comprobar si tenemos la defensa activa del hereoe y el enemigo para desactivarla 
            	//de lo contrario al inicio del siguiente combate el parametro defensa estara aumentado *2
            	if(defensaEnemigo==true){
                	ventana.enemigosArray.get(adversario).BloqueoOff(ventana.enemigosArray.get(adversario));
                	iconoDefensaEnemigo.setVisible(false);
                    defensaEnemigo=false;   
                }
            	if(defensaHeroe==true){
            		ventana.heroe.BloqueoOff(ventana.heroe);
                 	iconoDefensaHeroe.setVisible(false);
                    defensaHeroe=false;   
                }
            	imagenEnemigo.setIcon(imagenEnemigoDerrota[adversario]);
            	registroVictoriaDerrota.setText("<html><center><b>!!!VICTORIA!!!<br><br> Recibes "+ventana.enemigosArray.get(adversario).getDinero()+" Monedas de oro y "
                 		+ ventana.enemigosArray.get(adversario).getExperiencia()+" puntos de experiencia."
     					+"</center></b></html>");
            	registroVictoriaDerrota.setOpaque(true);
            	ventana.heroe.setDinero(ventana.heroe.getDinero()+ventana.enemigosArray.get(adversario).getDinero());
            	ventana.enemigosArray.get(adversario).restablecerEnemigo();
            	ocultarTodo();
            	 	
            	Musica.sonidosBoton(cancionVictoria);
            	ventana.heroe.subirNivel(ventana.enemigosArray.get(adversario).getExperiencia());
            	botonAtras.setVisible(true);
            }
			//Al final de cada turno quitamos al heroe la defensa aumentada.
			vidaHeroe();
			if(defensaHeroe==true){
		      ventana.heroe.BloqueoOff(ventana.heroe);
		      defensaHeroe=false;   
		    }
			//Al final del turno enemigo comprobamos si el heroe no tiene la suficiente vida para mostrar un GameOver.
			
			if(ventana.heroe.getSalud()<=0) {
				registroVictoriaDerrota.setText("<html><center><b>!!!DERROTA!!!<br><br> Esfuerzate mas la proxima vez."
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
            }else{
                dañar = personajeX.getFuerza();
                personajeY.daño(personajeY,dañar);
                registro.setText("<html><center><b>"+personajeX.getNombre()
					+" inflige "+personajeX.getFuerza()+" puntos de daño.<br>"
					+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño."
					+"</center></b></html>");
            }
        }else if(personajeX.getAgilidad()==personajeY.getAgilidad()){
            dañar = personajeX.getFuerza();
            personajeY.daño(personajeY,dañar);
            registro.setText("<html><center><b>"+personajeX.getNombre()
				+" inflige "+personajeX.getFuerza()+" puntos de daño.<br>"
				+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño."
				+"</center></b></html>");
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
            }
        }
        vidaEnemigo();
    }

	/*
	 * Funcion que nos ayuda a generar numeros aleatorios necesarios para calculos de daño.
	 */
    public static int NumeroAleatorio(int minimo,int maximo){
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }
}


package pantallas;

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
import componentes.Botones;
import componentes.BotonesCombate;
import componentes.LabelTextoOtros;
import componentes.Paneles;
import javax.swing.JProgressBar;
import java.awt.Font;

public class Lucha extends Paneles{
	private Ventana ventana;
	public int adversario;
	private Heroe heroe;
	private ArrayList<Enemigo> enemigoArray;
	private ImageIcon[] imagenEnemigoDerrota;
	public JProgressBar vidaHeroe, vidaEnemigo;
	public LabelTextoOtros registroBatallaHeroe, registroBatallaEnemigo, registroVictoriaDerrota, mostrarAtributos, mostrarAtributosEnemigo, Versus;
	private Botones botonSalir, botonAtras, quitarSeleccion;
	private BotonesCombate botonAtacar, botonDefender, botonHabilidades, botonObjetos, boton1Habilidad, boton2Habilidad, boton3Habilidad, boton1Objeto, boton2Objeto, boton3Objeto;
	public JLabel iconoDefensaHeroe, iconoDefensaEnemigo, imagenEnemigo, imagenHeroe;
	private String cancionVictoria, ataqueHeroeSonido, habilidadesObjetosSonido, defensaSonido, curacionSonido;
	private int aleatorio;
    private boolean defensaHeroe=false;
    private boolean defensaEnemigo=false;
    
	public Lucha(Ventana ventana, int adversario) {
		super();
		this.ventana=ventana;
		this.adversario=adversario;
		this.heroe=ventana.heroe;
		this.enemigoArray=ventana.enemigosArray;

		//Imagenes
		ImageIcon[] imagenEnemigoBatalla = new ImageIcon[6];
		imagenEnemigoBatalla[0] = new ImageIcon("./recursos/imagenes/combate/poi.gif");
		imagenEnemigoBatalla[1] = new ImageIcon("./recursos/imagenes/combate/nigromante.gif");
		imagenEnemigoBatalla[4] = new ImageIcon("./recursos/imagenes/combate/deviling.gif");

		imagenEnemigoDerrota = new ImageIcon[6];
		imagenEnemigoDerrota[0] = new ImageIcon("./recursos/imagenes/combate/poiD.png");
		imagenEnemigoDerrota[1] = new ImageIcon("./recursos/imagenes/combate/nigromanteD.png");
		imagenEnemigoDerrota[4] = new ImageIcon("./recursos/imagenes/combate/devilingD.png");

		//sonidos
		cancionVictoria = "./recursos/sonidos/Victoria.wav";
        ataqueHeroeSonido = "./recursos/sonidos/Atacar.wav";
        habilidadesObjetosSonido = "./recursos/sonidos/HabilidadesObjetos.wav";
        defensaSonido = "./recursos/sonidos/Defensa.wav";
        curacionSonido = "./recursos/sonidos/Curaciones.wav";
		
		//Paneles Texto
		registroVictoriaDerrota = new LabelTextoOtros();
		registroVictoriaDerrota.setOpaque(false);
		registroVictoriaDerrota .setBounds(281, 120, 446, 204);
		add(registroVictoriaDerrota );
		
		mostrarAtributos = new LabelTextoOtros();
		heroe.mostrarAtributosCombate(mostrarAtributos);
		mostrarAtributos.setVisible(false);
		mostrarAtributos.setBounds(80, 347, 120, 115);
		add(mostrarAtributos);
		
		mostrarAtributosEnemigo = new LabelTextoOtros();
		enemigoArray.get(adversario).mostrarAtributosCombate(mostrarAtributosEnemigo);
		mostrarAtributosEnemigo.setVisible(false);
		mostrarAtributosEnemigo.setBounds(807, 347, 120, 115);
		add(mostrarAtributosEnemigo);
		
        //Barras de salud
		this.vidaHeroe = new JProgressBar(0, heroe.getSaludMaxima());
		vidaHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaHeroe.setStringPainted(true);
		vidaHeroe.setString(Integer.toString(heroe.getSalud()));
		vidaHeroe.setForeground(Color.RED);
		vidaHeroe.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaHeroe.setBounds(20, 290, 241, 34);
		vidaHeroe.setValue(heroe.getSalud());
		add(vidaHeroe);
		
		this.vidaEnemigo = new JProgressBar(0, enemigoArray.get(adversario).getSaludMaxima());
		vidaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaEnemigo.setStringPainted(true);
		vidaEnemigo.setString(Integer.toString(enemigoArray.get(adversario).getSalud()));
		vidaEnemigo.setForeground(Color.RED);
		vidaEnemigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaEnemigo.setBounds(747, 290, 241, 34);
		vidaEnemigo.setValue(enemigoArray.get(adversario).getSalud());
		add(vidaEnemigo);
		
		//Botones
		botonSalir = new Botones("Salir del juego");
		botonSalir.setVisible(false);
		botonSalir.setBounds(395, 277, 215, 23);
		add(botonSalir);
		
		botonAtras = new Botones("Volver al mapa");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.stop();
				ventana.origenADestino(ventana, "lucha", "principal", 0);
			}
		});
		botonAtras.setBounds(395, 277, 215, 23);
		botonAtras.setVisible(false);
		add(botonAtras);
		
		botonAtacar = new BotonesCombate("");
		botonAtacar.setIcon(new ImageIcon("./recursos/imagenes/botones/botonEspada.png"));
		botonAtacar.setBounds(252, 347, 115, 115);
		add(botonAtacar);
		
		botonDefender = new BotonesCombate("");
		botonDefender.setIcon(new ImageIcon("./recursos/imagenes/botones/botonEscudo.png"));
		botonDefender.setBounds(381, 347, 115, 115);
		add(botonDefender);
		
		botonHabilidades = new BotonesCombate("");
		botonHabilidades.setIcon(new ImageIcon("./recursos/imagenes/botones/botonMagia.png"));
		botonHabilidades.setBounds(511, 347, 115, 115);
		add(botonHabilidades);
		
		botonObjetos = new BotonesCombate("");
		botonObjetos.setIcon(new ImageIcon("./recursos/imagenes/botones/botonObjeto.png"));
		botonObjetos.setBounds(642, 347, 115, 115);
		add(botonObjetos);
		
		boton1Habilidad = new BotonesCombate("1");
		boton1Habilidad.setVisible(false);
		boton1Habilidad.setIcon(new ImageIcon("./recursos/imagenes/botones/botonChispa.png"));
		boton1Habilidad.setBounds(317, 347, 115, 115);
		add(boton1Habilidad);
		
		boton2Habilidad = new BotonesCombate("2");
		boton2Habilidad.setVisible(false);
		boton2Habilidad.setIcon(new ImageIcon("./recursos/imagenes/botones/botonFlechaHelada.png"));
		boton2Habilidad.setBounds(446, 347, 115, 115);
		add(boton2Habilidad);
		
		boton3Habilidad = new BotonesCombate("3");
		boton3Habilidad.setVisible(false);
		boton3Habilidad.setIcon(new ImageIcon("./recursos/imagenes/botones/botonHeal.png"));
		boton3Habilidad.setBounds(577, 347, 115, 115);
		add(boton3Habilidad);
		
		boton1Objeto = new BotonesCombate("1");
		boton1Objeto.setVisible(false);
		boton1Objeto.setIcon(new ImageIcon("./recursos/imagenes/botones/botonBombaP.png"));
		boton1Objeto.setBounds(317, 347, 115, 115);
		add(boton1Objeto);
		
		boton2Objeto = new BotonesCombate("2");
		boton2Objeto.setVisible(false);
		boton2Objeto.setIcon(new ImageIcon("./recursos/imagenes/botones/botonBombaG.png"));
		boton2Objeto.setBounds(446, 347, 115, 115);
		add(boton2Objeto);
		
		boton3Objeto = new BotonesCombate("3");
		boton3Objeto.setVisible(false);
		boton3Objeto.setIcon(new ImageIcon("./recursos/imagenes/botones/botonPocion.png"));
		boton3Objeto.setBounds(577, 347, 115, 115);
		add(boton3Objeto);
		
		quitarSeleccion = new Botones("Atras");
		quitarSeleccion.setVisible(false);
		quitarSeleccion.setBounds(446, 473, 115, 23);
		add(quitarSeleccion);
		
		//Imagenes
		iconoDefensaHeroe = new JLabel("");
		iconoDefensaHeroe.setBounds(152, 166, 158, 170);
		iconoDefensaHeroe.setIcon(new ImageIcon("./recursos/imagenes/combate/miniEscudo.png"));
		iconoDefensaHeroe.setVisible(false);
		add(iconoDefensaHeroe);
		
		iconoDefensaEnemigo = new JLabel("");
		iconoDefensaEnemigo.setBounds(688, 166, 158, 170);
		iconoDefensaEnemigo.setIcon(new ImageIcon("./recursos/imagenes/combate/miniEscudo.png"));
		iconoDefensaEnemigo.setVisible(false);
		add(iconoDefensaEnemigo);
		
		registroBatallaHeroe = new LabelTextoOtros();
		registroBatallaHeroe.setBounds(281, 120, 446, 103);
		add(registroBatallaHeroe);
		
		registroBatallaEnemigo = new LabelTextoOtros();
		registroBatallaEnemigo.setBounds(281, 221, 446, 103);
		add(registroBatallaEnemigo);
		
		Versus = new LabelTextoOtros();
		Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		Versus.setText("<html><center>"+heroe.getNombre()+" Versus "+enemigoArray.get(adversario).getNombre()+"</b></center></html>");
		Versus.setBounds(281, 49, 446, 58);
		add(Versus);
		
		//JLabel donde se muestra las imagenes del heroe
		imagenHeroe = new JLabel("");
		imagenHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenHeroe.setBounds(10, 36, 261, 300);
		imagenHeroe.setIcon(new ImageIcon("./recursos/imagenes/combate/popollo.gif"));
		add(imagenHeroe);
		
		//JLabel donde se muestra las imagenes del enemigo
		imagenEnemigo = new JLabel("");
		imagenEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenEnemigo.setBounds(737, 36, 261, 300);
		imagenEnemigo.setIcon(imagenEnemigoBatalla[adversario]);
		add(imagenEnemigo);
		
		//Imagen de fondo
		JLabel imagenBatalla = new JLabel("");
		imagenBatalla.setBounds(0, 0, 1008, 536);
		imagenBatalla.setIcon(new ImageIcon("./recursos/imagenes/batalla.jpg"));
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
				heroe.mostrarHabilidadesCombate(registroBatallaHeroe);
				mostrarBotonHabilidades();
				iconoDefensaHeroe.setVisible(false);
			}
		});
		
		botonObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				heroe.mostrarObjetosCombate(registroBatallaHeroe);
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
		
		quitarSeleccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				atrasCombate();
			}
		});

		
		imagenHeroe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mostrarAtributos.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mostrarAtributos.setVisible(false);
			}
		});
		
		imagenEnemigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mostrarAtributosEnemigo.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mostrarAtributosEnemigo.setVisible(false);
			}
		});
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ventana.getConnect()!=null) {
					try {
						ventana.getConnect().close();
					} catch (SQLException e1) {
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
		quitarSeleccion.setVisible(true);
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
		quitarSeleccion.setVisible(false);
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
		quitarSeleccion.setVisible(true);
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
		quitarSeleccion.setVisible(false);
	}
	
	public void atrasCombate() {
		boton1Habilidad.setVisible(false);
		boton2Habilidad.setVisible(false);
		boton3Habilidad.setVisible(false);
		botonAtacar.setVisible(true);
		boton1Objeto.setVisible(false);
		boton2Objeto.setVisible(false);
		boton3Objeto.setVisible(false);
		quitarSeleccion.setVisible(false);
		botonAtacar.setVisible(true);
		botonDefender.setVisible(true);
		botonHabilidades.setVisible(true);
		botonObjetos.setVisible(true);
		registroBatallaHeroe.setText("<html><b>Piensate mejor las cosas!!!</b></html>");
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
		quitarSeleccion.setVisible(false);
	}
	
	/**
	 * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante del heroe.
	 */
	public void vidaHeroe() {
		vidaHeroe.setValue(heroe.getSalud());
		vidaHeroe.setString(Integer.toString(heroe.getSalud()));
	}
	
	/**
	 * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante del enemigo.
	 */
	public void vidaEnemigo() {
		vidaEnemigo.setValue(enemigoArray.get(adversario).getSalud());
		vidaEnemigo.setString(Integer.toString(enemigoArray.get(adversario).getSalud()));
	}
	
	/**
	 * Conjunto de instrucciones asociadas al boton de ataque
	 */
	public void usarAtaque(){
		heroe.atacar(enemigoArray.get(adversario),registroBatallaHeroe);
		general.Musica.sonidosBoton(ataqueHeroeSonido);
		ataqueEnemigo();
		iconoDefensaHeroe.setVisible(false);
		vidaEnemigo();
	}
	
	/**
	 * Conjunto de instrucciones asociados al boton de defensa
	 */
	public void usarDefensa() {
		iconoDefensaHeroe.setVisible(true);
		defensaHeroe=true;
		registroBatallaHeroe.setText("<html><center><b>"+heroe.getNombre()
				+" BLOQUEO!<br> Tu defensa natural se multiplica por 2 durante este turno."
				+"</center></b></html>");
		heroe.Bloqueo(heroe);
		ataqueEnemigo();
	}
	
	/**
	 * Conjunto de funciones para el uso de habilidades
	 * @param numero Indica la habilidad a usar
	 */
	public void usarHabilidadHeroe(int numero) {
			ocultarBotonHabilidades();
			heroe.usarHabilidades(numero, enemigoArray.get(adversario), registroBatallaHeroe, habilidadesObjetosSonido, curacionSonido);
			vidaEnemigo();
			ataqueEnemigo();	
	}
		
	/**
	 * Conjunto de funciones para el uso de objetos
	 * @param numero Indica el objeto a usar
	 */
	public void usarObjetosHeroe(int numero) {
			ocultarBotonObjetos();
			heroe.usarObjetos(numero, enemigoArray.get(adversario), registroBatallaHeroe, habilidadesObjetosSonido, curacionSonido);
			vidaEnemigo();
			ataqueEnemigo();
	}

	/**
	 * Funcion que recoge todas las acciones del enemigo y las condiciones de victoria o derrota.
	 */
	public void ataqueEnemigo() {
		//Comprobacion de que el enemigo tiene la salud suficiente para continuar el combate, de lo contrario ocurre la victoria.
		if(enemigoArray.get(adversario).getSalud()>0){
            //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
            if(defensaEnemigo==true){
            	enemigoArray.get(adversario).BloqueoOff(enemigoArray.get(adversario));
               iconoDefensaEnemigo.setVisible(false);
               defensaEnemigo=false;
            }
            //Tirada aleatoria para sacar la accion del enemigo (ataque, defender o uso de habilidades)
            //ATAQUE BASICO
            aleatorio = clases.Personaje.numeroAleatorio(0, 6);
            if(aleatorio<=3){
            	enemigoArray.get(adversario).atacar(heroe, registroBatallaEnemigo);
            //DEFENSA
            }else if(aleatorio==4){
            	registroBatallaEnemigo.setText("<html><center><b>"+enemigoArray.get(adversario).getNombre()
					+" decide usar bloqueo!<br> Su defensa natural se multiplica por 2 durante un turno."
					+"</center></b></html>");
            	iconoDefensaEnemigo.setVisible(true);
            	enemigoArray.get(adversario).Bloqueo(enemigoArray.get(adversario));
                defensaEnemigo=true;
            //HABILIDADES    
            }else{
            	enemigoArray.get(adversario).usarHabilidadesEnemigos(heroe, registroBatallaEnemigo);
            }
            }else{
            	//Si ganamos el combate debemos comprobar si tenemos la defensa activa del hereoe y el enemigo para desactivarla 
            	//de lo contrario al inicio del siguiente combate el parametro defensa estara aumentado *2
            	if(defensaEnemigo==true){
            		enemigoArray.get(adversario).BloqueoOff(enemigoArray.get(adversario));
                	iconoDefensaEnemigo.setVisible(false);
                    defensaEnemigo=false;   
                }
            	if(defensaHeroe==true){
            		heroe.BloqueoOff(heroe);
                 	iconoDefensaHeroe.setVisible(false);
                    defensaHeroe=false;   
                }
            	imagenEnemigo.setIcon(imagenEnemigoDerrota[adversario]);
            	registroVictoriaDerrota.setText("<html><center><b>!!!VICTORIA!!!<br><br> Recibes "+enemigoArray.get(adversario).getDinero()+" Monedas de oro y "
                 		+ enemigoArray.get(adversario).getExperiencia()+" puntos de experiencia."
     					+"</center></b></html>");
            	registroVictoriaDerrota.setOpaque(true);
            	heroe.setDinero(heroe.getDinero()+enemigoArray.get(adversario).getDinero());
            	ocultarTodo();
            	 	
            	//TODO
            	Ventana.sonidosBoton(cancionVictoria);
            	//Musica.sonidosBoton(cancionVictoria);
            	heroe.subirNivel(enemigoArray.get(adversario).getExperiencia());
            	botonAtras.setVisible(true);
            	vidaEnemigo.setVisible(false);
            	enemigoArray.get(adversario).restablecerEnemigo();
            	
            }
			//Al final de cada turno quitamos al heroe la defensa aumentada.
			vidaHeroe();
			if(defensaHeroe==true){
		      heroe.BloqueoOff(heroe);
		      defensaHeroe=false;   
		    }
			//Al final del turno enemigo comprobamos si el heroe no tiene la suficiente vida para mostrar un GameOver.
			
			if(heroe.getSalud()<=0) {
				vidaHeroe.setVisible(false);
				imagenHeroe.setIcon(new ImageIcon("./recursos/imagenes/combate/popolloD.png"));
				registroVictoriaDerrota.setText("<html><center><b>!!!DERROTA!!!<br><br> Esfuérzate más la próxima vez."
	 					+"</center></b></html>");
				ocultarTodo();
	            registroVictoriaDerrota.setOpaque(true);
	            botonSalir.setVisible(true);
			}	
	}
}




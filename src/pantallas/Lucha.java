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
import componentes.LabelCombateEvento;
import componentes.Paneles;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Lucha extends Paneles {

    private Ventana ventana;
    private final int adversario;
    private Heroe heroe;
    private final ArrayList<Enemigo> enemigoArray;
    private final ArrayList<ImageIcon> imagenEnemigoBatalla, imagenEnemigoDerrota;
    private final JProgressBar vidaHeroe, vidaEnemigo, manaHeroe, manaEnemigo;
    private final LabelCombateEvento registroBatallaHeroe, registroBatallaEnemigo, registroVictoriaDerrota,
            mostrarAtributos, mostrarAtributosEnemigo, Versus;
    private final Botones botonSalir, botonAtras, quitarSeleccion;
    private final BotonesCombate botonAtacar, botonDefender, botonHabilidades, botonObjetos, boton1Habilidad,
            boton2Habilidad, boton3Habilidad, boton1Objeto, boton2Objeto, boton3Objeto;
    private final JLabel iconoDefensaHeroe, iconoDefensaEnemigo, imagenEnemigo, imagenHeroe;
    private final String sonidoVictoria, sonidoAtaque, sonidoExplosion, sonidoDefensa, sonidoCuracion, sonidoDerrota;
    private int aleatorio;
    private boolean defensaHeroe, defensaEnemigo;

    //Dependiendo del numero(adversario) indicando llamaremos a un enemigo guardado en un ArrayList en la ventana principal.
    public Lucha(Ventana ventana, int adversario) {
        super();
        this.ventana = ventana;
        this.adversario = adversario;
        this.heroe = ventana.heroe;
        this.enemigoArray = ventana.enemigosArray;

        //Archivos de Sonido
        sonidoVictoria = "./recursos/sonidos/Victoria.wav";
        sonidoAtaque = "./recursos/sonidos/Atacar.wav";
        sonidoExplosion = "./recursos/sonidos/Explosion.wav";
        sonidoDefensa = "./recursos/sonidos/Defensa.wav";
        sonidoCuracion = "./recursos/sonidos/Curaciones.wav";
        sonidoDerrota = "./recursos/sonidos/Derrota.wav";

        Ventana.comenzarFondo("./recursos/sonidos/Combate.wav");

        //Imagenes de los enemigos.
        imagenEnemigoBatalla = new ArrayList<ImageIcon>();
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/poi.gif"));
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/nigromante.gif"));
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/dlc.gif"));
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/update.gif"));
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/deviling.gif"));
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/deviling.gif"));

        imagenEnemigoDerrota = new ArrayList<ImageIcon>();
        imagenEnemigoDerrota.add(new ImageIcon("./recursos/imagenes/combate/poiD.png"));
        imagenEnemigoDerrota.add(new ImageIcon("./recursos/imagenes/combate/nigromanteD.png"));
        imagenEnemigoDerrota.add(new ImageIcon("./recursos/imagenes/combate/dlcD.png"));
        imagenEnemigoDerrota.add(new ImageIcon("./recursos/imagenes/combate/updateD.png"));
        imagenEnemigoDerrota.add(new ImageIcon("./recursos/imagenes/combate/devilingD.png"));
        imagenEnemigoBatalla.add(new ImageIcon("./recursos/imagenes/combate/deviling.gif"));

        //Paneles Texto
        registroVictoriaDerrota = new LabelCombateEvento();
        registroVictoriaDerrota.setVisible(false);
        registroVictoriaDerrota.setHorizontalTextPosition(SwingConstants.CENTER);
        registroVictoriaDerrota.setBounds(281, 112, 446, 205);
        add(registroVictoriaDerrota);

        //Estos atributos permanecen ocultos hasta que pasemos el raton por encima de la imagen del heroe o del enemigo.
        mostrarAtributos = new LabelCombateEvento();
        mostrarAtributos.setHorizontalTextPosition(SwingConstants.CENTER);
        heroe.mostrarAtributosCombate(mostrarAtributos);
        mostrarAtributos.setVisible(false);
        mostrarAtributos.setBounds(80, 347, 120, 115);
        add(mostrarAtributos);

        mostrarAtributosEnemigo = new LabelCombateEvento();
        mostrarAtributosEnemigo.setHorizontalTextPosition(SwingConstants.CENTER);
        enemigoArray.get(adversario).mostrarAtributosCombate(mostrarAtributosEnemigo);
        mostrarAtributosEnemigo.setVisible(false);
        mostrarAtributosEnemigo.setBounds(807, 347, 120, 115);
        add(mostrarAtributosEnemigo);

        //Barras de salud/mana del heroe y del enemigo, gracias a unas funciones mas abajo aumentaran o disminuiran.
        vidaHeroe = new JProgressBar(0, heroe.getSaludMaxima());
        vidaHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        vidaHeroe.setStringPainted(true);
        vidaHeroe.setString(Integer.toString(heroe.getSalud()));
        vidaHeroe.setForeground(Color.RED);
        vidaHeroe.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        vidaHeroe.setBounds(10, 282, 261, 28);
        vidaHeroe.setValue(heroe.getSalud());
        add(vidaHeroe);

        manaHeroe = new JProgressBar(0, heroe.getManaMaximo());
        manaHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        manaHeroe.setStringPainted(true);
        manaHeroe.setString(Integer.toString(heroe.getMana()));
        manaHeroe.setForeground(new Color(0, 191, 255));
        manaHeroe.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        manaHeroe.setBounds(10, 308, 261, 28);
        manaHeroe.setValue(heroe.getMana());
        add(manaHeroe);

        vidaEnemigo = new JProgressBar(0, enemigoArray.get(adversario).getSaludMaxima());
        vidaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        vidaEnemigo.setStringPainted(true);
        vidaEnemigo.setString(Integer.toString(enemigoArray.get(adversario).getSalud()));
        vidaEnemigo.setForeground(Color.RED);
        vidaEnemigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        vidaEnemigo.setBounds(737, 282, 261, 28);
        vidaEnemigo.setValue(enemigoArray.get(adversario).getSalud());
        add(vidaEnemigo);

        manaEnemigo = new JProgressBar(0, enemigoArray.get(adversario).getManaMaximo());
        manaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        manaEnemigo.setStringPainted(true);
        manaEnemigo.setString(Integer.toString(enemigoArray.get(adversario).getMana()));
        manaEnemigo.setForeground(new Color(0, 191, 255));
        manaEnemigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        manaEnemigo.setBounds(737, 308, 261, 28);
        manaEnemigo.setValue(enemigoArray.get(adversario).getMana());
        add(manaEnemigo);

        //Botones
        botonSalir = new Botones("Salir del juego");
        botonSalir.setVisible(false);
        botonSalir.setBounds(395, 283, 215, 23);
        add(botonSalir);

        botonAtras = new Botones("Volver al mapa");
        botonAtras.setBounds(395, 283, 215, 23);
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

        //Mas JLabel que nos sirven para sacar la imagen del boton defensa, los textos de combate y las imagenes de los luchadores.
        iconoDefensaHeroe = new JLabel("");
        iconoDefensaHeroe.setBounds(213, 231, 48, 48);
        iconoDefensaHeroe.setIcon(new ImageIcon("./recursos/imagenes/combate/miniEscudo.png"));
        iconoDefensaHeroe.setVisible(false);
        add(iconoDefensaHeroe);

        iconoDefensaEnemigo = new JLabel("");
        iconoDefensaEnemigo.setBounds(747, 231, 48, 48);
        iconoDefensaEnemigo.setIcon(new ImageIcon("./recursos/imagenes/combate/miniEscudo.png"));
        iconoDefensaEnemigo.setVisible(false);
        add(iconoDefensaEnemigo);

        registroBatallaHeroe = new LabelCombateEvento();
        registroBatallaHeroe.setHorizontalTextPosition(SwingConstants.CENTER);
        registroBatallaHeroe.setBounds(281, 112, 446, 103);
        add(registroBatallaHeroe);

        registroBatallaEnemigo = new LabelCombateEvento();
        registroBatallaEnemigo.setHorizontalTextPosition(SwingConstants.CENTER);
        registroBatallaEnemigo.setBounds(281, 212, 446, 103);
        add(registroBatallaEnemigo);

        Versus = new LabelCombateEvento();
        Versus.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        Versus.setText(heroe.getNombre() + " Versus " + enemigoArray.get(adversario).getNombre());
        Versus.setBounds(281, 36, 446, 58);
        add(Versus);

        imagenHeroe = new JLabel("");
        imagenHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        imagenHeroe.setBounds(10, 36, 261, 300);
        imagenHeroe.setIcon(new ImageIcon("./recursos/imagenes/combate/popollo.gif"));
        add(imagenHeroe);

        imagenEnemigo = new JLabel("");
        imagenEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        imagenEnemigo.setBounds(737, 36, 261, 300);
        imagenEnemigo.setIcon(imagenEnemigoBatalla.get(adversario));
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
                if (ventana.getConnect() != null) {
                    try {
                        ventana.getConnect().close();
                    } catch (SQLException e1) {
                    }
                }
                System.exit(0);
            }
        });

        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.pararSonido();
                Ventana.origenADestino(ventana, "lucha", "principal", 0);
            }
        });
    }

    //FUNCIONES
    /**
     * Funcion que nos permite mostrar los botones asignados a las habilidades. Anotacion: Puedo hacer paneles con estos
     * botones pero quizas juego con ellos mas adelante por separado.
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
        registroBatallaHeroe.setText("¡Piensa mejor las cosas!");
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
     * Funcion que reescribe los valores dentro de la barra de progreso indicando el mana restante del heroe.
     */
    public void manaHeroe() {
        manaHeroe.setValue(heroe.getMana());
        manaHeroe.setString(Integer.toString(heroe.getMana()));
    }

    /**
     * Funcion que reescribe los valores dentro de la barra de progreso indicando la salud restante del enemigo.
     */
    public void vidaEnemigo() {
        vidaEnemigo.setValue(enemigoArray.get(adversario).getSalud());
        vidaEnemigo.setString(Integer.toString(enemigoArray.get(adversario).getSalud()));
    }

    /**
     * Funcion que reescribe los valores dentro de la barra de progreso indicando el mana restante del enemigo.
     */
    public void manaEnemigo() {
        manaEnemigo.setValue(enemigoArray.get(adversario).getMana());
        manaEnemigo.setString(Integer.toString(enemigoArray.get(adversario).getMana()));
    }

    /**
     * Conjunto de instrucciones asociadas al boton de ataque
     */
    public void usarAtaque() {
        Ventana.comenzarSonido(sonidoAtaque);
        heroe.atacar(enemigoArray.get(adversario), registroBatallaHeroe);
        iconoDefensaHeroe.setVisible(false);
        turnoEnemigo();
    }

    /**
     * Conjunto de instrucciones asociados al boton de defensa
     */
    public void usarDefensa() {
        Ventana.comenzarSonido(sonidoDefensa);
        iconoDefensaHeroe.setVisible(true);
        defensaHeroe = true;
        registroBatallaHeroe.setText("¡BLOQUEO!");
        heroe.Bloqueo();
        turnoEnemigo();
    }

    /**
     * Conjunto de funciones para el uso de habilidades
     *
     * @param numero Indica la habilidad a usar
     */
    public void usarHabilidadHeroe(int numero) {
        ocultarBotonHabilidades();
        heroe.usarHabilidades(numero, enemigoArray.get(adversario), registroBatallaHeroe, sonidoExplosion, sonidoCuracion);
        turnoEnemigo();
    }

    /**
     * Conjunto de funciones para el uso de objetos
     *
     * @param numero Indica el objeto a usar
     */
    public void usarObjetosHeroe(int numero) {
        ocultarBotonObjetos();
        heroe.usarObjetos(numero, enemigoArray.get(adversario), registroBatallaHeroe, sonidoExplosion, sonidoCuracion);
        turnoEnemigo();
    }

    /**
     * Funcion que recoge todas las acciones del enemigo y las condiciones de victoria o derrota. Modifica las imagenes
     * en funcion de conseguir una victoria o una derrota. Cambia los Jpanel para mostrar mensajes dependiendo de la
     * accion. Cambia las imagenes de la bonificacion por defensa del boton defender.
     */
    public void turnoEnemigo() {
        manaHeroe();
        vidaEnemigo();
        //Comprobacion de que el enemigo tiene la salud suficiente para continuar el combate, de lo contrario ocurre la victoria.
        if (enemigoArray.get(adversario).getSalud() > 0) {
            //Comprobacion de que el enemigo tiene activada la mejora de defensa, si es true la disminuye ya que ha pasado un turno.
            if (defensaEnemigo == true) {
                enemigoArray.get(adversario).BloqueoOff();
                iconoDefensaEnemigo.setVisible(false);
                defensaEnemigo = false;
            }
            //Tirada aleatoria para sacar la accion del enemigo (ataque, defender o uso de habilidades)
            //ATAQUE BASICO
            aleatorio = clases.Personaje.numeroAleatorio(0, 6);
            if (aleatorio <= 3) {
                enemigoArray.get(adversario).atacar(heroe, registroBatallaEnemigo);
                //DEFENSA
            } else if (aleatorio == 4) {
                registroBatallaEnemigo.setText("<html><center>¡BLOQUEO!<br> Aumento x2 de defensa el proximo turno.</center></html>");
                iconoDefensaEnemigo.setVisible(true);
                enemigoArray.get(adversario).Bloqueo();
                defensaEnemigo = true;
                //HABILIDADES    
            } else {
                enemigoArray.get(adversario).usarHabilidadesEnemigos(heroe, registroBatallaEnemigo);
                manaEnemigo();
            }
        } else {
            //Si ganamos el combate debemos comprobar si tenemos la defensa activa del hereoe y el enemigo para desactivarla 
            //de lo contrario al inicio del siguiente combate el parametro defensa estara aumentado *2
            if (defensaEnemigo == true) {
                enemigoArray.get(adversario).BloqueoOff();
                iconoDefensaEnemigo.setVisible(false);
                defensaEnemigo = false;
            }
            if (defensaHeroe == true) {
                heroe.BloqueoOff();
                iconoDefensaHeroe.setVisible(false);
                defensaHeroe = false;
            }
            //Cambia el retrato del enemigo y aparece un mensaje de victoria, indicando el dinero y experiencia obtenido.
            imagenEnemigo.setIcon(imagenEnemigoDerrota.get(adversario));
            registroBatallaEnemigo.setText("");
            registroVictoriaDerrota.setVisible(true);
            registroVictoriaDerrota.setText("<html><center>¡VICTORIA!<br><br>"
                    + "* Recibes " + enemigoArray.get(adversario).getDinero() + " Monedas de oro *<br>"
                    + "* Obtienes " + enemigoArray.get(adversario).getExperiencia() + " puntos de experiencia *"
                    + "</center></html>");
            registroVictoriaDerrota.setOpaque(true);
            heroe.setDinero(heroe.getDinero() + enemigoArray.get(adversario).getDinero());
            ocultarTodo();
            Ventana.pararFondo();
            Ventana.comenzarSonido(sonidoVictoria);
            botonAtras.setVisible(true);
            //Si aumenta el nivel del heroe aparece un JOptionPane
            heroe.subirNivel(enemigoArray.get(adversario).getExperiencia());
            //Restablece la vida del enemigo para volver a luchar contra el en otro combate.
            enemigoArray.get(adversario).restablecerCompleto();

        }
        //Al final de cada turno quitamos al heroe la defensa aumentada y mostramos el cambio en sus barras de salud/mana.
        vidaHeroe();
        manaHeroe();
        if (defensaHeroe == true) {
            heroe.BloqueoOff();
            defensaHeroe = false;
        }
        //Al final del turno enemigo comprobamos si el heroe no tiene la suficiente vida para mostrar un GameOver.
        if (heroe.getSalud() <= 0) {
            Ventana.pararFondo();
            Ventana.comenzarSonido(sonidoDerrota);
            imagenHeroe.setIcon(new ImageIcon("./recursos/imagenes/combate/popolloD.png"));
            iconoDefensaHeroe.setVisible(false);
            registroVictoriaDerrota.setVisible(true);
            registroVictoriaDerrota.setText("<html><center><b>¡DERROTA!<br><br> Esfuérzate más la próxima vez.</b></center></html>");
            ocultarTodo();
            botonSalir.setVisible(true);
        }
    }
}

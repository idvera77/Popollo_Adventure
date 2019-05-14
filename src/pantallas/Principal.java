package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import clases.Enemigo;
import clases.Habilidad;
import clases.Heroe;
import clases.Npc;
import clases.Objeto;
import componentes.Botones;
import componentes.LabelPosicion;
import componentes.LabelTextoPrincipal;
import componentes.Paneles;
import exceptions.InvalidMoralException;
import exceptions.InvalidTipoException;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Principal extends Paneles {
    private Ventana ventana;
    private LabelTextoPrincipal mostrarAtributos, mensajeBienvenida;
    private LabelPosicion posicion0Mapa, posicion1Mapa, posicion2Mapa, posicion3Mapa, posicion4Mapa, posicion5Mapa, posicion6Mapa, posicion7Mapa, posicion8Mapa, posicion9Mapa, posicion10Mapa, 
            posicion11Mapa, posicion12Mapa, posicion13Mapa, posicion14Mapa,posicion15Mapa, posicion16Mapa, posicion17Mapa, posicion18Mapa, marcaMapa;
    private Botones comenzar, finDelJuego, botonCombateAleatorio, botonGuardarPartida, botonDescanso;
    private JProgressBar barraExperiencia;
    private String sonidoGuardar, sonidoNoLevel, sonidoEnter;

    public Principal(Ventana ventana) {
        super();
        this.ventana=ventana;

        //Sonido
        sonidoGuardar = "./recursos/sonidos/Guardar.wav";
        sonidoNoLevel = "./recursos/sonidos/NoLevel.wav";

        //CARGANDO DATOS DEL JUEGO
        //Si detecta una conexion entra en la base de datos y recupera los datos del heroe junto sus habilidades de lo contrario no hace nada (evitando un error).
        if(ventana.getConnect()!=null) {
            try {			
                Statement stm = ventana.getConnect().createStatement();
                ResultSet rs;    

                //Habilidades
                rs=stm.executeQuery("SELECT * FROM habilidad ORDER BY ID ASC");
                ArrayList<Habilidad> habilidadesHeroe=new ArrayList<Habilidad>();
                while(rs.next()){
                    habilidadesHeroe.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                        rs.getInt("usosMaximos"),rs.getInt("usosRestantes"), rs.getString("tipo")));
                }

                //Objetos
                rs=stm.executeQuery("SELECT * FROM objeto ORDER BY ID ASC");
                ArrayList<Objeto> objetosHeroe=new ArrayList<>();
                while(rs.next()){
                    objetosHeroe.add(new Objeto(rs.getString("nombre"),rs.getString("descripcion"), rs.getInt("poder"), rs.getInt("cantidad"),
                        rs.getString("tipo"), rs.getInt("precio")));
                }

                //Creando el heroe
                rs=stm.executeQuery("SELECT * FROM Heroe");
                rs.next();
                String nombreHeroe=rs.getString("nombre");
                String descripcionHeroe=rs.getString("descripcion");
                int saludMaxHeroe=rs.getInt("saludMaxima");
                int saludHeroe=rs.getInt("salud");
                int fuerzaHeroe=rs.getInt("fuerza");
                int magiaHeroe=rs.getInt("magia");
                int agilidadHeroe=rs.getInt("agilidad");
                int defensaHeroe=rs.getInt("defensa");
                int dineroHeroe=rs.getInt("dinero");
                int reputacionHeroe=rs.getInt("reputacion");
                int experienciaHeroe=rs.getInt("experiencia");
                int nivelHeroe=rs.getInt("nivel");
                int explorar=rs.getInt("explorar");

                //Constructor del Heroe
                if(ventana.getHeroe()==null) {
                    ventana.setHeroe(new Heroe(nombreHeroe, descripcionHeroe, saludMaxHeroe, saludHeroe, fuerzaHeroe, magiaHeroe, agilidadHeroe,
                        defensaHeroe, habilidadesHeroe, objetosHeroe, dineroHeroe, reputacionHeroe, experienciaHeroe, nivelHeroe, explorar));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (InvalidTipoException ex) {
                ex.printStackTrace();
                System.err.println(ex.getMessage());
            }	
            
            //Comprobamos si existe un heroe creado (cargar) y si no existe empieza desde una base guardada en el programa.	
        }else if(ventana.getHeroe()==null){
            try {
                ArrayList<Habilidad> habilidadesHeroe=new ArrayList<Habilidad>();
                    habilidadesHeroe.add(new Habilidad("Proyectil Magico", "Disparas chispas magicas de tus manos.", 7, 5, 5, "ofensivo"));
                    habilidadesHeroe.add(new Habilidad("Flecha Helada", "Lanzas una flecha que congela todo a su paso.", 12, 3, 3, "ofensivo"));
                    habilidadesHeroe.add(new Habilidad("Curar Heridas", "Sana las heridas superficiales.", 8, 3, 3, "curativo"));

                ArrayList<Objeto> objetosHeroe=new ArrayList<Objeto>();
                    objetosHeroe.add(new Objeto("Bomba Pequeña", "Inflige 30 puntos de daño.", 30, 3, "ofensivo", 100));
                    objetosHeroe.add(new Objeto("Bomba Grande", "Inflige 100 puntos de daño.", 100, 1, "ofensivo", 500));
                    objetosHeroe.add(new Objeto("Pocion", "Restablece 50 puntos de salud.", 50, 5, "curativo", 250));

                ventana.setHeroe(new Heroe("Popollo", "Un adorable popollito comilon.", 80, 80, 20, 5, 10, 10, habilidadesHeroe, objetosHeroe, 50000, 0, 0, 1, 0));
            } catch (InvalidTipoException e1) {
                e1.printStackTrace();
            }
        }

        //Insertando el resto de datos, como no se modifican en ningun momento no los guardo en base de datos.
        try {			
            //Creacion de enemigos y sus habilidades, se comprueba si estan creados para no repetir el proceso.
            if(ventana.enemigosArray==null) {
                ArrayList<Habilidad> habilidadesPoring=new ArrayList<Habilidad>();
                    habilidadesPoring.add(new Habilidad("Pedo magico", "Flatulencia rosada.", 7, 5, 5, "ofensivo"));
                    habilidadesPoring.add(new Habilidad("Tirar jellopy", "Mejor no digo de donde sale.", 10, 3, 3, "ofensivo"));           

                ArrayList<Habilidad> habilidadesNigromante=new ArrayList<Habilidad>();
                    habilidadesNigromante.add(new Habilidad("Lanzar maldicion", "Dolor intenso en las entrañas.", 5, 5, 5, "ofensivo"));
                    habilidadesNigromante.add(new Habilidad("Flecha acida", "Derrite armaduras y quema la carne.", 10, 3, 3, "ofensivo"));          

                ArrayList<Habilidad> habilidadesGolem=new ArrayList<Habilidad>();
                    habilidadesGolem.add(new Habilidad("Mina magica", "El suelo a tu alrededor explota.", 5, 5, 5, "ofensivo"));
                    habilidadesGolem.add(new Habilidad("Llamarada", "Quema el aire a su alrededor.", 7, 3, 3, "ofensivo"));     

                ArrayList<Habilidad> habilidadesGoblin=new ArrayList<Habilidad>();
                    habilidadesGoblin.add(new Habilidad("Lanza envenenada", "La punta de lanza brilla con un color extraña.", 10, 5, 5, "ofensivo"));
                    habilidadesGoblin.add(new Habilidad("Flecha venenosa", "Es mejor que no te alcance.", 15, 3, 3, "ofensivo"));     

                ArrayList<Habilidad> habilidadesPulpoi=new ArrayList<Habilidad>();
                    habilidadesPulpoi.add(new Habilidad("Cosquillas", "Flatulencia rosada.", 10, 5, 5, "ofensivo"));
                    habilidadesPulpoi.add(new Habilidad("Mirada viciosa", "Te desnuda con la mirada.", 15, 3, 3, "ofensivo"));               

                //Guardo los enemigos en un ArrayList por comodidad.
                ventana.enemigosArray = new ArrayList<Enemigo>();
                    ventana.enemigosArray.add(new Enemigo("Poring", "Una pequeña bola rosita", 60, 60, 15, 3, 10, 5, habilidadesPoring, 500, 25));
                    ventana.enemigosArray.add(new Enemigo("Nigromante", "Da grima verlo", 80, 80, 20, 5, 15, 15, habilidadesNigromante, 1000, 50));
                    ventana.enemigosArray.add(new Enemigo("Golem", "Un muro enorme de piedra.", 150, 150, 30, 5, 15, 25, habilidadesGolem, 1500, 60));
                    ventana.enemigosArray.add(new Enemigo("Goblin", "Es muy rapido", 120, 120, 20, 3, 30, 10, habilidadesGoblin, 1500, 60));
                    ventana.enemigosArray.add(new Enemigo("Deviling", "Un poring malvado", 200, 200, 40, 5, 20, 20, habilidadesPoring, 2000, 75));
                    ventana.enemigosArray.add(new Enemigo("Pulpoi", "Pulpo pervertido.", 300, 300, 40, 5, 20, 30, habilidadesPulpoi, 2500, 100));	
            }

            //Creacion de npcs, se comprueba si estan creados para no repetir el proceso.
            if(ventana.npcsArray==null) {
                 //Npcs
                 ventana.npcsArray=new ArrayList<Npc>();	
                     ventana.npcsArray.add(new Npc("Narcyl", "Sacerdotisa novata.", "legal"));
                     ventana.npcsArray.add(new Npc("Tomberi", "Demasiado gruñon.", "neutral"));
                     ventana.npcsArray.add(new Npc("Mystra", "Hechicera demente.", "caotico"));
            }		
        } catch (InvalidTipoException | InvalidMoralException ex) {
             ex.printStackTrace();
             System.err.println(ex.getMessage());
        }	

        //Mensaje inicial/final, botones de empezar y finalizar juego completo.
        comenzar = new Botones("Continua tu aventura");
        comenzar.setVisible(false);
        comenzar.setBounds(275, 310, 443, 48);
        add(comenzar);

        finDelJuego = new Botones("Felicidades!!!");
        finDelJuego.setVisible(false);
        finDelJuego.setBounds(275, 310, 443, 48);
        add(finDelJuego);


        mensajeBienvenida = new LabelTextoPrincipal();
        mensajeBienvenida.setVisible(false);
        mensajeBienvenida.setBounds(150, 104, 705, 208);
        add(mensajeBienvenida);

        //Movimiento se mueve dependiendo del valor Explorar del heroe.
        //Tiene documentado las posiciones del cursor para ser mas faciles futuras modificaciones.

        posicion0Mapa = new LabelPosicion();
        posicion0Mapa.setBounds(30, 194, 60, 60);
        add(posicion0Mapa);

        posicion1Mapa = new LabelPosicion();
        posicion1Mapa.setBounds(112, 134, 60, 60);
        add(posicion1Mapa);

        posicion2Mapa = new LabelPosicion();
        posicion2Mapa.setBounds(184, 86, 60, 60);
        add(posicion2Mapa);

        posicion3Mapa = new LabelPosicion();
        posicion3Mapa.setBounds(275, 48, 60, 60);
        add(posicion3Mapa);

        posicion4Mapa = new LabelPosicion();
        posicion4Mapa.setBounds(354, 85, 60, 60);
        add(posicion4Mapa);

        posicion5Mapa = new LabelPosicion();
        posicion5Mapa.setBounds(352, 182, 60, 60);
        add(posicion5Mapa);

        posicion6Mapa = new LabelPosicion();
        posicion6Mapa.setBounds(314, 260, 60, 60);
        add(posicion6Mapa);

        posicion7Mapa = new LabelPosicion();
        posicion7Mapa.setBounds(334, 344, 60, 60);
        add(posicion7Mapa);

        posicion8Mapa = new LabelPosicion();
        posicion8Mapa.setBounds(412, 351, 60, 60);
        add(posicion8Mapa);

        posicion9Mapa = new LabelPosicion();
        posicion9Mapa.setBounds(477, 283, 60, 60);
        add(posicion9Mapa);

        posicion10Mapa = new LabelPosicion();
        posicion10Mapa.setBounds(537, 209, 60, 60);
        add(posicion10Mapa);

        posicion11Mapa = new LabelPosicion();
        posicion11Mapa.setBounds(592, 133, 60, 60);
        add(posicion11Mapa);

        posicion12Mapa = new LabelPosicion();
        posicion12Mapa.setBounds(677, 104, 60, 60);
        add(posicion12Mapa);

        posicion13Mapa = new LabelPosicion();
        posicion13Mapa.setBounds(728, 179, 60, 60);
        add(posicion13Mapa);

        posicion14Mapa = new LabelPosicion();
        posicion14Mapa.setBounds(728, 265, 60, 60);
        add(posicion14Mapa);

        posicion15Mapa = new LabelPosicion();
        posicion15Mapa.setBounds(813, 290, 60, 60);
        add(posicion15Mapa);

        posicion16Mapa = new LabelPosicion();
        posicion16Mapa.setBounds(865, 223, 60, 60);
        add(posicion16Mapa);

        posicion17Mapa = new LabelPosicion();
        posicion17Mapa.setBounds(880, 145, 60, 60);
        add(posicion17Mapa);

        posicion18Mapa = new LabelPosicion();
        posicion18Mapa.setBounds(900, 38, 60, 60);
        add(posicion18Mapa);

        marcaMapa = new LabelPosicion();
        marcaMapa.setIcon(new ImageIcon("./recursos/marcadorMapa.gif"));
        add(marcaMapa);

        movimientoMapa();

        //Añadiendo botones

        Botones pruebaAfinidad = new Botones("Afinidad");
        pruebaAfinidad.setBounds(255, 33, 218, 23);
        add(pruebaAfinidad);

        botonGuardarPartida = new Botones("Guardar Partida");
        botonGuardarPartida.setBounds(767, 436, 215, 23);
        add(botonGuardarPartida);

        Botones botonTienda = new Botones("Tienda");
        botonTienda.setVisible(false);
        botonTienda.setBounds(496, 33, 165, 23);
        add(botonTienda);

        botonDescanso = new Botones("Punto de descanso");
        botonDescanso.setBounds(522, 487, 215, 23);
        add(botonDescanso);

        botonCombateAleatorio = new Botones("Avanzar");
        botonCombateAleatorio.setEnabled(false);
        botonCombateAleatorio.setText("Combate aleatorio");
        if(ventana.heroe.getExplorar()>=2) {
            botonCombateAleatorio.setEnabled(true);
        }
        botonCombateAleatorio.setBounds(522, 436, 215, 23);
        add(botonCombateAleatorio);

        Botones botonSalir = new Botones("Salir del Juego");
        botonSalir.setBounds(767, 487, 215, 23);
        add(botonSalir);

        //Eventos de botones

        pruebaAfinidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Ventana.origenADestino(ventana, "principal", "evento", 2);
            Ventana.origenADestino(ventana, "principal", "creditos", 0);
            }
        });	

        botonGuardarPartida.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int guardar = JOptionPane.showConfirmDialog(null, "¿Estás seguro?" , " Guardar Partida", 
                    JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (guardar == JOptionPane.YES_OPTION){
                    ventana.guardarPartida(ventana.heroe.getHabilidadesArray(), ventana.heroe.getObjetosArray()); 
                    Ventana.comenzarSonido(sonidoGuardar);
                }	
            }
        });

        botonTienda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.origenADestino(ventana,"principal", "tienda", 0);
            }
        });	

        botonDescanso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.origenADestino(ventana,"principal", "descanso", 0);
            }
        });	

        botonCombateAleatorio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                combateAleatorio();
            }
        });

        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int exit = JOptionPane.showConfirmDialog(null, "¿Estás seguro?" , " Cerrar Programa", 
                    JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (exit == JOptionPane.YES_OPTION){
                    if(ventana.getConnect()!=null) {
                        try {
                                ventana.getConnect().close();
                        } catch (SQLException e1) {
                        //No importa el error que pueda transmitir en este caso.
                        }
                    }	
                    System.exit(0);
                }	
            }
        });

        finDelJuego.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Ventana.origenADestino(ventana, "principal", "creditos", 0);
            }
        });

        marcaMapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                avanzarCasilla();
                movimientoMapa();
            }
        });

        comenzar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mensajeBienvenida.setVisible(false);
                comenzar.setVisible(false);
            }
        });

        barraExperiencia = new JProgressBar(0, 100);
        barraExperiencia.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        barraExperiencia.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        barraExperiencia.setStringPainted(true);
        barraExperiencia.setString(ventana.heroe.getExperiencia()+"/"+100);
        barraExperiencia.setValue(ventana.heroe.getExperiencia());
        barraExperiencia.setBounds(10, 344, 130, 31);
        add(barraExperiencia);

        mostrarAtributos = new LabelTextoPrincipal();
        ventana.heroe.pantallaGeneralEstadisticas(mostrarAtributos);
        mostrarAtributos.setBounds(10, 370, 130, 155);
        add(mostrarAtributos);

        LabelTextoPrincipal mostrarHabilidades = new LabelTextoPrincipal();
        ventana.heroe.mostrarHabilidades(mostrarHabilidades);
        mostrarHabilidades.setBounds(150, 436, 174, 89);
        add(mostrarHabilidades);

        LabelTextoPrincipal mostrarObjetos = new LabelTextoPrincipal();
        ventana.heroe.mostrarObjetos(mostrarObjetos);
        mostrarObjetos.setBounds(334, 436, 174, 89);
        add(mostrarObjetos);

        LabelTextoPrincipal mostrarDineroReputacion = new LabelTextoPrincipal();
        mostrarDineroReputacion.setText("<html><b>Oro: "+Integer.toString(ventana.heroe.getDinero())
            +"<br/>Reputacion: "+Integer.toString(ventana.heroe.getReputacion())	
            +"</b></html>");
        mostrarDineroReputacion.setBounds(10, 29, 130, 51);
        add(mostrarDineroReputacion);

        //Imagen de fondo
        JLabel imagenMapa = new JLabel("");
        imagenMapa.setBounds(0, 0, 1008, 536);
        imagenMapa.setIcon(new ImageIcon("./recursos/imagenes/mapa.png"));
        add(imagenMapa);	    

        //Mensaje Inicial o final
        if(ventana.getHeroe().getExplorar()==0) {
            comenzar.setVisible(true);
            mensajeBienvenida.setText("<html><b><center>Una malvada criatura está robando toda la comida.<br><br> "
                + "Un voraz pollo de granja se alza entre todos los habitantes del reino para hacer frente al vil enemigo que le priva de sus chuletitas.</center><br> "
                + " - Recuerda que debes pulsar en la flecha para ir al siguiente destino.<br>"
                + " - Te aconsejo que guardes la partida frecuentemente y uses la tienda sabiamente. </b></html>");
            mensajeBienvenida.setVisible(true);
        }
        if(ventana.getHeroe().getExplorar()==20) {
            finDelJuego.setVisible(true);
            mensajeBienvenida.setText("<html><center><b>¡Popollo ha conseguido derrotar al infame Pulpoi!</center><br><br> Todos en el reino recordarán la hazaña y cantarán odas en tu honor, "
                + "pero ahora lo más importante es... Que a Popollo le ruge el estómago. </b></html>");
            mensajeBienvenida.setVisible(true);
            botonCombateAleatorio.setVisible(false);
            botonDescanso.setVisible(false);
            botonGuardarPartida.setVisible(false);
        }
    }	

    /**
     * Pulsando en el boton asignado aumentamos un punto. Ademas si no tenemos el nivel suficiente no podemos continuar la partida.
     */
    public void avanzarCasilla() {
        ventana.heroe.setExplorar(ventana.heroe.getExplorar()+1);
        if(ventana.heroe.getExplorar()==1) {
            JOptionPane.showMessageDialog(null, "Has dado tu primer paso, ahora empieza lo divertido.", "Animo ^_^", 1);
        }
        if(ventana.heroe.getExplorar()==2) {
            Ventana.origenADestino(ventana,"principal", "lucha", 0);
        }
        if(ventana.heroe.getExplorar()==3) {
            Ventana.origenADestino(ventana, "principal", "evento", 0);
        }

        if(ventana.heroe.getExplorar()==4) {
            int entrar = JOptionPane.showConfirmDialog(null, "¿Quieres comprar algo?" , " Entrar en Tienda", 
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (entrar == JOptionPane.YES_OPTION){
                Ventana.origenADestino(ventana, "principal", "tienda", 0);
            }
        }
        if(ventana.heroe.getExplorar()==5) {
            if(ventana.heroe.getNivel()>=2) {
                Ventana.origenADestino(ventana, "principal", "lucha", 1);
            }else {
                Ventana.comenzarSonido(sonidoNoLevel);
                JOptionPane.showMessageDialog(null, "Retirada, necesitas mínimo nivel 2 para continuar.", "Blandengue", 1);
                ventana.heroe.setExplorar(ventana.heroe.getExplorar()-2);
                posicion3Mapa.setVisible(false);			
            }
        }
        if(ventana.heroe.getExplorar()==6) {
            Ventana.origenADestino(ventana, "principal", "evento", 1);
        }
        if(ventana.heroe.getExplorar()==7) {
            int entrar = JOptionPane.showConfirmDialog(null, "¿Quieres comprar algo?" , " Entrar en Tienda", 
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (entrar == JOptionPane.YES_OPTION){
                Ventana.origenADestino(ventana, "principal", "tienda", 0);
            }
        }
        if(ventana.heroe.getExplorar()==8) {
            //Evento Afinidad
        }
        if(ventana.heroe.getExplorar()==9) {
            Ventana.origenADestino(ventana, "principal", "lucha", 2);
        }
        if(ventana.heroe.getExplorar()==10) {
            //ventana.origenADestino(ventana, "principal", "evento", 2);
        }
        if(ventana.heroe.getExplorar()==11) {
            int entrar = JOptionPane.showConfirmDialog(null, "¿Quieres comprar algo?" , " Entrar en Tienda", 
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (entrar == JOptionPane.YES_OPTION){
                Ventana.origenADestino(ventana, "principal", "tienda", 0);
            }
        }
        if(ventana.heroe.getExplorar()==12) {
            if(ventana.heroe.getNivel()>=4) {
                Ventana.origenADestino(ventana, "principal", "lucha", 3);
            }else {
                JOptionPane.showMessageDialog(null, "Retirada, necesitas mínimo nivel 4 para continuar.", "Blandengue", 1);
                ventana.heroe.setExplorar(ventana.heroe.getExplorar()-2);	
                posicion10Mapa.setVisible(false);
            }
        }
        if(ventana.heroe.getExplorar()==13) {
            //ventana.origenADestino(ventana, "principal", "evento", 3);
        }
        if(ventana.heroe.getExplorar()==14) {
            Ventana.origenADestino(ventana, "principal", "tienda", 0);
        }
        if(ventana.heroe.getExplorar()==15) {
            //Evento Afinidad
        }
        if(ventana.heroe.getExplorar()==16) {
            Ventana.origenADestino(ventana, "principal", "lucha", 4);
        }
        if(ventana.heroe.getExplorar()==17) {
            //ventana.origenADestino(ventana, "principal", "evento", 4);
        }
        if(ventana.heroe.getExplorar()==18) {
            int entrar = JOptionPane.showConfirmDialog(null, "¿Quieres comprar algo?" , " Entrar en Tienda", 
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (entrar == JOptionPane.YES_OPTION){
                Ventana.origenADestino(ventana, "principal", "tienda", 0);
            }
        }
        if(ventana.heroe.getExplorar()==19) {
            if(ventana.heroe.getNivel()>=6) {
                Ventana.origenADestino(ventana, "principal", "lucha", 5);
                ventana.heroe.setExplorar(20);
            }else {
                JOptionPane.showMessageDialog(null, "Retirada, necesitas mínimo nivel 6 para continuar.", "Blandengue", 1);
                ventana.heroe.setExplorar(ventana.heroe.getExplorar()-2);	
                posicion17Mapa.setVisible(false);
            }
        }
    }

    /**
     * Funcion que nos permite avanzar en la barra de progreso paso a paso, aumenta el valor explorar del heroe para saber el punto exacto de la partida.
     */
    public void movimientoMapa() {
        ventana.heroe.getExplorar();
        if(ventana.heroe.getExplorar()>=0) {
            marcaMapa.setBounds(39, 182, 60, 60);
            marcaMapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=1) {
            marcaMapa.setBounds(114, 118, 60, 60);
            posicion0Mapa.setVisible(true);
            marcaMapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=2) {
            marcaMapa.setBounds(190, 67, 60, 60);
            posicion1Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=3) {
            marcaMapa.setBounds(280, 29, 60, 60);
            posicion2Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=4) {
            marcaMapa.setBounds(362, 67, 60, 60);
            posicion3Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=5) {
            marcaMapa.setBounds(358, 150, 60, 60);
            posicion4Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=6) {
            marcaMapa.setBounds(319, 234, 60, 60);
            posicion5Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=7) {
            marcaMapa.setBounds(340, 314, 60, 60);
            posicion6Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=8) {
            marcaMapa.setBounds(419, 329, 60, 60);
            posicion7Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=9) {
            marcaMapa.setBounds(483, 253, 60, 60);
            posicion8Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=10) {
            marcaMapa.setBounds(540, 182, 60, 60);
            posicion9Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=11) {
            marcaMapa.setBounds(596, 111, 60, 60);
            posicion10Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=12) {
            marcaMapa.setBounds(680, 67, 60, 60);
            posicion11Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=13) {
            marcaMapa.setBounds(732, 150, 60, 60);
            posicion12Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=14) {
            marcaMapa.setBounds(743, 234, 60, 60);
            posicion13Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=15) {
            marcaMapa.setBounds(814, 267, 60, 60);
            posicion14Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=16) {
            marcaMapa.setBounds(870, 196, 60, 60);
            posicion15Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=17) {
            marcaMapa.setBounds(889, 118, 60, 60);
            posicion16Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=18) {
            marcaMapa.setBounds(909, 11, 60, 60);
            posicion17Mapa.setVisible(true);
        }
        if(ventana.heroe.getExplorar()>=19) {
            marcaMapa.setVisible(false);
            posicion18Mapa.setVisible(true);
        }
    }

    public void combateAleatorio() {
        int aleatorio;
        if(ventana.heroe.getExplorar()>=2&&ventana.heroe.getExplorar()<5) {
            Ventana.origenADestino(ventana,"principal", "lucha", 0);
        }
        else if(ventana.heroe.getExplorar()>=5&&ventana.heroe.getExplorar()<9) {
            aleatorio= numeroAleatorio(0,1);
            Ventana.origenADestino(ventana,"principal", "lucha", aleatorio);
        }
        else if(ventana.heroe.getExplorar()>=9&&ventana.heroe.getExplorar()<12) {
            aleatorio= numeroAleatorio(0,2);
            Ventana.origenADestino(ventana,"principal", "lucha", aleatorio);
        }
        else if(ventana.heroe.getExplorar()>=12&&ventana.heroe.getExplorar()<16) {
            aleatorio= numeroAleatorio(0,3);
            Ventana.origenADestino(ventana,"principal", "lucha", aleatorio);
        }
        else if(ventana.heroe.getExplorar()>=16&&ventana.heroe.getExplorar()<19) {
            aleatorio= numeroAleatorio(0,4);
            Ventana.origenADestino(ventana,"principal", "lucha", aleatorio);
        }
    }

    public static int numeroAleatorio(int minimo,int maximo){
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }
}
	


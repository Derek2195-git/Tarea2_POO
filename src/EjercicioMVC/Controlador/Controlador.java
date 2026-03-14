package EjercicioMVC.Controlador;

import EjercicioMVC.Modelo.CatalogoMusica;
import EjercicioMVC.Modelo.Musica;
import EjercicioMVC.Vista.Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controlador {
    private Vista vista;
    private CatalogoMusica modelo;

    public Controlador(CatalogoMusica modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch(opcion) {
                case 1:
                    insertarNuevaMusica();
                    break;
                case 2:
                    mostrarMusica();
                    break;
                case 3:
                    mostrarCantidadPorGenero();
                    break;
                case 4:
                    recuperarCancionesPorGenero();
                    break;
                case 5:
                    obtenerPrecioColeccion();
                    break;
                case 6:
                    obtenerListaCantantes();
                    break;
                case 7:
                    mostrarTodasDeUnGenero();
                    break;
                case 8:
                    mostrarTodasDeUnCantante();
                    break;
                case 9:
                    borrarUnaMelodia();
                    break;
                case 10:
                    modificarUnaMelodia();
                    break;
                case 11:
                    consultarUnaMelodia();
                    break;
                case 12:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("La opción ingresada no existe, ingresala una opción de nuevo");
                    break;
            }
        } while (opcion != 12);
    }

    public void insertarNuevaMusica() {
        Musica musica = vista.capturarMusica();
        boolean bandera = modelo.agregarMelodia(musica);
        vista.exitoInsertar(bandera);
    }

    public void mostrarMusica() {
        String cadena = modelo.mostrarColeccion();
        vista.mostrarTodasLasMusicas(cadena);
    }


    public void mostrarCantidadPorGenero() {
        // String generoCancion = vista.leerCadena("genero");
        HashMap hm = modelo.cantidadGeneroMusicas();
        vista.mostrarHashMap(hm);

    }

    public void recuperarCancionesPorGenero() {
        HashSet hs = modelo.recuperarTodosLosGeneros();
        vista.mostrarHashSet(hs);
    }

    public void obtenerPrecioColeccion() {
        double valorMonetario = modelo.obtenerValorMonetario();
        vista.mostrarValorMonetario(valorMonetario);
    }

    public void obtenerListaCantantes() {
        HashMap cantantes = modelo.listaCantantes();
        vista.mostrarCantantes(cantantes);
    }

    public void mostrarTodasDeUnGenero() {
        String genero = vista.leerCadena("genero");
        ArrayList<Musica> canciones = modelo.obtenerCancionesUnGenero(genero);
        vista.mostrarCancionesUnGenero(canciones, genero);
    }

    public void mostrarTodasDeUnCantante() {
        String cantante = vista.leerCadena("cantante");
        ArrayList<Musica> canciones = modelo.obtenerMelodiasDeArtista(cantante);
        vista.mostrarCancionesUnArtista(canciones, cantante);
    }

    public void borrarUnaMelodia() {
        String nombreMelodia = vista.leerCadena("nombre de la melodia");
        boolean exitoDeLaEliminacion = modelo.eliminarMelodia(nombreMelodia);
        vista.mostrarExitoEliminacion(exitoDeLaEliminacion);
    }

    public void modificarUnaMelodia() {
        String nombreMelodiaAModificar = vista.leerCadena("nombre de la canción a modificar");
        if (modelo.comprobarSiExiste(nombreMelodiaAModificar)) {
            Musica cancionModificada = vista.capturarMusica();
            boolean exitoDeLaModificacion = modelo.modificarMelodia(nombreMelodiaAModificar, cancionModificada);
            vista.mostrarExitoModificacion(exitoDeLaModificacion);
        } else {
            vista.mostrarExitoModificacion(false);
        }

    }

    public void consultarUnaMelodia() {
        String nombreMelodiaConsultada = vista.leerCadena("nombre de la canción a consultar");
        Musica musicaConsultada = modelo.consultarUnaMelodia(nombreMelodiaConsultada);
        vista.mostrarCancionConsultada(musicaConsultada);
    }
}

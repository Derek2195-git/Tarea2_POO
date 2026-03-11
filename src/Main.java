import EjercicioMVC.Controlador.Controlador;
import EjercicioMVC.Modelo.CatalogoMusica;
import EjercicioMVC.Vista.Vista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    CatalogoMusica modelo = new CatalogoMusica();
    Vista vista = new Vista();

    System.out.println("Hello World!");
    Controlador controlador = new Controlador(modelo, vista);
    controlador.iniciar();

}

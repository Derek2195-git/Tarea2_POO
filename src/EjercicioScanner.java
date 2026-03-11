import java.util.Scanner;

public class EjercicioScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int numero1 = sc.nextInt();
        System.out.print("Ingrese otro numero: ");
        int numero2 = sc.nextInt();
        int resultado = numero1 + numero2;
        System.out.println("La suma de " + numero1 + " y " + numero2 + " es de: " + resultado);

        System.out.print("Vuelva a ingresar un numero: ");
        numero1 = sc.nextInt();
        System.out.print("Vuelva a ingresar otro numero: ");
        numero2 = sc.nextInt();

        String cadena = numero1 > numero2 ? numero1 + " es mayor que " + numero2 : numero2 + " es mayor que " + numero1;
        System.out.println(cadena);

        System.out.println("Ingrese un numero: ");
        int numeroTablaMultiplicar = sc.nextInt();
        for (int i = 1; i <= 12; i++) {
            System.out.println("El resultado de multiplicar "+i+" por "+numeroTablaMultiplicar+" es de: "+i*numeroTablaMultiplicar);
        }


    }
}

import java.util.Scanner;

public class EjemplosArrayList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        char gender = sc.next().charAt(0);
        int age = sc.nextInt();
        long mobileNo = sc.nextLong();
        double average = sc.nextDouble();
        // Imprima los valores para verificar si la entrada
        // fue obtenida correctamente
        System.out.println("Nombre: " + name);
        System.out.println("Genero: "+gender);
        System.out.println("Edad: "+age);
        System.out.println("Telefono: "+mobileNo);
        System.out.println("Promedio: "+average);

        String cadena = age>18?"es mayor de edad":"cabron que pedo";
        System.out.println(cadena);

    }

}

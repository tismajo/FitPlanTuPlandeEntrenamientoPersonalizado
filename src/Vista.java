import java.util.List;
import java.util.Scanner;

public class Vista {
    Controlador controlador = new Controlador();
    Scanner scn = new Scanner(System.in);

    public void desplegarMenu() {
            while (true) {
                System.out.println("\nM E N Ú"); // Esto tendrá que ser modificado más tarde porque se supone que deberías registrarte una vez
                System.out.println("Ingresa el número de opción: ");
                System.out.println("1. Registrar Usuario\n2. Iniciar sesión\n3. Registrar comida\n4. Calcular calorías\n5. Ejercicios\n0. Salir del programa"); 
                int opcion = scn.nextInt();
                switch (opcion) {
                    case 1:
                        controlador.creacionCSV();
                        controlador.agregarUsuario();
                        break;
                    case 2:
                        scn = new Scanner(System.in);
                        System.out.print("Ingrese su nombre de usuario: ");
                        String nombreUsuario = scn.nextLine();
                        System.out.print("Ingrse su contraseña: ");
                        String contraseña = scn.nextLine();
                        controlador.iniciarSesion(nombreUsuario, contraseña);
                        break;
                    case 3:
                        scn = new Scanner(System.in);
                        System.out.print("Ingresa el nombre del alimento: ");
                        String alimento = scn.nextLine();
                        controlador.registrarComida(alimento);
                        break;
                    case 4:
                        scn = new Scanner(System.in);
                        System.out.print("Ingresa la fecha a consultar: ");
                        String fecha = scn.nextLine();
                        controlador.calcularCalorias(fecha);
                        break;
                    case 5:
                        controlador.crearListadeEjerciciosCSV();
                        System.out.print("¿Qué te gustaría trabajar?\n1. Pierna\n2. Brazos\n3. Abdomen");
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida. \nPor favor, ingrese una opción válida.");
                        break;
                }
            }
    }
}

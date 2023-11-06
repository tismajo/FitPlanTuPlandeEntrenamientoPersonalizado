import java.util.List;
import java.util.Scanner;

public class Vista {
    Controlador controlador = new Controlador();
    Scanner scn = new Scanner(System.in);

    public void desplegarMenu() {
            while (true) {
                System.out.println("\nM E N Ú"); // Esto tendrá que ser modificado más tarde porque se supone que deberías registrarte una vez
                System.out.println("Ingresa el número de opción: ");
                System.out.println("1. Registrar Usuario\n2. Iniciar sesión\n3. Registrar comida\n4. Ingresar ingredientes\n5. Ejercicios\n0. Salir del programa"); 
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
                        break;
                    case 4:
                    controlador.crearVerificarCSVingredientes();
                    scn = new Scanner(System.in);
                    System.out.println("INGRESAR INGREDIENTE NUEVO\nIngrese lo solicitado a continuación");
                        System.out.print("Ingresa el nombre del ingrediente: ");
                        String nombre = scn.nextLine();
                        scn = new Scanner(System.in);
                        System.out.print("Ingrese la cantidad de porción del ingrediente (ya sea en ml o g): ");
                        double cantidad = scn.nextDouble();
                        System.out.print("Ingresa el número de calorias: ");
                        double calorias = scn.nextDouble();
                        controlador.agregarIngredientes(nombre, cantidad, calorias);
                        break;
                    case 5:
                    controlador.crearListadeEjerciciosCSV();
                        System.out.print("¿Qué te gustaría trabajar? ");
                        
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

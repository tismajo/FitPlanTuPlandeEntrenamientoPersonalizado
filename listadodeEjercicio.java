import java.util.Scanner;

public class CaloriasQuemadas {

    public static void main(String[] args) {
        // Mostrar la lista de ejercicios
        mostrarListaEjercicios();

        // Obtener la elección del usuario
        int opcion = obtenerOpcionUsuario("Ingrese el número correspondiente al ejercicio: ");

        // Duración del ejercicio en minutos
        int minutos = obtenerOpcionUsuario("Ingrese la cantidad de minutos que realizó el ejercicio: ");

        // Calorías quemadas según la elección del usuario y la duración del ejercicio
        double caloriasQuemadas = calcularCaloriasQuemadas(opcion, minutos);

        // Mostrar el resultado
        System.out.println("Calorías quemadas en " + minutos + " minutos: " + caloriasQuemadas);
    }

    // Mostrar la lista de ejercicios
    public static void mostrarListaEjercicios() {
        System.out.println("Indique el ejercicio que realizó:");
        System.out.println("1. Ciclismo");
        System.out.println("2. Calistenia");
        System.out.println("3. Caminar");
        System.out.println("4. Trotar");
        System.out.println("5. Pesas");
        System.out.println("6. Maquina de escaleras");
        System.out.println("7. Maquina de remo");
        System.out.println("8. Aerobicos");
        System.out.println("9. Yoga");
        System.out.println("10. Baile");
        System.out.println("11. Correr");
        System.out.println("12. Jugar Baloncesto");
        System.out.println("13. Artes Marciales");
        System.out.println("14. Boxeo");
    }

    // Obtener la elección del usuario
    public static int obtenerOpcionUsuario(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        int opcion = scanner.nextInt();
        // No cerramos el scanner aquí
        return opcion;
    }

    // Calcular las calorías quemadas según la elección del usuario y la duración del ejercicio
    public static double calcularCaloriasQuemadas(int opcion, int minutos) {
        double caloriasBase = obtenerCaloriasQuemadas(opcion);
        return (caloriasBase * minutos) / 60.0; // Calcular las calorías en función de los minutos
    }

    // Obtener las calorías quemadas según la elección del usuario
    public static int obtenerCaloriasQuemadas(int opcion) {
        switch (opcion) {
            case 1: return 502;
            case 2: return 472;
            case 3: return 236;
            case 4: return 372;
            case 5: return 354;
            case 6: return 531;
            case 7: return 708;
            case 8: return 413;
            case 9: return 236;
            case 10: return 266;
            case 11: return 472;
            case 12: return 354;
            case 13: return 590;
            case 14: return 708;
            default: return 0; // Valor predeterminado si la elección no es válida
        }
    }
}
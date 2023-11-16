import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    Scanner scn = new Scanner(System.in);
    public void creacionCSV(){ // Creación de un archivo CSV que permita almacenar los datos de los usuarios
        File enclosuresArchive = new File("datosUsuarios.csv");

        if (!enclosuresArchive.exists()){
            try {
                enclosuresArchive.createNewFile();
                System.out.println("Archivo de datosUsuarios.csv creado");
            } catch (IOException e) {
                System.out.println("Error encontrado" + e.getMessage());
            }
        }
    }

    public void comidasRegistradasCrearCSV(String usuario){
        File registroComida = new File("comidasRegistradasCSV.csv");
        if (!registroComida.exists()) {
            try {
                registroComida.createNewFile();
                System.out.println("Archivo ausente, se ha creado un nuevo archivo...");
    
                FileWriter fw = new FileWriter(registroComida);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Alimento,Medida,Gramos,Calorías,Proteína,Grasa,Grasa saturada,Fibra,Carbohidratos,Categoría,Fecha"); 
                bw.newLine();
                bw.close();
    
            } catch (IOException e) {
                System.out.println("Error encontrado: " + e.getMessage());
            }
        }
    }

    public void crearListadeEjerciciosCSV(){
        File listaEjercicios = new File("listadeEjercicios.csv");
        if (!listaEjercicios.exists()) {
            try {
                listaEjercicios.createNewFile();
                System.out.println("Archivo ausente, se ha creado un nuevo archivo...");
    
                FileWriter fw = new FileWriter(listaEjercicios);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Nombre del ejercicio,Duración,Total de Calorias Quemadas"); 
                bw.newLine();
                bw.close();
    
            } catch (IOException e) {
                System.out.println("Error encontrado: " + e.getMessage());
            }
        }
    }

    public void agregarUsuario(){ // El método para ir agregando a los usuarios
        String archivoCSV = "datosUsuarios.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV, true))) {
            System.out.println("Le damos la bienvenida. \nPor favor ingresar los datos que se le solicitan: ");
            System.out.print("Ingrese nombre de usuario: ");
            String nombreUsuario = scn.nextLine();
            System.out.print("Ingresa la contraseña: ");
            String contraseñaUsuario = scn.nextLine();
            writer.write(nombreUsuario + "," + contraseñaUsuario);
            writer.newLine();
            System.out.println("\nTe hemos registrado con éxito, " + nombreUsuario);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

    public void iniciarSesion(String nombreUsuario, String contraseña){
        String archivoCSV = "datosUsuarios.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");

                if (columnas.length >= 2 && columnas[0].equals(nombreUsuario) && columnas[1].equals(contraseña)) {
                    System.out.println("INICIO DE SESIÓN CORRECTO.\nTe damos la bienvenida de vuelta, " + nombreUsuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarComida(String Alimento, String Medida, double Gramos, double Calorías, double Proteína, double Grasa, double Grasasaturada, double Fibra, double Carbohidratos, String categoria){
        String archivoCSV = "archivoCSVnutrientes.csv";
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivoCSV, true))){
            wr.write(Alimento + "," + Medida + "," + Gramos + "," + Calorías + "," + Proteína + "," + Grasa +"," + Grasasaturada + "," + Fibra + "," + Carbohidratos + "," + categoria
            );
            System.out.println("La comida : '" + Alimento + "' se ha agregado con éxito");
            wr.newLine();
        } catch(IOException e){
            System.out.println("Error al ingresar datos: " + e.getMessage());
        }
    }

    public void registrarComida(String alimento) {
        String archivoCSVnutrientes = "archivoCSVnutrientes.csv";
        String archivoCSVRegistro = "registroComidaCSV.csv";
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSVnutrientes));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSVRegistro, true))) {
            scn = new Scanner(System.in);
            System.out.print("Ingrese una fecha (formato dd/MM/yyyy): ");
            String fechaIngresada = scn.nextLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String columnValue = fields[0];

                if (columnValue.equalsIgnoreCase(alimento)) {
                    writer.write(line + "," + fechaIngresada);
                    writer.newLine();
                    encontrado = true;
                }
            }
        if (!encontrado) {
            String archivo = "archivoCSVnutrientes.csv";
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                System.out.print("Ingrese el nombre del alimento: ");
                String alimentoNOmbre = scn.nextLine();
                System.out.print("Ingresa la medida (en taza, oz, qt...): ");
                String medidaIngresada = scn.nextLine();
                scn = new Scanner(System.in);
                System.out.print("Ingresa la cantidad de gramos: ");
                int gramos = scn.nextInt();
                System.out.print("Ingresa la cantidad de calorías: ");
                int caloriasIngresadas = scn.nextInt();
                System.out.print("Ingresa la cantidad de proteína: ");
                int cantidadProteina = scn.nextInt();
                System.out.print("Ingresa la cantidad de grasas: ");
                int grasasIngresadas = scn.nextInt();
                bw.write(alimentoNOmbre + "," + medidaIngresada + "," + gramos+ "," + caloriasIngresadas + "," + cantidadProteina + ","+ grasasIngresadas + "," + "Alimento,Medida,Gramos,Calorías,Proteína,Grasa,Grasa saturada,Fibra,Carbohidratos,Categoría,Fecha\r\n"); 
                bw.newLine();
                bw.close();
    
            } catch (IOException e) {
                System.out.println("Error encontrado: " + e.getMessage());
            }
        }
            if (!encontrado) {
                System.out.print("No se ha encontrado el alimento, espere a una actualización.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calcularCalorias(String fecha){
        String archivoCSV = "registroComidaCSV.csv";
        String datoBuscado = fecha;
        int columnaBuscada = 10;
        int columnaSuma = 3; 
        double suma = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > columnaBuscada && fields.length > columnaSuma) {
                    String valorBuscado = fields[columnaBuscada];

                    if (valorBuscado.equalsIgnoreCase(datoBuscado)) {
                        double valorSuma = Double.parseDouble(fields[columnaSuma]);
                        suma += valorSuma;
                    }
                }
            }

            System.out.println("El total de calorías en esta fecha es: " + suma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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

    public void ejercicio(){
        // Mostrar la lista de ejercicios
        mostrarListaEjercicios();

        // Obtener la elección del usuario
        int opcion = obtenerOpcionUsuario("Ingrese el número correspondiente al ejercicio: ");

        // Obtener la duración del ejercicio en minutos
        int minutos = obtenerOpcionUsuario("Ingrese la cantidad de minutos que realizó el ejercicio: ");

        // Calcular las calorías quemadas según la elección del usuario y la duración del ejercicio
        double caloriasQuemadas = calcularCaloriasQuemadas(opcion, minutos);

        // Mostrar el resultado
        System.out.println("Calorías quemadas en " + minutos + " minutos: " + caloriasQuemadas);
    }
        
            // Método para mostrar la lista de ejercicios
        
        
            // Método para obtener la elección del usuario
    public static int obtenerOpcionUsuario(String mensaje) {
        Scanner scn = new Scanner(System.in);
        System.out.print(mensaje);
        int opcion = scn.nextInt();
        // No cerramos el scanner aquí
        return opcion;
    }
        
    // Método para calcular las calorías quemadas según la elección del usuario y la duración del ejercicio
    public static double calcularCaloriasQuemadas(int opcion, int minutos) {
        double caloriasBase = obtenerCaloriasQuemadas(opcion);
        return (caloriasBase * minutos) / 60.0; // Calcular las calorías en función de los minutos
    }
        
    // Método para obtener las calorías quemadas según la elección del usuario
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
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
                System.out.print("No se ha encontrado el alimento, por favor ingresarlo.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calcularCalorias(String fecha){
        String archivoCSV = "registroComidaCSV.csv";
        String datoBuscado = fecha;
        int columnaBuscada = 10; // Columna 11 (índice 10)
        int columnaSuma = 3; // Columna 3 (índice 2)
        double suma = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > columnaBuscada && fields.length > columnaSuma) {
                    String valorBuscado = fields[columnaBuscada];

                    if (valorBuscado.equals(datoBuscado)) {
                        double valorSuma = Double.parseDouble(fields[columnaSuma]);
                        suma += valorSuma;
                    }
                }
            }

            System.out.println("La suma de los elementos de la tercera columna es: " + suma);
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
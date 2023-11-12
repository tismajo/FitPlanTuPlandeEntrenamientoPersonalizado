import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void agregarComida(String Alimento, String Medida, double Gramos, double Calorías, double Proteína, double Grasa, double Grasasaturada, double Fibra, double Carbohidratos, String Categoria){
        String archivoCSV = "archivoCSVnutrientes.csv";
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivoCSV, true))){
            wr.write(Alimento + "," + Medida + "," + Gramos + "," + Calorías + "," + Proteína + "," + Grasa +"," + Grasasaturada + "," + Fibra + "," + Carbohidratos + "," + Categoria
            );
            System.out.println("La comida : '" + Alimento + "' se ha agregado con éxito");
            wr.newLine();
        } catch(IOException e){
            System.out.println("Error al ingresar datos: " + e.getMessage());
        }
    }

    public void registrarComida(String alimento){
        String archivoCSVnutrientes = "archivoCSVnutrientes.csv";
        String archivoCSVRegistro = "registroComidaCSV.csv";
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSVnutrientes));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSVRegistro))) {
                
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String columnValue = fields[0];

                if (columnValue.equals(alimento)) {
                    writer.write(line);
                    writer.newLine();
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Ingresar nuevo alimento");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

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

    public void crearVerificarCSVingredientes() {
        File registroIngrediente = new File("ingredientesCaloriasCSV.csv");
        if (!registroIngrediente.exists()) {
            try {
                registroIngrediente.createNewFile();
                System.out.println("Archivo ausente, se ha creado un nuevo archivo...");
    
                // Agregar títulos en la primera fila del archivo CSV
                FileWriter fw = new FileWriter(registroIngrediente);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Nombre,Cantidad,Calorias"); 
                bw.newLine();
                bw.close();
    
            } catch (IOException e) {
                System.out.println("Error encontrado: " + e.getMessage());
            }
        }
    }

    public void comidasRegistradasCrearCSV(){
        File registroComida = new File("comidasRegistradasCSV.csv");
        if (!registroComida.exists()) {
            try {
                registroComida.createNewFile();
                System.out.println("Archivo ausente, se ha creado un nuevo archivo...");
    
                FileWriter fw = new FileWriter(registroComida);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Nombre,Ingredientes,Total de Calorias"); 
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

            System.out.println("\nTe hemos registrado con éxito.");

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

    public void agregarIngredientes(String nombre, double cantidad, double calorias){
        String archivoCSV = "ingredientesCaloriasCSV.csv";
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivoCSV, true))){
            wr.write(nombre + "," + cantidad + "," + calorias);
            System.out.println("El ingrediente: '" + nombre + "' se ha agregado con éxito");
            wr.newLine();
        } catch(IOException e){
            System.out.println("Error al ingresar datos: " + e.getMessage());
        }
    }

    public void ingresarComdia(){
        
    }
    }

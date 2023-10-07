import java.io.File;
import java.io.IOException;

public class Controlador {
    public void creationVerificationCSV(){
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
}

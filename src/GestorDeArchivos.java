import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestorDeArchivos {

    public static void guardarMascota(String cedula, String nombreDueño, String nombreMascota, String especie, String historia) {
        try {
            File archivo = new File(cedula + ".txt");
            boolean archivoExiste = archivo.exists();

            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));

            if (!archivoExiste) {
                writer.write("Dueño: " + nombreDueño + " - Cédula: " + cedula + "\n");
            }

            writer.write("\nMascota:\n");
            writer.write("Nombre: " + nombreMascota + "\n");
            writer.write("Especie: " + especie + "\n");
            writer.write("Historia: " + historia + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import com.opencsv.CSVWriter;
import java.io.*;
import java.util.List;

public class OpenCsvWriter {
  /*  OpenCsvWriter(List<EdicionColeccionista> edicionColeccionistas, File file){
        CSVWriter csvWriter;
        String[] entries =  new String[4];
        for (EdicionColeccionista ec: edicionColeccionistas) {
            entries[0]=(ec.numero);
            entries[1]=(ec.nombre);
            entries[2]=(ec.imagen);
            entries[3]=(ec.año);
            entries[4]=(ec.variantes);
            entries[3]=(ec.coleccion);

            try {
                csvWriter = new CSVWriter(new FileWriter(file, true));
                csvWriter.writeNext(entries);
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ruta del archivo " + file.getPath());
    }*/
}
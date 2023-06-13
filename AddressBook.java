/**
 * Package: address_data
 * 
 * Esta clase representa una libreta de direcciones. Permite agregar, eliminar, buscar y mostrar entradas de la libreta.
 */
package address_data;

import address_data.AddressEntry;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class AddressBook {
    private List<AddressEntry> entries;
    private String filePath;

    /**
     * Constructor de la clase AddressBook.
     * Inicializa la lista de entradas y establece la ruta del archivo de la
     * libreta.
     * Carga las entradas existentes desde el archivo.
     * 
     * @param filePath Ruta del archivo de la libreta de direcciones
     */
    public AddressBook(String filePath) {
        entries = new ArrayList<>();
        this.filePath = filePath;
        loadEntriesFromFile();
    }

    /**
     * Agrega una entrada a la libreta de direcciones.
     * Si la entrada ya existe (basado en el nombre y apellido), muestra un mensaje
     * de error.
     * Guarda la entrada en la lista y actualiza el archivo.
     * 
     * @param entry La entrada a agregar
     */
    public void addEntry(AddressEntry entry) {
        if (NoDuplicado(entry)) {
            System.out.println("........................................");
            System.out.println("Este contacto ya ha sido dado de alta");
            System.out.println("........................................");
        } else {
            entries.add(entry);
            cargaEntriesFile();
            System.out.println("................................");
            System.out.println(" Contacto Guardado Exitosamente");
            System.out.println("................................");
        }
    }

    /**
     * Verifica si una entrada ya existe en la libreta de direcciones.
     * Comprueba si hay una entrada con el mismo nombre y apellido.
     * 
     * @param entry La entrada a verificar
     * @return true si la entrada ya existe, false de lo contrario
     */
    private boolean NoDuplicado(AddressEntry entry) {
        for (AddressEntry existingEntry : entries) {
            if (existingEntry.getNombre().equals(entry.getNombre())
                    && existingEntry.getApellido().equals(entry.getApellido())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una entrada de la libreta de direcciones.
     * Elimina la entrada de la lista y actualiza el archivo.
     * 
     * @param entry La entrada a eliminar
     */
    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
        cargaEntriesFile();
        System.out.println("Se ha eliminado correctamente");
    }

    /**
     * Busca entradas en la libreta de direcciones por apellido.
     * Compara el inicio del apellido con la cadena proporcionada.
     * 
     * @param Apellido El inicio del apellido a buscar
     * @return Una lista de entradas coincidentes encontradas
     */
    public List<AddressEntry> searchEntriesByApellido(String Apellido) {
        List<AddressEntry> searchResults = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getApellido().startsWith(Apellido, 0)) {
                searchResults.add(entry);
            }
        }
        return searchResults;
    }

    /**
     * Devuelve todas las entradas en la libreta de direcciones.
     * 
     * @return Una lista de todas las entradas en la libreta
     */
    public List<AddressEntry> getAllEntries() {
        return entries;
    }

    /**
     * Carga las entradas existentes desde el archivo de la libreta de direcciones.
     * Lee cada línea del archivo, crea una entrada y la agrega a la lista.
     */
    private void loadEntriesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                AddressEntry entry = createAddressEntryFromString(line);
                if (entry != null) {
                    entries.add(entry);
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error en los datos de la libreria");
        }
    }

    /**
     * Actualiza el archivo de la libreta de direcciones con las entradas actuales.
     * Escribe cada entrada en el archivo, separando los campos por comas.
     */
    private void cargaEntriesFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (AddressEntry entry : entries) {
                writer.write(entryToString(entry));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de la libreta de direcciones en el archivo.");
        }
    }

    /**
     * Crea una entrada de dirección a partir de una cadena.
     * Divide la cadena en partes utilizando la coma como separador.
     * 
     * @param line La cadena que representa una entrada
     * @return La entrada de dirección creada a partir de la cadena, o null si la
     *         cadena no es válida
     */
    private AddressEntry createAddressEntryFromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 8) {
            String Nombre = parts[0];
            String Apellido = parts[1];
            String Calle = parts[2];
            String Ciudad = parts[3];
            String Estado = parts[4];
            String codigoPostal = parts[5];
            String email = parts[6];
            String Telefono = parts[7];
            return new AddressEntry(Nombre, Apellido, Calle, Ciudad, Estado, codigoPostal, email, Telefono);
        }
        return null;
    }

    /**
     * Convierte una entrada de dirección en una cadena.
     * Concatena los campos de la entrada, separados por comas.
     * 
     * @param entry La entrada de dirección a convertir en cadena
     * @return La cadena que representa la entrada de dirección
     */
    private String entryToString(AddressEntry entry) {
        return entry.getNombre() + "," + entry.getApellido() + "," + entry.getCalle() + ","
                + entry.getCiudad() + "," + entry.getEstado() + "," + entry.getCodigoPostal() + ","
                + entry.getEmail() + "," + entry.getTelefono();
    }
}

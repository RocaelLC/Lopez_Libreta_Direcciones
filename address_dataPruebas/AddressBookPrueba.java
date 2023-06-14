package address_data;

public class AddressBookPrueba {

    /**
     * Clase de prueba para la clase AddressBook.
     */
    public static void main(String[] args) {
        // Crea una instancia de AddressBook con el archivo "libreta_direcciones.txt"
        AddressBook addressBook = new AddressBook("libreta.txt");

        // Crea una nueva entrada de dirección
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "City1", "State1", "12345", "john@example.com", "123-456-7890");
        // Agrega la entrada a la libreta de direcciones
        addressBook.addEntry(entry1);

        // Crea otra entrada de dirección
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Elm St", "City2", "State2", "67890", "jane@example.com", "987-654-3210");
        // Agrega la entrada a la libreta de direcciones
        addressBook.addEntry(entry2);

        // Crea una tercera entrada de dirección con el mismo nombre y apellido que entry1
        AddressEntry entry3 = new AddressEntry("John", "Doe", "789 Oak St", "City3", "State3", "54321", "john.doe@example.com", "456-789-0123");
        // Intenta agregar la entrada a la libreta de direcciones (se mostrará un mensaje de error)
        addressBook.addEntry(entry3);

        // Imprime la lista de todas las entradas en la libreta de direcciones
        System.out.println("Lista de entradas en la libreta de direcciones:");
        for (AddressEntry entry : addressBook.getAllEntries()) {
            System.out.println(entryToString(entry));
        }

        // Realiza una búsqueda en la libreta de direcciones por apellido
        String apellidoBusqueda = "Doe";
        System.out.println("Resultados de búsqueda por apellido: " + apellidoBusqueda);
        for (AddressEntry entry : addressBook.searchEntriesByApellido(apellidoBusqueda)) {
            System.out.println(entryToString(entry));
        }

        // Elimina una entrada de la libreta de direcciones
        addressBook.removeEntry(entry2);

        // Imprime la lista de entradas en la libreta de direcciones después de eliminar una entrada
        System.out.println("Lista de entradas en la libreta de direcciones después de eliminar una entrada:");
        for (AddressEntry entry : addressBook.getAllEntries()) {
            System.out.println(entryToString(entry));
        }
    }

    /**
     * Convierte una entrada de dirección en una cadena formateada para su impresión.
     * 
     * @param entry La entrada de dirección a convertir en cadena
     * @return La cadena formateada que representa la entrada de dirección
     */
    private static String entryToString(AddressEntry entry) {
        return "Nombre: " + entry.getNombre() +
                ", Apellido: " + entry.getApellido() +
                ", Calle: " + entry.getCalle() +
                ", Ciudad: " + entry.getCiudad() +
                ", Estado: " + entry.getEstado() +
                ", Código Postal: " + entry.getCodigoPostal() +
                ", Email: " + entry.getEmail() +
                ", Teléfono: " + entry.getTelefono();
    }
}

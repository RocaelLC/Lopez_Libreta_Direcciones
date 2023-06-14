/**
 * Package: address_data
 * 
 * Esta clase representa una aplicación de Libreta de Direcciones.
 * Permite agregar, eliminar, buscar y mostrar entradas de la libreta.
 */
package address_data;

import java.util.List;
import java.util.Scanner;

public class AddressBookApplication {
    private AddressBook addressBook;
    private Scanner scanner;

    /**
     * Constructor de la clase AddressBookApplication.
     * Inicializa la dirección de la libreta y el objeto Scanner.
     */
    public AddressBookApplication() {
        String filePath = "K:/Proyecto/libreta.txt"; // Ruta del archivo TXT
        addressBook = new AddressBook(filePath);
        scanner = new Scanner(System.in);
    }

    /**
     * Ejecuta la aplicación de la libreta de direcciones.
     * Muestra un menú y solicita la selección del usuario hasta que elija salir.
     */
    public void run() {
        Menu menu = new Menu();
        boolean exit = false;

        while (!exit) {
            menu.displayMenu();
            String choice = menu.getUserChoice();

            switch (choice) {
                case "1":
                    addEntry();
                    break;
                case "2":
                    removeEntry();
                    break;
                case "3":
                    searchEntries();
                    break;
                case "4":
                    displayEntries();
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    /**
     * Agrega una nueva entrada a la libreta de direcciones.
     * Solicita al usuario ingresar los detalles de la entrada y la agrega a la libreta.
     */
    private void addEntry() {
        System.out.println("Ingrese los detalles de la entrada:");
        System.out.print("Nombre: ");
        String Nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String Apellido = scanner.nextLine();
        System.out.print("Calle: ");
        String Calle = scanner.nextLine();
        System.out.print("Ciudad: ");
        String Ciudad = scanner.nextLine();
        System.out.print("Estado: ");
        String Estado = scanner.nextLine();
        System.out.print("Código postal: ");
        String codigoPostal = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String Telefono = scanner.nextLine();

        AddressEntry entry = new AddressEntry(Nombre, Apellido, Calle, Ciudad, Estado,
                codigoPostal, email, Telefono);
        addressBook.addEntry(entry);
    }

    /**
     * Elimina una entrada de la libreta de direcciones.
     * Solicita al usuario ingresar el apellido de la entrada a eliminar y realiza la eliminación.
     */
    private void removeEntry() {
        System.out.println("Ingrese el apellido de la entrada a eliminar:");
        String Apellido = scanner.nextLine();
        List<AddressEntry> searchResults = addressBook.searchEntriesByApellido(Apellido);
        if (!searchResults.isEmpty()) {
            System.out.println("Se encontraron las siguientes entradas:");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }
            System.out.print("Selecciona el número de la entrada a eliminar: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= searchResults.size()) {
                AddressEntry entryToRemove = searchResults.get(choice - 1);
                addressBook.removeEntry(entryToRemove);
            } else {
                System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("No se encontraron entradas con ese apellido.");
        }
    }

    /**
     * Busca entradas en la libreta de direcciones por el inicio del apellido.
     * Solicita al usuario ingresar el inicio del apellido y muestra los resultados.
     */
    private void searchEntries() {
        System.out.println("Ingrese el inicio del apellido para buscar:");
        String Apellido = scanner.nextLine();
        List<AddressEntry> searchResults = addressBook.searchEntriesByApellido(Apellido);
        if (!searchResults.isEmpty()) {
            System.out.println("Se encontraron las siguientes entradas:");
            for (AddressEntry entry : searchResults) {
                System.out.println(entry);
                System.out.println("---------------");
            }
        } else {
            System.out.println("No se encontraron entradas con ese apellido.");
        }
    }

    /**
     * Muestra todas las entradas de la libreta de direcciones.
     * Si la libreta no contiene entradas, muestra un mensaje indicando que está vacía.
     */
    private void displayEntries() {
        List<AddressEntry> entries = addressBook.getAllEntries();
        if (!entries.isEmpty()) {
            System.out.println("Lista de entradas:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
                System.out.println("---------------");
            }
        } else {
            System.out.println("La libreta de direcciones está vacía.");
        }
    }

    /**
     * Método principal que inicia la aplicación de la libreta de direcciones.
     */
    public static void main(String[] args) {
        AddressBookApplication application = new AddressBookApplication();
        application.run();
    }
}
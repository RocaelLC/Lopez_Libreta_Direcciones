package address_data;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú de opciones al usuario.
     */
    public void displayMenu() {
        System.out.println("...........Bienvenido..........");
        System.out.println(".................................");
        System.out.println("      1. Agregar");
        System.out.println("      2. Eliminar Contacto");
        System.out.println("      3. Buscar Contacto");
        System.out.println("      4. Mostrar Contacto");
        System.out.println("      5. Salir");
        System.out.println("..................................");
    }

    /**
     * Obtiene la opción elegida por el usuario.
     *
     * @return La opción elegida como una cadena de texto.
     */
    public String getUserChoice() {
        System.out.print("¿Elige la opción a realizar?: ");
        return scanner.nextLine();
    }
}

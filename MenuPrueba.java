package address_data;

import java.util.Scanner;

public class MenuPrueba {

    /**
     * El método principal que se ejecuta al iniciar la aplicación de prueba.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso)
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase Menu
        Menu menu = new Menu();

        // Mostrar el menú al usuario
        menu.displayMenu();

        // Obtener la opción elegida por el usuario
        String choice = menu.getUserChoice();

        // Imprimir la opción elegida por el usuario
        System.out.println("Opción elegida: " + choice);
    }
}

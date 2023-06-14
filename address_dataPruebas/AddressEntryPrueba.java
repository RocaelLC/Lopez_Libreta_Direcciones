package address_data;

public class AddressEntryPrueba {

    /**
     * El método principal que se ejecuta al iniciar la aplicación de prueba.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso)
     */
    public static void main(String[] args) {
        // Crear una instancia de AddressEntry con datos de ejemplo
        AddressEntry entry = new AddressEntry("Juan", "Ruiz", "Juan osorio",
                "Coatzacoalcos ", "Veracruz", "96386", "juan.doe@gmail.com", "59212334377");

        // Imprimir la representación en forma de cadena de la entrada de dirección
        System.out.println("Información de la entrada de dirección:");
        System.out.println(entry);

        // Acceder a los atributos individuales de la entrada de dirección utilizando los métodos getter
        System.out.println("Nombre: " + entry.getNombre());
        System.out.println("Apellido: " + entry.getApellido());
        System.out.println("Calle: " + entry.getCalle());
        System.out.println("Ciudad: " + entry.getCiudad());
        System.out.println("Estado: " + entry.getEstado());
        System.out.println("Código Postal: " + entry.getCodigoPostal());
        System.out.println("Email: " + entry.getEmail());
        System.out.println("Teléfono: " + entry.getTelefono());
    }
}

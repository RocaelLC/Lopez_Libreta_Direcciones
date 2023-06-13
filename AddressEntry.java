package address_data;

public class AddressEntry {
    private String Nombre;
    private String Apellido;
    private String Calle;
    private String Ciudad;
    private String Estado;
    private String CodigoPostal;
    private String Email;
    private String Telefono;

    /**
     * Constructor de la clase AddressEntry.
     *
     * @param Nombre        El nombre del contacto.
     * @param Apellido      El apellido del contacto.
     * @param Calle         La calle del contacto.
     * @param Ciudad        La ciudad del contacto.
     * @param Estado        El estado del contacto.
     * @param CodigoPostal  El código postal del contacto.
     * @param Email         El correo electrónico del contacto.
     * @param Telefono      El número de teléfono del contacto.
     */
    public AddressEntry(String Nombre, String Apellido, String Calle,
            String Ciudad, String Estado, String CodigoPostal, String Email, String Telefono) {

        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Calle = Calle;
        this.Ciudad = Ciudad;
        this.Estado = Estado;
        this.CodigoPostal = CodigoPostal;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    /**
     * Devuelve una representación en forma de cadena de la entrada de dirección.
     *
     * @return La representación en forma de cadena de la entrada de dirección.
     */
    @Override
    public String toString() {
        return "Nombre: " + Nombre + " " + Apellido + "\n" +
                "Dirección: " + Calle + ", " + Ciudad + ", " + Estado + ", " + CodigoPostal + "\n" +
                "Email: " + Email + "\n" +
                "Número de Teléfono: " + Telefono;
    }

    // Métodos getter para acceder a los atributos privados de la clase

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCalle() {
        return Calle;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelefono() {
        return Telefono;
    }
}

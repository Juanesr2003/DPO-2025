package uniandes.dpoo.aerolinea.modelo.cliente;

/**
 * Representa a un cliente de tipo natural dentro del sistema de la aerolínea.
 */
public class ClienteNatural extends Cliente {
    /**
     * Constante que define el tipo de cliente natural
     */
    public static final String NATURAL = "Natural";

    /**
     * Nombre asociado al cliente natural
     */
    private String nombre; 

    /**
     * Crea una instancia de un cliente natural asignándole un nombre
     * @param nombre Nombre del cliente
     */
    public ClienteNatural(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Retorna un identificador único para el cliente, basado en su nombre
     * @return Nombre del cliente como identificador
     */
    public String getIdentificador()
    {
        return nombre != null ? nombre.trim() : ""; 
    }
    
    /**
     * Obtiene el tipo de cliente al que pertenece esta instancia
     * @return Tipo de cliente en formato de cadena
     */
    public String getTipoCliente()
    {
        return NATURAL;
    }
}
package uniandes.dpoo.aerolinea.modelo;

/**
 * Representa un avión con un nombre identificador y una capacidad de pasajeros.
 */
public class Avion {
	   /**
     * Nombre del avión.
     */
    private String nombre;
    
    /**
     * Capacidad máxima de pasajeros que el avión puede transportar.
     */
    private int capacidad;

    /**
     * Crea un nuevo avión con el nombre y la capacidad especificados.
     *
     * @param nombre    Identificador del avión.
     * @param capacidad Número máximo de pasajeros que puede transportar.
     */
    public Avion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // ************************************************************************************
    //
    // Métodos getters.
    //
    // ************************************************************************************

    /**
     * Obtiene el nombre del avión.
     *
     * @return Nombre del avión.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la capacidad del avión.
     *
     * @return Capacidad máxima del avión.
     */
    public int getCapacidad() {
        return capacidad;
    }
}

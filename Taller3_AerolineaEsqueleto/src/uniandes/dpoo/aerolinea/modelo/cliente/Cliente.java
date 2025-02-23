package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/*
 * Representa la clase de referencia para los clientes corporativos y naturales
 */
public abstract class Cliente {
    /**
     * Lista de tiquetes comprados por el cliente que aún no han sido utilizados.
     */
    private List<Tiquete> tiquetesSinUsar = new ArrayList();

    /**
     * Lista de tiquetes que el cliente ya ha utilizado.
     */
    private List<Tiquete> tiquetesUsados = new ArrayList();

    /**
     * Constructor que inicializa un nuevo cliente sin asignarle tiquetes inicialmente.
     */
    public Cliente() {
        
    }

    // ************************************************************************************
    //
    // Métodos relacionados con la gestión de los atributos del cliente.
    //
    // ************************************************************************************

    /**
     * Obtiene el tipo de cliente.
     *
     * @return Tipo de cliente como una cadena de texto.
     */
    public abstract String getTipoCliente();

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return Identificador del cliente.
     */
    public abstract String getIdentificador();

    /**
     * Agrega un nuevo tiquete a la lista de tiquetes sin usar del cliente.
     *
     * @param tiquete Tiquete que será agregado a la lista de tiquetes sin utilizar.
     */
    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }

    /**
     * Calcula el valor total de todos los tiquetes comprados por el cliente que aún no han sido utilizados.
     *
     * @return Suma total del valor de los tiquetes sin usar.
     */
    public int calcularValorTotalTiquetes() {
        int Total = 0;
        for (Tiquete tiquete : tiquetesSinUsar) {
           Total += tiquete.getTarifa();
        }
        return Total;
    }

    /**
     * Marca como usados los tiquetes asociados al vuelo especificado, 
     * moviéndolos de la lista de tiquetes sin usar a la lista de tiquetes usados.
     *
     * @param vuelo Vuelo para el cual se actualizará el estado de los tiquetes.
     */
    public void usarTiquetes​(Vuelo vuelo) {
    	Iterator<Tiquete> iterator = tiquetesSinUsar.iterator();
    	boolean encontrado = false;

    	while (iterator.hasNext() && !encontrado) {
    	    Tiquete tiquete = iterator.next();
    	    if (tiquete.getVuelo() == vuelo) {
    	        iterator.remove(); // Elimina de la lista de manera segura
    	        tiquetesUsados.add(tiquete);
    	        encontrado = true; // Detiene el while sin usar break
    	    }
    	}
}
}

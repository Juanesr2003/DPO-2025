package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Representa un objeto de tiqeute para un vuelo
 */
public class Tiquete {
	/**
     * Cliente que compró el tiquete.
     */
    private Cliente cliente; 

    /**
     * Código único que identifica el tiquete.
     */
    private String codigo; 

    /**
     * Valor pagado por el cliente por este tiquete.
     */
    private int tarifa; 

    /**
     * Indica si el tiquete ha sido utilizado.
     */
    private boolean usado; 

    /**
     * Vuelo en el que se utilizará el tiquete.
     */
    private Vuelo vuelo;

    /**
     * Crea un nuevo tiquete con los datos especificados y lo asocia al cliente que lo adquirió.
     *
     * @param codigo           Código único del tiquete.
     * @param vuelo            Vuelo en el que se utilizará el tiquete.
     * @param clienteComprador Cliente que compró el tiquete.
     * @param tarifa           Valor pagado por el tiquete.
     */
    public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
        this.cliente = clienteComprador;
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.vuelo = vuelo;
    }

    // ************************************************************************************
    //
    // Métodos de acceso y manipulación de los atributos del tiquete.
    //
    // ************************************************************************************

    /**
     * Obtiene el cliente que adquirió el tiquete.
     *
     * @return Cliente que compró el tiquete.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene el vuelo al que está asociado el tiquete.
     *
     * @return Vuelo del tiquete.
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**
     * Obtiene el código único del tiquete.
     *
     * @return Código del tiquete.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el costo del tiquete.
     *
     * @return Tarifa del tiquete.
     */
    public int getTarifa() {
        return tarifa;
    }

    /**
     * Marca el tiquete como utilizado.
     */
    public void marcarComoUsado() {
        usado = true;
    }

    /**
     * Verifica si el tiquete ya ha sido utilizado.
     *
     * @return {@code true} si el tiquete ha sido usado, de lo contrario {@code false}.
     */
    public boolean esUsado() {
        return usado;
    }
}
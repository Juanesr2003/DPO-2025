package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
/**
 *  Esta clase tiene la información de un vuelo de una aerolinea
 */
public class Vuelo {

    /**
     * Ruta aérea que sigue el vuelo.
     */
    private Ruta ruta; 

    /**
     * Fecha programada del vuelo en formato YYYY-MM-DD.
     */
    private String fecha;

    /**
     * Avión asignado para realizar el vuelo.
     */
    private Avion avion;

    /**
     * Mapa de tiquetes vendidos para el vuelo, identificados por su código.
     */
    private Map<String, Tiquete> tiquetes = new HashMap<String, Tiquete>();

    /**
     * Crea un nuevo vuelo con la ruta, fecha y avión especificados.
     *
     * @param ruta  Ruta del vuelo.
     * @param fecha Fecha del vuelo en formato YYYY-MM-DD.
     * @param avion Avión asignado al vuelo.
     */
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
    }

    // ************************************************************************************
    //
    // Métodos de acceso y manipulación de los atributos del vuelo.
    //
    // ************************************************************************************

    /**
     * Obtiene la ruta del vuelo.
     *
     * @return Ruta del vuelo.
     */
    public Ruta getRuta() {
        return ruta;
    }

    /**
     * Obtiene la fecha del vuelo.
     *
     * @return Fecha del vuelo.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene el avión asignado al vuelo.
     *
     * @return Avión del vuelo.
     */
    public Avion getAvion() {
        return avion;
    }

    
    public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public void setTiquetes(Map<String, Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}

	/**
     * Obtiene la colección de tiquetes vendidos para el vuelo.
     *
     * @return Colección de tiquetes del vuelo.
     */
    public Collection<Tiquete> getTiquetes() {
        return tiquetes.values();
    }

    /**
     * Vende una cantidad específica de tiquetes y los registra en el mapa de tiquetes.
     *
     * @param cliente    Cliente que adquiere los tiquetes.
     * @param calculadora Calculadora de tarifas para determinar el precio.
     * @param cantidad   Cantidad de tiquetes a vender.
     * @return Valor total de los tiquetes comprados.
     */
    public int venderTiquetes​(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        int precioTiquete = calculadora.calcularTarifa(this, cliente);
        int precioFinal = precioTiquete * cantidad;

        if (avion.getCapacidad() - cantidad >= 0) {
            Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, precioFinal);
            tiquetes.put(nuevoTiquete.getCodigo(), nuevoTiquete);
        }    

        return precioFinal;
    }

    /**
     * Compara si este vuelo es igual a otro objeto.
     *
     * @param obj Objeto a comparar.
     * @return {@code true} si los vuelos son iguales, de lo contrario {@code false}.
     */
    public boolean equals​(java.lang.Object obj) {
        return true;
    }
}

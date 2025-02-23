package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifasTemporadaAlta;

/*
 * Representa la calculadora de tarifas de temporada alta
 */
public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	
	/**
     * Tarifa fija por kilómetro durante la temporada alta.
     */
    protected int COSTO_POR_KM = 1000;

    /**
     * Constructor que inicializa la calculadora de tarifas para temporada alta.
     * @param vuelo   Vuelo sobre el cual se calculará la tarifa.
     * @param cliente Cliente al que se le aplicará la tarifa.
     */
    public CalculadoraTarifasTemporadaAlta(Vuelo vuelo, Cliente cliente) {
        super(vuelo, cliente);
    }

    /**
     * Calcula el costo base multiplicando la distancia del vuelo por la tarifa por kilómetro.
     * @param vuelo   Vuelo sobre el cual se calculará el costo base.
     * @param cliente Cliente para el cual se calcula el costo.
     * @return Costo base del vuelo en temporada alta.
     */
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente)
    {
        Aeropuerto origen = vuelo.getRuta().getOrigen();
        Aeropuerto destino = vuelo.getRuta().getDestino();
        int distancia = Aeropuerto.calcularDistancia(origen, destino);

        return COSTO_POR_KM * distancia;
    }

    /**
     * En temporada alta no se aplican descuentos, por lo que este método siempre retorna 0.
     * @param cliente Cliente al que se le calcularía el descuento.
     * @return Porcentaje de descuento (siempre 0 en temporada alta).
     */
    public double calcularPorcentajeDescuento(Cliente cliente)
    {
        return 0.0;
    }
}

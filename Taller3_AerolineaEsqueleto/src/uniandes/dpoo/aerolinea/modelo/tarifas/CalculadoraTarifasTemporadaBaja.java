package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifasTemporadaBaja;


/*
 * Representa la calculadora de tarifas para temporada baja 
 */
public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

	/**
     * Tarifa por kilómetro en temporada baja para clientes naturales.
     */
    protected int COSTO_POR_KM_NATURAL = 600;

    /**
     * Tarifa por kilómetro en temporada baja para clientes corporativos.
     */
    protected int COSTO_POR_KM_CORPORATIVO = 900;

    /**
     * Descuento aplicable a empresas pequeñas.
     */
    protected double DESCUENTO_PEQ = 0.02;

    /**
     * Descuento aplicable a empresas medianas.
     */
    protected double DESCUENTO_MEDIANAS = 0.1;

    /**
     * Descuento aplicable a empresas grandes.
     */
    protected double DESCUENTO_GRANDES = 0.2;

    /**
     * Constructor que inicializa la calculadora de tarifas para temporada baja.
     * @param vuelo   Vuelo sobre el cual se calculará la tarifa.
     * @param cliente Cliente al que se le aplicará la tarifa.
     */
    public CalculadoraTarifasTemporadaBaja(Vuelo vuelo, Cliente cliente) {
        super(vuelo, cliente);
    }

    /**
     * Calcula el costo base multiplicando la distancia del vuelo por el costo por kilómetro
     * dependiendo del tipo de cliente (Natural o Corporativo).
     * @param vuelo   Vuelo sobre el cual se calculará el costo base.
     * @param cliente Cliente para el cual se calcula el costo.
     * @return Costo base del vuelo en temporada baja.
     */
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente)
    {
        int tarifaKm = cliente.getTipoCliente().equals("Natural") ? COSTO_POR_KM_NATURAL : COSTO_POR_KM_CORPORATIVO;
        
        Aeropuerto origen = vuelo.getRuta().getOrigen();
        Aeropuerto destino = vuelo.getRuta().getDestino();
        int distancia = Aeropuerto.calcularDistancia(origen, destino);

        return tarifaKm * distancia;
    }

    /**
     * Calcula el porcentaje de descuento para un cliente corporativo según el tamaño de su empresa.
     * @param cliente Cliente al que se le calcularía el descuento.
     * @return Porcentaje de descuento aplicado.
     */
    public double calcularPorcentajeDescuento(Cliente cliente)
    {
        if (cliente.getTipoCliente().equals("Corporativo"))
        {
            ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
            int tamano = clienteCorporativo.getTamanoEmpresa();
            
            return (tamano == 1) ? DESCUENTO_PEQ :
                   (tamano == 2) ? DESCUENTO_MEDIANAS : 
                                   DESCUENTO_GRANDES;
        }
        return 0.0;
    }
}

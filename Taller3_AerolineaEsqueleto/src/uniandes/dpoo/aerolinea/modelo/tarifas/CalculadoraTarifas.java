package uniandes.dpoo.aerolinea.modelo.tarifas;


import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public abstract class CalculadoraTarifas {

	/**
     * Porcentaje fijo de impuestos aplicado sobre el costo base.
     */
    public static final double IMPUESTO = 0.28; 

    /**
     * Referencia al vuelo para el cual se realizará el cálculo de tarifas.
     */
    public static Vuelo vuelo; 

    /**
     * Cliente para el cual se calculará la tarifa.
     */
    public static Cliente cliente; 

    /**
     * Constructor de la calculadora de tarifas, inicializa el vuelo y el cliente.
     * @param vuelo   Vuelo para el cual se calculará la tarifa.
     * @param cliente Cliente al que se le aplicará la tarifa.
     */
    CalculadoraTarifas(Vuelo vueloA, Cliente clienteA)
    {
        vuelo = vueloA;
        cliente = clienteA;
    }

    /**
     * Calcula el costo base de un vuelo considerando sus características y el cliente asociado.
     * Este método debe ser implementado por las subclases.
     * @param vuelo   Vuelo sobre el cual se calculará el costo base.
     * @param cliente Cliente para el cual se calcula el costo.
     * @return Costo base del vuelo.
     */
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    /**
     * Calcula la distancia aproximada en kilómetros de una ruta aérea entre dos aeropuertos.
     * @param ruta Ruta del vuelo.
     * @return Distancia en kilómetros entre el aeropuerto de origen y destino.
     */
    protected int calcularDistanciaVuelo(Ruta ruta)
    {   
        Aeropuerto origen = ruta.getOrigen(); 
        Aeropuerto destino = ruta.getDestino(); 

        return Aeropuerto.calcularDistancia(origen, destino);
    }

    /**
     * Calcula el porcentaje de descuento aplicable a un cliente en función de su historial y tipo.
     * Retorna un valor entre 0 y 1, donde 0 significa sin descuento y 1 equivale al 100% de descuento.
     * @param cliente Cliente al que se le calculará el descuento.
     * @return Porcentaje de descuento (valor entre 0 y 1).
     */   
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    /**
     * Calcula el precio final de un vuelo, aplicando descuentos e impuestos al costo base.
     * @param vuelo   Vuelo sobre el cual se calculará la tarifa.
     * @param cliente Cliente que comprará el tiquete.
     * @return Tarifa total luego de aplicar descuentos e impuestos.
     */   
    public int calcularTarifa(Vuelo vuelo, Cliente cliente)
    {
        int costoBase = calcularCostoBase(vuelo, cliente); 
        double descuento = calcularPorcentajeDescuento(cliente);
        double costoConDescuento = costoBase * (1 - descuento);
        int costoRedondeado = (int) Math.round(costoConDescuento);
        int impuestos = calcularValorImpuestos(costoRedondeado);
        return costoRedondeado + impuestos;
    }

    /**
     * Calcula el valor de los impuestos a partir del costo base del vuelo.
     * El impuesto se calcula aplicando el porcentaje definido en la constante IMPUESTO.
     * @param costoBase Costo base del vuelo antes de impuestos.
     * @return Monto total de impuestos aplicados.
     */   
    protected int calcularValorImpuestos(int costoBase)
    {
        return (int) (costoBase * IMPUESTO);
    }
}

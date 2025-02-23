package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;


/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * 
 * No puede haber dos aeropuertos con el mismo código.
 */
public class Aeropuerto
{
	/**
     * Código único que identifica al aeropuerto.
     */
    private String codigo;

    /**
     * Conjunto de códigos de aeropuertos registrados en el sistema.
     */
    private static Set<String> codigosUtilizados = new HashSet<String>();

    /**
     * Latitud del aeropuerto, debe estar en el rango de -90 a +90 grados.
     */
    private double latitud; 

    /**
     * Longitud del aeropuerto, debe estar en el rango de -180 a +180 grados.
     */
    private double longitud;

    /**
     * Nombre oficial del aeropuerto.
     */
    private String nombre;

    /**
     * Nombre de la ciudad más cercana al aeropuerto.
     */
    private String nombreCiudad; 

    /**
     * Constante que representa el radio de la Tierra en kilómetros, utilizado para cálculos de distancia.
     */
    private static final int RADIO_TERRESTRE = 6371;

    /**
     * Crea un nuevo aeropuerto con los datos proporcionados y registra su código en el sistema.
     *
     * @param nombre       Nombre del aeropuerto.
     * @param codigo       Código único del aeropuerto.
     * @param nombreCiudad Nombre de la ciudad cercana al aeropuerto.
     * @param latitud      Latitud geográfica del aeropuerto.
     * @param longitud     Longitud geográfica del aeropuerto.
     */
    public Aeropuerto(String nombre, String codigo, String nombreCiudad, double latitud, double longitud) {
        this.codigo = codigo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
    }

    
    public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public static Set<String> getCodigosUtilizados() {
		return codigosUtilizados;
	}


	public static void setCodigosUtilizados(Set<String> codigosUtilizados) {
		Aeropuerto.codigosUtilizados = codigosUtilizados;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombreCiudad() {
		return nombreCiudad;
	}


	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}


	public static int getRadioTerrestre() {
		return RADIO_TERRESTRE;
	}


	/**
     * Este método calcula la distancia *aproximada* entre dos aeropuertos. Hay fórmulas más precisas pero esta es suficientemente buena para el caso de la aerolínea.
     * 
     * Este método asume que las coordenadas (latitud y longitud) de los aeropuertos están expresadas en la forma que las hace más cercanas. Si no es así, la distancia entre
     * los dos aeropuertos podría ser la más larga posible.
     * 
     * Por ejemplo, dependiendo de cómo estén expresadas las longitudes, la distancia calculada entre Narita (Tokyo) y El Dorado (Bogotá) podría ser atravesando el Pacífico, o
     * atravesando el Atlántico y Asia (el camino largo)
     * 
     * @param aeropuerto1
     * @param aeropuerto2
     * @return La distancia en kilómetros entre los puntos
     */
    public static int calcularDistancia( Aeropuerto aeropuerto1, Aeropuerto aeropuerto2 )
    {
        // Convertir los ángulos a radianes para facilitar las operaciones trigonométricas
        double latAeropuerto1 = Math.toRadians( aeropuerto1.getLatitud( ) );
        double lonAeropuerto1 = Math.toRadians( aeropuerto1.getLongitud( ) );
        double latAeropuerto2 = Math.toRadians( aeropuerto2.getLatitud( ) );
        double lonAeropuerto2 = Math.toRadians( aeropuerto2.getLongitud( ) );

        // Calcular la distancia debido a la diferencia de latitud y de longitud
        double deltaX = ( lonAeropuerto2 - lonAeropuerto1 ) * Math.cos( ( latAeropuerto1 + latAeropuerto2 ) / 2 );
        double deltaY = ( latAeropuerto2 - latAeropuerto1 );

        // Calcular la distancia real en kilómetros
        double distancia = Math.sqrt( deltaX * deltaX + deltaY * deltaY ) * RADIO_TERRESTRE;

        return ( int )Math.round( distancia );
    }

}

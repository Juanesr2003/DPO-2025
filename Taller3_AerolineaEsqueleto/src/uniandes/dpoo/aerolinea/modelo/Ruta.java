package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
	/**
     * Aeropuerto de origen de la ruta.
     */
    private Aeropuerto origen; 

    /**
     * Aeropuerto de destino de la ruta.
     */
    private Aeropuerto destino;

    /**
     * Hora programada de salida en formato de cuatro dígitos (HHMM).
     */
    private String horaSalida;

    /**
     * Hora programada de llegada en formato de cuatro dígitos (HHMM).
     */
    private String horaLlegada;

    /**
     * Código único que identifica la ruta.
     */
    private String codigoRuta;

    /**
     * Crea una nueva ruta aérea entre dos aeropuertos con los horarios especificados.
     *
     * @param origen      Aeropuerto de origen de la ruta.
     * @param destino     Aeropuerto de destino de la ruta.
     * @param horaSalida  Hora programada de salida (formato HHMM).
     * @param horaLlegada Hora programada de llegada (formato HHMM).
     * @param codigoRuta  Código único de la ruta.
     */
    public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigoRuta = codigoRuta;
    }


    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }


	public Aeropuerto getOrigen() {
		return origen;
	}


	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}


	public Aeropuerto getDestino() {
		return destino;
	}


	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}


	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	public String getHoraLlegada() {
		return horaLlegada;
	}


	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	public String getCodigoRuta() {
		return codigoRuta;
	}


	public void setCodigoRuta(String codigoRuta) {
		this.codigoRuta = codigoRuta;
	}
    

    
}

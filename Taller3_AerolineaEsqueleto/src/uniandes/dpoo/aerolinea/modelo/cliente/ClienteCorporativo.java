package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
	/**
     * Identificador de tipo de cliente para clientes corporativos.
     */
    static String CORPORATIVO = "Corporativo";

    /**
     * Código que representa una empresa de gran tamaño.
     */
    static int GRANDE = 1;

    /**
     * Código que representa una empresa de tamaño mediano.
     */
    static int MEDIANA = 2;

    /**
     * Código que representa una empresa de tamaño pequeño.
     */
    static int PEQUEÑA = 3;

    /**
     * Nombre de la empresa asociada al cliente corporativo.
     */
    private String nombreEmpresa;

    /**
     * Tamaño de la empresa según las categorías definidas.
     */
    private int tamanoEmpresa;

    /**
     * Constructor que inicializa un cliente corporativo con el nombre y tamaño de la empresa.
     */
    public ClienteCorporativo(String nombreDeEmpresa, int tamanoEmpresa) {
        super();
        this.nombreEmpresa = nombreDeEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }
    


    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
    

    /**
     * Devuelve el identificador único del cliente corporativo.
     * @return idCliente
     */
    public String getIdentificador()
    {
        return nombreEmpresa + (int) (Math.random() * 1000);
    }
    
    /**
     * Obtiene el nombre de la empresa asociada al cliente.
     * @return empresaNombre
     */
    public String getNombreEmpresa()
    {
        return nombreEmpresa; 
    }

    /**
     * Obtiene la categoría de tamaño de la empresa (GRANDE, MEDIANA, PEQUEÑA).
     * @return categoriaTamano
     */
    public int getTamanoEmpresa()
    {
        return tamanoEmpresa; 
    }

    /**
     * Devuelve el tipo de cliente corporativo.
     * @return tipoCliente
     */
    public String getTipoCliente()
    {
        return CORPORATIVO; 
    }
}

package uniandes.dpoo.aerolinea.consola;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;

public class ConsolaAerolinea extends ConsolaBasica
{
    private Aerolinea unaAerolinea;

    /**
     * Es un método que corre la aplicación y realmente no hace nada interesante: sólo muestra cómo se podría utilizar la clase Aerolínea para hacer pruebas.
     * @throws Exception 
     * @throws VueloSobrevendidoException 
     */
    public void correrAplicacion( ) throws VueloSobrevendidoException, Exception
    {
        try
        {
            unaAerolinea = new Aerolinea( );
            Ruta ruta = new Ruta(new Aeropuerto("AeroPepe", "11", "Bogota", 1.56, 2.34), new Aeropuerto("AeroPepeKorean", "21", "Seul", 2.56, 0.34),null, null, "4558");
            unaAerolinea.agregarRuta(ruta);
            
            Vuelo vuelo = new Vuelo(ruta,"2024-11-05", new Avion("AvionPepe", 30) );
            unaAerolinea.agregarVuelo(vuelo);
            
            Cliente cliente = new ClienteNatural("Pepe");
            unaAerolinea.agregarCliente(cliente);
            
            Avion avion = new Avion("PepeVuela", 25);
            
            String archivo = "tiquetes.json"; 
            unaAerolinea.cargarTiquetes( "./datos/" + archivo, CentralPersistencia.JSON );
            
            unaAerolinea.venderTiquetes("Pepe", "2024-11-05", "4558", 1);
            
            unaAerolinea.registrarVueloRealizado("2024-11-05", "4558");
            
            unaAerolinea.consultarSaldoPendienteCliente("Pepe");
            unaAerolinea.programarVuelo("2024-12-01", "4558", "PepeVuela");
        }
        catch( TipoInvalidoException e )
        {
            e.printStackTrace( );
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        catch( InformacionInconsistenteException e )
        {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) throws VueloSobrevendidoException, Exception
    {
        ConsolaAerolinea ca = new ConsolaAerolinea( );
        ca.correrAplicacion( );
    }
}
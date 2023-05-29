/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxrmi;

/**
 *
 * @author Jona xD
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "192.168.100.38");

            // Crear instancia del servidor
            ChatServidor servidor = new ChatServidor();

            // Registrar el servidor en el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ChatServidor", servidor);

            System.out.println("El servidor está listo.");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}


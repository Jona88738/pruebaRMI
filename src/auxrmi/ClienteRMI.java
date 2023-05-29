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
import java.util.Scanner;

public class ClienteRMI {
    private static boolean continuar = true;

    public static void main(String[] args) {
        try {
            // Obtener referencia al servidor RMI
            Registry registry = LocateRegistry.getRegistry("192.168.100.6", 1099);
            ChatInterface servidor = (ChatInterface) registry.lookup("ChatServidor");

            // Crear instancia del cliente
            ChatCliente cliente = new ChatCliente(servidor);

            // Registrar el cliente en el servidor
            cliente.registrarCliente();

            // Iniciar hilo para enviar mensajes o salir del chat
            Thread hiloEnvio = new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);
                    while (continuar) {
                        System.out.println("Ingrese su mensaje ('exit' para salir):");
                        String mensaje = scanner.nextLine();
                        if (mensaje.equalsIgnoreCase("exit")) {
                            continuar = false;
                            cliente.eliminarCliente();
                        } else {
                            cliente.enviarMensaje(mensaje);
                        }
                    }
                    scanner.close();
                }
            });
            hiloEnvio.start();

            // Esperar hasta que el hilo de envío termine
            hiloEnvio.join();

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}


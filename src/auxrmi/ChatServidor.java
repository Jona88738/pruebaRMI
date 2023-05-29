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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServidor extends UnicastRemoteObject implements ChatInterface {
    private List<ClienteInterface> clientes;

    public ChatServidor() throws RemoteException {
        clientes = new ArrayList<>();
    }

    public void enviarMensaje(String mensaje) throws RemoteException {
        for (ClienteInterface cliente : clientes) {
            cliente.recibirMensaje(mensaje);
        }
    }

    public void registrarCliente(ClienteInterface cliente) throws RemoteException {
        clientes.add(cliente);
    }

    public void eliminarCliente(ClienteInterface cliente) throws RemoteException {
        clientes.remove(cliente);
    }
}


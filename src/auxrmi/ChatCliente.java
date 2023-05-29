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

public class ChatCliente extends UnicastRemoteObject implements ClienteInterface {
    private ChatInterface servidor;

    public ChatCliente(ChatInterface servidor) throws RemoteException {
        this.servidor = servidor;
    }

    public void recibirMensaje(String mensaje) throws RemoteException {
        System.out.println(mensaje);
    }

    public void enviarMensaje(String mensaje) {
        try {
            servidor.enviarMensaje(mensaje);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void registrarCliente() {
        try {
            servidor.registrarCliente(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente() {
        try {
            servidor.eliminarCliente(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

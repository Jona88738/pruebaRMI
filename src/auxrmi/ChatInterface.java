/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Jona xD
 */
public interface ChatInterface extends Remote {
    void enviarMensaje(String mensaje) throws RemoteException;
    void registrarCliente(ClienteInterface cliente) throws RemoteException;
    void eliminarCliente(ClienteInterface cliente) throws RemoteException;
}

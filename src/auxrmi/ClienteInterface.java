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

public interface ClienteInterface extends Remote {
    void recibirMensaje(String mensaje) throws RemoteException;
}


import java.rmi.Remote;
import java.rmi.RemoteException;
//Define o que o cliente pode fazer com os objetos
//Esta interface é compartilhada entre o cliente eo servidor

public interface RemoteHello extends Remote {

    public String getMensagem() throws RemoteException;

    public void setMensagem(String msg) throws RemoteException;
}

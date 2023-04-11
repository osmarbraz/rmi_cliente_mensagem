
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 * Programa cliente do objeto de mensagens.
 * 
 * Classe que obtêm uma instância do objeto no servidor.
 * 
 * @author osmar
 */
public class Principal {

    public static void main(String args[]) {
        try{
        //Referência para rmiregistry na porta 1099
        Registry registro = LocateRegistry.getRegistry("localhost");
        //Localiza a referência do objeto remoto 
        Object obj = registro.lookup("mensagens");
        //ou Object obj = Naming.lookup("rmi://localhost/mensagens");
        RemoteHello hello = (RemoteHello) obj;
        System.out.println("Mensagem recebida: " + hello.getMensagem());
        hello.setMensagem(JOptionPane.showInputDialog("Digite a mensagen"));
        } catch(RemoteException ex){
            System.out.println("Excecao: " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("Excecao: " + ex.getMessage());
        }
    }
}
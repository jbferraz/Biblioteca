package repositorio;

import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Jair Ferraz
 */
public class RepositorioClientes {
    private ArrayList<Cliente> listaClientes;
    
    public RepositorioClientes(){
        listaClientes= new ArrayList<Cliente>();        
    }
    public void adicionar(Cliente cliente){
        listaClientes.add(cliente);
    }
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public Cliente buscarClientePorMatricula(int matricula)
    {
        for(Cliente c: listaClientes)
        {
            if(c.getMatricula()==(matricula))
            {
                return(c);
            }
        }
        return(null);
    }
    public boolean existeCliente(int matricula){
        if(this.buscarClientePorMatricula(matricula)!=null)
            return true;
        else
            return false;    
    }
    public Cliente buscarClientePorNomeCliente(String NomeCliente)
    {
        for(Cliente c: listaClientes)
        {
            if(c.getNome().equals(NomeCliente))
            {
                return(c);
            }
        }
        return(null);
    }
    public boolean temMedicamentos(){
        return !listaClientes.isEmpty();
    }
}

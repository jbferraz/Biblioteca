package repositorio;

import java.util.ArrayList;
import model.RetiraLivro;

/**
 *
 * @author Jair Ferraz
 */
public class RepositorioRetiraLivro{
    private ArrayList<RetiraLivro> listaRetiraLivros;
    
    public RepositorioRetiraLivro(){
        listaRetiraLivros=new ArrayList<RetiraLivro>();
    }
    public void adicionar (RetiraLivro retiraLivro){
        listaRetiraLivros.add(retiraLivro);
    }
    public ArrayList<RetiraLivro> getListaRetiraLivro(){
        return  listaRetiraLivros;
    }
    public RetiraLivro buscaRetiraLivroPorMatricula(int matricula){
        for(RetiraLivro r: listaRetiraLivros)
        {
            if(r.getCliente().getMatricula()==matricula)
            {
                return(r);
            }
        }
        return(null);
    }
    public boolean temRetiraLivro(){
        return !listaRetiraLivros.isEmpty();
    }
}


























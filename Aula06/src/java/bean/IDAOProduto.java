package bean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rqguzman
 */
@Local
public interface IDAOProduto 
{
    void cadastrar(Produto p);
    
    List<Produto> obterProdutos();
    
    void excluir(Produto p);
    
    void alterar(Produto p);
    
}

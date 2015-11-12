package bean;

import javax.ejb.Local;

/**
 *
 * @author rqguzman
 */
@Local
public interface IDAOProduto2 
{

    void cadastrar(Produto p);
    
}

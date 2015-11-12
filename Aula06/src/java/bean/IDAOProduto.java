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

    /* Should methods in a Java interface be declared with or without a public access modifier?
     * It is permitted, but discouraged as a matter of style,
     * to redundantly specify the public and/or abstract modifier
     * for a method declared in an interface. 
     **/
    void cadastrar(Produto p);
    
    public List<Produto> obterProdutos();
    
    public void excluir(Produto p);
    
    public void alterar(Produto p);
    
}

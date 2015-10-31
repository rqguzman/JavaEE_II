package bean;

import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author rqguzman
 */
@Remote
public interface ICarrinhoCompra 
{
    public void comprar(String produto, int qtd);
    public Map<String, Integer> listarCompras();
    public void devolver(String produto, int qtd);
    public void remover(String produto);
    
}

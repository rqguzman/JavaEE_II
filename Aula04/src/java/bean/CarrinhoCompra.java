package bean;

import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author rqguzman
 */
@Remote
public interface CarrinhoCompra 
{
    public void comprar(String produto, int qtd);
    public Map<String, Integer> listarCompras();
    
}

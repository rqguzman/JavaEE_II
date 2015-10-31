package aula04client;

import bean.CarrinhoCompra;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;

/**
 *
 * @author rqguzman
 */
public class Main 
{
    @EJB
    private static CarrinhoCompra cc;
    
    public static void main(String[] args) 
    {
        try 
        {
            cc.comprar("Memória", 4);
            cc.comprar("HD", 2);
            cc.comprar("Memória", 2);
            
            Map<String, Integer>listaCompra = cc.listarCompras();
            
            for (String produto : listaCompra.keySet()) 
            {
                System.out.println("Produto: " + produto);
                System.out.println("Quantidade: " + listaCompra.get(produto));
                System.out.println("--------------------------");
            }
            
        }
            catch (EJBAccessException e) 
        {
            System.out.println("sem permissão");
        }
            catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}

package ex04cliente;

import bean.ICarrinhoCompra;
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
   private static ICarrinhoCompra cc;
   
    public static void main(String[] args) 
    {
        try 
        {
            cc.comprar("Memória", 4);
            cc.comprar("HD", 2);
            cc.comprar("Memória", 2);
            
            cc.devolver("Memória", 1);
            cc.remover("HD");
            //LISTAR PRODUTOS COMPRADOS
            Map<String, Integer>listaCompra = cc.listarCompras();
            
            for (String produto : listaCompra.keySet()) 
            {
                System.out.println("Produto: " + produto);
                System.out.println("Quantidade: " + listaCompra.get(produto));
                System.out.println("--------------------------");
            }
            
        } 
        catch (EJBAccessException ae) 
        {
            System.out.println("ERRO: Sem Permissão de acesso.");
        }
        catch (Exception e) 
        {            
            System.out.println(e.getMessage());
        }
    }
    
}

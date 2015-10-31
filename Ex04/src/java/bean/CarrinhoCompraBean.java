package bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;

/**
 *
 * @author rqguzman
 */
@Stateful
@DeclareRoles({"usuarios", "administrador"})
public class CarrinhoCompraBean implements ICarrinhoCompra
{

    private static Map<String, Integer> listaDeCompras;

    public CarrinhoCompraBean() 
    {
        listaDeCompras = new HashMap<String, Integer>();
    }
       
    @Override
    @RolesAllowed({"usuarios", "administrador"})
    public void comprar(String produto, int qtd) 
    {
        Integer n = listaDeCompras.get(produto);
        
        if (n == null) 
        {
            listaDeCompras.put(produto, qtd);
        }
        else
        {
            listaDeCompras.replace(produto, n+qtd);
        }   
    }

    @Override
    @RolesAllowed("administrador")
    public Map<String, Integer> listarCompras() 
    {
        return listaDeCompras;
    }

    @Override
    @RolesAllowed({"usuarios", "administrador"})
    public void devolver(String produto, int qtd) 
    {
        Integer n = listaDeCompras.get(produto);
        
        if (n == null) 
        {
            System.out.println("Não há produtos deste tipo em seu carrinho.");
        }
        else
        {
            listaDeCompras.replace(produto, n-qtd);
        }
    }

    @Override
    @RolesAllowed("administrador")
    public void remover(String produto) 
    {
        if (listaDeCompras.containsKey(produto)) 
        {
            listaDeCompras.remove(produto);
        } 
            else 
        {
            System.out.println("Produto não encontrado");
        }
    }
    
}

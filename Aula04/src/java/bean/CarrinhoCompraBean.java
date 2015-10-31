package bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.Stateful;

/**
 *
 * @author rqguzman
 */
@Stateful
@DeclareRoles({"usuarios", "administrador"})
public class CarrinhoCompraBean implements CarrinhoCompra
{
   private Map<String, Integer> listaCompras;

   
    public CarrinhoCompraBean() 
    {
        listaCompras = new HashMap<String, Integer>();
    }

    @Override
    @RolesAllowed({"usuarios", "administrador"})
    public void comprar(String produto, int qtd) 
    {
        Integer n = listaCompras.get(produto);
        if (n == null) 
        {
            listaCompras.put(produto, qtd);
        }
        else
        {
            listaCompras.replace(produto, n+qtd);
        }          
    }

    @Override
    @RolesAllowed("administrador")
    //@PermitAll --> Todos podem usar
    //@DenyAll --> Ninguém pode usar
    //@RunAs --> Propagar a permissão.    
    public Map<String, Integer> listarCompras() 
    {
        return listaCompras;
    }  
    
}

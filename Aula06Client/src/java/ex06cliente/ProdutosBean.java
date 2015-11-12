package ex06cliente;

import bean.IDAOProduto;
import bean.IDAOProduto2;
import bean.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author rqguzman
 */
@Named
@ViewScoped
public class ProdutosBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private List<Produto> listaDeProdutos = new ArrayList<Produto>();
    private Produto produto;

    public Produto getProduto() 
    {
        return produto;
    }

    @EJB
    private IDAOProduto idaop;
    
    @EJB
    private IDAOProduto2 idaop2;
    
    @PostConstruct
    public void init()
    {
        limpaFormulario();
        carregaProdutos();
    }
    
    private void carregaProdutos()
    {
        listaDeProdutos = idaop.obterProdutos();
    }
    
    private void limpaFormulario()
    {
        produto = new Produto();
    }
    
    public void salvar()
    {
        idaop.cadastrar(produto);
        
        carregaProdutos();
        limpaFormulario();
    }
    
    public void salvar2()
    {
        idaop2.cadastrar(produto);
        
        carregaProdutos();
        limpaFormulario();
    }
    
    public List<Produto> getListaDeProdutos() 
    {
        return listaDeProdutos;
    }
    
}

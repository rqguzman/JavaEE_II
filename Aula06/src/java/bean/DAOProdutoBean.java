package bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rqguzman
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//Usando o serviço JTS(Java Transaction Service do EJB Container)
public class DAOProdutoBean implements IDAOProduto 
{
    @PersistenceContext(unitName = "Aula06PU")
    private EntityManager em;
    
    @Override
    public void cadastrar(Produto p)
    {
        em.persist(p);
    }
    
    @Override
    public List<Produto> obterProdutos()
    {
        return em.createQuery("SELECT p FROM Produto p").getResultList();
    }

    @Override
    public void excluir(Produto p) 
    {
        em.remove(em.find(Produto.class, p.getCodigo()));
    }

    @Override
    public void alterar(Produto p) 
    {
        em.merge(p);
    }
    
    
}

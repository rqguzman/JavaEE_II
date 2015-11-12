package bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author rqguzman
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DAOProdutoBean2 implements IDAOProduto2 
{
    @PersistenceContext(name = "Aula06PU")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
    
    @Override
    public void cadastrar (Produto p)
    {
        try 
        {
            ut.begin();
            em.persist(p);
            ut.commit();
        } catch (Exception e) 
        {
            try {
                ut.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Produto> obterProduto()
    {
        return em.createQuery("SELECT p FROM Produto p").getResultList();
    }
    
    public void excluir (Produto p)
    {
        try 
        {
            ut.begin();
            em.remove(em.find(Produto.class, p.getCodigo()));
            ut.commit();
        } catch (Exception e) 
        {
            try {
                ut.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void alterar (Produto p)
    {
        try 
        {
            ut.begin();
            em.merge(p);
            ut.commit();
        } catch (Exception e) 
        {
            try {
                ut.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(DAOProdutoBean2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
    
}

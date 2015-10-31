package bean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import modelo.Fisica;
import modelo.IPessoa;

/**
 *
 * @author rafael.guzman
 */
@Stateless
public class TesteBean implements ITeste
{
    @Inject
    @Fisica
    private IPessoa pessoa;
    
    @Override
    public void servico() 
    {
        System.out.println("Pessoa: " + pessoa.getPessoa());
    }    
}

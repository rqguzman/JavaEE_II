package modelo;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author rafael.guzman
 */
@ApplicationScoped
@Fisica
public class PessoaFisica implements IPessoa
{

    @Override
    public String getPessoa() 
    {
        return "Física";
    }
    
}

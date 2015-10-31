package modelo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 *
 * @author rafael.guzman
 */
@ApplicationScoped
@Default
@Juridica
public class PessoaJuridica implements IPessoa
{

    @Override
    public String getPessoa() 
    {
        return "Jurídica";
    }
    
}

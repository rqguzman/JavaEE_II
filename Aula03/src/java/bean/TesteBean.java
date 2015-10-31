package bean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import modelo.Branco;
import modelo.Tinto;
import modelo.IVinho;

@Stateless
public class TesteBean  implements ITeste
{

    @Inject
    @Branco
    private IVinho v;
    
    @Override
    public void servico() 
    {
        System.out.println("Cor do vinho: "+v.getCor());
    }  
    
    
}

package modelo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Branco
public class VinhoBranco implements IVinho {
    
    @Override
    public String getCor(){
        return "Branco";
    }
}

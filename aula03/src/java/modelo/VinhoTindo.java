package modelo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Tinto
public class VinhoTindo implements IVinho {

    @Override
    public String getCor() {
        return "Tinto";
    }
    
}

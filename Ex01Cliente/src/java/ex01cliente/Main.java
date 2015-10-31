package ex01cliente;

import bean.IServicos;
import javax.ejb.EJB;

/**
 *
 * @author rafael.guzman
 */
public class Main {

    @EJB
    private static IServicos s;
    
    public static void main(String[] args) 
    {
        s.ligarLuzes();
        s.ligarHidromassagem();
        s.desligarHidromassagem();
        s.desligarLuzes();
    }
    
}

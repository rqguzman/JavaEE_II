package aula02client;

import bean.Test;
import javax.ejb.EJB;

/**
 *
 * @author rqguzman
 */
public class Main 
{

    @EJB // referência para o objeto TestBean no container EJB
    private static Test t;
    
    public static void main(String[] args) 
    {
        //Chamada do método interceptado
        t.metodoInterceptado();
        
    }
    
}

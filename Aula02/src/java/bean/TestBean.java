package bean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author rqguzman
 */
@Stateless
public class TestBean implements Test
{

    @Override
    @Interceptors({Interceptador.class})
    public void metodoInterceptado()
    {
        System.out.println("TestBean interceptado");
        
    }
    
    
}

package bean;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author rqguzman
 */
public class Interceptador 
{
    @AroundInvoke
    public Object metodointerceptador(InvocationContext ic) throws Exception
    {
        System.out.println("Objeto interceptado: " + ic.getTarget());
        
        System.out.println("Método interceptado: " + ic.getMethod().getName());
        
        return ic.proceed();
    }
    
}

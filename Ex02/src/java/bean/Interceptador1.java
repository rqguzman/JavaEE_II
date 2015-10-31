package bean;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author rqguzman
 */
public class Interceptador1 
{
    @AroundInvoke
    public Object metodoInterceptador1(InvocationContext ic) throws Exception
    {
        CalculadoraDeSalariosBean calculadora = 
                (CalculadoraDeSalariosBean)ic.getTarget();
        
        double aumento=0;
        
        if (calculadora.getTitulo().equals("Especialista")) 
        {
            aumento = calculadora.getSalario()*0.10;
            
            System.out.println("Valor do aumento: " + aumento);
        }        
        return ic.proceed();
    }
    
}

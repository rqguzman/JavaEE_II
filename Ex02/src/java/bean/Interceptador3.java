package bean;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author rqguzman
 */
public class Interceptador3 
{
    @AroundInvoke
    public Object metodoInterceptador3(InvocationContext ic) throws Exception
    {
        CalculadoraDeSalariosBean calculadora = 
                (CalculadoraDeSalariosBean)ic.getTarget();
        
        double aumento=0;
        
        if (calculadora.getTitulo().equals("Doutor")) 
        {
            aumento = calculadora.getSalario()*0.40;
            
            System.out.println("Valor do aumento: " + aumento);
        }
        return ic.proceed();
    }
}

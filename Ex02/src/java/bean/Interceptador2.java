package bean;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author rqguzman
 */
public class Interceptador2 
{
    @AroundInvoke
    public Object metodoInterceptador2(InvocationContext ic) throws Exception
    {
        CalculadoraDeSalariosBean calculadora = 
                (CalculadoraDeSalariosBean)ic.getTarget();
        
        double aumento=0;
        
        if (calculadora.getTitulo().equals("Mestre")) 
        {
            aumento = calculadora.getSalario()*0.20;
            
            System.out.println("Valor do aumento: " + aumento);
        }
        
        return ic.proceed();
    }
}

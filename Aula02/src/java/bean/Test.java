package bean;

import javax.ejb.Remote;

/**
 *
 * @author rqguzman
 */
@Remote
public interface Test 
{
    public void metodoInterceptado();
    
    
}

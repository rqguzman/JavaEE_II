package bean;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author rqguzman
 */
@WebService
@Stateless
public class CasaBean implements ICasa
{

    @WebMethod
    @Override
    public String ligarLuzes() 
    {
        return "luzes ligadas";
    }

    @WebMethod
    @Override
    public String desligarLuzes() 
    {
        return "luzes apagadas";
    }
    
}

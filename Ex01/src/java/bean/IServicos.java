package bean;

import javax.ejb.Remote;
import javax.ejb.Timer;

/**
 *
 * @author rafael.guzman
 */
@Remote
public interface IServicos 
{
    public void setTemporizador(long t);
    public void timeout(Timer timer);
    
    public void ligarLuzes();
    
    public void desligarLuzes();
    
    public void ligarHidromassagem();
    
    public void desligarHidromassagem();
}

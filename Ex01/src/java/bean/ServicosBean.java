package bean;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author rafael.guzman
 */
@Stateless
public class ServicosBean implements IServicos
{
    private static boolean hidroLigada = false;
    private static Logger log = Logger.getLogger("bean.TemporizadorBean");
    
    @Resource
    private TimerService ts;
    
    @Override
    public void setTemporizador(long t) 
    {
        Timer timer = ts.createTimer(t, "Hidro desligando");
        while(timer.getTimeRemaining()>0)
       {
           log.info("Tempo:" + timer.getTimeRemaining());
       }
    }

    @Override
    @Timeout
    public void timeout(Timer timer) 
    {
        System.out.println("Temporizador finalizado");
    }

    @Override
    public void ligarLuzes() 
    {
        System.out.println("Luzes Ligadas");
    }

    @Override
    public void desligarLuzes() 
    {       
        if (hidroLigada) 
        {
            System.out.println("Luzes Desligadas");
            setTemporizador(10000);
            desligarHidromassagem();
        }
        else
        {
             System.out.println("Luzes Desligadas");
        }
               
    }

    @Override
    public void ligarHidromassagem() 
    {
        hidroLigada = true;
        System.out.println("Hidro Ligada");
    }

    @Override
    public void desligarHidromassagem()
    {
        if (hidroLigada) 
        {
            System.out.println("Hidro Desligada");
            hidroLigada = false;
        }
        else
        {
            System.out.println("Hidro já estava desligada");
        }
           
    }    
    
}

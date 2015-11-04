package bean;

import javax.ejb.Remote;

/**
 *
 * @author rqguzman
 */
@Remote
public interface ICasa 
{
 public String ligarLuzes();
 public String desligarLuzes();
 
}

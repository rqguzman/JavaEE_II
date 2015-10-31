package bean;

import javax.ejb.Remote;

/**
 *
 * @author rqguzman
 */
@Remote
public interface ICalculadoraDeSalarios 
{         
    public void setSalario(double salario);
    public void setTitulo(String titulo);
    
    public void verificaECalculaAumento();
    
}

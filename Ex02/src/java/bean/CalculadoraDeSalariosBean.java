package bean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author rqguzman
 */
@Stateless
public class CalculadoraDeSalariosBean implements ICalculadoraDeSalarios
{

    private double salario;
    private String titulo;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
       
    @Override
    @Interceptors({Interceptador1.class, Interceptador2.class, Interceptador3.class})
    public void verificaECalculaAumento() 
    {
        System.out.println("Interceptado");
    }
    
}

package ex02client;

import bean.ICalculadoraDeSalarios;
import javax.ejb.EJB;

/**
 *
 * @author rqguzman
 */
public class Main {

    @EJB
    private static ICalculadoraDeSalarios ics;
    
    public static void main(String[] args) 
    {
        ics.setSalario(1000);
        ics.setTitulo("Especialista");
        ics.setTitulo("Mestre");
        ics.setTitulo("Doutor");
        
        ics.verificaECalculaAumento();
    }
    
}

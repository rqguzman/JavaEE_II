package ex05cliente;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 *
 * @author rqguzman
 */
public class Main 
{
    public static SOAPMessage criarMensagemDesligado()
    {        
        try {
            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage message = mf.createMessage();
            SOAPPart part = message.getSOAPPart();
            SOAPEnvelope envelope = part.getEnvelope();
            SOAPBody body = envelope.getBody();
            body.addNamespaceDeclaration("ns2", "http://bean/");
            SOAPElement element = body.addChildElement("desligarLuzes", "ns2");
            
            message.saveChanges();
            return message;
        } catch (SOAPException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
        
    }
    
    public static SOAPMessage criarMensagemLigado()
    {        
        try {
            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage message = mf.createMessage();
            SOAPPart part = message.getSOAPPart();
            SOAPEnvelope envelope = part.getEnvelope();
            SOAPBody body = envelope.getBody();
            body.addNamespaceDeclaration("ns2", "http://bean/");
            SOAPElement element = body.addChildElement("ligarLuzes", "ns2");
            
            message.saveChanges();
            return message;
        } catch (SOAPException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
        
    }
    
    public static void enviarMensagem(SOAPMessage msg)
    {
        
        try 
        {
            SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
            SOAPConnection c = cf.createConnection();
            
            SOAPMessage resposta =
                    c.call(msg, "http://localhost:8080/CasaBeanService/CasaBean");
            SOAPBody corpo = resposta.getSOAPBody();
            Iterator i = corpo.getChildElements();
            SOAPElement e = (SOAPElement)i.next();
            Iterator i1 = e.getChildElements();
            SOAPElement e1 = (SOAPElement)i1.next();
            System.out.println("Resposta: " + e1.getValue());
            
        } 
        catch (SOAPException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public static void main(String[] args) 
    {
//       SOAPMessage mensagem = criarMensagemDesligado();
//        
//        if (mensagem == null)
//        {
//            System.out.println("ERRO na criacao da msg");
//        }
        
        System.out.println(">>>> MENU <<<");
        System.out.println("1 - Ligar luz;");
        System.out.println("2 - Desligar luz;");
        System.out.println("0 - sair da aplicação;");
        
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        
        while (opcao != 0)
        {            
            if (opcao == 1)
            {
                SOAPMessage message = criarMensagemLigado();
                enviarMensagem(message);
            }
            else if(opcao == 2)
            {
                SOAPMessage message = criarMensagemDesligado();
                enviarMensagem(message);
            }
            else 
            {
                System.out.println("Opção inválida!");
            }
            
            System.out.println(">>>> MENU <<<");
            System.out.println("1 - Ligar luz;");
            System.out.println("2 - Desligar luz;");
            System.out.println("0 - sair da aplicação;");
            
            scan = new Scanner(System.in);
            opcao = scan.nextInt(); 
        }
        System.out.println("Aplicação encerrada pelo usuário.");
        
       
    }
    
}

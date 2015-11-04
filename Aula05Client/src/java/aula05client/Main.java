package aula05client;

import java.io.IOException;
import java.util.Iterator;
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
// SOAP
//    <?xml version="1.0" encoding="UTF-8"?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
//    <SOAP-ENV:Header/>
//    <S:Body>
//        <ns2:ligarLuzes xmlns:ns2="http://bean/"/>
//    </S:Body>
//    </S:Envelope> 
    public static SOAPMessage criarMensagem() throws SOAPException, IOException
    {
        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage mensagem = mf.createMessage();
        SOAPPart parte = mensagem.getSOAPPart();
        SOAPEnvelope envelope = parte.getEnvelope();
        SOAPBody corpo = envelope.getBody();
        corpo.addNamespaceDeclaration("ns2", "http://bean/");
        SOAPElement elemento = corpo.addChildElement("ligarLuzes", "ns2");
        mensagem.saveChanges();
        
        //TESTE
        //mensagem.writeTo(System.out);
        
        System.out.println("\n\nMensagem");
        return mensagem;
        
    }
    
    public static void main(String[] args) 
    {
        //TESTE 1
//        try
//        {
//            criarMensagem();
//        }
//        catch (SOAPException ex) 
//        {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (IOException ex) 
//        {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        try 
        {
            SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
            SOAPConnection c = cf.createConnection();
            
            try 
            {
                SOAPMessage resposta =
                        c.call(criarMensagem(), "http://localhost:8080/CasaBeanService/CasaBean");
                
                SOAPBody corpo = resposta.getSOAPBody();
                        
                Iterator i = corpo.getChildElements();

                SOAPElement e = (SOAPElement)i.next();
                
                Iterator i1 = e.getChildElements();

                SOAPElement e1 = (SOAPElement)i1.next();

                System.out.println("Resposta: " + e1.getValue());
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }            

        } 
        catch (SOAPException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
}

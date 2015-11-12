package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rqguzman
 */
@Entity
@Table(name="Produto2")
public class Produto implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    private String codigo;
    private String descricao;
    private String valor;

    
    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public String getValor() 
    {
        return valor;
    }

    public void setValor(String valor) 
    {
        this.valor = valor;
    }
            
}

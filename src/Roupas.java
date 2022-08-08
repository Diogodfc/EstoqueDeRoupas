
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class Roupas implements Serializable {
    
    String tamanho;
    String cor;
    int quantidade;
    String tipo;
     String sexo;       
    int id;      
       
    public static int roupasRegistradas = 0;
            
    public Roupas (String tamanho, String cor, int quantidade, String tipo, String masculino){
    
    this.tamanho = tamanho;
    this.cor = cor;
    this.quantidade = quantidade;
    this.tipo = tipo;
    this.sexo = masculino;
    this.id = roupasRegistradas;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String isMasculino() {
        return sexo;
    }
  
    @Override
    public String toString (){
        
        String str;
        str = id +" - "+ sexo +" - "+ tamanho +" - "+ cor +" - "+ tipo +" - "+ quantidade; 
        return str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
    
    
    
    
    
    
}

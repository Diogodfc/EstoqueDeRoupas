
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class Estoque {
    
    public static ArrayList <Roupas> estoque;
    public static Scanner sc;
    
    public static void escreveArquivo() {
        try {
            File file = new File("estoque.obj");
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));

            for (int i = 0; i < estoque.size(); i++) {
                objOutput.writeObject(estoque.get(i));
            }
            System.out.println("Objeto escrito");
            objOutput.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //
    }

    public static void leArquivo() {
        try {
            File file = new File("estoque.obj");
            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

            Roupas b;
            b = (Roupas) objInput.readObject();
            
            while(b != null){
                estoque.add(b);
             Roupas.roupasRegistradas = b.getId()+2;
                b = (Roupas) objInput.readObject();
              
                System.out.println(b.getId());
            }
            System.out.println("Objeto lido");
            objInput.close();

        } catch (Exception e) {

        }

    }

    
    public static void main(String[] args){
        
        boolean valido = true;
        sc = new Scanner (System.in);
        estoque = new ArrayList <Roupas>();
        leArquivo();
        
        do{
           
       
       
        System.out.println("Digite a opção desejada:");
            System.out.println("1 - Adiconar Roupas");
            System.out.println("2 - Mostrar Roupas");
            System.out.println("3 - Tirar roupas do Estoque");
            System.out.println("4 - Sair do programa");
            System.out.print("Opcao: ");
            opcaoMenu ( Integer.parseInt(sc.nextLine()));
           
        }
        while(valido);
    
               
               
               
               }
    
    public static void opcaoMenu (int opcao){
        
        if (opcao == 1){
            System.out.println("Qual tamanho da roupa?");
         String tamanho = sc.nextLine();
          if (tamanho.equalsIgnoreCase(""))  
              return;
          
            System.out.println("Qual cor?");  
            String cor = sc.nextLine();
          if (cor.equalsIgnoreCase(""))  
              return;          
          
          System.out.println("Qual categoria?");  
            String categoria = sc.nextLine();
          if (categoria.equalsIgnoreCase(""))  
              return;       
          
          System.out.println("Qual sexo?");  
            String sexo = sc.nextLine();
          if (sexo.equalsIgnoreCase(""))  
              return;       
          
          System.out.println("Qual a quantidade?");  
            int quantidade = Integer.parseInt(sc.nextLine());
          if (quantidade == 0)
              return;       
          
          adicionarRoupas (tamanho, cor, quantidade, categoria, sexo);
            System.out.println("ROUPA ADICIONADA");
            
            escreveArquivo();
    }
        if (opcao == 2){
            
            mostrarRoupas();
            
            
        }
        if (opcao == 3) {
            
            
            mostrarRoupas();
            System.out.println("ID da roupa que deseja remover");
            int ID = Integer.parseInt(sc.nextLine());
            System.out.println("Quantidade a ser removida:");
            int quantidade = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < estoque.size(); i++) {
                
                if (estoque.get(i).getId()== ID){
                    
                removerRoupa (ID, quantidade);
                escreveArquivo();
                return;
                    
                }
                
            }
        }
 
        if (opcao == 4) 
            System.exit(0);
        
        
    }
  
    public static void mostrarRoupas(){
        for (int i = 0; i < estoque.size(); i++) {
            
            System.out.println(estoque.get(i).toString());
        
        }
    }
            
            
     public static void adicionarRoupas (String tamanho, String cor, int quantidade, String tipo, String masculino){
        Roupas roupas = new Roupas(tamanho, cor, quantidade, tipo, masculino);
         int id = estoque.size();
         roupas.setId(id);
         
         estoque.add (roupas);
         
     }
    
   
   
    public static void removerRoupa (int id, int quantidade){
        
        for (int i = 0; i < estoque.size(); i++) {
            
            if(id == estoque.get(i).getId()){
                 if (estoque.get(i).getQuantidade() == quantidade){
                     estoque.remove(estoque.get(i));
                     return;
                 }
                 
                 else if (estoque.get(i).getQuantidade() < quantidade){
                     System.out.println("NÃO TEMOS ESSA QUANTIDADE DE ROUPA NO ESTOQUE");
                     return;
                 }
                 else if (estoque.get(i).getQuantidade() > quantidade){
                     estoque.get(i).setQuantidade(estoque.get(i).getQuantidade() - quantidade);
                     return;
                     
                 }
                     
            }
            
        }
        
    }
    
}

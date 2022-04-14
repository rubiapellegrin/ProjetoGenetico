/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.projetogenetico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MASTER
 */
public class Principal {
    public static void main(String args[]){
        
        List<Itens> listaItens = new ArrayList();
        listaItens.add(new Itens("rubia", 1.0, 20.0));
        listaItens.add(new Itens("julio", 2.0, 20.0));
        listaItens.add(new Itens("Ieda", 2.0, 3.0));

        
        
        List pesos =new ArrayList();
        List beneficios =new ArrayList();
        List nomes =new ArrayList();
        
        for(Itens item: listaItens){
            pesos.add(item.getPeso());
            beneficios.add(item.getBeneficio());
            nomes.add(item.getNome()); 
        }
        
        Double limite = 3.0;
        int tamanhoPopulacao = 20;
        Double taxaMutacao =0.01;
        int numerosGeracoes = 100;
        
        AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
        List resultado = ag.resolver(taxaMutacao,numerosGeracoes,pesos,beneficios,limite);
        
        for(int i=0;i <listaItens.size();i++){
           if(resultado.get(i).equals("1")){
               System.out.println("Nome: " + listaItens.get(i).getNome());
           }
            
        }
        
        
    }   
}

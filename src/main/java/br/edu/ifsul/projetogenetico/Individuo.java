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
public class Individuo implements Comparable<Individuo>{
    private List pesos = new ArrayList();
    private List beneficios = new ArrayList();
    private Double limitePeso;
    private Double notaAvaliacao;
    private Double pesoUsado;
    private int geracao;
    private List cromossomos = new ArrayList();
    
    public Individuo(List pesos, List beneficios, Double limitePeso){
      super();
      this.pesos = pesos;
      this.beneficios = beneficios;
      this.limitePeso = limitePeso;
      this.notaAvaliacao = 0.0;
      this.pesoUsado = 0.0;
      this.geracao = 0;
        
      
     for(int i =0; i<this.pesos.size();i++){
         if(java.lang.Math.random() < 0.5){
             this.cromossomos.add("0");
         }
         else{
             this.cromossomos.add("1");
         }   
     } 
        
    }

    public List getPesos() {
        return pesos;
    }

    public void setPesos(List pesos) {
        this.pesos = pesos;
    }

    public List getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List beneficios) {
        this.beneficios = beneficios;
    }

    public Double getLimitePeso() {
        return limitePeso;
    }

    public void setLimitePeso(Double limitePeso) {
        this.limitePeso = limitePeso;
    }

    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public Double getPesoUsado() {
        return pesoUsado;
    }

    public void setPesoUsado(Double pesoUsado) {
        this.pesoUsado = pesoUsado;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    public List getCromossomos() {
        return cromossomos;
    }

    public void setCromossomos(List cromossomos) {
        this.cromossomos = cromossomos;
    }

    
    public void Avaliacao(){
        Double nota=0.0;
        Double SomaPesos=0.0;
     
        
        for(int i =0; i<this.cromossomos.size();i++){
            if(this.cromossomos.get(i).equals("1")){
                nota += (Double) this.beneficios.get(i);
                SomaPesos += (Double) this.pesos.get(i);
            }
        }     
        if(SomaPesos > this.limitePeso){
            nota =1.0;
        }
        this.notaAvaliacao=nota;
        this.pesoUsado=SomaPesos;
    }    
    
    @Override
    public int compareTo(Individuo o) {
        if(this.notaAvaliacao > o.getNotaAvaliacao()){
            return -1;
        }
        if(this.notaAvaliacao < o.getNotaAvaliacao()){
            return 1;
        }
        return 0;
    }
    
    public List crossover(Individuo outroIndividuo){
        int corte = (int) Math.round(Math.random() * this.cromossomos.size());
    
        List filho1 = new ArrayList();
        filho1.addAll(outroIndividuo.getCromossomos().subList(0, corte));
        filho1.addAll(this.cromossomos.subList(corte, this.cromossomos.size()));
    
        List filho2 = new ArrayList();
        filho2.addAll(this.cromossomos.subList(0, corte));
        filho2.addAll(outroIndividuo.getCromossomos().subList(corte, this.cromossomos.size()));
    
        List<Individuo> filhos = new ArrayList();
        filhos.add(new Individuo(this.pesos, this.beneficios,this.limitePeso));    ///aquii tem erro
        filhos.add(new Individuo(this.pesos, this.beneficios,this.limitePeso));   ///aquii tem erro
        
        filhos.get(0).setCromossomos(filho1);
        filhos.get(0).setGeracao(this.geracao+1);
        filhos.get(1).setCromossomos(filho2);
        filhos.get(1).setGeracao(this.geracao+1);
        
        return filhos;
    }
    
    public Individuo mutacao(Double taxaMutacao){
        
        for(int i =0; i<this.cromossomos.size();i++){
            if(Math.random()< taxaMutacao){
                if(this.cromossomos.get(i).equals("0")){
                     this.cromossomos.set(i,"1");
                }
                else{
                     this.cromossomos.set(i,"0");
                }  
            }  
        }
        return this;
    }

    
    

}

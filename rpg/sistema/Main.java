package rpg.sistema;

import rpg.armas.*;
import rpg.personagens.*;


public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Padrões de Projeto: RPG com Padrão Strategy ---");
        
        Guerreiro thor = new Guerreiro("Thor, o Bárbaro");
        Mago merlin = new Mago("Merlin, o Sábio");
        Arqueiro legolas = new Arqueiro("Legolas, o Veloz");
        
        EspadaLonga espada = new EspadaLonga();
        MachadoGuerra machado = new MachadoGuerra();
        CajadoArcano cajado = new CajadoArcano();
        ArcoElfico arco = new ArcoElfico();
        AdagaSombria adaga = new AdagaSombria();
        
        System.out.println("\n--- FASE DE EQUIPAMENTO E REQUISITOS ---");
        thor.equiparArma(espada);      
        thor.equiparArma(cajado);      
        legolas.equiparArma(arco);     
        merlin.equiparArma(cajado);    
        
        
        thor.equiparArma(machado); 
        
        Batalha luta = new Batalha(thor, merlin);
        

        luta.iniciar();
    }
}
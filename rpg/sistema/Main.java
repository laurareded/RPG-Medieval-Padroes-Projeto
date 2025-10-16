package rpg.sistema;

import rpg.armas.*;
import rpg.personagens.*;


public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Padrões de Projeto: RPG com Padrão Strategy (Extensões) ---");
        
        Guerreiro thor = new Guerreiro("Thor, o Bárbaro");
        Mago merlin = new Mago("Merlin, o Sábio");
        Arqueiro legolas = new Arqueiro("Legolas, o Veloz");
        Samurai kenshin = new Samurai("Kenshin, o Samurai"); 

        EspadaLonga espada = new EspadaLonga();
        MachadoGuerra machado = new MachadoGuerra();
        CajadoArcano cajado = new CajadoArcano();
        ArcoElfico arco = new ArcoElfico();
        AdagaSombria adaga = new AdagaSombria();
        Katana katana = new Katana(); 
        
        System.out.println("\n--- FASE DE EQUIPAMENTO E REQUISITOS ---");
        thor.equiparArma(machado);
        merlin.equiparArma(cajado);
        legolas.equiparArma(arco);
        kenshin.equiparArma(katana); 

        
        thor.equiparArma(espada); 
        kenshin.equiparArma(katana); 
        
        Batalha luta = new Batalha(kenshin, thor);
        
        luta.iniciar();
    }
}
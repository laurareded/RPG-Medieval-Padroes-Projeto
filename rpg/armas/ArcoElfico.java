package rpg.armas;

import java.util.Random;
import rpg.personagens.Personagem;

public class ArcoElfico implements Arma {
    private static final Random RAND = new Random();
    
    private static final int DANO_BASE = 12;
    private static final int CUSTO_MANA = 15;
    private static final int REQUISITO_DESTREZA = 8;
    private static final double MULTIPLICADOR_AREA = 1.5;
    private static final int CHANCE_CRITICO = 15; 

    @Override
    public String getNome() {
        return "Arco Élfico";
    }

    @Override
    public int getDanoBase() {
        return DANO_BASE;
    }

    @Override
    public int getCustoMana() {
        return CUSTO_MANA;
    }

    @Override
    public String getRequisito() {
        return "Destreza ≥ " + REQUISITO_DESTREZA;
    }

    @Override
    public boolean temRequisito(Personagem p) {
        return p.getDestreza() >= REQUISITO_DESTREZA;
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        if (atacante.getMana() < CUSTO_MANA) {
            System.out.println("   [Ataque Falhou] Mana insuficiente para usar " + getNome() + " (Custo: " + CUSTO_MANA + ").");
            return;
        }

        atacante.setMana(atacante.getMana() - CUSTO_MANA); 


        int danoBase = (int) (DANO_BASE * MULTIPLICADOR_AREA) + atacante.getDestreza() / 2;
        int danoAleatorio = danoBase + RAND.nextInt(5) - 2; 
        boolean isCritico = RAND.nextInt(100) < CHANCE_CRITICO;

        int danoFinal = danoAleatorio;
        if (isCritico) {
            danoFinal *= 2;
            System.out.println("   -> [CRÍTICO!] Dano duplicado!");
        }
        
        System.out.println(atacante.getNome() + " dispara Chuva de Flechas com " + getNome() + "!");
        System.out.println("   -> [Especial] Dano em área (simulado). Dano total: " + danoFinal + ".");
        
        alvo.receberDano(danoFinal);
    }
}
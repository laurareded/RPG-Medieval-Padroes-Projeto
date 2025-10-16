package rpg.armas;

import java.util.Random;
import rpg.efeitos.QueimaduraEffect;
import rpg.personagens.Personagem;

public class CajadoArcano implements Arma {
    private static final Random RAND = new Random();
    
    private static final int DANO_BASE = 8;
    private static final int CUSTO_MANA = 25;
    private static final int REQUISITO_INT = 12;
    private static final int CHANCE_CRITICO = 15; 

    @Override
    public String getNome() {
        return "Cajado Arcano";
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
        return "Inteligência ≥ " + REQUISITO_INT;
    }

    @Override
    public boolean temRequisito(Personagem p) {
        return p.getInteligencia() >= REQUISITO_INT;
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        if (atacante.getMana() < CUSTO_MANA) {
            System.out.println("   [Ataque Falhou] Mana insuficiente para usar " + getNome() + " (Custo: " + CUSTO_MANA + ").");
            return;
        }
        atacante.setMana(atacante.getMana() - CUSTO_MANA); 

        int danoBase = DANO_BASE + atacante.getInteligencia() / 2; 
        int danoAleatorio = danoBase + RAND.nextInt(5) - 2; 
        boolean isCritico = RAND.nextInt(100) < CHANCE_CRITICO;

        int danoFinal = danoAleatorio;
        if (isCritico) {
            danoFinal *= 2;
            System.out.println("   -> [CRÍTICO!] Dano duplicado!");
        }
        
        System.out.println(atacante.getNome() + " conjura Bola de Fogo com " + getNome() + ", causando " + danoFinal + " de dano.");
        alvo.receberDano(danoFinal);

        System.out.println("   -> [Especial] Bola de Fogo! " + alvo.getNome() + " está sofrendo Queimadura.");
        alvo.adicionarEfeito(new QueimaduraEffect(alvo)); 
    }
}
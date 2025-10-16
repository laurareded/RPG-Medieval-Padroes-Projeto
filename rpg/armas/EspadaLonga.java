package rpg.armas;

import java.util.Random;
import rpg.efeitos.SangramentoEffect;
import rpg.personagens.Personagem;

public class EspadaLonga implements Arma {
    private static final Random RAND = new Random();
    
    private static final int DANO_BASE = 15;
    private static final int REQUISITO_FORCA = 10;
    private static final int CHANCE_SANGRAMENTO = 30; 
    private static final int CHANCE_CRITICO = 15; 

    @Override
    public String getNome() {
        return "Espada Longa";
    }

    @Override
    public int getDanoBase() {
        return DANO_BASE;
    }

    @Override
    public int getCustoMana() {
        return 0;
    }

    @Override
    public String getRequisito() {
        return "Força ≥ " + REQUISITO_FORCA;
    }

    @Override
    public boolean temRequisito(Personagem p) {
        return p.getForca() >= REQUISITO_FORCA;
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        int danoBase = DANO_BASE + atacante.getForca() / 3; 
        int danoAleatorio = danoBase + RAND.nextInt(5) - 2; 
        boolean isCritico = RAND.nextInt(100) < CHANCE_CRITICO; 

        int danoFinal = danoAleatorio;
        if (isCritico) {
            danoFinal *= 2; 
            System.out.println("   -> [CRÍTICO!] Dano duplicado!");
        }
        
        System.out.println(atacante.getNome() + " ataca com " + getNome() + ", causando " + danoFinal + " de dano.");
        alvo.receberDano(danoFinal);

        if (RAND.nextInt(100) < CHANCE_SANGRAMENTO) {
            System.out.println("   -> [Especial] Corte Profundo! " + alvo.getNome() + " está Sangrando.");
            alvo.adicionarEfeito(new SangramentoEffect(alvo));
        }
    }
}
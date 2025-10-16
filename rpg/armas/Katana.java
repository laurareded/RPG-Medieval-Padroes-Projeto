package rpg.armas;

import java.util.Random;
import rpg.efeitos.VulnerabilidadeEffect;
import rpg.personagens.Personagem;

public class Katana implements Arma {
    private static final Random RAND = new Random();
    private static final int DANO_BASE = 14;
    private static final int CUSTO_MANA = 10;
    private static final int REQUISITO_STR = 10;
    private static final int REQUISITO_DEX = 10;
    private static final int CHANCE_VULNERABILIDADE = 40; // 40%
    private static final int CHANCE_CRITICO = 15; // 15%

    @Override
    public String getNome() { return "Katana"; }
    @Override
    public int getDanoBase() { return DANO_BASE; }
    @Override
    public int getCustoMana() { return CUSTO_MANA; }
    
    @Override
    public String getRequisito() {
        return "Força ≥ " + REQUISITO_STR + " E Destreza ≥ " + REQUISITO_DEX;
    }
    
    @Override
    public boolean temRequisito(Personagem p) {
        return p.getForca() >= REQUISITO_STR && p.getDestreza() >= REQUISITO_DEX;
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        if (atacante.getMana() < CUSTO_MANA) {
            System.out.println("   [Ataque Falhou] Mana insuficiente para usar " + getNome() + ".");
            return;
        }
        atacante.setMana(atacante.getMana() - CUSTO_MANA);

        int danoBase = DANO_BASE + atacante.getDestreza() / 3; 
        int danoAleatorio = danoBase + RAND.nextInt(5) - 2; 
        boolean isCritico = RAND.nextInt(100) < CHANCE_CRITICO; 

        int danoFinal = danoAleatorio;
        if (isCritico) {
            danoFinal *= 2; 
            System.out.println("   -> [CRÍTICO!] Dano duplicado!");
        }

        System.out.println(atacante.getNome() + " desfere um golpe rápido com a Katana, causando " + danoFinal + " de dano.");
        alvo.receberDano(danoFinal);

        if (RAND.nextInt(100) < CHANCE_VULNERABILIDADE) {
            System.out.println("   -> [Especial] Corte da Vulnerabilidade! " + alvo.getNome() + " está Vulnerável.");
            alvo.adicionarEfeito(new VulnerabilidadeEffect(alvo)); 
        }
    }
}
package rpg.armas;

import java.util.Random;
import rpg.efeitos.AtordoadoEffect;
import rpg.personagens.Personagem;


public class MachadoGuerra implements Arma {
    private static final Random RAND = new Random();
    private static final int DANO_BASE = 18;
    private static final int CUSTO_MANA = 5;
    private static final int REQUISITO_FORCA = 15;
    private static final int CHANCE_ATORDOAR = 25; // 25%

    @Override
    public String getNome() {
        return "Machado de Guerra";
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
        return "Força ≥ " + REQUISITO_FORCA;
    }

    @Override
    public boolean temRequisito(Personagem p) {
        return p.getForca() >= REQUISITO_FORCA;
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        if (atacante.getMana() < CUSTO_MANA) {
            System.out.println("   [Ataque Falhou] Mana insuficiente para usar " + getNome() + ".");
            return;
        }

        atacante.setMana(atacante.getMana() - CUSTO_MANA); 


        int danoFinal = DANO_BASE;
        System.out.println(atacante.getNome() + " desfere " + getNome() + ", causando " + danoFinal + " de dano.");
        
        alvo.receberDano(danoFinal);

        if (RAND.nextInt(100) < CHANCE_ATORDOAR) {
            System.out.println("   -> [Especial] Golpe Esmagador! " + alvo.getNome() + " foi ATORDOADO.");
            alvo.adicionarEfeito(new AtordoadoEffect(alvo)); 
        }
    }
}
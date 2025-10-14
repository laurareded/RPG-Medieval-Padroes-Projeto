package rpg.armas;

import rpg.personagens.Personagem;

public class AdagaSombria implements Arma {
    private static final int DANO_BASE = 10;
    private static final int CUSTO_MANA = 10;
    private static final int REQUISITO_DESTREZA = 12;
    private static final int MULTIPLICADOR_FURTIVO = 3; 

    @Override
    public String getNome() {
        return "Adaga Sombria";
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
            System.out.println("   [Ataque Falhou] Mana insuficiente para usar " + getNome() + ".");
            return;
        }

        atacante.setMana(atacante.getMana() - CUSTO_MANA); 

        int danoFinal = DANO_BASE;
        
        if (atacante.getDestreza() > alvo.getDestreza()) {
            danoFinal *= MULTIPLICADOR_FURTIVO;
            System.out.println("   -> [Especial] Ataque Furtivo! Dano Triplo contra alvo desprevenido!");
        }
        
        System.out.println(atacante.getNome() + " ataca furtivamente com " + getNome() + ", causando " + danoFinal + " de dano.");
        alvo.receberDano(danoFinal);
    }
}

package rpg.armas;

import rpg.personagens.Personagem;

public class ArcoElfico implements Arma {
    private static final int DANO_BASE = 12;
    private static final int CUSTO_MANA = 15;
    private static final int REQUISITO_DESTREZA = 8;
    private static final double MULTIPLICADOR_AREA = 2.0; 

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

        int danoEspecial = (int) (DANO_BASE * MULTIPLICADOR_AREA);
        
        System.out.println(atacante.getNome() + " dispara Chuva de Flechas com " + getNome() + "!");
        System.out.println("   -> [Especial] Dano em área (simulado). Dano total: " + danoEspecial + ".");
        
        alvo.receberDano(danoEspecial);
    }
}

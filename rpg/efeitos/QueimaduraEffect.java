package rpg.efeitos;

import rpg.personagens.Personagem;


public class QueimaduraEffect implements StatusEffect {
    private int turnosRestantes = 2;
    private static final int DANO_POR_TURNO = 10;


    private final Personagem alvo; 

    public QueimaduraEffect(Personagem alvo) {
        this.alvo = alvo;
    }

    @Override
    public String getNome() {
        return "Queimadura";
    }

    @Override
    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        if (isAtivo()) {
            System.out.println("   [EFEITO] " + alvo.getNome() + " está queimando, perdendo " + DANO_POR_TURNO + " de vida.");
            alvo.receberDano(DANO_POR_TURNO);
        }
    }

    @Override
    public void decrementarTurno() {
        if (turnosRestantes > 0) {
            turnosRestantes--;
            if (turnosRestantes == 0) {
                System.out.println("   [EFEITO] Queimadura em " + alvo.getNome() + " cessou."); 
            }
        }
    }

    @Override
    public boolean isAtivo() {
        return turnosRestantes > 0;
    }
}
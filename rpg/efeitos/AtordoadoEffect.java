package rpg.efeitos;

import rpg.personagens.Personagem;

public class AtordoadoEffect implements StatusEffect {

    private int turnosRestantes = 1; 
    

    private final Personagem alvo; 
    

    public AtordoadoEffect(Personagem alvo) {
        this.alvo = alvo;
    }

    @Override
    public String getNome() {
        return "Atordoado";
    }

    @Override
    public int getTurnosRestantes() {
        return turnosRestantes;
    }

 
    @Override
    public void aplicarEfeito(Personagem alvo) {
        if (isAtivo()) {
            System.out.println("   [EFEITO] " + alvo.getNome() + " está atordoado e não pode agir neste turno.");

        }
    }

    @Override
    public void decrementarTurno() {

        if (turnosRestantes > 0) {
            turnosRestantes--;
            if (turnosRestantes == 0) {
                System.out.println("   [EFEITO] Atordoamento em " + alvo.getNome() + " passou."); 
            }
        }
    }

    @Override
    public boolean isAtivo() {
        return turnosRestantes > 0;
    }
}
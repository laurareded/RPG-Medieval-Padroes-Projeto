package rpg.personagens;

public class Mago extends Personagem {
    private static final int REGEN_MANA_POR_TURNO = 10;

    public Mago(String nome) {
        super(nome, 70, 150, 5, 7, 18); 
    }

    @Override
    protected int aplicarPassivaDefesa(int danoBruto) {
        return danoBruto;
    }

    @Override
    protected void aplicarPassivaTurno() {
        if (mana < manaMaxima) {
            mana = Math.min(manaMaxima, mana + REGEN_MANA_POR_TURNO);
            System.out.println("   [Passiva] Regeneração de Mana: +10 Mana. Mana atual: " + mana);
        }
    }
}

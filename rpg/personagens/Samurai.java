package rpg.personagens;

public class Samurai extends Personagem {
    private static final int VIDA_BASE = 110;
    private static final int MANA_BASE = 80;
    private static final int REGEN_MANA_POR_TURNO = 10;
    
    private static final int FORCA_BASE = 12; 
    private static final int INTELIGENCIA_BASE = 5;
    private static final int DESTREZA_BASE = 15;

    public Samurai(String nome) {
        super(nome, VIDA_BASE, MANA_BASE, FORCA_BASE, DESTREZA_BASE, INTELIGENCIA_BASE);
    }

    @Override
    protected int aplicarPassivaDefesa(int danoBruto) {
        return danoBruto;
    }
    
    @Override
    protected void aplicarPassivaTurno() {
        if (this.mana < this.manaMaxima) {
            this.mana = Math.min(this.manaMaxima, this.mana + REGEN_MANA_POR_TURNO);
            System.out.println("   [Passiva] Maestria de Batalha: +" + REGEN_MANA_POR_TURNO + " Mana. Mana atual: " + this.mana);
        }
    }
}
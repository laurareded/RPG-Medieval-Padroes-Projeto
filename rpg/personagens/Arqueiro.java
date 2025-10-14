package rpg.personagens;

import java.util.Random;


public class Arqueiro extends Personagem {
    private static final Random RAND = new Random();
    private static final int CHANCE_ESQUIVA = 25; 

    public Arqueiro(String nome) {

        super(nome, 90, 80, 8, 15, 7); 
    }


    @Override
    protected int aplicarPassivaDefesa(int danoBruto) {
        if (RAND.nextInt(100) < CHANCE_ESQUIVA) {
            System.out.println("   [Passiva] Esquiva bem-sucedida! O Arqueiro evitou todo o dano.");
            return 0; 
        }
        return danoBruto;
    }

    @Override
    protected void aplicarPassivaTurno() {
    }
}

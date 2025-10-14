package rpg.personagens;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 50, 15, 8, 5); 
    }

    @Override
    protected int aplicarPassivaDefesa(int danoBruto) {
        int danoReduzido = (int) (danoBruto * 0.80);
        System.out.println("   [Passiva] Pele Dura reduziu o dano de " + danoBruto + " para " + danoReduzido + ".");
        return danoReduzido;
    }

    @Override
    protected void aplicarPassivaTurno() {
    }
    

}

package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.armas.Arma;
import rpg.efeitos.StatusEffect;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int mana;
    protected int manaMaxima; 
    protected int forca;
    protected int destreza;
    protected int inteligencia;


    protected Arma armaEquipada; 
    
    protected List<StatusEffect> efeitosAtivos = new ArrayList<>();

    public Personagem(String nome, int vida, int mana, int forca, int destreza, int inteligencia) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.mana = mana;
        this.manaMaxima = mana; 
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
    }

    public void equiparArma(Arma novaArma) {
        if (novaArma.temRequisito(this)) {
            this.armaEquipada = novaArma;
            System.out.println(nome + " equipou: " + novaArma.getNome());
        } else {
            System.out.println(nome + " não pode equipar " + novaArma.getNome() + 
                               " (Requisito: " + novaArma.getRequisito() + ")");
        }
    }

    public void atacar(Personagem alvo) {
        if (armaEquipada == null) {
            System.out.println(nome + " não tem arma equipada e não pode atacar.");
            return;
        }
        
        System.out.println("\nTURNO de " + nome);

        armaEquipada.atacar(this, alvo); 
    }

    public void receberDano(int danoBruto) {

        int danoReduzido = aplicarPassivaDefesa(danoBruto); 
        this.vida -= danoReduzido;
        if (this.vida < 0) this.vida = 0;
        System.out.println("   " + nome + " recebeu " + danoReduzido + " de dano. Vida restante: " + vida);
    }
    
    public void adicionarEfeito(StatusEffect efeito) {
 
        efeitosAtivos.add(efeito);
    }

    public void aplicarEfeitosDeTurno() {

        efeitosAtivos.forEach(e -> e.aplicarEfeito(this));
        

        efeitosAtivos.forEach(StatusEffect::decrementarTurno);
        efeitosAtivos.removeIf(e -> !e.isAtivo());

        aplicarPassivaTurno();
    }
    

    protected abstract int aplicarPassivaDefesa(int danoBruto); 
    protected abstract void aplicarPassivaTurno();              
    
    public boolean estaVivo() { return vida > 0; }
    

    public int getForca() { return forca; }
    public int getDestreza() { return destreza; }
    public int getInteligencia() { return inteligencia; }
    public String getNome() { return nome; }
    public int getMana() { return mana; }
    public int getVida() { return vida; } 
    

    public List<StatusEffect> getEfeitosAtivos() {
        return efeitosAtivos;
    }
    
    public void setMana(int novaMana) {
        this.mana = novaMana;
    }
    
    public int getManaMaxima() { return manaMaxima; }
}
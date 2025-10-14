package rpg.armas;

import rpg.personagens.Personagem;


public interface Arma {
    String getNome();
    int getDanoBase();
    int getCustoMana();
    String getRequisito();
    boolean temRequisito(Personagem p);

    /**
     * O método principal que define a estratégia de ataque.
     * @param atacante O personagem que está atacando.
     * @param alvo O personagem que está recebendo o ataque.
     */
    void atacar(Personagem atacante, Personagem alvo);
}

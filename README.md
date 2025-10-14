# ⚔️ RPG Medieval: Combate com Padrões de Projeto

Este repositório contém a solução para a atividade avaliativa de Padrões de Projeto, implementando um sistema de combate de RPG medieval focado no **Padrão Strategy**.

O projeto demonstra como desacoplar a lógica de ataque (Arma) da classe principal (Personagem), permitindo a troca dinâmica de táticas de combate e a fácil adição de novas funcionalidades (Efeitos de Status).

## 💡 Padrão de Projeto Principal: Strategy

O Strategy é aplicado para permitir que o **comportamento de ataque** de um personagem seja alterado dinamicamente ao trocar de arma.

| Conceito | Classe/Interface | Função no Projeto |
| :--- | :--- | :--- |
| **Strategy (Interface)** | `Arma` | Define o contrato de ataque (`atacar(atacante, alvo)`) comum a todas as armas. |
| **Concrete Strategy** | `EspadaLonga`, `CajadoArcano`, `MachadoGuerra`, etc. | Implementam a lógica de ataque e os efeitos especiais específicos de cada arma. |
| **Context** | `Personagem` | Mantém uma referência para a `Arma` equipada e delega a execução do ataque a ela, sem saber qual estratégia concreta está usando. |

**Justificativa:** O Padrão Strategy garante que o código do `Personagem` permaneça *fechado para modificação* (não precisa mudar a classe quando uma nova arma é criada), mas *aberto para extensão* (novas armas/estratégias podem ser adicionadas facilmente).

---

## 📂 Estrutura e Implementação

O código está modularizado nos seguintes pacotes:

| Pacote | Conteúdo Principal | Responsabilidade |
| :--- | :--- | :--- |
| **`rpg.personagens`** | `Personagem`, `Guerreiro`, `Mago`, `Arqueiro`. | O **Contexto**. Gerencia atributos, passivas e recebe o ataque. |
| **`rpg.armas`** | `Arma` (Interface), `EspadaLonga`, `ArcoElfico`, etc. | A **Estratégia**. Lógica de dano, custo de Mana e aplicação de efeitos. |
| **`rpg.efeitos`** | `StatusEffect` (Interface), `SangramentoEffect`, `AtordoadoEffect`, etc. | Implementação de lógica de estado. Gerencia duração e dano por turno. |
| **`rpg.sistema`** | `Batalha`, `Main`. | Gerencia o loop de turnos, verifica atordoamento e demonstra a execução. |

---

## 🛠 Como Executar

O projeto foi desenvolvido em Java, utilizando uma estrutura de pacotes que permite a compilação e execução via terminal (PowerShell).

**Pré-requisito:** Estar na pasta raiz do projeto (`.../RPG-Medieval-Padroes-Projeto`).

1.  **Compilar (Gera os arquivos .class):**
    ```bash
    javac (Get-ChildItem -Recurse -Path "rpg" -Include "*.java").FullName
    ```
2.  **Executar (Roda a simulação de combate):**
    ```bash
    java rpg.sistema.Main
    ```

**Status:** Funcional e testado.

---
*Laura Reded de Melo*
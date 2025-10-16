# ⚔️ RPG Medieval - Disciplina Padrões de Projeto

Este repositório contém a solução para a atividade avaliativa de Padrões de Projeto, implementando um sistema de combate de RPG medieval focado no **Padrão Strategy**.

O projeto demonstra como desacoplar a lógica de ataque (Arma) da classe principal (Personagem), permitindo a troca dinâmica de táticas de combate e a fácil adição de novas funcionalidades (Efeitos de Status).

## 💡 Padrão de Projeto Principal: Strategy

O Strategy é aplicado para permitir que o **comportamento de ataque** de um personagem seja alterado dinamicamente ao trocar de arma.

| Conceito | Classe/Interface | Função no Projeto |
| :--- | :--- | :--- |
| **Strategy (Interface)** | `Arma` | Define o contrato de ataque (`atacar(atacante, alvo)`) comum a todas as armas. |
| **Concrete Strategy** | **6 Armas** (`EspadaLonga`, `Katana`, etc.) | Implementam a lógica de ataque, crítico e os efeitos especiais. |
| **Context** | `Personagem` | Mantém a referência para a `Arma` e delega a execução do ataque, garantindo flexibilidade. |

**Justificativa:** O Padrão Strategy garante que o código do `Personagem` permaneça *fechado para modificação* (não precisa mudar a classe quando uma nova arma é criada), mas *aberto para extensão* (novas armas/estratégias podem ser adicionadas facilmente). Isso atende ao **Princípio Aberto/Fechado (OCP)**.

---

## 🚀 Extensões e Funcionalidades Avançadas

O projeto inclui todas as extensões solicitadas:

| Extensão | Implementação | Arquivos Principais |
| :--- | :--- | :--- |
| **Personagem Híbrido** | Criada a classe `Samurai` (híbrido Força/Destreza), que possui a passiva "Maestria de Batalha" (Regeneração de Mana por turno). | `Samurai.java` |
| **Nova Arma com Efeito Único** | Criada a `Katana`, que tem chance de aplicar o efeito "Vulnerabilidade". | `Katana.java`, `VulnerabilidadeEffect.java` |
| **Sistema de Crítico e Dano Aleatório**| Adicionada a lógica de dano flutuante (+/- 2) e chance de **Crítico (dano duplicado)** em **todas** as classes de armas. | Todas as classes em `rpg.armas` |

---

## 📂 Estrutura de Pacotes

| Pacote | Conteúdo Principal | Destaques |
| :--- | :--- | :--- |
| **`rpg.personagens`** | `Personagem`, `Guerreiro`, `Mago`, `Arqueiro`, **`Samurai`**. | O **Contexto** principal. Gerencia atributos e passivas (e.g., `Pele Dura`, `Regen Mana`). |
| **`rpg.armas`** | `Arma` (Interface), `EspadaLonga`, **`Katana`**, etc. | A **Estratégia**. Contém a lógica de ataque, crítico e requisitos. |
| **`rpg.efeitos`** | `StatusEffect` (Interface), `SangramentoEffect`, **`VulnerabilidadeEffect`**, etc. | Gerencia estados temporários e lógica de dano/alteração de recebimento de dano. |
| **`rpg.sistema`** | `Batalha`, `Main`. | Gerencia o loop de turnos, verifica atordoamento e demonstra a execução. |

---

## 🛠 Como Executar

O projeto foi desenvolvido em Java e a execução ocorre a partir da linha de comando (PowerShell), na pasta raiz do repositório.

**Pré-requisito:** Estar na pasta raiz do projeto (`.../RPG-Medieval-Padroes-Projeto`).

1.  **Compilar (Gera os arquivos .class):**
    ```bash
    javac (Get-ChildItem -Recurse -Path "rpg" -Include "*.java").FullName
    ```
2.  **Executar (Roda a simulação de combate):**
    ```bash
    java rpg.sistema.Main
    ```

**Status:** Funcional e testado.

---
*Laura Reded de Melo*
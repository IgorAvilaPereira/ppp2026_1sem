# 📚 Lista 1 bim.

---

# ✅ 01 — Strategy

## 🧠 Ideia

Trocar algoritmos dinamicamente sem alterar o cliente.

---

## 💻 Exercício 1 — Sistema de Impostos

(igual ao anterior)

Interface:
`CalculoImposto`

Estratégias:

* Simples Nacional
* Lucro Presumido
* Lucro Real

Contexto:
`NotaFiscal`

Objetivo → eliminar condicionais.

---

## 💻 Exercício 2 — Sistema de Pagamentos

Um e-commerce aceita múltiplos pagamentos.

### Estratégias

* `PagamentoPix`
* `PagamentoCartaoCredito`
* `PagamentoBoleto`
* `PagamentoCarteiraDigital`

### Contexto

`Checkout`

### Requisitos

* método `pagar(valor)`
* permitir adicionar novos meios de pagamento sem alterar o checkout.

👉 Simula gateways reais.

---

# ✅ 02 — State + Observer (Integrados)

## 🧠 Ideia

* **State** → comportamento interno
* **Observer** → propagação de eventos

---

## 💻 Exercício 1 — Pedido de E-commerce

Estados:

* Criado
* Pago
* Enviado
* Cancelado

Observers:

* Email
* Estoque
* Faturamento
* Analytics

Fluxo:

```
Estado valida → muda estado → notifica observers
```

---

## 💻 Exercício 2 — Sistema de Entrega (Delivery Tracking)

Agora o pedido possui **rastreamento em tempo real**.

### Estados (STATE)

* Preparando
* SaiuParaEntrega
* EmRota
* Entregue
* FalhaEntrega

### Observadores (OBSERVER)

* AppCliente
* AppEntregador
* SistemaMapa
* NotificacaoPush

### Objetivo

Simular apps como Uber Eats / iFood.

👉 Mudança de estado dispara atualizações em tempo real.

---

# ✅ 03 — Template Method

## 🧠 Ideia

Fluxo fixo + etapas customizáveis.

---

## 💻 Exercício 1 — Processador de Arquivos

CSV / JSON / XML.

---

## 💻 Exercício 2 — Pipeline de Build (CI/CD)

Classe abstrata:
`PipelineBuild`

Template:

```
executarPipeline()
  baixarCodigo()
  compilar()
  rodarTestes()
  gerarArtefato()
  publicar()
```

Implementações:

* BuildJava
* BuildNode
* BuildPython

👉 Igual Jenkins/GitHub Actions internamente.

---

# ✅ 04 — Command

## 🧠 Ideia

Transformar ações em objetos.

---

## 💻 Exercício 1 — Editor de Texto

Com Undo + Macro.

---

## 💻 Exercício 2 — Automação Residencial

Receiver:
`CasaInteligente`

Comandos:

* LigarLuz
* DesligarLuz
* AbrirPortao
* FecharCortina
* AjustarTemperatura

Invoker:
`CentralAutomacao`

### Extra

Criar:

```
ModoNoiteCommand
```

(Executa vários comandos).

👉 Command composto.

---

# ✅ 05 — State

## 🧠 Ideia

Cada estado define comportamento próprio.

---

## 💻 Exercício 1 — Máquina de Venda

(Sem observer — treino isolado)

Estados:

* SemMoeda
* ComMoeda
* ProdutoSelecionado
* Esgotado

---

## 💻 Exercício 2 — Conexão de Rede

Contexto:
`ConexaoInternet`

Estados:

* Desconectado
* Conectando
* Conectado
* Reconectando
* Falha

Operações:

* conectar()
* enviarDados()
* reconectar()

👉 Remove vários `if(connectionStatus)`.

---

# ✅ 06 — Iterator

## 🧠 Ideia

Separar coleção de navegação.

---

## 💻 Exercício 1 — Biblioteca Digital

Iteradores:

* normal
* reverso
* disponíveis

---

## 💻 Exercício 2 — Feed de Rede Social

Coleção:
`FeedPosts`

Iteradores:

* cronológico
* maisCurtidos
* apenasAmigos
* apenasVideos

Cliente percorre posts sem conhecer estrutura interna.

👉 Igual timeline real.

---

# 🧩 DESAFIO EXTRA — 🔥 Player de Música (Arquitetura Completa)

Construa um Player usando múltiplos patterns cooperando.

---

## 🎵 Strategy

Modo reprodução:

* Normal
* Aleatório
* Repetir

---

## ▶ State

Estado:

* Play
* Pause
* Stop
* Buffering

---

## 🔔 Observer

Atualizações automáticas:

* UI
* Barra progresso
* Recomendações
* Histórico
* Scrobbler

---

## 🎮 Command

Botões:

* Play
* Pause
* Next
* Previous
* Volume

Com:

* Undo
* histórico
* macro

---

## 🧠 Regra Senior

Adicionar qualquer elemento novo **sem modificar código existente**.




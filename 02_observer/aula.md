# 📘 Padrão de Projeto Observer

🎯 Objetivo: Compreender profundamente o padrão Observer, sua motivação, estrutura, implementação e implicações arquiteturais.

---

# 🧭 1ª Parte – Problema e Motivação (1h)

## 1️⃣ Contextualização (20 min)

Iniciar com um problema real:

> “Como projetar um sistema onde vários objetos precisam reagir automaticamente quando outro objeto muda de estado?”

Exemplos práticos:

* Sistema de notificações acadêmicas
* Atualização automática de interface
* Monitoramento de sensores
* Eventos em interfaces gráficas
* Sistemas orientados a eventos

### Problema central:

Evitar dependências diretas como:

```java
class Sistema {
    EmailService email;
    SmsService sms;
}
```

Explorar:

* Alto acoplamento
* Código rígido
* Violação do Open/Closed Principle
* Baixa escalabilidade

---

## 2️⃣ Conceito Formal do Observer (20 min)

Definição clássica:

> Define uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados automaticamente.

Classificação:

* Padrão **Comportamental**
* Presente no catálogo GoF (1994)

Conceitos-chave:

* Subject (Observável)
* Observer (Observador)
* Registro dinâmico
* Notificação automática
* Desacoplamento estrutural

---

## 3️⃣ Base Teórica: Acoplamento e Coesão (20 min)

Discutir:

### 🔹 Alto acoplamento

Objetos conhecem implementações concretas.

### 🔹 Baixo acoplamento

Objetos dependem de abstrações.

Observer promove:

* Dependência por interface
* Extensibilidade
* Flexibilidade arquitetural

Relacionar com princípios SOLID:

* OCP
* DIP

---

# 🧱 2ª Parte – Estrutura do Padrão (1h20)

## 4️⃣ Estrutura UML e Papéis (30 min)

Componentes:

### 🔹 Subject

* Mantém lista de observers
* Fornece métodos attach/detach
* Dispara notificações

### 🔹 Observer

* Define método update()

### 🔹 ConcreteSubject

* Implementa lógica de negócio
* Armazena estado

### 🔹 ConcreteObserver

* Reage às mudanças

Estrutura conceitual:

```
Subject
+ attach()
+ detach()
+ notify()

Observer
+ update()
```

Fluxo interno:

1. Observer se registra
2. Subject altera estado
3. notify() é chamado
4. update() é executado

---

## 5️⃣ Implementação Completa (Java) (50 min)

### Interface Observer

```java
public interface Observer {
    void update(String mensagem);
}
```

---

### Interface Subject

```java
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
```

---

### Implementação Concreta

```java
import java.util.ArrayList;
import java.util.List;

public class Canal implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String novoConteudo;

    public void publicar(String conteudo) {
        this.novoConteudo = conteudo;
        notifyObservers();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(novoConteudo);
        }
    }
}
```

---

### Observer Concreto

```java
public class Usuario implements Observer {

    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void update(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
}
```

---

### Classe de Teste

```java
public class Main {
    public static void main(String[] args) {

        Canal canal = new Canal();

        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Carlos");

        canal.attach(u1);
        canal.attach(u2);

        canal.publicar("Novo vídeo disponível!");
    }
}
```

---

# ⚙ 3ª Parte – Conceitos Avançados (1h20)

## 6️⃣ Modelo Push vs Pull (25 min)

### 🔹 Push Model

Subject envia dados no update().

Vantagem:

* Simples

Desvantagem:

* Pode enviar dados desnecessários

---

### 🔹 Pull Model

Observer recebe referência ao Subject e consulta dados.

Exemplo conceitual:

```java
void update(Subject s)
```

Vantagem:

* Flexível

Desvantagem:

* Maior acoplamento conceitual

---

## 7️⃣ Observer em Arquiteturas Modernas (30 min)

Mostrar como o padrão aparece em:

### 🔹 Interfaces Gráficas

EventListener

### 🔹 JavaScript

addEventListener()

### 🔹 Node.js

EventEmitter

### 🔹 Spring Framework

ApplicationEventPublisher

### 🔹 Sistemas Reativos

Flux, Streams

Relacionar com:

* Arquitetura orientada a eventos
* Sistemas assíncronos
* Microsserviços
* Comunicação desacoplada

Explicar que modelos Pub/Sub distribuídos são uma evolução arquitetural do Observer clássico.

---

## 8️⃣ Problemas e Limitações (25 min)

### 🔴 Atualizações em cascata

Pode gerar efeito dominó.

### 🔴 Loop infinito

Observers modificando o Subject novamente.

### 🔴 Vazamento de memória

Observers não removidos.

### 🔴 Concorrência

Múltiplas threads notificando simultaneamente.

Discutir possíveis soluções:

* Sincronização
* Uso de coleções thread-safe
* WeakReference
* Filas de eventos
* Controle de estado para evitar ciclos

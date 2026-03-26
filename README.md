# 📦 Refactoring to Hexagonal Architecture

Este projeto demonstra a refatoração de uma aplicação Spring Boot de uma **arquitetura em camadas tradicional** para **Arquitetura Hexagonal (Ports and Adapters)**.

---

## 🌿 Branches do projeto

O repositório está organizado em duas abordagens arquiteturais:

### 🔹 `layered-architecture (Branch Main)`
- Arquitetura tradicional
- Baseada em:
  - Controller
  - Service
  - Repository
- Forte acoplamento entre camadas

---

### 🔹 `hexagonal-architecture`
- Arquitetura Hexagonal (Ports & Adapters)
- Separação clara entre:
  - Core (domínio + regras de negócio)
  - Ports (interfaces)
  - Adapters (integrações externas)

👉 **Dica:** Compare as duas branches para entender a evolução arquitetural.

---

## 🧠 Objetivo

Demonstrar na prática:

- Desacoplamento do core da aplicação
- Aplicação de Ports & Adapters
- Melhoria na testabilidade
- Evolução de arquitetura real

---

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- Maven

---

## 🧩 Arquitetura Hexagonal

### 📌 Diagrama

```
                ┌──────────────────────────────┐
                │        External World        │
                │  (HTTP, DB, APIs, etc)      │
                └─────────────┬────────────────┘
                              │
                ┌─────────────▼─────────────┐
                │     Adapters (IN/OUT)     │
                │                           │
                │  ┌─────────────────────┐  │
                │  │   Web Controller    │  │  ← Adapter IN
                │  └─────────────────────┘  │
                │  ┌─────────────────────┐  │
                │  │ Persistence Adapter │  │  ← Adapter OUT
                │  └─────────────────────┘  │
                └─────────────┬─────────────┘
                              │
                ┌─────────────▼─────────────┐
                │         PORTS             │
                │                           │
                │   IN        |     OUT     │
                │ (UseCases)  | (Gateways)  │
                └─────────────┬─────────────┘
                              │
                ┌─────────────▼─────────────┐
                │           CORE            │
                │                           │
                │  Domain + Use Cases       │
                │  (Regra de Negócio)       │
                └───────────────────────────┘
```

---

## 📁 Estrutura do Projeto

```
src/main/java/com/.../refactoring_to_hexagonal_arch

core/
 ├── domain/
 │    └── Product
 │
 ├── ports/
 │    ├── in/
 │    │    └── ProductServicePort
 │    └── out/
 │
 └── usecases/
      └── ProductService

infrastructure/
 ├── adapters/
 │    ├── in.web/
 │    │    ├── ProductController
 │    │    └── ProductRequestDTO
 │    │
 │    └── out.persistence/
 │         ├── ProductEntity
 │         ├── ProductJpaRepository
 │         └── ProductPersistenceAdapter
 │
 └── config/

RefactoringToHexagonalArchApplication
```

---

## 🔄 Fluxo da aplicação

```
HTTP Request
   ↓
Controller (Adapter IN)
   ↓
Port IN
   ↓
Use Case (Core)
   ↓
Port OUT
   ↓
Adapter OUT (Persistence)
   ↓
Database
```

---

## 🆚 Comparação: Antes vs Depois

### 🏗️ Arquitetura em Camadas

```
Controller → Service → Repository → Database
```

❌ Problemas:
- Alto acoplamento
- Difícil testar isoladamente
- Dependência direta do framework

---

### 🧩 Arquitetura Hexagonal

```
Controller → Port IN → UseCase → Port OUT → Adapter → Database
```

✅ Benefícios:
- Baixo acoplamento
- Alta testabilidade
- Independência de tecnologia
- Código mais organizado

---

## ▶️ Como rodar o projeto

```bash
# Clonar o repositório
git clone <repo-url>

# Entrar na pasta
cd refactoring-to-hexagonal-arch

# Escolher a branch
git checkout hexagonal-arch

# Rodar
./mvnw spring-boot:run
```

---

## 🧪 Testes

A arquitetura permite:

- Testar UseCases isoladamente
- Mockar Ports OUT
- Evitar dependência de banco ou framework

---

## 💡 Possíveis melhorias

- Adicionar testes unitários
- Implementar validações (Bean Validation)
- Criar DTOs de response
- Documentar com Swagger/OpenAPI
- Adicionar autenticação (JWT)

---

## 👨‍💻 Autor

Projeto desenvolvido para estudo de arquitetura de software e boas práticas com Spring Boot.

---

## ⭐ Conclusão

Este projeto mostra na prática que:

- Arquitetura Hexagonal melhora a organização do código
- O domínio deve ser o centro da aplicação
- O desacoplamento facilita evolução e manutenção

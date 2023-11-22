# MedControl API
Projeto referente à plataforma mobile de auxílio aos profissionais do ramo farmacêutico, denominado "MedControl". A finalidade principal é facilitar o controle de estoque e compras para farmácias, tornando o processo menos burocrático e mais eficiente. A API MedControl gerencia transações, funcionários, medicamentos, estoque, departamentos e unidades de trabalho para auxiliar profissionais do ramo farmacêutico no controle de estoque e compras.

# Endpoints

1. **Funcionário:**
   - Ancora: `funcionario`
   - Uso: [Funcionário](#funcionario)

2. **Transação:**
   - Ancora: `transacao`
   - Uso: [Transação](#transacao)

3. **Medicamento:**
   - Ancora: `medicamento`
   - Uso: [Medicamento](#medicamento)

4. **Estoque:**
   - Ancora: `estoque`
   - Uso: [Estoque](#estoque)

5. **Departamento:**
   - Ancora: `departamento`
   - Uso: [Departamento](#departamento)

6. **Unidade de Trabalho:**
   - Ancora: `unidade-de-trabalho`
   - Uso: [Unidade de Trabalho](#unidade-de-trabalho)
  

## Funcionário
#### Obter detalhes do funcionário a partir do ID

```http
GET /medcontrol/api/funcionario/{id}
```

**Parâmetros de URL:**

- `id` (obrigatório) - ID do funcionário

**Exemplo do corpo de Response:**

```json
{
   "id": 1,
   "nome": "João Silva",
   "cargo": "Farmacêutico",
   "identificacao": "Unidade A",
   "listaDeTransacoes": [
      {
         "id": 1,
         "nomeDoRemedio": "Paracetamol",
         "quantidade": 10,
         "dataHora": "2023-01-01T12:00:00"
      },
      {
         "id": 2,
         "nomeDoRemedio": "Ibuprofeno",
         "quantidade": 5,
         "dataHora": "2023-01-01T12:00:00"
      }
   ],
   "status": true
}
```

**Códigos de Resposta:**

| Código | Descrição |
| --- | --- |
| `200` | Dados retornados com sucesso |
| `404` | Funcionário não encontrado |

#### Listar todos os funcionários cadastrados

```http
GET /medcontrol/api/funcionario/listar
```

**Exemplo do corpo de Response:**

```json
[
   {
      "id": 1,
      "nome": "João Silva",
      "cargo": "Farmacêutico",
      "identificacao": "Unidade A",
      "listaDeTransacoes": [
         {
            "id": 1,
            "nomeDoRemedio": "Paracetamol",
            "quantidade": 10,
            "dataHora": "2023-01-01T12:00:00"
         },
         {
            "id": 2,
            "nomeDoRemedio": "Ibuprofeno",
            "quantidade": 5,
            "dataHora": "2023-01-01T12:00:00"
         }
      ],
      "status": true
   },
   {
      "id": 2,
      "nome": "Maria Oliveira",
      "cargo": "Atendente",
      "identificacao": "Unidade B",
      "listaDeTransacoes": [
         {
            "id": 3,
            "nomeDoRemedio": "Dipirona",
            "quantidade": 8,
            "dataHora": "2023-01-02T14:30:00"
         },
         {
            "id": 4,
            "nomeDoRemedio": "Amoxicilina",
            "quantidade": 15,
            "dataHora": "2023-01-02T14:30:00"
         }
      ],
      "status": true
   }
]
```

**Códigos de Resposta:**

| Código | Descrição |
| --- | --- |
| `200` | Dados retornados com sucesso |

#### Cadastrar novo funcionário

```http
POST /medcontrol/api/funcionario/cadastrar
```

**Parâmetros de Request:**

```json
{
  "nome": "João Silva",
  "cargo": "Farmacêutico",
  "identificacao": "Unidade A",
  "status": true
}
```

**Códigos de Resposta:**

| Código | Descrição |
| --- | --- |
| `201` | Funcionário cadastrado com sucesso |
| `400` | Erro na validação dos dados da requisição |

#### Atualizar funcionário

```http
PUT /medcontrol/api/funcionario/atualizar
```

**Parâmetros de Request:**

```json
{
  "id": 1,
  "nome": "João Silva",
  "cargo": "Farmacêutico",
  "identificacao": "Unidade A",
  "status": false
}
```

**Códigos de Resposta:**

| Código | Descrição |
| --- | --- |
| `200` | Funcionário atualizado com sucesso |
| `400` | Erro na validação dos dados da requisição |
| `404` | Funcionário não encontrado |


## Estoque

* **Atributos:**
  - `id` (PK)
  - `nomeDoRemedio` (FK)
  - `quantidade`
  - `nomeDoFuncionario` (FK)
  - `data`
  - `hora`

#### Obter detalhes do estoque a partir do ID

```http
GET /medcontrol/api/estoque/{id}
```

**Parâmetros de URL:**
- `id` (obrigatório) - ID do estoque

**Exemplo do corpo de Response:**

```json
{
   "id": 1,
   "nomeDoRemedio": "Paracetamol",
   "quantidade": 100,
   "nomeDoFuncionario": "João Silva",
   "dataHora": "2023-01-05T09:45:00"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |
| `404`  | Estoque não encontrado     |

#### Listar todos os registros de estoque

```http
GET /medcontrol/api/estoque/listar
```

**Exemplo do corpo de Response:**

```json
[
   {
      "id": 1,
      "nomeDoRemedio": "Paracetamol",
      "quantidade": 100,
      "nomeDoFuncionario": "João Silva",
      "dataHora": "2023-01-05T09:45:00"
   },
   {
      "id": 2,
      "nomeDoRemedio": "Ibuprofeno",
      "quantidade": 50,
      "nomeDoFuncionario": "Maria Oliveira",
      "dataHora": "2023-01-05T14:00:00"
   }
]
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |

#### Adicionar novo registro de estoque

```http
POST /medcontrol/api/estoque/adicionar
```

**Parâmetros de Request:**

```json
{
  "nomeDoRemedio": "Paracetamol",
  "quantidade": 50,
  "nomeDoFuncionario": "João Silva",
  "dataHora": "2023-03-10T14:30:00"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `201`  | Registro de estoque adicionado com sucesso |
| `400`  | Erro na validação dos dados da requisição |

#### Atualizar registro de estoque

```http
PUT /medcontrol/api/estoque/atualizar
```

**Parâmetros de Request:**

```json
{
  "id": 1,
  "nomeDoRemedio": "Paracetamol",
  "quantidade": 75,
  "nomeDoFuncionario": "João Silva",
  "dataHora": "2023-03-10T14:30:00"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Registro de estoque atualizado com sucesso |
| `400`  | Erro na validação dos dados da requisição |
| `404`  | Registro de estoque não encontrado |

#### Remover registro de estoque

```http
DELETE /medcontrol/api/estoque/remover/{id}
```

**Parâmetros de URL:**

- `id` (obrigatório) - ID do registro de estoque a ser removido

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Registro de estoque removido com sucesso |
| `404`  | Registro de estoque não encontrado |

## Medicamento

* **Atributos:**
  - `id` (PK)
  - `nome`
  - `fabricante`
  - `principioAtivo`
  - `dosagem`

#### Obter detalhes do medicamento a partir do ID

```http
GET /medcontrol/api/medicamento/{id}
```

**Parâmetros de URL:**
- `id` (obrigatório) - ID do medicamento

**Exemplo do corpo de Response:**

```json
{
   "id": 1,
   "nome": "Paracetamol",
   "fabricante": "Genérico",
   "principioAtivo": "Paracetamol",
   "dosagem": "500mg"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |
| `404`  | Medicamento não encontrado |

#### Listar todos os medicamentos cadastrados

```http
GET /medcontrol/api/medicamento/listar
```

**Exemplo do corpo de Response:**

```json
[
   {
      "id": 1,
      "nome": "Paracetamol",
      "fabricante": "Genérico",
      "principioAtivo": "Paracetamol",
      "dosagem": "500mg"
   },
   {
      "id": 2,
      "nome": "Ibuprofeno",
      "fabricante": "Medley",
      "principioAtivo": "Ibuprofeno",
      "dosagem": "400mg"
   }
]
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |

#### Cadastrar novo medicamento

```http
POST /medcontrol/api/medicamento/cadastrar
```

**Parâmetros de Request:**

```json
{
  "nome": "Paracetamol",
  "fabricante": "Genérico",
  "principioAtivo": "Paracetamol",
  "dosagem": "500mg"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `201`  | Medicamento cadastrado com sucesso |
| `400`  | Erro na validação dos dados da requisição |

#### Atualizar medicamento

```http
PUT /medcontrol/api/medicamento/atualizar
```

**Parâmetros de Request:**

```json
{
  "id": 1,
  "nome": "Paracetamol",
  "fabricante": "Genérico",
  "principioAtivo": "Paracetamol",
  "dosagem": "750mg"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Medicamento atualizado com sucesso |
| `400`  | Erro na validação dos dados da requisição |
| `404`  | Medicamento não encontrado |

#### Apagar medicamento

```http
DELETE /medcontrol/api/medicamento/apagar/{id}
```

**Parâmetros de URL:**

- `id` (obrigatório) - ID do medicamento a ser apagado

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Medicamento apagado com sucesso |
| `404`  | Medicamento não encontrado |

## Unidade de Trabalho

* **Atributos:**
  - `id` (PK)
  - `nome`
  - `endereco`
  - `telefone`

#### Obter detalhes da unidade de trabalho a partir do ID

```http
GET /medcontrol/api/unidade-trabalho/{id}
```

**Parâmetros de URL:**
- `id` (obrigatório) - ID da unidade de trabalho

**Exemplo do corpo de Response:**

```json
{
   "id": 1,
   "nome": "Unidade A",
   "endereco": "Rua Principal, 123",
   "telefone": "(XX) XXXX-XXXX"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |
| `404`  | Unidade de trabalho não encontrada |

#### Listar todas as unidades de trabalho cadastradas

```http
GET /medcontrol/api/unidade-trabalho/listar
```

**Exemplo do corpo de Response:**

```json
[
   {
      "id": 1,
      "nome": "Unidade A",
      "endereco": "Rua Principal, 123",
      "telefone": "(XX) XXXX-XXXX"
   },
   {
      "id": 2,
      "nome": "Unidade B",
      "endereco": "Avenida Secundária, 456",
      "telefone": "(XX) XXXX-XXXX"
   }
]
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |

#### Cadastrar nova unidade de trabalho

```http
POST /medcontrol/api/unidade-trabalho/cadastrar
```

**Parâmetros de Request:**

```json
{
  "nome": "Unidade A",
  "endereco": "Rua Principal, 123",
  "telefone": "(XX) XXXX-XXXX"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `201`  | Unidade de trabalho cadastrada com sucesso |
| `400`  | Erro na validação dos dados da requisição |

#### Atualizar unidade de trabalho

```http
PUT /medcontrol/api/unidade-trabalho/atualizar
```

**Parâmetros de Request:**

```json
{
  "id": 1,
  "nome": "Unidade A",
  "endereco": "Rua Principal, 123",
  "telefone": "(XX) XXXX-XXXX"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Unidade de trabalho atualizada com sucesso |
| `400`  | Erro na validação dos dados da requisição |
| `404`  | Unidade de trabalho não encontrada |

#### Apagar unidade de trabalho

```http
DELETE /medcontrol/api/unidade-trabalho/apagar/{id}
```

**Parâmetros de URL:**

- `id` (obrigatório) - ID da unidade de trabalho a ser apagada

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Unidade de trabalho apagada com sucesso |
| `404`  | Unidade de trabalho não encontrada |

## Departamento

* **Atributos:**
  - `id` (PK)
  - `nome`

#### Obter detalhes do departamento a partir do ID

```http
GET /medcontrol/api/departamento/{id}
```

**Parâmetros de URL:**
- `id` (obrigatório) - ID do departamento

**Exemplo do corpo de Response:**

```json
{
   "id": 1,
   "nome": "Departamento A"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |
| `404`  | Departamento não encontrado |

#### Listar todos os departamentos cadastrados

```http
GET /medcontrol/api/departamento/listar
```

**Exemplo do corpo de Response:**

```json
[
   {
      "id": 1,
      "nome": "Departamento A"
   },
   {
      "id": 2,
      "nome": "Departamento B"
   }
]
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |

#### Cadastrar novo departamento

```http
POST /medcontrol/api/departamento/cadastrar
```

**Parâmetros de Request:**

```json
{
  "nome": "Departamento A"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `201`  | Departamento cadastrado com sucesso |
| `400`  | Erro na validação dos dados da requisição |

#### Atualizar departamento

```http
PUT /medcontrol/api/departamento/atualizar
```

**Parâmetros de Request:**

```json
{
  "id": 1,
  "nome": "Departamento A"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Departamento atualizado com sucesso |
| `400`  | Erro na validação dos dados da requisição |
| `404`  | Departamento não encontrado |

#### Apagar departamento

```http
DELETE /medcontrol/api/departamento/apagar/{id}
```

**Parâmetros de URL:**

- `id` (obrigatório) - ID do departamento a ser apagado

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Departamento apagado com sucesso |
| `404`  | Departamento não encontrado |


## Transacao

* **Atributos:**
  - `id` (PK)
  - `nomeDoFuncionario` (FK)
  - `data`
  - `hora`
  - `itens` (Lista de Itens)

#### Obter detalhes da transação a partir do ID

```http
GET /medcontrol/api/transacao/{id}
```

**Parâmetros de URL:**
- `id` (obrigatório) - ID da transação

**Exemplo do corpo de Response:**

```json
{
   "id": 1,
   "nomeDoFuncionario": "João Silva",
   "data": "2023-01-01",
   "hora": "12:00",
   "itens": [
      {
         "nomeDoRemedio": "Paracetamol",
         "quantidade": 10
      },
      {
         "nomeDoRemedio": "Ibuprofeno",
         "quantidade": 5
      }
   ]
}
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |
| `404`  | Transação não encontrada |

#### Listar todas as transações cadastradas

```http
GET /medcontrol/api/transacao/listar
```

**Exemplo do corpo de Response:**

```json
[
   {
      "id": 1,
      "nomeDoFuncionario": "João Silva",
      "data": "2023-01-01",
      "hora": "12:00",
      "itens": [
         {
            "nomeDoRemedio": "Paracetamol",
            "quantidade": 10
         },
         {
            "nomeDoRemedio": "Ibuprofeno",
            "quantidade": 5
         }
      ]
   },
   {
      "id": 2,
      "nomeDoFuncionario": "Maria Oliveira",
      "data": "2023-01-02",
      "hora": "14:30",
      "itens": [
         {
            "nomeDoRemedio": "Dipirona",
            "quantidade": 8
         },
         {
            "nomeDoRemedio": "Amoxicilina",
            "quantidade": 15
         }
      ]
   }
]
```

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Dados retornados com sucesso |

#### Cadastrar nova transação

```http
POST /medcontrol/api/transacao/cadastrar
```

**Parâmetros de Request:**

```json
{
  "nomeDoRemedio": "Paracetamol",
  "quantidade": 10,
  "nomeDoFuncionario": "João Silva",
  "dataHora": "2023-03-10T14:30:00"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
| `201`  | Transação cadastrada com sucesso |
| `400`  | Erro na validação dos dados da requisição |

#### Atualizar transação

```http
PUT /medcontrol/api/transacao/atualizar
```

**Parâmetros de Request:**

```json
{
  "id": 1,
  "nomeDoRemedio": "Paracetamol",
  "quantidade": 15,
  "nomeDoFuncionario": "João Silva",
  "dataHora": "2023-03-10T14:30:00"
}
```

**Códigos de Resposta:**
| Código | Descrição              |
| `200`  | Transação atualizada com sucesso |
| `400`  | Erro na validação dos dados da requisição |
| `404`  | Transação não encontrada |

#### Apagar transação

```http
DELETE /medcontrol/api/transacao/apagar/{id}
```

**Parâmetros de URL:**

- `id` (obrigatório) - ID da transação a ser apagada

**Códigos de Resposta:**
| Código | Descrição              |
|--------|------------------------|
| `200`  | Transação apagada com sucesso |
| `404`  | Transação não encontrada |

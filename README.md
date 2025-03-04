# Management-INK
## O Management INK é uma ideia de controle de dados de clientes e dados monetários a partir dos procedimentos feitos em um estúdio X.


Segue o fluxograma que mediará toda a aplicação a fim de chegar simplificação do processo de fichar o cliente.

```mermaid
graph TD;
    A[Usuário abre a aplicação] --> B[Adicionar novo cliente]
    B --> C[Dados do Cliente: Data, Nome, Idade, CPF, Data de nascimento, Onde mora, Profissão, Onde nos conheceu, Cor preferida, Descrição da tatuagem]
    B --> O[Dados monetários]
    O --> P[Valor total]
    P --> Q[Método de pagamento]
    Q --> R[Parcela?]
    R --> |Sim| S[Sem juros - Desconto_15_porcento]
    R --> |Não| T[Com juros - Sem_diminuição]
    S --> M[Tatuador]
    T --> M[Tatuador]
    M --> |Reconhece o nome do tatuador| N[Envia para a planilha do tatuador]
```




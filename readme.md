# Management-INK
## O Management INK é uma ideia de controle de dados de clientes e dados monetários a partir dos procedimentos feitos em um estúdio X.


Segue o fluxograma que mediará toda a aplicação a fim de chegar simplificação do processo de fichar o cliente.

```mermaid
graph TD;
    A[Usuário abre a aplicação]
    A --> C[Adicionar novo cliente]
    C --> D[Dados do Cliente]
    C --> O[Dados monetários]
    O --> P[Valor total]
    P --> Q[Método de pagamento]
    Q --> R[Parcela?]
    R --> |Sim| S[Sem juros - Desconto_15_porcento]
    R --> |Não| T[Com juros - Sem_diminuição]
    S --> M[Tatuador]
    T --> M[Tatuador]
    M --> |Reconhece o nome do tatuador| N[Envia para a planilha do tatuador]

```

## Quebrando um problema em vários.
### Tentando jogar os dados do cliente para um arquivo txt.

Bem, terminei meu módulo inicial de java ontem, não posso esperar que eu monte essa aplicação em um dia, portanto irei seguindo passos, primeiro vou montar um processo onde eu consiga pegar os dados desse cliente e os colocar em um arquivo txt.
# RELATÓRIO DE IMPLEMENTAÇÃO DE SERVIÇOS AWS

**Data:** 27 de Fevereiro de 2026  
**Empresa:** Abstergo Industries  
**Responsável:** Davi

---

## Introdução
Este relatório apresenta o processo de implementação de ferramentas na empresa **Abstergo Industries**, realizado por **[Seu Nome]**. O objetivo do projeto foi elencar 3 serviços AWS, com a finalidade de otimizar a escalabilidade, garantir a segurança de dados sensíveis e permitir o monitoramento analítico de custos e performance.

## Descrição do Projeto
O projeto de implementação foi dividido em 3 pilares estratégicos: persistência de dados flexível, conectividade segura e observabilidade operacional.

### Etapa 1:
* **Nome da ferramenta:** Amazon DynamoDB
* **Foco da ferramenta:** Banco de Dados NoSQL de alta performance.
* **Descrição de caso de uso:** Utilizado para o catálogo de produtos e registro de vendas da farmácia. Por ser NoSQL, permite que cada item de venda tenha uma estrutura flexível (ex: vendas com diferentes tipos de descontos, convênios ou programas de fidelidade) sem a rigidez de um esquema relacional, garantindo baixa latência em períodos de alta demanda.

### Etapa 2:
* **Nome da ferramenta:** AWS PrivateLink
* **Foco da ferramenta:** Segurança e Privacidade de Rede.
* **Descrição de caso de uso:** Estabelece uma conexão privada entre a VPC da farmácia e os serviços da AWS, sem expor os dados à internet pública. Essencial para o tráfego de dados sensíveis de saúde (prontuários e receitas) e dados pessoais de clientes, garantindo conformidade com normas de proteção de dados.

### Etapa 3:
* **Nome da ferramenta:** Amazon CloudWatch
* **Foco da ferramenta:** Monitoramento e Observabilidade.
* **Descrição de caso de uso:** Centraliza logs e métricas de todas as aplicações. Setores de desenvolvimento e administrativo utilizam painéis (dashboards) para monitorar a saúde do sistema e configurar alertas de faturamento, garantindo que o consumo de recursos esteja sempre dentro do orçamento previsto.

---

## Conclusão
A implementação de ferramentas na empresa **Abstergo Industries** tem como esperado uma **maior agilidade no desenvolvimento de novas funcionalidades de venda, proteção rigorosa contra vazamento de dados e controle total sobre os gastos de infraestrutura**, o que aumentará a eficiência e a produtividade da empresa. Recomenda-se a continuidade da utilização das ferramentas implementadas e a busca por novas tecnologias que possam melhorar ainda mais os processos da empresa.


**Assinatura do Responsável pelo Projeto:**

*Davi*
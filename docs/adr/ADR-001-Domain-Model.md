# ADR-001 - Domain Model

## Status

Accepted

## Context

O projeto precisa gerar diversos formatos de documentação
(Draw.io, HTML, Mermaid e JSON).

Para evitar acoplamento entre a análise do código e os
formatos de saída, foi criado um modelo de domínio próprio.

## Decision

Toda análise da AST será convertida para objetos do domínio.

JavaParser nunca será utilizado fora da camada de analysis.

## Consequences

- baixo acoplamento
- alta reutilização
- múltiplos geradores utilizando o mesmo modelo

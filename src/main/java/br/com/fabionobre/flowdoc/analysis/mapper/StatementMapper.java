package br.com.fabionobre.flowdoc.analysis.mapper;

import com.github.javaparser.ast.stmt.Statement;

import br.com.fabionobre.flowdoc.domain.model.FlowNode;
import br.com.fabionobre.flowdoc.domain.model.FlowNodeType;

public class StatementMapper {

  public FlowNode map(Statement statement) {

    FlowNode node = new FlowNode();

    node.setId(java.util.UUID.randomUUID().toString());

    node.setLabel(statement.toString());

    node.setType(resolveType(statement));

    return node;
  }

  private FlowNodeType resolveType(Statement statement) {

    String name = statement.getClass().getSimpleName();

    switch (name) {

      case "IfStmt":
        return FlowNodeType.DECISION;

      case "ForStmt":

      case "ForEachStmt":

      case "WhileStmt":

      case "DoStmt":
        return FlowNodeType.LOOP;

      case "ReturnStmt":
        return FlowNodeType.RETURN;

      default:
        return FlowNodeType.ACTION;

    }

  }

}
package br.com.fabionobre.flowdoc.analysis.mapper;

import com.github.javaparser.ast.body.MethodDeclaration;

import br.com.fabionobre.flowdoc.domain.model.MethodModel;
import br.com.fabionobre.flowdoc.domain.model.ParameterModel;

public class MethodMapper {

  private final ParameterMapper parameterMapper = new ParameterMapper();

  private final StatementMapper statementMapper = new StatementMapper();

  public MethodModel map(MethodDeclaration method) {

    MethodModel model = new MethodModel();

    model.setName(method.getNameAsString());

    model.setReturnType(method.getType().asString());

    // parâmetros

    method.getParameters().forEach(parameter ->

    model.addParameter(
        parameterMapper.map(parameter)));

    // fluxo

    method.getBody().ifPresent(body ->

    body.getStatements().forEach(statement ->

    model.addFlowNode(
        statementMapper.map(statement)))

    );

    return model;

  }

}
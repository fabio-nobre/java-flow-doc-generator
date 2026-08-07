package br.com.fabionobre.flowdoc.analysis.mapper;

import com.github.javaparser.ast.body.Parameter;

import br.com.fabionobre.flowdoc.domain.model.ParameterModel;

public class ParameterMapper {

  public ParameterModel map(Parameter parameter) {

    ParameterModel model = new ParameterModel();

    model.setName(parameter.getNameAsString());

    model.setType(parameter.getType().asString());

    return model;

  }

}
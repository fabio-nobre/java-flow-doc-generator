package br.com.fabionobre.flowdoc.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodModel {

  private String name;

  private String returnType;

  private final List<ParameterModel> parameters = new ArrayList<>();
  private final List<FlowNode> flowNodes = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReturnType() {
    return returnType;
  }

  public void setReturnType(String returnType) {
    this.returnType = returnType;
  }

  public List<ParameterModel> getParameters() {
    return Collections.unmodifiableList(parameters);
  }

  public void addParameter(ParameterModel parameter) {
    parameters.add(parameter);
  }

  public List<FlowNode> getFlowNodes() {
    return Collections.unmodifiableList(flowNodes);
  }

  public void addFlowNode(FlowNode node) {
    flowNodes.add(node);
  }

}
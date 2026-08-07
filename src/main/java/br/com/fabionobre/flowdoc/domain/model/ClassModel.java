package br.com.fabionobre.flowdoc.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassModel {

  private String packageName;

  private String className;

  private final List<MethodModel> methods = new ArrayList<>();

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public List<MethodModel> getMethods() {
    return Collections.unmodifiableList(methods);
  }

  public void addMethod(MethodModel method) {
    methods.add(method);
  }

}
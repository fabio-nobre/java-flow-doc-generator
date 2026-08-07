package br.com.fabionobre.flowdoc.analysis.mapper;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import br.com.fabionobre.flowdoc.domain.model.ClassModel;

public class ClassMapper {

  private final MethodMapper methodMapper = new MethodMapper();

  public ClassModel map(
      CompilationUnit unit,
      ClassOrInterfaceDeclaration clazz) {

    ClassModel model = new ClassModel();

    model.setClassName(clazz.getNameAsString());

    unit.getPackageDeclaration()

        .ifPresent(pkg -> model.setPackageName(pkg.getNameAsString()));

    clazz.getMethods()

        .forEach(method -> model.addMethod(
            methodMapper.map(method)));

    return model;

  }

}
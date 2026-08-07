package br.com.fabionobre.flowdoc.analysis.mapper;

import com.github.javaparser.ast.CompilationUnit;

import br.com.fabionobre.flowdoc.domain.model.ClassModel;

public class CompilationUnitMapper {

  private final ClassMapper classMapper = new ClassMapper();

  public ClassModel map(CompilationUnit unit) {

    return unit.findFirst(
        com.github.javaparser.ast.body.ClassOrInterfaceDeclaration.class)

        .map(clazz -> classMapper.map(unit, clazz))

        .orElseThrow(() -> new IllegalArgumentException(
            "Nenhuma classe encontrada."));

  }

}
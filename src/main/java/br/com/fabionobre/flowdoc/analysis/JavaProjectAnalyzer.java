package br.com.fabionobre.flowdoc.analysis;

import java.nio.file.Files;
import java.nio.file.Path;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import br.com.fabionobre.flowdoc.analysis.mapper.CompilationUnitMapper;
import br.com.fabionobre.flowdoc.analysis.mapper.StatementMapper;
import br.com.fabionobre.flowdoc.domain.model.ClassModel;
import br.com.fabionobre.flowdoc.domain.model.MethodModel;
import br.com.fabionobre.flowdoc.domain.model.ParameterModel;
import br.com.fabionobre.flowdoc.domain.model.FlowNode;

public class JavaProjectAnalyzer implements ProjectAnalyzer {

  private final CompilationUnitMapper mapper = new CompilationUnitMapper();

  @Override
  public ClassModel analyze(Path sourceFile)
      throws Exception {

    validarArquivo(sourceFile);

    CompilationUnit unit = StaticJavaParser.parse(sourceFile);

    return mapper.map(unit);

  }

  private void validarArquivo(Path sourceFile) {

    if (!Files.exists(sourceFile)) {

      throw new IllegalArgumentException(
          "Arquivo não encontrado: "
              + sourceFile.toAbsolutePath());

    }

    if (!Files.isRegularFile(sourceFile)) {

      throw new IllegalArgumentException(
          "O caminho informado não é um arquivo.");

    }

    if (!sourceFile.toString().endsWith(".java")) {

      throw new IllegalArgumentException(
          "O arquivo deve possuir extensão .java");

    }

  }

}
package br.com.fabionobre.flowdoc.analysis.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import br.com.fabionobre.flowdoc.analysis.JavaProjectAnalyzer;
import br.com.fabionobre.flowdoc.domain.model.ClassModel;

public class ProjectAnalysisService {

  private final JavaProjectAnalyzer analyzer;

  public ProjectAnalysisService(
      JavaProjectAnalyzer analyzer) {

    this.analyzer = analyzer;
  }

  public List<ClassModel> analyze(
      List<Path> files) throws Exception {

    List<ClassModel> classes = new ArrayList<>();

    for (Path file : files) {

      ClassModel classModel = analyzer.analyze(file);

      classes.add(classModel);
    }

    return classes;
  }
}

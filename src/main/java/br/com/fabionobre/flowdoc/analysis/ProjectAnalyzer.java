package br.com.fabionobre.flowdoc.analysis;

import java.nio.file.Path;

import br.com.fabionobre.flowdoc.domain.model.ClassModel;

public interface ProjectAnalyzer {

    ClassModel analyze(Path sourceFile) throws Exception;

}
package br.com.fabionobre.flowdoc.analysis.scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectScanner implements SourceScanner {

  @Override
  public List<Path> scan(Path rootDirectory) throws IOException {

    validarDiretorio(rootDirectory);

    return Files.walk(rootDirectory)
        .filter(Files::isRegularFile)
        .filter(this::isJavaFile)
        .sorted()
        .collect(Collectors.toList());

  }

  private boolean isJavaFile(Path file) {

    return file.toString().endsWith(".java");

  }

  private void validarDiretorio(Path directory) {

    if (!Files.exists(directory)) {

      throw new IllegalArgumentException(
          "Diretório inexistente: "
              + directory.toAbsolutePath());

    }

    if (!Files.isDirectory(directory)) {

      throw new IllegalArgumentException(
          "O caminho informado não é um diretório.");

    }

  }

}
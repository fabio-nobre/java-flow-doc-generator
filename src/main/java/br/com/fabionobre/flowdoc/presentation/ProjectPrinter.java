package br.com.fabionobre.flowdoc.presentation;

import java.nio.file.Path;
import java.util.List;

public class ProjectPrinter {

  public void print(List<Path> files) {

    System.out.println();
    System.out.println("Arquivos encontrados:");
    System.out.println();

    files.forEach(System.out::println);

  }

}
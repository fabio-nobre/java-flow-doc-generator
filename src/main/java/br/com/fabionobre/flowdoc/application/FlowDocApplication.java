package br.com.fabionobre.flowdoc.application;

import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.fabionobre.flowdoc.analysis.JavaProjectAnalyzer;
import br.com.fabionobre.flowdoc.analysis.ProjectAnalyzer;
import br.com.fabionobre.flowdoc.domain.model.ClassModel;
import br.com.fabionobre.flowdoc.presentation.ConsolePrinter;

public class FlowDocApplication {

    public static void main(String[] args) throws Exception {

        System.out.println("======================================");
        System.out.println(" Java Flow Doc Generator");
        System.out.println("======================================");

        ProjectAnalyzer analyzer = new JavaProjectAnalyzer();

        Path source = Paths.get("samples", "Pessoa.java");

        System.out.println("Diretório atual : " + Paths.get("").toAbsolutePath());
        System.out.println("Arquivo.........: " + source.toAbsolutePath());
        System.out.println(Paths.get("").toAbsolutePath());

        ClassModel model = analyzer.analyze(source);

        ConsolePrinter printer = new ConsolePrinter();

        printer.print(model);

    }

}
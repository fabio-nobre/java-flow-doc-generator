package br.com.fabionobre.flowdoc.application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.fabionobre.flowdoc.analysis.scanner.ProjectScanner;
import br.com.fabionobre.flowdoc.presentation.ProjectPrinter;

public class FlowDocApplication {

    public static void main(String[] args) throws Exception {

        System.out.println("======================================");
        System.out.println(" Java Flow Doc Generator");
        System.out.println("======================================");

        Path projectDirectory = Paths.get("samples");

        ProjectScanner scanner = new ProjectScanner();

        List<Path> files = scanner.scan(projectDirectory);

        ProjectPrinter printer = new ProjectPrinter();

        printer.print(files);

    }

}
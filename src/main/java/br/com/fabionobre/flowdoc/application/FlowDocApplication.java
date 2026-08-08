package br.com.fabionobre.flowdoc.application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.fabionobre.flowdoc.analysis.JavaProjectAnalyzer;
import br.com.fabionobre.flowdoc.analysis.scanner.ProjectScanner;
import br.com.fabionobre.flowdoc.analysis.service.ProjectAnalysisService;
import br.com.fabionobre.flowdoc.domain.model.ClassModel;
import br.com.fabionobre.flowdoc.presentation.ConsolePrinter;

public class FlowDocApplication {

    public static void main(String[] args) throws Exception {

        System.out.println("======================================");
        System.out.println(" Java Flow Doc Generator");
        System.out.println("======================================");

        Path projectDirectory = Paths.get("samples");

        ProjectScanner scanner = new ProjectScanner();

        List<Path> files = scanner.scan(projectDirectory);

        JavaProjectAnalyzer analyzer = new JavaProjectAnalyzer();

        ProjectAnalysisService analysisService = new ProjectAnalysisService(analyzer);

        List<ClassModel> classes = analysisService.analyze(files);

        ConsolePrinter printer = new ConsolePrinter();

        for (ClassModel clazz : classes) {

            printer.print(clazz);
        }

    }

}
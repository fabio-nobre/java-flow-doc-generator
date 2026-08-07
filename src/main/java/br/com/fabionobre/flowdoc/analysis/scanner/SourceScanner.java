package br.com.fabionobre.flowdoc.analysis.scanner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface SourceScanner {

  List<Path> scan(Path rootDirectory) throws IOException;

}
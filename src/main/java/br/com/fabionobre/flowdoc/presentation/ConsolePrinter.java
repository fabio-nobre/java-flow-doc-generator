package br.com.fabionobre.flowdoc.presentation;

import br.com.fabionobre.flowdoc.domain.model.ClassModel;
import br.com.fabionobre.flowdoc.domain.model.FlowNode;
import br.com.fabionobre.flowdoc.domain.model.MethodModel;
import br.com.fabionobre.flowdoc.domain.model.ParameterModel;

public class ConsolePrinter {

  public void print(ClassModel model) {

    System.out.println();
    System.out.println("Classe : " + model.getClassName());

    System.out.println("Pacote : " + model.getPackageName());

    System.out.println();
    System.out.println("Métodos:");

    for (MethodModel method : model.getMethods()) {

      StringBuilder assinatura = new StringBuilder();
      assinatura.append(" - ")
          .append(method.getReturnType())
          .append(" ")
          .append(method.getName())
          .append("(");

      for (int i = 0; i < method.getParameters().size(); i++) {

        ParameterModel p = method.getParameters().get(i);

        assinatura.append(p.getType())
            .append(" ")
            .append(p.getName());

        if (i < method.getParameters().size() - 1) {
          assinatura.append(", ");
        }

        System.out.println("Fluxo:");

        for (FlowNode node : method.getFlowNodes()) {

          System.out.println("   "
              + node.getType()
              + " -> "
              + node.getLabel());

        }
      }

      assinatura.append(")");

      System.out.println(assinatura);
    }
  }
}
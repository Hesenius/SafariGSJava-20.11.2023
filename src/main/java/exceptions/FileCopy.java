package exceptions;

import java.io.*;

public class FileCopy {
  // checked exceptions represent environmental problems
  // that good code SHOULD fix... Java tries to enforce this
  public static void main(String[] args) /*throws IOException*/ {
    String fn = "data.txt";
    // since Java 7
    try ( // "try with resources" generates code for reliable closure
      FileReader fr = new FileReader(fn);
      BufferedReader input = new BufferedReader(fr);
      FileWriter fw = new FileWriter("output.txt");
      PrintWriter output = new PrintWriter(fw);
      ) {
      String line;
      while ((line = input.readLine()) != null) {
        output.println(line);
      }

    } catch (IOException ioe) {
      System.out.println("broke " + ioe.getMessage());
    }

  }
}

import java.io.*;

public class writing {
   public static void main(String[] args) throws IOException {
    File file = new File("outfilename");
    System.out.println(file.length());
    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("WTF IS THIS?!?!?");
    bw.close();
   }//main ends
}//end writing class
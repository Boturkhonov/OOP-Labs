import java.io.*;
import java.util.Arrays;

public class BinFileMaker {
    public static void main(String[] args) {
        String path = "taskB";
        String text = "";
        double[] values = null;
        try(FileReader reader = new FileReader(path + ".txt"))
        {
            int c;
            while((c=reader.read())!=-1) {
                text += String.valueOf((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        String[] splatText = text.split("\\r\\n| ");
        //System.out.println(Arrays.toString(splatText));

        values = new double[splatText.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(splatText[i]);
        }
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(path + ".bin")))
        {
            for (double elem: values) {
                dos.writeDouble(elem);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

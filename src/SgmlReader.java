package toke;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SgmlReader {
    public static void main(String[] args) {
        String contents;
        if (args.length != 1){
            System.out.print("Error. Usage tokenizer <filename>");
        }

        contents = readFile(args[0]);
        System.out.println(contents);

        Boolean found = false;
        Pattern pat = Pattern.compile("test");
        //pattern idea: <$name>$value</$name>
        Matcher mat = pat.matcher(contents);
        while(mat.find()){
            System.out.println(String.format("Match found at: %d to %d", mat.start(), mat.end()));
            found = true;
        }
        if(!found){
            System.out.println("No Match Found");
        }

        //Token tok = new Token("Yeaaa");
        //System.out.print(tok.toString());
    }

    static String readFile(String filename) {
        String line;
        String content;
        StringBuilder sb = new StringBuilder();
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while(line != null){
                sb.append(line + "\n");
                line = br.readLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            content = sb.toString();
        }
        return content;
    }

}

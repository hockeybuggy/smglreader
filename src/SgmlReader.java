package toke;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Stack;

public class SgmlReader {
    public static void main(String[] args) {
        String contents;
        if (args.length != 1){
            System.out.print("Error. Usage tokenizer <filename>");
        }

        ArrayList<Tag> tags = new ArrayList();
        contents = readFile(args[0]);
        System.out.println(contents);

        Boolean found = false;
        Pattern pat = Pattern.compile("<(/?\\w+)>");
        //pattern idea: <$name>$value</$name>
        //Pattern pat = Pattern.compile("(<\\w+>)(.)(</\\w+>)");
        Matcher mat = pat.matcher(contents);
        while(mat.find()){
            tags.add(new Tag(mat.group(1), mat.start(), mat.end()));
            found = true;
        }
        if(!found){
            System.out.println("No Match Found");
        }

        for(int i = 0; i < tags.size(); i+=1){
            System.out.println(tags.get(i).toString());
        }

        Stack st = new Stack();
        if (tags.get(0).isOpen() == true){
            st.push(tags.get(0));
        } else {
            System.out.println("Error. First tag is a closing tag");
        }
        for(int i = 1; i < tags.size(); i+=1){
            Tag item = (Tag) st.peek();
            if (tags.get(i).getName() == item.getName()){ // Tag matches top of stack
                st.pop(); // TODO set body of tag pair
            } else {
                if (tags.get(i).isOpen()){
                    //st.peek().addChild(tags[i]) // Add as child to pair on top of stack
                    st.push(tags.get(i));    // Add new open tag to top of the stack
                } else {
                    System.out.println("Error. Unexplained closing tag");
                }
            }
        }

        System.out.println("End..");

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
                sb.append(line);
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

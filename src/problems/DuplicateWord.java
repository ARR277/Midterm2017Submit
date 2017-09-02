package problems;

import java.util.StringTokenizer;

/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        String delimiter = "[ .]";
        String [] stringArray = st.split(delimiter);
        //for(String print: stringArray) System.out.println(print);
        System.out.println(Word(stringArray));
    }

    private static String Word(String [] n){
        int duplicatesWord = 0, head, duplicates, spaces = 0;
        String result = "";
        for(int i=0; i<n.length-1; i++){
            duplicates = 0;
            head = i;
            if(n[head].equals("")){
                spaces++;
                continue;
            }
            if(n[head].equals("REPEAT"))continue;
            for(int j=i+1; j<n.length; j++){
                if(n[j].equals("") || n[j].equals("REPEAT"))continue;
                if(n[head].equalsIgnoreCase(n[j])){
                    duplicates++;
                    n[j] = "REPEAT";
                }
            }
            if(duplicates>0){
                result += " ["+n[head]+" "+(duplicates+1)+"]";
                duplicatesWord += duplicates+1;
            }
        }
        return "Out Of "+(n.length-spaces)+" Words, There Are "+duplicatesWord+" Duplicate Words: "+result;
    }

}

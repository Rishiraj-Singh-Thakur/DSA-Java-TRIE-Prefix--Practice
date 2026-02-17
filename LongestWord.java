import java.util.*;
public class LongestWord {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int level = 0 ; level<word.length();level++){
            int idx = word.charAt(level) - 'a';

            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static String Ans = "";
    public static void prefix(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i =0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>Ans.length()){
                    Ans = temp.toString();
                }
                prefix(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(String word : words){
            insert(word);
        }
        StringBuilder str = new StringBuilder("");
        prefix(root, str);
        System.out.println(Ans);
    }
}

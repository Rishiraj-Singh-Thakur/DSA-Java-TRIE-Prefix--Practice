public class CountUniqueSubstring {
    static class Node{
        Node child[] = new Node[26];
        public Node(){
            for(int i =0;i<26;i++){
                child[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i =0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
    }
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int counts = 0;
        for(int i =0;i<26;i++){
            if(root.child[i]!=null){
                counts+= count(root.child[i]);
            }
        }
        return counts+1;
    }

    public static void main(String[] args) {
        String str = "apply";
        for(int i = 0 ;i<str.length();i++){
            insert(str.substring(i));
        }
        System.out.println(count(root));
    }
}
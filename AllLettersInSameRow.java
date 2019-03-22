import java.util.*; 
public class AllLettersInSameRow{
    public static String[] findWords(String[] words) {
        ArrayList<String> validList = new ArrayList<String>(); 
        for(int i=0; i<words.length; i++) {
            if (sameGroup(words[i])) validList.add(words[i]); 
        }
        String[] answer = new String[validList.size()]; 
        for(int i=0; i<validList.size(); i++){
            answer[i] = validList.get(i); 
        }
        return answer; 
    } 
    private static int findGroup(char c) {
        int group = -1; 
        //the indexOf looks for which index a giving character is in the string, and returns -1 if no such character found
        if("QWERTYUIOPqwertyuiop".indexOf(c)!=-1) group = 0; 
        if("ASDFGHJKLasdfghjkl".indexOf(c)!=-1) group= 1; 
        if("ZXCVBNMzxcvbnm".indexOf(c)!=-1) group= 2; 
        return group; 
    }
    private static boolean sameGroup(String words) {
        boolean valid = false; 
        if (words.length()<2) return true; //if the words consists of only 1 character or even a null, then it's always true that "all characters" are in the same group
        //so the concept here is that we see the first character in the string and decide this string's group, cuz every character in the string should be in the same group.
        int group = findGroup(words.charAt(0)); //here we check which group the string should belong to 
        for(int i=1; i<words.length(); i++) { //and here we start to check from 2nd letter until the last to make sure they're all in the same group as the 1st letter
            int flag = findGroup(words.charAt(i)); 
            if (flag!=group) {
                valid = false;
                break; 
            }
            else valid = true; 
        }
        return valid; 
    }
    
     public static void main(String []args){
        String[] stringArray = {"Hello", "Alaska", "Dad", "Peace"};
        String[] answer = findWords(stringArray); 
        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]+" ");
        }
     }
}

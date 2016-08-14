public class TestClass {
    
    public static void main(String[] args) {
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };
        int i=0;
        short s=0;
        char c='a';
        String newStr = null;
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }
        try{}
        finally{}
        System.out.println((newStr == myStr)+ " " + (newStr));
        
    }
}
package basic.code.backtrack;

public class CheckIfParenthesesStringCanBeValid {

    public static void main(String[] args) {
        CheckIfParenthesesStringCanBeValid c = new CheckIfParenthesesStringCanBeValid();
        System.out.println(c.canBeValid(")(((((", "010100"));
        System.out.println(c.canBeValid(")()(((", "010100"));
        System.out.println(c.canBeValid(")))())", "010100"));
    }

    public boolean canBeValid(String s, String locked) {
        return s.length()%2==0 && isValid(s, locked, '(') && isValid(s, locked,')');
    }

    public boolean isValid(String s, String locked, char p) {
        int bal =0;
        int wild =0;
        int dir = p =='('?1:-1;
        int start = p =='('? 0 : s.length()-1;

        for(int i=start; i>=0 && i<s.length() && wild+bal>=0; i+=dir){
            if(locked.charAt(i) =='1'){
                bal+=s.charAt(i)==p?1:-1;
            } else{
                wild++;
            }

            if(wild+bal<0) return false;
        }

        return bal<=wild;
    }
}

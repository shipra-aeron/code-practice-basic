package basic.code.backtrack;

public class ValidParanthesisString {
    public boolean checkValidString(String s) {
        return isValid(s,'(') && isValid(s, ')');
    }

    public boolean isValid(String s, char op){
        int bal =0;
        int wild =0;
        int dir=op =='('? 1:-1;
        int start= op == '('?0:s.length()-1;
        for(int i=start; i>=0 && i<s.length(); i+=dir){
            if (s.charAt(i) == op){
                bal++;
            } else if(s.charAt(i) == '*'){
                wild++;
            } else {
                bal--;
            }

            if(wild+bal>=0){
                return false;
            }

        }
        return wild+bal>0;
    }
}

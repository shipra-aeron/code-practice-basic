package basic.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> para = gp.generateParenthesis(3);
        for (String s: para
             ) {
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        StringBuilder currentPath = new StringBuilder("");
        List<String> result = new ArrayList<>();
        backtracking(currentPath, n, 0, 0, result);
        return result;
    }

    public void backtracking(StringBuilder currentPath, int n, int leftCount, int rightCount, List<String> result){
        if(currentPath.length() == 2*n){
            result.add(currentPath.toString());
            return;
        }
        if(leftCount <n){
            currentPath.append("(");
            backtracking(currentPath, n, leftCount+1, rightCount, result);
            currentPath.deleteCharAt(currentPath.length()-1);
        }

        if(rightCount < leftCount){
            currentPath.append(")");
            backtracking(currentPath, n, leftCount, rightCount+1, result);
            currentPath.deleteCharAt(currentPath.length()-1);
        }
    }
}

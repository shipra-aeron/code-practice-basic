package basic.code.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> digitMap = Map.of
                ('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        if (digits.length() == 0) {
            return result;
        }

        backtrack(0, new StringBuilder(), digits, digitMap, result);
        return result;

    }

    private void backtrack(int index, StringBuilder path, String digits, Map<Character, String> digitMap, List<String> result) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        String possibleLetters = digitMap.get(digits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path, digits, digitMap, result);
            path.deleteCharAt(path.length() - 1);

        }

    }

    public static void main(String[] args) {
        LetterCombinationOfAPhoneNumber lc = new LetterCombinationOfAPhoneNumber();
        List<String> result = lc.letterCombinations("23");

        for (String s: result) {
            System.out.println(s);
        }
    }
}

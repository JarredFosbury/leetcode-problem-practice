import java.util.ArrayList;

public class ValidParentheses
{
    public static void main(String[] args)
    {
        System.out.println(test(isValid("()"), true));
        System.out.println(test(isValid("()[]{}"), true));
        System.out.println(test(isValid("(]"), false));
        System.out.println(test(isValid("{}["), false));
        System.out.println(test(isValid("){"), false));
    }

    private static String test(boolean in, boolean expected)
    {
        if (in == expected)
            return "passed";
        else
            return "failed";
    }

    public static boolean isValid(String s)
    {
        ArrayList<Character> openBrackets = new ArrayList<>();

        if (s.length() % 2 != 0)
            return false;

        for (int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i))
            {
                case '(', '[', '{':
                    openBrackets.add(s.charAt(i));
                    break;
                case ')', ']', '}':
                    if (openBrackets.size() == 0)
                        return false;

                    if ((int)s.charAt(i) == (int)openBrackets.get(openBrackets.size() - 1) + 2
                            && (int)s.charAt(i) > 50)
                        openBrackets.remove(openBrackets.size() - 1);
                    else if ((int)s.charAt(i) == (int)openBrackets.get(openBrackets.size() - 1) + 1
                            && (int)s.charAt(i) < 50)
                        openBrackets.remove(openBrackets.size() - 1);
                    else
                        return false;
                    break;
            }
        }

        return openBrackets.size() == 0;
    }
}
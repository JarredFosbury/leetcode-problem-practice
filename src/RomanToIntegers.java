public class RomanToIntegers
{
    public static void main(String[] args)
    {
        System.out.println(romanToInt("III"));
    }

    private static int romanToInt(String s)
    {
        int base10sum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int base10Value = getBase10Value(s.charAt(i));
            if (i >= s.length() - 1)
            {
                base10sum += base10Value;
            }
            else
            {
                int nextCharValue = getBase10Value(s.charAt(i + 1));
                if (nextCharValue > base10Value)
                {
                    base10Value = nextCharValue - base10Value;
                    i++;
                }

                base10sum += base10Value;
            }
        }

        return base10sum;
    }

    private static int getBase10Value(char value)
    {
        int base10Value = 0;
        switch (value)
        {
            case 'I' -> base10Value = 1;
            case 'V' -> base10Value = 5;
            case 'X' -> base10Value = 10;
            case 'L' -> base10Value = 50;
            case 'C' -> base10Value = 100;
            case 'D' -> base10Value = 500;
            case 'M' -> base10Value = 1000;
        }

        return base10Value;
    }
}
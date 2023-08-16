public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        System.out.println("got: " + longestCommonPrefix(new String[] {"flower","flow","flight"}) + ", expected: fl");
        System.out.println("got: " + longestCommonPrefix(new String[] {"dog","racecar","car"}) + ", expected: ");
        System.out.println("got: " + longestCommonPrefix(new String[] {"ab", "a"}) + ", expected: a");
        System.out.println("got: " + longestCommonPrefix(new String[] {"abab","aba",""}) + ", expected: ");
    }

    private static String longestCommonPrefix(String[] strs)
    {
        String prefixToReturn = "";
        char[] prefixCharacters = new char[strs[0].length()];

        // copy first word into prefix array since either they all have all
        // the prefix characters, or they don't all match
        for (int i = 0; i < strs[0].length(); i++)
            prefixCharacters[i] = strs[0].charAt(i);

        // loop through each character of each word, starting at the string
        // at the 2nd index, index 1
        for (int i = 1; i < strs.length; i++)
        {
            if (strs[i].isEmpty())
                return "";

            int charLoopLength = Math.min(strs[i].length(), prefixCharacters.length);
            for (int j = 0; j < charLoopLength; j++)
            {
                if (strs[i].charAt(j) != prefixCharacters[j])
                {
                    prefixCharacters = cropArrayUpToIndex(prefixCharacters, j);
                    break;
                }
                else if (j + 1 == charLoopLength)
                {
                    prefixCharacters = cropArrayUpToIndex(prefixCharacters, j + 1);
                }
            }
        }

        for (int i = 0; i < prefixCharacters.length; i++)
            prefixToReturn += prefixCharacters[i];

        return prefixToReturn;
    }

    private static char[] cropArrayUpToIndex(char[] arrayToCopy, int cutoffIndex)
    {
        char[] croppedArray = new char[cutoffIndex];
        System.arraycopy(arrayToCopy, 0, croppedArray, 0, croppedArray.length);

        return  croppedArray;
    }
}
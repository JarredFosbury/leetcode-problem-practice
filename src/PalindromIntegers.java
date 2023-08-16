
public class PalindromIntegers 
{
	public static void main(String[] args)
	{
		System.out.println(isPalindrome(1234554521));
	}
	
	public static boolean isPalindrome(int x)
    {
        if(x < 0)
            return false;
        
        String value = String.valueOf(x);
        
        if(value.charAt(0) != value.charAt(value.length() - 1))
        	return false;
        
        int leftIndex = 1;
    	int rightIndex = value.length() - 2;
        
        if(value.length() % 2 != 0) // odd
        {
        	while(leftIndex != rightIndex)
        	{
        		if(value.charAt(leftIndex) != value.charAt(rightIndex))
        			return false;
        		
        		leftIndex ++;
        		rightIndex --;
        	}
        }
        else						// even
        {
        	for(int i = 0; i < value.length() - 3; i += 2)
        	{
        		if(value.charAt(leftIndex) != value.charAt(rightIndex))
        			return false;
        		
        		leftIndex ++;
        		rightIndex --;
        	}
        }
        
        return true;
    }
}
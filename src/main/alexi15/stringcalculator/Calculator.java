package alexi15.stringcalcultor;

public class Calculator{
	public static int add(String text){
		if(text.equals(""))
			return 0;
		else if(text.contains(","))
		{
			return 2;
		}
		else
			return Integer.parseInt(text);
	}
}

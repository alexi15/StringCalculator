package alexi15.stringcalcultor;

public class Calculator{
	public static int add(String text){
		if(text.equals(""))
			return 0;
		else if(text.contains(","))
		{
			String [] numbers = text.split(",");
			return toInt(numbers[0]) + toInt(numbers[1]);
		}
		else
			return toInt(text);
	}

	private static int toInt(String text){
		return Integer.parseInt(text);
	}
}

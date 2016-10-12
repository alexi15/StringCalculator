package alexi15.stringcalcultor;

public class Calculator{
	public static int add(String text){
		if(text.equals(""))
			return 0;
		else if(text.contains(","))
		{
			String [] numbers = text.split(",");
			int sum = 0;
			for(String curr : numbers)
				sum += toInt(curr);
			return sum;
		}
		else
			return toInt(text);
	}

	private static int toInt(String text){
		return Integer.parseInt(text);
	}
}

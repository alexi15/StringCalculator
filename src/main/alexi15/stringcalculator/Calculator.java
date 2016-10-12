package alexi15.stringcalcultor;

public class Calculator{
	public static int add(String text){
		if(text.equals(""))
			return 0;

		else if(text.contains(",") || text.contains("\n") || text.contains("//"))
		{
			String delimiter = ",|\n";
			if(text.contains("//"))
			{
				delimiter += "|"+Character.toString(text.charAt(2));
				text = text.substring(3);
			}
			//String [] numbers = text.split(",|\n");
			String [] numbers = text.split(delimiter);

			if(text.contains("-"))
					throwException(numbers);

			int sum = 0;
			int currInt;
			for(String curr : numbers)
			{
				currInt = toInt(curr);
				if(currInt > 1000)
					currInt = 0;
				sum += currInt;
			}
			return sum;
		}

		else
		{
			if(text.contains("-"))
				throw new IllegalArgumentException("Negatives not allowed: " + text);
			return toInt(text);
		}
	}

	private static int toInt(String text){
		return Integer.parseInt(text);
	}

	private static void throwException(String[] numbers)
	{
		String error = "Negatives not allowed: ";
		for(String curr : numbers)
			if(curr.contains("-"))
				error = error + curr + ",";
		throw new IllegalArgumentException(error);
	}
}

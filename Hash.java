import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hash {

	public static void main(String[] args)
	{
		Scanner newWord = new Scanner(System.in);
		Map<Integer,TreeSet<String>> theMap = new TreeMap<>();
		while(newWord.hasNext())			
		{
		Set<String> names = new TreeSet<>();
		String theWord = newWord.next();
		names.add(theWord);
		if(theMap.containsKey(names.hashCode()))
		{
			TreeSet inTheMap = theMap.get(names.hashCode());
			for(String name: names)
			{
			inTheMap.add(name);
			}
			theMap.put(names.hashCode(), inTheMap);
		}
		else
		{
		theMap.put(names.hashCode(), (TreeSet<String>) names);
		}
		}
		Set<Integer> theKey = theMap.keySet();
		Iterator<Integer> theKeyIterator = theKey.iterator();
		while(theKeyIterator.hasNext())
		{
			int presentKey = theKeyIterator.next();
		
			Set<String> testing = theMap.get(presentKey);
			if(testing.size()>1)
			{
				String newKey = "";
				for(String smallKey: theMap.get(presentKey))
				{
					if(newKey.equals(""))
					{
						newKey+= smallKey;
					}
					else
					{
					newKey  += ", "+smallKey;
					}
				}
				System.out.println(presentKey+": "+ newKey);				
			}
			
		}
	}
}
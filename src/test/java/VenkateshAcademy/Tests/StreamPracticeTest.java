package VenkateshAcademy.Tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StreamPracticeTest {
	
	@Test
	public void streams()
	{
		List<String> ls = Arrays.asList("Lululem","Zalando","Lazada","Freedom","Metlife");
		
		String tosplit ="Zalando Zalando which is a MarketPlace which is operated by Lululemon";
		
		String[] ls3 = tosplit.split(" ");
		
		List ls4 = Arrays.asList(ls3);
		
		//ls.stream().filter(p->p.endsWith("e")).map(p->p.toUpperCase()).forEach(p->System.out.println(p));
		
	//List<String> ls1 =	ls.stream().filter(s->s.length()>=3).collect(Collectors.toList());
				
	//List<String> ls5 = 	 (List<String>) ls4.stream().sorted().collect(Collectors.toList());
		
		
		((Iterable<String>) ls4.stream().sorted().collect(Collectors.toSet())).forEach(p->System.out.print(p));
	}

}

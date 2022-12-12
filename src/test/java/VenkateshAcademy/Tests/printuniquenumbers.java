package VenkateshAcademy.Tests;

import java.util.ArrayList;
import java.util.List;

public class printuniquenumbers {

	public static void main(String[] args) {
		
		
				
			int a[] = {1,2,4,3,3,5,4,5,9,1,2,3};
			
			
			List ab = new ArrayList();
			
			for(int i=0;i<a.length;i++) {
				int k=0;
				if(!ab.contains(a[i])) {
				ab.add(a[i]);
				k++;
				
				for(int j=i+1;j<a.length;j++) {
					
					if(a[j]==a[i]) {
						k++;
					}
					
				}
				System.out.println(a[i]+" "+k);
				
			}

		}
		}
		

}

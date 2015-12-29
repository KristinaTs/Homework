package battle;

public class FrontBookkeeper61856 implements IFrontBookkeeper{
	 public String updateFront(String[] news){
		 news[0]="regiment_Stoykov = [1, 2, 3]";
		 news[1]="show regiment_Stoykov";
		 news[2]="regiment_Chaushev = [13]";
		 news[3]="show soldier 13";
		 news[4]="division_Dimitroff = []";
		 news[5]="regiment_Stoykov attached to division_Dimitroff";
		 news[6]="regiment_Chaushev attached to division_Dimitroff";
		 news[7]= "show division_Dimitroff";
		 news[8]="show soldier 13";
		 news[9]="brigade_Ignatov = []";
		 news[10]= "regiment_Stoykov attached to brigade_Ignatov  # brigade_Ignatov == [1, 2, 3]";
		news[11]= "regiment_Chaushev attached to brigade_Ignatov after soldier 3 # brigade_Ignatov == [1, 2, 3, 13]";
		
		news[12]= "show brigade_Ignatov";
		news[13]="show division_Dimitroff # both regiments detached from division_Dimitroff, so that's empty now";
		news[14]="brigade_Ignatov attached to division_Dimitroff # division_Dimitroff == [1, 2, 3, 13]";
		news[15]="show division_Dimitroff";
		news[16]="soldiers 2..3 from division_Dimitroff died heroically ";
		news[17]="show regiment_Stoykov";
		news[18]="show brigade_Ignatov";
		news[19]= "show division_Dimitrof";
		 return news[0];
	 }
	

}

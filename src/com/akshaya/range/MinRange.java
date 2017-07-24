package com.akshaya.range;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class MinRange {
	
	private static ArrayList<Ranges> ranges_List = new ArrayList<Ranges>();
	
	public static void main(String[] args) {	
		
//		Ranges a = new Ranges(94133,94133);
//		Ranges b = new Ranges(94200,94299);
//		Ranges c = new Ranges(94277,94699);
		
		Ranges a = new Ranges(20, 25);
		Ranges b = new Ranges(15, 50);
		Ranges c = new Ranges(8, 12);
		Ranges d = new Ranges(21, 67);
		Ranges e = new Ranges(63, 65);
		
		MinRange.AddToRange(a);
		MinRange.AddToRange(b);
		MinRange.AddToRange(c);
		MinRange.AddToRange(d);
		MinRange.AddToRange(e);
		
		showRanges() ;
		
	}

	public static void AddToRange(Ranges toAdd) {
		if(ranges_List.size()==0)
			ranges_List.add(toAdd);
		else {
			//adding new ranges
			//Merge if the range overlaps with existing range
			ListIterator<Ranges> iter = ranges_List.listIterator();
			boolean add = true; //flag
			while( iter.hasNext()) {
				Ranges ranges = iter.next();	
				//Don't add if new range overlaps with the existing
				if(ranges.getLow()<=toAdd.getLow() && ranges.getUp()>=toAdd.getUp()) {
					add = false;
				}
				//New range is not present in existing range so add it
				else if(ranges.getLow()>toAdd.getUp() || ranges.getUp()<toAdd.getLow()) {
					add = true;
				}
				//Remove the existing range and update toAdd since there is an overlap
				else {
					if(ranges.getLow()<toAdd.getLow())
						toAdd.setLow(ranges.getLow());
					if(ranges.getUp()>toAdd.getUp())
						toAdd.SetUp(ranges.getUp());
					iter.remove();
					add = true;
				}
			}
			if(add)
				ranges_List.add(toAdd);
		}
		
   }
	
   public static void showRanges() {
	   if(ranges_List.size()>0) {
		   for(Ranges ranges :ranges_List) {
			   System.out.println(ranges.toString());
		   }
	   }
	   
   }
   
   public static int size() {
	   return ranges_List.size();
   }
   
   public static List<Ranges> getMinRanges() {
	   return ranges_List;
   }
   
   
   public static void clear() {
	   ranges_List.clear();
   }

}

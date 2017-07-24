package com.akshaya.range;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;




public class MinRangeTest {
	
	private ArrayList<Ranges> expectedOutputs;
	
    @Before
    public void setUp() {
    	System.out.println("@Before - setUp");
    	this.expectedOutputs = new ArrayList<Ranges>();
    }
    
    @After
    public void tearDown() {
        System.out.println("@After - tearDown");
        this.expectedOutputs.clear();
        MinRange.clear();
    }

    
	@SuppressWarnings("deprecation")
	@Test
	public void MinRangetestWithNumbers() {
		
		setUp();
		
		Ranges a = new Ranges(3, 5);
		Ranges b = new Ranges(10, 13);
		Ranges c = new Ranges(8, 11);
		Ranges d = new Ranges(15, 19);
		Ranges e = new Ranges(13, 16);
		
		MinRange.AddToRange(a);
		MinRange.AddToRange(b);
		MinRange.AddToRange(c);
		MinRange.AddToRange(d);
		MinRange.AddToRange(e);
		
		//Test size
		Assert.assertEquals("failure - expected result size match", 2, MinRange.size());
		
		//Test content
		ArrayList<Ranges> expectedOutputs = new ArrayList<Ranges>();
		expectedOutputs.add(a);
		Ranges f = new Ranges(8, 19);
		expectedOutputs.add(f);
		Assert.assertEquals("failure - expected result content match", expectedOutputs, MinRange.getMinRanges());
		
		expectedOutputs.clear();
	}
	
	@Test
	public void MinRangetestWithTestData1() {
		setUp();
		
		Ranges a = new Ranges(94133, 94133);
		Ranges b = new Ranges(94200, 94299);
		Ranges c = new Ranges(94600, 94699);
		
		MinRange.AddToRange(a);
		MinRange.AddToRange(b);
		MinRange.AddToRange(c);
		
		Assert.assertEquals("failure - expected result size match", 3, MinRange.size());
		
		Ranges e = new Ranges(94133, 94133);
		Ranges f = new Ranges(94200, 94299);
		Ranges g = new Ranges(94600, 94699);
		expectedOutputs.add(e);
		expectedOutputs.add(f);
		expectedOutputs.add(g);
		Assert.assertEquals("failure - expected result content match", expectedOutputs, MinRange.getMinRanges());
		
		tearDown();
		
	}
	
	
	@Test
	public void MinRangetestWithTestData2() {
		setUp();
		
		Ranges a = new Ranges(94133, 94133);
		Ranges b = new Ranges(94200, 94299);
		Ranges c = new Ranges(94226, 94399);
		
		MinRange.AddToRange(a);
		MinRange.AddToRange(b);
		MinRange.AddToRange(c);
		
		Assert.assertEquals("failure - expected result size match", 2, MinRange.size());
		
		Ranges e = new Ranges(94133, 94133);
		Ranges f = new Ranges(94200, 94399);
		
		expectedOutputs.add(e);
		expectedOutputs.add(f);
		
		Assert.assertEquals("failure - expected result content match", expectedOutputs, MinRange.getMinRanges());
		
		tearDown();
		
	}
	

}
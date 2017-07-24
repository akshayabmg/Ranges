package com.akshaya.range;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class MinRangeTest {
	//using array list
	private ArrayList<Ranges> expectedOutputs;
	
	//before the test case- setting up 
    @Before
    public void setUp() {
    	System.out.println("Setting upper- @Before run");
    	this.expectedOutputs = new ArrayList<Ranges>();
    }
    
    //after the test case pass/fail- teardown the tests
    @After
    public void tearDown() {
        System.out.println("tearDown run- @After run");
        this.expectedOutputs.clear();
        MinRange.clear();
    }

    
	@SuppressWarnings("deprecation") //for assert
	
	//first set of data for tests
	@Test
	public void MinRangetestWithTestData1() {
		setUp();
		//test data taken from the question 
		Ranges a = new Ranges(94133, 94133);
		Ranges b = new Ranges(94200, 94299);
		Ranges c = new Ranges(94600, 94699);
		
		MinRange.AddToRange(a);
		MinRange.AddToRange(b);
		MinRange.AddToRange(c);
		
		Assert.assertEquals("size matching failure", 3, MinRange.size());
		
		Ranges e = new Ranges(94133, 94133);
		Ranges f = new Ranges(94200, 94299);
		Ranges g = new Ranges(94600, 94699);
		expectedOutputs.add(e);
		expectedOutputs.add(f);
		expectedOutputs.add(g);
		Assert.assertEquals("content matching failure", expectedOutputs, MinRange.getMinRanges());
		
		//expected output is same as that of input 
		
		tearDown(); //tear down called for finishing the test
		
	}
	
	//second set of data for tests
	@Test
	public void MinRangetestWithTestData2() {
		setUp();
		
		//data taken from question 
		
		Ranges a = new Ranges(94133, 94133);
		Ranges b = new Ranges(94200, 94299);
		Ranges c = new Ranges(94226, 94399);
		
		MinRange.AddToRange(a);
		MinRange.AddToRange(b);
		MinRange.AddToRange(c);
		
		Assert.assertEquals("size matching failure", 2, MinRange.size());
		
		
		Ranges e = new Ranges(94133, 94133);
		Ranges f = new Ranges(94200, 94399);
		
		expectedOutputs.add(e);
		expectedOutputs.add(f);
		
		
		Assert.assertEquals("content matching failure", expectedOutputs, MinRange.getMinRanges());
		
		tearDown(); //tear down called for finishing off the tests
		
	}
	

}
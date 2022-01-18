package com;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ElectricityDiscountCalcTest {
	ElectricityDiscountCalc e =new ElectricityDiscountCalc();
	DecimalFormat df = new DecimalFormat("#,###,##0.00");

	//tax consumption < 601
	@Test
	void TaxTest1() {
		String a = df.format(0);
		String b = df.format(e.calcTax(600, 100,1));
		
		assertEquals(a, b);
	}
	
	//tax consumption >= 601 AND disc == 0
	@Test
	void TaxTest2() {
		String a = df.format(-7.908);
		String b = df.format(e.calcTax(602, 100,0));
		
		assertEquals(a,b);
	}
	
	//tax consumption >= 601 AND disc == 1
	@Test
	void TaxTest3() {
		String a = df.format(-4.7058);
		String b = df.format(e.calcTax(601, 100,1));
		assertEquals(a,b);
	}
	
	/* #### calcDisBilNR1 #####*/
	//consumption < 201
	@Test
	void calcDisBilNR1Test1() {
		String a = df.format(73.95);
		String b = df.format(e.calcDiscBilNR1(200));
		assertEquals(a,b);
	}
	//consumption >= 201
	@Test
	void calcDisBilNR1Test2() {
		String a = df.format(74.38);
		String a1 = df.format(160.48);
		String b = df.format(e.calcDiscBilNR1(201));
		String b1 = df.format(e.calcDiscBilNR1(400));
		assertEquals(a,b);
		assertEquals(a1,b1);
	}	
		 /* #### calcDisBilNR2 #####*/
		//consumption < 201
		@Test
		void calcDisBilNR2Test1() {
			String a = df.format(85.26);
			String b = df.format(e.calcDiscBilNR2(200));
			assertEquals(a,b);
	}
		//consumption >= 201
		@Test
		void calcDisBilNR2Test2() {
			String a = df.format(85.76);
			String b = df.format(e.calcDiscBilNR2(201));
			assertEquals(a,b);
		}


//    /* #### calcNoDisBilNR #####*/
		//consumption < 201
		@Test
		void calcNoDisBilNRTest1() {
			String a = df.format(87);
			String b = df.format(e.calcNoDiscBilNR(200));
			assertEquals(a,b);
		}
		//consumption >= 201
		@Test
		void calcNoDisBilNRTest2() {
			String a = df.format(290.6);
			String b = df.format(e.calcNoDiscBilNR(600));
			assertEquals(a,b);
		}

//    /* #### calcDisBilR #####*/
		@Test
		void calcDisBilRTest1() {
			String a = df.format(21.8);
			String b = df.format(e.calcDiscBilR(200));
			assertEquals(a,b);
		}
		@Test
		void calcDisBilRTest2() {
			String a = df.format(33.32);
			String b = df.format(e.calcDiscBilR(246));
			assertEquals(a,b);
		}
		@Test
		void calcDisBilRTest3() {
			String a = df.format(90.71);
			String b = df.format(e.calcDiscBilR(400));
			assertEquals(a,b);
		}
		@Test
		void calcDisBilRTest4() {
			String a = df.format(189.13);
			String b = df.format(e.calcDiscBilR(620));
			assertEquals(a,b);
		}
		@Test
		void calcDisBilRTest5() {
			String a = df.format(340.07);
			String b = df.format(e.calcDiscBilR(902));
			assertEquals(a,b);
		}
		

//    /* #### calcNoDisBilR #####*/
		@Test
		void calcNoDisBilRTest1() {
			String a = df.format(43.6);
			String b = df.format(e.calcNoDiscBilR(200));
			assertEquals(a,b);
		}
		@Test
		void calcNoDisBilRTest2() {
			String a = df.format(70.32);
			String b = df.format(e.calcNoDiscBilR(280));
			assertEquals(a,b);
		}
		@Test
		void calcNoDisBilRTest3() {
			String a = df.format(128.6);
			String b = df.format(e.calcNoDiscBilR(400));
			assertEquals(a,b);
		}
		@Test
		void calcNoDisBilRTest4() {
			String a = df.format(242.72);
			String b = df.format(e.calcNoDiscBilR(620));
			assertEquals(a,b);
		}
		@Test
		void calcNoDisBilRTest5() {
			String a = df.format(396.742);
			String b = df.format(e.calcNoDiscBilR(902));
			assertEquals(a,b);
		}
		
		 private ByteArrayInputStream testIn;
		 private ByteArrayOutputStream testOut;
		 
		 private void provideInput(String data) {
	            testIn = new ByteArrayInputStream(data.getBytes());
	            System.setIn(testIn);
	        }
		 
		 
		//@Nested
		private String Test(double amount, double tax, double amountWithTax, double amountDisc, double taxDisc, double amountDiscWithTaxDisc, double total,boolean notR,String sector_type) {
			
			String user_type ="";
			String residential="Residential";

			return null;
		}
	@Test
	 void TestCase1() {
		provideInput("1\nResidential\n200\n0\n");
		e.main(null);
		equals(Test(43.6,0,43.6,21.8,0,21.8,21.8,false,null));
	}
	@Test
	void TestCase2() {
		provideInput("1\nResidential\n280\n0\n");
		e.main(null);
		equals(Test(70.32,0,70.32,41.84,0,41.84,28.48,false,null));
	}
	@Test
	void TestCase3() {
		provideInput("1\nResidential\n500\n0\n");
		e.main(null);
		equals(Test(180.2,0,180.2,134.57,0,134.57,45.63,false,null));
	}
	@Test
	void TestCase4() {
		provideInput("1\nResidential\n800\n0\n");
		e.main(null);
		equals(Test(341,6.55,347.55,285.45,6.42,291.87,55.69,false,null));
	}
	
	


	 @Test
     public void classShouldInstantiateMainClass() {
         assertTrue((new ElectricityDiscountCalc()) instanceof ElectricityDiscountCalc);
     }

		 



}
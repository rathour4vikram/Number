package devops.numbers;

import org.junit.*;

import devops.numbers.NumberWords;

public class NumberWordsTests {
        private NumberWords numberWords ;
        
        @Before
        public void setup() {
                numberWords = new NumberWords() ;
        }

        @Test
        public void numberOutOfRangeReturnsError() {
        	//Test case 1.1 - 1.4:  To test input  "Number out of range" 
                Assert.assertEquals( "Test1.1", "Number out of range", numberWords.toWords( -1 ) ) ;
                Assert.assertEquals( "Test1.2", "Number out of range", numberWords.toWords( 1000 ) ) ;
                Assert.assertEquals( "Test1.3", "Number out of range", numberWords.toWords( 12000 ) ) ;
                Assert.assertEquals( "Test1.4", "Number out of range", numberWords.toWords( 0 ) ) ;
        }
        
        @Test
        public void numberRangeOneToNine() {    
            //Test cases 2.1 - 2.9 :  To test input 1 to 9 by iteration 
        	
        	String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                int i  = 0;
                for(String word : SingleDigit){
                	i = i + 1;
                	String TestNo = "Test2." + i;
              // 	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                
              //Test case 2.9:  To test input 5      
                
                Assert.assertEquals( "Test2.10", "Five", numberWords.toWords( 5 ) ) ;
        }
        
        @Test
        public void numberRangeTenToNineteen() {
        	 //Test cases 3.1 - 3.10 :  To test input 10 to 19 by iteration 
        	
                String[] DoubleDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                int i  = 9;
                for(String word : DoubleDigit){
                	i = i + 1;
                	String TestNo = "Test3." + (i - 9);
               //  	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                
                //Test case 3.11:  To test input 12
                
                Assert.assertEquals( "Test3.11", "Twelve", numberWords.toWords( 12 ) ) ;

        }

        @Test
        public void numberRangeTwentyToNinetyNine() {
        	//Test cases 4.1 - 4.80 :  To test input 20 to 99 by iteration 
        	
                String[] DoubleDigitMultipleOf10 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
                String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                int i  = 19;
                while( i < 99 ){
                	String word = "";
                	i = i + 1;
                	int digit_unit = i % 10;
                	int digit_ten = i / 10;
                	if( digit_unit == 0 ) {
                		word = DoubleDigitMultipleOf10[digit_ten - 2 ];
                	}else {
                		word = DoubleDigitMultipleOf10[digit_ten - 2 ] + " " + SingleDigit[digit_unit - 1];
                	}
                	String TestNo = "Test4." + (i - 19);
//                	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                
                //Test case 4.81:  To test input 89
                
                Assert.assertEquals( "Test4.81", "Eighty Nine", numberWords.toWords( 89 ) ) ;  
                   
                }
        
        @Test
        public void numberRangeHundredToNineHundredNinetyNine() {
        	        //Test case 5.1 - 5.4:  To test input 101, 121, 411 and 813
    
                    Assert.assertEquals( "Test5.1", "One Hundred One", numberWords.toWords( 101 ) ) ;
                    Assert.assertEquals( "Test5.2", "One Hundred Twenty One", numberWords.toWords( 121 ) ) ;
                    Assert.assertEquals( "Test5.3", "Four Hundred Eleven", numberWords.toWords( 411 ) ) ;
                    Assert.assertEquals( "Test5.4", "Eight Hundred Thirteen", numberWords.toWords( 813 ) ) ;
                    
                  //Test cases 5.5 - 5.904 :  To test input 100 to 999 by iteration   
                    
            	    String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        		    String[] DoubleDigit = {"Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                    String[] DoubleDigitMultipleOf10 = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
                    String[] place = {"Unit", "Ten", "Hundred"};
                        int i  = 99;
                        while( i < 999 ){
                        	String word = "";
                        	i = i + 1;
                        	int num = i;
                        	int j = 0;
                        	while ( num > 0 ) {
                        		int digit = num % 10; int ten_digits = num % 100;
                        		if ( digit == 0 ) {
                        			num = num / 10; j++;
                        			continue;
                        		  }
                        		if (place[j] == "Unit") {
                        			if (!( ten_digits >= 11 && ten_digits <= 19)) {
                                		
                                	word =  " " + SingleDigit[digit - 1] + word;
                                	}else {
                                		
                                		word =  " " + DoubleDigit[ten_digits - 11] + word;
                                		num = num / 100; j = j + 2;
                                		continue;
                                	}
                        			
                        		}else if(place[j] =="Ten"){
                        			
                        			word =  " " + DoubleDigitMultipleOf10[digit - 1] + word;
                        					
                        		}else if(place[j] == "Hundred"){
                        			
                        			word =  " " + SingleDigit[digit - 1]  + " " + place[j] + word;
                        		}
                        	    num = num / 10; j++;
                        		
                        	}
                        	word = word.trim();
//               	        System.out.println( i ) ;
//                        	System.out.println( word ) ;
                        	String TestNo = "Test5." + ((i - 99) + 4);
//                        	System.out.println( TestNo ) ;
                        	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                        }
                }
        }
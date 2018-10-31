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
                Assert.assertEquals( "Test1.1", "Number out of range", numberWords.toWords( -1 ) ) ;
                Assert.assertEquals( "Test1.2", "Number out of range", numberWords.toWords( 1000 ) ) ;
                Assert.assertEquals( "Test1.3", "Number out of range", numberWords.toWords( 12000 ) ) ;
                Assert.assertEquals( "Test1.4", "Number out of range", numberWords.toWords( 0 ) ) ;
        }
        
        @Test
        public void numberRangeOneToNine() {
                String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                int i  = 0;
                for(String word : SingleDigit){
                	i = i + 1;
                	String TestNo = "Test2." + i;
                	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                
                Assert.assertEquals( "Test2.10", "Five", numberWords.toWords( 5 ) ) ;
        }
        
        @Test
        public void numberRangeTenToNineteen() {
                String[] DoubleDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                int i  = 9;
                for(String word : DoubleDigit){
                	i = i + 1;
                	String TestNo = "Test3." + (i - 9);
                	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                
                Assert.assertEquals( "Test3.11", "Twelve", numberWords.toWords( 12 ) ) ;

        }

        @Test
        public void numberRangeTwentyToNinetyNine() {
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
                	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                	
                   Assert.assertEquals( "Test4.81", "Eighty Nine", numberWords.toWords( 89 ) ) ;  
                }
        
        @Test
        public void numberRangeHundredToNineHundredNinetyNine() {
        	String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
            String[] DoubleDigitMultipleOf10 = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
            String[] place = {"Unit", "Ten", "Hundred"};
                int i  = 99;
                while( i < 999 ){
                	String word = "";
                	i = i + 1;
                	int num = i;
                	int j = 0;
                	while ( num > 0 ) {
                		int digit = num % 10;
                		if ( digit == 0 ) {
                			num = num / 10; j++;
                			continue;
                		  }
                		if (place[j] == "Unit") {
                			word =  " " + SingleDigit[digit - 1] + word;
                			
                		}else if(place[j] =="Ten"){
                			
                			word =  " " + DoubleDigitMultipleOf10[digit - 1] + word;
                					
                		}else if(place[j] == "Hundred"){
                			
                			word =  " " + SingleDigit[digit - 1]  + " " + place[j] + word;
                		}
                	    num = num / 10; j++;
                		
                	}
                	word = word.trim();
 //               	System.out.println( i ) ;
//                	System.out.println( word ) ;
                	String TestNo = "Test5." + (i - 99);
                	System.out.println( TestNo ) ;
                	Assert.assertEquals( TestNo, word, numberWords.toWords( i ) ) ;
                }
                    Assert.assertEquals( "Test5.901", "One Hundred One", numberWords.toWords( 101 ) ) ;
                    Assert.assertEquals( "Test5.901", "Four Hundred Eleven", numberWords.toWords( 411 ) ) ;
                    Assert.assertEquals( "Test5.902", "Eight Hundred Thirteen", numberWords.toWords( 813 ) ) ; 
                }
        }
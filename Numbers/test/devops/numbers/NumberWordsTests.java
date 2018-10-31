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
                Assert.assertEquals( "Test01", "Number out of range", numberWords.toWords( -1 ) ) ;
        }
        
        @Test
        public void numberRangeBetweenOneToNine() {
                String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                int i  = 0;
                for(String word : SingleDigit){
                	i = i + 1;
                	Assert.assertEquals( "Test02", word, numberWords.toWords( i ) ) ;
                }
                
        }
        
        @Test
        public void numberRangeBetweenTenToNineteen() {
                String[] DoubleDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                int i  = 9;
                for(String word : DoubleDigit){
                	i = i + 1;
                	Assert.assertEquals( "Test03", word, numberWords.toWords( i ) ) ;
                }

        }

        @Test
        public void numberRangeBetweenTwentyToNinetyNine() {
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
                	
                	Assert.assertEquals( "Test04", word, numberWords.toWords( i ) ) ;
                }
                	
                     
                }
        
        @Test
        public void numberRangeBetweenHundredToNineHundredNinetyNine() {
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
                	
                	Assert.assertEquals( "Test05", word, numberWords.toWords( i ) ) ;
                }
                	
                     
                }
        }
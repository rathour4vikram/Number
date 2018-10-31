package devops.numbers;

public class NumberWords {

        public String toWords( int number ) {
                String result = "" ;
                if ( number <= 0 || number > 999 ){
                        result = "Number out of range";
                } else if ( number >= 1 && number <= 9 ) {
                        String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                        result = SingleDigit[number - 1];
                }else if (number >= 10 && number <= 19 ){
                        String[] DoubleDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                        result = DoubleDigit[number - 10];
                }else if ( number >= 20 && number <= 99 ) {
                	String[] DoubleDigitMultipleOf10 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
                    String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                    	int digit_unit = number % 10;
                    	int digit_ten = number / 10;
                    	if( digit_unit == 0 ) {
                    		result = DoubleDigitMultipleOf10[digit_ten - 2 ];
                    	}else {
                    		result = DoubleDigitMultipleOf10[digit_ten - 2 ] + " " + SingleDigit[digit_unit - 1];
                    	}
                }else {
                	String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                	String[] DoubleDigit = {"Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                    String[] DoubleDigitMultipleOf10 = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
                    String[] place = {"Unit", "Ten", "Hundred"};
                    String word = "";
                  
                    int num = number;
                    int j = 0;
                    while ( num > 0 ) {
                    	int digit = num % 10; int ten_digits = num % 100; 
                    	if ( digit == 0 ) {
                    		num = num / 10; j++;
                            continue;
                            }
                        if ( place[j] == "Unit" ) {
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
                        			
                        	word =  " " + SingleDigit[digit - 1] + " " + place[j] + word;
                        
                        }
                        num = num / 10; j++;
                        		
                        }
                        result = word;
                        	
                        }
                return result.trim() ;
        }

}
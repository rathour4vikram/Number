package devops.numbers;

public class NumberWords {

        public String toWords( int number ) {
                String result = "" ;
                if ( number < 0 || number > 999){
                        result = "Number out of range";
                } else if ( number >= 1 && number < 10) {
                        String[] SingleDigit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                        result = SingleDigit[number - 1];
                }else if (number >= 10 && number <= 19 ){
                        String[] DoubleDigit = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                        result = DoubleDigit[number - 10];
                }else if ( number > 19 && number < 100 ) {
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
                    String[] DoubleDigitMultipleOf10 = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy", "Eighty", "Ninety"};
                    String[] place = {"Unit", "Ten", "Hundred"};
                    String word = "";
                  
                    int num = number;
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
                        			
                        	word =  " " + SingleDigit[digit - 1] + " " + place[j] + word;
                        
                        }
                        num = num / 10; j++;
                        		
                        }
                        result = word;
                        	
                        }
                return result.trim() ;
        }

}
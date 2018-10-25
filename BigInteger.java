package bigint;

/**
 * This class encapsulates a BigInteger, i.e. a positive or negative integer with 
 * any number of digits, which overcomes the computer storage length limitation of 
 * an integer.
 * 
 */
public class BigInteger {

	/**
	 * True if this is a negative integer
	 */
	boolean negative;
	
	/**
	 * Number of digits in this integer
	 */
	int numDigits;
	
	/**
	 * Reference to the first node of this integer's linked list representation
	 * NOTE: The linked list stores the Least Significant Digit in the FIRST node.
	 * For instance, the integer 235 would be stored as:
	 *    5 --> 3  --> 2
	 *    
	 * Insignificant digits are not stored. So the integer 00235 will be stored as:
	 *    5 --> 3 --> 2  (No zeros after the last 2)        
	 */
	DigitNode front;
	
	/**
	 * Initializes this integer to a positive number with zero digits, in other
	 * words this is the 0 (zero) valued integer.
	 */
	public BigInteger() {
		negative = false;
		numDigits = 0;
		front = null;
	}
	
	/**
	 * Parses an input integer string into a corresponding BigInteger instance.
	 * A correctly formatted integer would have an optional sign as the first 
	 * character (no sign means positive), and at least one digit character
	 * (including zero). 
	 * Examples of correct format, with corresponding values
	 *      Format     Value
	 *       +0            0
	 *       -0            0
	 *       +123        123
	 *       1023       1023
	 *       0012         12  
	 *       0             0
	 *       -123       -123
	 *       -001         -1
	 *       +000          0
	 *       
	 * Leading and trailing spaces are ignored. So "  +123  " will still parse 
	 * correctly, as +123, after ignoring leading and trailing spaces in the input
	 * string.
	 * 
	 * Spaces between digits are not ignored. So "12  345" will not parse as
	 * an integer - the input is incorrectly formatted.
	 * 
	 * An integer with value 0 will correspond to a null (empty) list - see the BigInteger
	 * constructor
	 * 
	 * @param integer Integer string that is to be parsed
	 * @return BigInteger instance that stores the input integer.
	 * @throws IllegalArgumentException If input is incorrectly formatted
	 */
	
	private void addToFront(int digit) {
		front = new DigitNode(digit, front);
	}
	
	
	public static BigInteger parse(String integer) 
	throws IllegalArgumentException {
		
		// following line is a placeholder - compiler needs a return
		// modify it according to need
		
//		if (integer.length() == 0) {
//			throw new IllegalArgumentException();
//			System.out.println("Can't enter empty string");
//		}
		
		BigInteger head = new BigInteger();
		integer = integer.trim();
		

		if (!Character.isDigit(integer.charAt(0))) {
			
			if (integer.charAt(0) == '+') {
				
				head.negative = false;
				
			} else if (integer.charAt(0) == '-') {
				
				head.negative = true;
			} else {
				
				throw new IllegalArgumentException();
			}
			
			
			
			integer = integer.substring(1);
		}
		
		
//		if (!Character.isDigit(integer.charAt(0)) || integer.charAt(0) == '-' || integer.charAt(0) == '+') {
//			
//			if (integer.charAt(0) == '-') {
//				head.negative = true;
//				//integer = integer.substring(1);
//			}
//			
//			if (integer.charAt(0) == '+') {
//				head.negative = false;
//				//integer = integer.substring(1);
//			}
//			
//			if (!Character.isDigit(integer.charAt(0)))
//				throw new IllegalArgumentException();
//			
//			integer = integer.substring(1);
//		}
		
		
		
		
		
			// 0 is not the only digit in the string
			while (integer.charAt(0) == '0' && integer.length() > 1) {
				
				integer = integer.substring(1);
			}
			
			
			
			for (int i = 0; i < integer.length(); i++) {
				
				
				if (Character.isDigit(integer.charAt(i))) {
					
					char x = integer.charAt(i);
					int y = Character.getNumericValue(x);
					int z = Integer.parseInt(String.valueOf(x));
					head.addToFront(z);
					head.numDigits++;
					
				} else {
					
					throw new IllegalArgumentException();
				}
			}
			
//			  System.out.println("Parsing result");
//		        System.out.println("Number of Digits: " + head.numDigits);
//		        for (DigitNode ptr = head.front; ptr != null; ptr = ptr.next) {
//		            System.out.print(ptr.digit + " - > ");
//		        }
//		        System.out.println();


			
			
			
		
		        return head;
		
		
		//for loop, for every 0, add to counter but somehow avoid any 0's in between numbers
		//insert number without 0's into linked list
		//determine the sign 
		
		
		
		
		
		
		
		
		
		
	}
	
	/**
	 * Adds the first and second big integers, and returns the result in a NEW BigInteger object. 
	 * DOES NOT MODIFY the input big integers.
	 * 
	 * NOTE that either or both of the input big integers could be negative.
	 * (Which means this method can effectively subtract as well.)
	 * 
	 * @param first First big integer
	 * @param second Second big integer
	 * @return Result big integer
	 */
	public static BigInteger add(BigInteger first, BigInteger second) {
		// following line is a placeholder - compiler needs a return
		// modify it according to need

		// both numbers are positive or both numbers are negative
		 if ((first.negative == true && second.negative == true) || (first.negative == false && second.negative == false)) {
	         
	            DigitNode ptrSmall = first.front;
	            DigitNode ptrBig = second.front;

	        
	            if (second.numDigits < first.numDigits) {
	                ptrSmall = second.front;
	                ptrBig = first.front;
	            }

	            BigInteger list = new BigInteger();
	            list.negative = first.negative;
	            int x = 0;
	            int a;
	            int b;
	            int c;

	            
	            
	            while (ptrBig != null || (ptrBig == null && x != 0)) {
	              
	                if (ptrSmall == null) {
	                    b = 0;
	                    
	                } else {
	                    b = ptrSmall.digit;
	                }

	                
	                
	                if (ptrBig == null) {
	                    c = 0;
	                    
	                } else {
	                    c = ptrBig.digit;
	                }
	             
	                
	                a = b + c + x;

	             
	                x = 0;
	                
	                
	                
	                if (a > 9) {
	                	
	                    a = a % 10;
	                    x = 1;
	                    
	                }

	             
	                if (list.numDigits == 0) {
	                
	                    list.front = new DigitNode(a, list.front);
	                    
	                } else {
	                 
	                    DigitNode ptr = list.front;
	                   
	                    while (ptr.next != null) {
	                        ptr = ptr.next;
	                    }
	                    ptr.next = new DigitNode(a, null);
	                }
	                
	                
	                
	                list.numDigits++;

	             
	                if (ptrSmall!= null) {
	                    ptrSmall = ptrSmall.next;
	                }

	                if (ptrBig!=null) {
	                    ptrBig = ptrBig.next;
	                }
	                
	            }

	   
//	            System.out.println("Adding result: ");
//	            System.out.println("Number of Digits: " + addedInt.numDigits);
//	            for (DigitNode ptr = addedInt.front; ptr != null; ptr = ptr.next) {
//	                System.out.print(ptr.digit + " - > ");
//	            }
//	            System.out.println();
	            
	            list = list.parse(list.toString());
	            return list;
	        } 
		 
		 //ignore signs when doing single digit math
		 //while loop to traverse both lists, comparing digits
		 //whichever is bigger takes over as the sign, the ending boolean is the result
		 
		 // 3103
		 //-3003
		 
		 // first is positive, second is negative
		 
		 // first number is positive, second is negative
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 else if (first.negative == false && second.negative == true) {
			
			 DigitNode ptrBig = first.front;
			 DigitNode ptrSmall = second.front;
//			 DigitNode ptrPos = first.front;
//			 DigitNode ptrNeg = second.front;
			 BigInteger list2 = new BigInteger();
			 
			 if (first.numDigits < second.numDigits) {
				 ptrBig = second.front;
				 ptrSmall = first.front;
			 }
			 
			 int x;
			 int y;
			 int z;
			 
			 while (ptrBig != null) {
//			 while ((ptrPos != null && ptrNeg == null) || (ptrPos == null && ptrNeg != null) || (ptrPos != null && ptrNeg != null)) {
				 
				 
//				 if (first.numDigits > second.numDigits) {
//					 x = ptrBig.digit;
//					 y = ptrSmall.digit;
//					 
//				 }
				 
				 if (ptrSmall != null) {
					 
					 
					 
					 
					 
				 if (ptrBig.digit >= ptrSmall.digit) {
					 x = ptrBig.digit;
					 y = ptrSmall.digit;
					 z = x - y;
					 list2.negative = false;
				 
//				 if (ptrPos.digit >= ptrNeg.digit) {
//					 x = ptrPos.digit;
//					 y = ptrNeg.digit;
//					 z = x - y;
					 
				 } else {
					 
					 x = ptrSmall.digit;
					 y = ptrBig.digit;
					 z = x - y;
					list2.negative = true;
				 }
				 
				 } else {
					 z = ptrBig.digit;
				 }
				 
//				 if (first.numDigits > second.numDigits && ptrSmall != null) {
//					 x = ptrBig.digit;
//					 y = ptrSmall.digit;
//					 if (ptrBig.digit >= ptrSmall.digit) {
//						 z = x - y;
//						 addedInt2.negative = false;
//					 } else {
//						 x = ptrBig.digit + 10;
//						 ptrBig.next.digit -= 1;
//						 y = ptrSmall.digit;
//						 z = x - y;
//						 addedInt2.negative = true;
//					 }
//				 } else if (first.numDigits < second.numDigits && ptrSmall != null) {
//					 x = ptrSmall.digit;
//					 y = ptrBig.digit;
//					 if (ptrSmall.digit >= ptrBig.digit) {
//						 z = x - y;
//						 addedInt2.negative = false;
//					 } else {
//						 x = ptrSmall.digit + 10;
//						 ptrBig.next.digit -= 1;
//						 y = ptrBig.digit;
//						 z = x = y;
//						 addedInt2.negative = true;
//					 }
//				 } else {
//					 x = ptrBig.digit;
//					 y = ptrSmall.digit;
//					 if (x >= y) {
//						 z = x - y;
//					 } else {
//						 z = y - x;
//					 }
//				 }
				 
				 //------------------------------------------------------------
//				 if (ptrBig != null && ptrSmall != null) {
//				 if (first.numDigits >= second.numDigits) {
//					 if (ptrBig.digit > ptrSmall.digit) {
//						 z = ptrBig.digit - ptrSmall.digit;
//					 } else {
//						 z = ptrSmall.digit - ptrBig.digit;
//					 	}
//				 	}
//				 }
				 //------------------------------------------------------------

				 
				 
				 
				 
				 
				 if (list2.numDigits == 0) {
				
					 list2.front = new DigitNode(z, list2.front);
					 list2.numDigits++;
					 
				 } else {
					 
					 DigitNode ptr = list2.front;
					 
					 while (ptr.next != null) {
						 ptr = ptr.next;
					 }
					 
					 ptr.next = new DigitNode(z, null);
					 list2.numDigits++;
					 
				 }
				 
				 if (ptrBig != null) {
					 ptrBig = ptrBig.next;
				 }
				 
				 if (ptrSmall != null) {
					 ptrSmall = ptrSmall.next;
				 }
				 
				 
				 
				 
			 }
			 
			 if (first.numDigits > second.numDigits) {
				 list2.negative = false;
			 } else if (first.numDigits < second.numDigits) {
				 list2.negative = true;
			 } else {
				 DigitNode ptrFirst = first.front;
				 DigitNode ptrSecond = second.front;
				 
				 while (ptrFirst.next != null) {

					 if (ptrFirst.digit > ptrSecond.digit) {
						 list2.negative = false;
					 } else if (ptrFirst.digit < ptrSecond.digit) {
						 list2.negative = true;
					 }
				 
					 ptrFirst = ptrFirst.next;
					 ptrSecond = ptrSecond.next;
				 }
				 //if (second.numDigits > first.numDigits) addedInt2.negative = true;
			 }
			 
			 
			 list2 = list2.parse(list2.toString());
			 return list2;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
//		  else if (first.negative == false && second.negative == true) {
//			 
//			 BigInteger addedInt2 = new BigInteger();
//			 DigitNode ptrPos = first.front;
//			 DigitNode ptrNeg = second.front;
//			 boolean posBigger;
//			 
//			 if (first.numDigits >= second.numDigits) {
//				 posBigger = true;
//			 } else {
//				 posBigger = false;
//			 }
//		 
//			 while ((posBigger == true && ptrPos != null) || (posBigger == false && ptrNeg != null)) {
//				 
//				 int posDigit;
//				 int negDigit;
//				 if (ptrPos != null) {
//					 posDigit = ptrPos.digit;
//				 }
//				 if (ptrNeg != null) {
//					 negDigit = ptrNeg.digit;
//				 }
//				 int answer;
//				 
//
//				 
//				 
//				 
//				 if (ptrPos.digit >= ptrNeg.digit) {
//					 answer = ptrPos.digit - ptrNeg.digit;
//				 } else {
//					 answer = ptrNeg.digit - ptrPos.digit;
//				 }
//				 
//				 if (first.numDigits == second.numDigits) {
//				 if (ptrPos.digit < ptrNeg.digit && ptrPos.next != null) {
//					 posDigit = 10 + ptrPos.digit;
//					 ptrPos.next.digit -= 1;
//					 negDigit = ptrNeg.digit;
//					 answer = posDigit - negDigit;
//				 }
//				 }
//				 
//				 if (addedInt2.numDigits == 0) {
//					 addedInt2.front = new DigitNode(answer, addedInt2.front);
//					 addedInt2.numDigits++;
//				 } else {
//					 DigitNode ptr = addedInt2.front;
//					 while (ptr.next != null) {
//						 ptr = ptr.next;
//					 }
//					 ptr.next = new DigitNode(answer, null);
//					 addedInt2.numDigits++;
//				 }
//				 
//				 if (ptrPos != null) {
//					 ptrPos = ptrPos.next;
//				 }
//				 
//				 if (ptrNeg != null) {
//					 ptrNeg = ptrNeg.next;
//				 }
//				 
//			 }
//			 	addedInt2 = addedInt2.parse(addedInt2.toString());
//			 	return addedInt2;
//		 }
//		 
		 
		 

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
//		 		else if (first.negative == false && second.negative == true) {
//		 			
//		 			DigitNode ptrPos = first.front;
//		 			DigitNode ptrNeg = second.front;
//		 			
//		 			BigInteger addedInt2 = new BigInteger();
//		 			
//		 			int x;
//		 			int y;
//		 			int z;
//		 			
//		 			if (first.numDigits > second.numDigits) {
//		 				
//		 				first.negative = false;
//		 				
//		 				while (ptrPos != null) {
//		 					
//		 				if (ptrPos.digit >= ptrNeg.digit) {
//		 					x = ptrPos.digit;
//		 					y = ptrNeg.digit;
//		 					z = x - y;
//		 					
//		 				}  else 
////		 					if (ptrPos.digit < ptrNeg.digit) 
//		 					{
//		 					x = 10 + ptrPos.digit;
//		 					ptrPos.next.digit -= 1;
//		 					y = ptrNeg.digit;
//		 					z = x - y;
//		 				}
//		 				//5612
//		 				//5621
//		 				
//		 				
//		 				if (addedInt2.numDigits == 0) {
//		 					addedInt2.front = new DigitNode(z, addedInt2.front);
//		 					addedInt2.numDigits++;
//		 				}
//
//		 				else {
//		 					
//		 					DigitNode ptr = addedInt2.front;
//		 					
//		 					while (ptr!=null) {
//		 						ptr = ptr.next;
//		 					}
//		 					ptr.next = new DigitNode(z, null);
//		 					addedInt2.numDigits++;
//		 					
//
//		 				}
//
//		 				if (ptrPos != null) {
//		 					ptrPos = ptrPos.next;
//		 				}
//
//		 				if (ptrNeg != null) {
//		 					ptrNeg = ptrNeg.next;
//		 				}
//
//
//
//		 				}
//
//		 				return addedInt2;
//		 				
//		 			}
//
//		 		} 
	
			 // first number is negative, second number is positive
		 } else {
			 
			DigitNode ptrBig = first.front;
			DigitNode ptrSmall = second.front;
			BigInteger list2 = new BigInteger();
			
			 if (first.numDigits < second.numDigits) {
				 ptrBig = second.front;
				 ptrSmall = first.front;
			 }
			 
			 int x;
			 int y;
			 int z;
			 
			 while (ptrBig != null) {
				 
				 if (ptrSmall != null) {
					 
					  if (ptrBig.digit >= ptrSmall.digit) {
						 x = ptrBig.digit;
						 y = ptrSmall.digit;
						 z = x - y;
						 list2.negative = false;
					 
					  } else {
							 
							 x = ptrSmall.digit;
							 y = ptrBig.digit;
							 z = x - y;
							list2.negative = true;
						 }
						 
						 } else {
							 z = ptrBig.digit;
						 }
				 
				 if (list2.numDigits == 0) {
						
					 list2.front = new DigitNode(z, list2.front);
					 list2.numDigits++;
					 
				 } else {
					 
					 DigitNode ptr = list2.front;
					 
					 while (ptr.next != null) {
						 ptr = ptr.next;
					 }
					 
					 ptr.next = new DigitNode(z, null);
					 list2.numDigits++;
					 
				 }
				 
				 if (ptrBig != null) {
					 ptrBig = ptrBig.next;
				 }
				 
				 if (ptrSmall != null) {
					 ptrSmall = ptrSmall.next;
				 }
				 
				 
				 
				 
			 }
			 
			 if (first.numDigits > second.numDigits) {
				 list2.negative = true;
			 } else if (first.numDigits < second.numDigits) {
				 list2.negative = false;
			 } else {
				 DigitNode ptrFirst = first.front;
				 DigitNode ptrSecond = second.front;
				 
				 while (ptrFirst.next != null) {

					 if (ptrFirst.digit > ptrSecond.digit) {
						 list2.negative = true;
					 } else if (ptrFirst.digit <= ptrSecond.digit) {
						 list2.negative = false;
					 }
				 
					 ptrFirst = ptrFirst.next;
					 ptrSecond = ptrSecond.next;
				 }
				 
				 
				 
				 
				 
			 }
			

			list2 = list2.parse(list2.toString());
			return list2;
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
//		 
//		 
//		 
//		 	else if (first.negative == true && second.negative == false) {
//		 		// first number is negative, second number is positive
//		 		
//		 		DigitNode ptrNeg = first.front;
//		 		DigitNode ptrPos = second.front;
//		 		
////	            if (second.numDigits < first.numDigits) {
////	                ptr3 = second.front;
////	                ptr4 = first.front;
////	            }
//		 		
//	            
//	            
//	            BigInteger addedInt2 = new BigInteger();
//	            
//	            if (second.numDigits < first.numDigits) {
//	                ptrNeg = second.front;
//	                ptrPos = first.front;
//	            }
////	            if (first.numDigits > second.numDigits) {
////	            		addedInt2.negative = first.negative;
////	            } else if (first.numDigits < second.numDigits) {
////	            		addedInt2.negative = second.negative;
////	            } else {
////	            		DigitNode ptrTemp1 = first.front;
////	            		DigitNode ptrTemp2 = second.front;
////	            		while (ptrTemp1 != null && ptrTemp2 != null) {
////	            			ptrTemp1 = ptrTemp1.next;
////	            			ptrTemp2 = ptrTemp2.next;
////	            		}
////	            		if (Math.abs(ptrTemp1.digit) >= Math.abs(ptrTemp2.digit)) {
////	            			addedInt2.negative = first.negative;
////	            		} else {
////	            			addedInt2.negative = second.negative;
////	            		}
////	            }
//	            // sets the addedInt sign to the largest number
//	            
//	            int carry2 = 0;
//	            int addedDigit2;
//	            int smallDigit2;
//	            int bigDigit2;
//	            
//	            while (ptrPos != null || (ptrPos == null && carry2 != 0)) {
//		              
//	                if (ptrNeg == null) {
//	                    smallDigit2 = 0;
//	                } else {
////	                	if (carry2 == 1) 
////	                		ptrNeg.digit=ptrNeg.digit-1;
//	                    smallDigit2 = ptrNeg.digit;
//	                }
//
//	                if (ptrPos == null) {
//	                    bigDigit2 = 0;
//	                } else {
//	                	if (carry2 == 1)
//	                		ptrPos.digit = ptrPos.digit-1;
//	                    bigDigit2 = ptrPos.digit;
//	                }
//		 	
//	                addedDigit2 = bigDigit2 - smallDigit2 + carry2;
//		 	
//	                carry2 = 0;
//	                if (addedDigit2 < 0) {
//	                		addedDigit2 = Math.abs(addedDigit2);
//	                		carry2 = 1;
//	                		}
//	                
//	                
//	                if (addedInt2.numDigits == 0) {
//	                		
//	                		addedInt2.front = new DigitNode(addedDigit2, addedInt2.front);
//	                		
//	                } else {
//	                	DigitNode ptr = addedInt2.front;
//	                	while (ptr != null) {
//	                		ptr = ptr.next;
//	                	}
//	                	ptr.next = new DigitNode(addedDigit2, null);
//	                	addedInt2.numDigits++;
//	                }
//	                	if (ptrPos != null) {
//	                		ptrPos = ptrPos.next;
//	                	}
//	                	
//	                	if (ptrNeg != null) {
//	                		ptrNeg = ptrNeg.next;
//	                	}
//	            }
//	                	
//	            System.out.println("Adding result: ");
//	            System.out.println("Number of Digits: " + addedInt2.numDigits);
//	            for (DigitNode ptr5 = addedInt2.front; ptr5 != null; ptr5 = ptr5.next) {
//	                System.out.print(ptr5.digit + " - > ");
//	            }
//	            System.out.println();
//	            
//	            
//	            
//	            return addedInt2;
//	                	
//	                
//		 	} else {
//		 		return null;
//		 	}
	                
	                
	                
	               
		 	
	                
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 		
	         
//	            BigInteger thisInt = new BigInteger();
//	            DigitNode end = thisInt.front;
//	            for (DigitNode ptrThis = first.front; ptrThis != null; ptrThis = ptrThis.next) {
//	            
//	                if (thisInt.numDigits == 0) {
//	                  
//	                    end = new DigitNode(ptrThis.digit, end);
//	                } else {
//	                  
//	                    end.next = new DigitNode(ptrThis.digit, null);
//	                    end = end.next;
//	                }
//	                thisInt.numDigits++;
//	            }
//	            
//	            
//	            
//	            
////	            System.out.println("THIS IS: ");
////	            for (DigitNode ptrThis = thisInt.front; ptrThis != null; ptrThis = ptrThis.next) {
////	                System.out.print(ptrThis.digit + " -> ");
////	            }
////	            System.out.println();
//
//	            BigInteger otherInt = new BigInteger();
//	            for (DigitNode ptrOther = second.front; ptrOther != null; ptrOther = ptrOther.next) {
//	             
//	                if (otherInt.numDigits == 0) {
//	                  
//	                    otherInt.front = new DigitNode(ptrOther.digit, first.front);
//	                } else {
//	                
//	                    DigitNode ptr = otherInt.front;
//	                    while (ptr.next != null) {
//	                        ptr = ptr.next;
//	                    }
//	                    ptr.next = new DigitNode(ptrOther.digit, null);
//	                }
//	                otherInt.numDigits++;
//	            }
//
//	            DigitNode ptrPos = thisInt.front;
//	            DigitNode ptrNeg = otherInt.front;
//	            boolean posBigger = true;
//	            boolean thisIntIsPositive = true;
//
//	            if (first.negative == true) {
//	                ptrNeg = first.front;
//	                ptrPos = second.front;
//	                thisIntIsPositive = false;
//
//	                if (first.numDigits > second.numDigits) {
//	                    posBigger = false;
//	                } else if (first.numDigits < second.numDigits) {
//	                    posBigger = true;
//	                } else {
//	                    while(ptrNeg.digit == ptrPos.digit && ptrNeg != null) {
//	                        ptrNeg = ptrNeg.next;
//	                        ptrPos = ptrPos.next;
//	                    }
//	                    if (ptrNeg == null) {
//	                     
//	                        posBigger = true;
//	                    } else {
//	                        if (ptrNeg.digit > ptrPos.digit) {
//	                            posBigger = false;
//	                        } else {
//	                            posBigger = true;
//	                        }
//	                    }
//	                }
//
//	          
//	                ptrNeg = first.front;
//	                ptrPos = second.front;
//
//	            } else {
//	             
//	                if (first.numDigits > second.numDigits) {
//	                    posBigger = true;
//	                } else if (first.numDigits < second.numDigits) {
//	                    posBigger = false;
//	                } else {
//	                    while(ptrNeg.digit == ptrPos.digit && ptrNeg != null) {
//	                        ptrNeg = ptrNeg.next;
//	                        ptrPos = ptrPos.next;
//	                    }
//	                    if (ptrNeg == null) {
//	                     
//	                        posBigger = true;
//	                    } else {
//	                        if (ptrNeg.digit > ptrPos.digit) {
//	                            posBigger = false;
//	                        } else {
//	                            posBigger = true;
//	                        }
//	                    }
//	                }
//
//	             
//	                ptrPos = thisInt.front;
//	                ptrNeg = otherInt.front;
//	                thisIntIsPositive = true;
//	            }
//
//	         
//	            if (!posBigger) {
//	             
//	                DigitNode temp = ptrNeg;
//	                ptrNeg = ptrPos;
//	                ptrPos = temp;
//	                if (thisIntIsPositive) {
//	                    thisIntIsPositive = false;
//	                } else {
//	                    thisIntIsPositive = true;
//	                }
//	            } else {
//	              
//	            }
//
//	          
//	            BigInteger answer = new BigInteger();
//	            int bottomDigit = 0;
//	            int subtracted = 0;
//	            while (ptrPos != null) {
//	             
//	                if (ptrNeg == null) {
//	                    bottomDigit = 0;
//	                } else {
//	                    bottomDigit = ptrNeg.digit;
//	                }
//	                subtracted = ptrPos.digit - bottomDigit;
//	                if (subtracted < 0) {
//	                  
//	                    DigitNode ptrPosOriginal = ptrPos;
//	                    ptrPos = ptrPos.next;
//	                    while (ptrPos.digit == 0 && ptrPos != null) {
//	                        ptrPos.digit = 9;
//	                        ptrPos = ptrPos.next;
//	                    }
//	                    ptrPos.digit--;
//	                    subtracted = ptrPos.digit + 10 - bottomDigit;
//	                    ptrPos = ptrPosOriginal;
//	                }
//
//	              
//	                if (answer.numDigits == 0) {
//	                 
//	                    answer.front = new DigitNode(subtracted, answer.front);
//	                } else {
//	                
//	                    DigitNode ptr = answer.front;
//	                    while (ptr.next != null) {
//	                        ptr = ptr.next;
//	                    }
//	                    ptr.next = new DigitNode(subtracted, null);
//	                }
//	                answer.numDigits++;
//
//	                ptrPos = ptrPos.next;
//	                if (ptrNeg != null) {
//	                    ptrNeg = ptrNeg.next;
//	                }
//	            }
//
//	            if (!posBigger) {
//	              
//	                answer.negative = true;
//	            } else {
//	                answer.negative = false;
//	            }
//
//	            return answer;
	        }

		
		
		
		
		
		
		
		
	
	
	/**
	 * Returns the BigInteger obtained by multiplying the first big integer
	 * with the second big integer
	 * 
	 * This method DOES NOT MODIFY either of the input big integers
	 * 
	 * @param first First big integer
	 * @param second Second big integer
	 * @return A new BigInteger which is the product of the first and second big integers
	 */
	public static BigInteger multiply(BigInteger first, BigInteger second) {
		// following line is a placeholder - compiler needs a return
		// modify it according to need

			BigInteger resultList = new BigInteger();
			
	        //resultList = parse("0");
	        //resultList = resultList.parse(resultList.toString());
	        
	        DigitNode ptrFirst = first.front;
	        DigitNode ptrSecond = second.front;
	        
	        int x = 0;
	        int y = 0;

	        while (ptrFirst != null) {
	        	
	            BigInteger list1 = new BigInteger();

	            while (ptrSecond != null) {
	            
	                int z = (ptrFirst.digit * ptrSecond.digit) + y;
	                
	                if (z > 9) {
	                	
	                    y = z / 10;
	                    z = z % 10;
	                    
	                } else {
	                	
	                    y = 0;
	                    
	                }

	              
	                if (list1.numDigits == 0) {
	                 
	                    list1.front = new DigitNode(z, list1.front);
	                    list1.numDigits++;
	                } else {
	                  
	                    DigitNode ptr3 = list1.front;
	                   
	                    while (ptr3.next != null) {
	                        ptr3 = ptr3.next;
	                    }
	                    
	                    ptr3.next = new DigitNode(z, null);
	                    list1.numDigits++;
	                }
	                
	               // list1.numDigits++;

	                ptrSecond = ptrSecond.next;
	                
	            }


	        
	            int count = x;
	            
	            
	            
	            while (count > 0) {
	              
	                list1.front = new DigitNode(0, list1.front);
	                list1.numDigits++;
	                count--;
	            
	            }

	         
	            if (y > 0) {
	              
	                DigitNode ptr4 = list1.front;
	                
	                
	                while (ptr4.next != null) {
	                    ptr4 = ptr4.next;
	                }
	                
	                
	                ptr4.next = new DigitNode(y, null);
	                list1.numDigits++;
	            }

	            
	            
	            //list1 = BigInteger.parse(list1.toString());
	            //resultList = resultList.add(list1);
	            
	            resultList = resultList.add(resultList, list1);
	          
	            x++;
	            y = 0;
	            
	            ptrFirst = ptrFirst.next;
	            ptrSecond = second.front;
	        }
	        

	        if ((first.negative == false && second.negative == false) || (first.negative == true && second.negative == true)) {
	            resultList.negative = false;
	       
	        } else {
	            resultList.negative = true;
	        }
	        

	        resultList = resultList.parse(resultList.toString());

	        if (resultList.front.digit == 0 && resultList.negative == true) {
	        	resultList.negative = false;
	        }
	        return resultList;
	    }
		
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (front == null) {
			return "0";
		}
		String retval = front.digit + "";
		for (DigitNode curr = front.next; curr != null; curr = curr.next) {
				retval = curr.digit + retval;
		}
		
		if (negative) {
			retval = '-' + retval;
		}
		return retval;
	}
	
}	
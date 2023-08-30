// ---------------------------------------------------------
//          Y O U R   C O D E   H E R E
// ---------------------------------------------------------


// PRIME  - Check a 4-bit binary number is a prime
// ---------------------------------------------------------

module prime_detector(bin, prime);
  // Parameters definitions
  input		[3:0]	bin;	// Input  bin - 4 bit number
  output 	prime;			// Output prime indicator
  
  // Module implementation
  wire prime = (bin[0] & bin[1] & ~bin[3])|
  (bin[1] & ~bin[2] & ~bin[3]) |
  (bin[0] & ~bin[1] & bin[2]) |
  (bin[0] & bin[1] & ~bin[2]);
  
endmodule
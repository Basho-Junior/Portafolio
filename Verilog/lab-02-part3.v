// ---------------------------------------------------------
//          Y O U R   C O D E   H E R E
// ---------------------------------------------------------


// BIN_TO_SEGMENT  - Convert 4-bit binary number to 
//					 seven segment vector {g,f,e,d,c,b,a}
// ---------------------------------------------------------

module bin_to_segments(bin, segments);
  // Parameters definitions
  input		[3:0]	bin;		// Input  bin - 4 bit number
  output 	[6:0]	segments;	// Output segments - 7 bit vector
  
  // Module implementation
  assign segments = (bin ==  0) ? 7'b011_1111 : 
    				(bin ==  1) ? 7'b000_0110 : 
    				(bin ==  2) ? 7'b101_1011 : 
    				(bin ==  3) ? 7'b100_1111 : 
    				(bin ==  4) ? 7'b110_0110 : 
    				(bin ==  5) ? 7'b110_1101 : 
    				(bin ==  6) ? 7'b111_1101 : 
    				(bin ==  7) ? 7'b000_0111 : 
    				(bin ==  8) ? 7'b111_1111 : 
    				(bin ==  9) ? 7'b110_1111 : 
    				(bin == 10) ? 7'b111_0111 :
    				(bin == 11) ? 7'b111_1100 :
    				(bin == 12) ? 7'b011_1001 :
    				(bin == 13) ? 7'b101_1110 :
    				(bin == 14) ? 7'b111_1001 :
    				(bin == 15) ? 7'b111_0001 :
    				7'bxxx_xxxx;
endmodule     
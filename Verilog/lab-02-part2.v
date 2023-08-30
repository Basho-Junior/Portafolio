// Code your design here

module add3_cond(a, s);
  input  [3:0]	a;  	// 4 bit input
  output [3:0]	s;		// 4 bit output
  
  // Module implementation
  assign s = (a >= 5) ? a + 3 : 
            a;
  
endmodule


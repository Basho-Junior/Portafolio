
// ----------------------------------------------------------
//           D O   N O T   T O U C H
// ----------------------------------------------------------

module half_adder(a, b, s, cout);
  // Parameters definitions
  input	    a;		// Input A
  input 	b;		// Input B
  output	s;		// Output Sum
  output    cout;	// Output Cout

  // Module implementation
  xor G1(s, a, b);
  and G2(cout, a, b);
  
endmodule



// ---------------------------------------------------------
//          Y O U R   C O D E   H E R E
// ---------------------------------------------------------


// FULL ADDER - Hierarchical
// ---------------------------------------------------------

module full_adder_v2(a, b, cin, s, cout);
  // Parameters definitions
  input		a;		// Input A
  input 	b;		// Input B
  input		cin;	// Input Cin
  output	s;		// Output Sum
  output  	cout;	// Output Cout

  //Wires
  wire n1, n2, n3;
  
  // Module implementation
  half_adder U0 (a, b, n1, n2);
  half_adder U1 (cin, n1, n3, s);
  or U3 (cout, n3, n2); 
  
endmodule

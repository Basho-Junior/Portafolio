// ---------------------------------------------------------
//          Y O U R   C O D E   H E R E
// ---------------------------------------------------------


// Full Adder - Schematic
// ---------------------------------------------------------

module full_adder_v1(a, b, cin, s, cout);
  // Parameters definitions
  input		a;		// Input A
  input 	b;		// Input B
  input		cin;	// Input Cin
  output	s;		// Output Sum
  output  	cout;	// Output Cout

  //Wires
  wire O1,O2,O3;
  wire XA,And,Bnd;
  
  // Module implementation
  xor xor1 (XA,a,b);
  xor xor2 (s,XA,cin);
  and and1 (And,XA,cin);
  and and2 (Bnd,a,b);
  or or1 (cout,And,Bnd);
  	
endmodule
// SYSTEM1 - System #1 (Logic Gates)
// -------------------------------------------------------

module system1(a, b, c, x);
  	// Parameters definitions
  	input	a;		// Input A
  	input 	b;		// Input B
  	input	c;		// Input C
	output	x;		// Output X

	//Wires
  	wire An, Bnd, Cnd;
  
    // Module implementation
  	not not1 (An, a);
    and and1 (Bnd, b, An);
    and and2 (Cnd, c, a);
    or or1 (x, An, Bnd, Cnd);
 
endmodule
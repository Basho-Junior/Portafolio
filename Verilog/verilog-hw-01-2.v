// SYSTEM2 - System #2 (Logic Gates)
// -------------------------------------------------------
module system2(a, b, f);
  	// Parameters definitions
  	input	a;		// Input A
  	input 	b;		// Input B
	output	f;		// Output F

	//Wires
  	wire An, Bn, And, Bnd;
  
    // Module implementation
  	not not1 (An, a);
    not not2 (Bn, b);
    and and1 (And, a, Bn);
    and and2 (Bnd, An, b);
    or or1 (f, And, Bnd);

endmodule
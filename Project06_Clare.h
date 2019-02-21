#ifndef Rational_H
#define Rational_H

class Rational {
	//CS255C Project06 Clare 2/20/2019
	//The .h file of Rational class
public:
	int nume;//numerator
	int deno;//denominator
	int g=1;//greatest common divisor, to avoid ZeroDivisionError, initialize it with 1.
	int newNume, newDeno;//variables which use in methods to change the value of nume and deno

public:
	Rational(int=0, int=0);//constructor
	void setRational(int, int);//setter
	int gcd(int, int );//gcd function
	void add(Rational);//add 
	void sub(Rational);//subtract
	void mul(Rational);//multipy
	void div(Rational);//divide
	void print();//print
	void rec();//reciprocal
	void neg();//negate
	
};

#endif

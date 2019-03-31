#pragma once
#ifndef Rational_H
#define Rational_H

class Rational {
	//CS255C Project08 Clare 3/5/2019
	//The .h file of Rational class
	//Addition to project06: bool overloaded operators ==,<,>,<=,>=,!= (compare two rational numbers), binary overloaded operators +,-,*,/, unary overloaded operators -,!
public:
	int nume;//numerator
	int deno;//denominator
	int g = 1;//greatest common divisor, to avoid ZeroDivisionError, initialize it with 1.
	int newNume, newDeno;//variables which use in methods to change the value of nume and deno

public:
	Rational(int = 0, int = 0);//constructor
	void setRational(int, int);//setter
	int gcd(int, int);//gcd function
	Rational operator +(Rational);//add 
	Rational operator -(Rational);//subtract
	Rational operator *(Rational);//multipy
	Rational operator /(Rational);//divide
	Rational operator !();//reciprocal
	Rational operator -();//negate
	bool operator ==(Rational);//equal to
	bool operator >(Rational);//greater than
	bool operator <(Rational);//less than
	bool operator >=(Rational);//greater or equal to
	bool operator <=(Rational);//less or equal to
	bool operator !=(Rational);//not equal
	void print();//print
}; 

#endif

#include "Project08_Clare.h"
#include<stdexcept>
#include<iostream>
#include<string>
//CS255C Project08 Clare 3/5/2019
//The Rational class and the details of its methods.
//These methods include adding, subtracting, multipying, dividing between two rational numbers, and get their negation and reciprocal.
//The Rational objects are stored as fraction in the lowest terms (ex. 3/5 but not 9/15) all the time.
//Addition to project06: bool overloaded operators ==,<,>,<=,>=,!= (compare two rational numbers) , binary overloaded operators +,-,*,/, unary overloaded operators -,!
using namespace std;
Rational::Rational(int n, int d) {
	setRational(n, d);
	
}//constructor
void Rational::setRational(int n, int d) {
	if (gcd(n, d) != 0) {
		g = gcd(n, d);
	}
	nume = n / g;
	deno = d / g;
	if (deno < 0) {
		deno *= -1;
		nume *= -1;
	}//MAKE SURE THE NEGATIVE SIGN ONLY IN NUMERATOR
}//setter


int Rational::gcd(int a, int b) {
	if (b == 0) return a;
	return gcd(b, a%b);
}//gcd function

Rational Rational::operator +(Rational a) {
	Rational r;
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.deno + a.nume*this->deno);
	r.setRational(newNume, newDeno);
	return r;
}//(a/b + c/d =(ad+bc)/bd)
Rational Rational::operator -(Rational a) {
	Rational r;
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.deno - a.nume*this->deno);//only change the "+" to "-" from add()
	r.setRational(newNume, newDeno);
	return r;
}//(a/b - c/d =(ad-bc)/bd)
Rational Rational::operator *(Rational a) {
	Rational r;
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.nume);
	r.setRational(newNume, newDeno);
	return r;
}//(a/b * c/d = ac/bd)
Rational Rational::operator /(Rational a) {
	Rational r;
	a = a.operator!();//switch nume and deno,revised 3/25/19
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.nume);
	r.setRational(newNume, newDeno);
	return r;
	//then do the same thing as mul()
}//(a/b / c/d = ad/bc)
Rational Rational::operator !() {
	Rational r;
	newNume = this->deno;
	newDeno = this->nume;
	if (newDeno < 0) {
		newDeno *= -1;
		newNume *= -1;
	}
	r.setRational(newNume, newDeno);
	return r;//keep negative sign on numerator
}//reciprocal of a/b is b/a 
Rational Rational::operator -() {
	Rational r;
	newNume=this->nume * -1;
	r.setRational(newNume, this->deno);
	return r;
}//negation of a/b is -a/b
bool Rational::operator ==(Rational a) {
	Rational r = this->operator-(a);
	if (this->nume*a.deno - a.nume*this->deno ==0) {
		return true;
	}
	return false;
}//equal
bool Rational::operator >(Rational a) {
	Rational r = this->operator-(a);
	if (this->nume*a.deno - a.nume*this->deno > 0) {
		return true;
	}
	return false;
}//greater than
bool Rational::operator <(Rational a) {
	Rational r = this->operator-(a);
	if (r.nume < 0) {
		return true;
	}
	return false;
}//less than
bool Rational::operator >=(Rational a) {
	Rational r = this->operator-(a);
	if (r.nume > 0|| r.nume==0) {
		return true;
	}
	return false;
}//greater than or equal to
bool Rational::operator <=(Rational a) {
	Rational r = this->operator-(a);
	if (r.nume < 0|| r.nume ==0) {
		return true;
	}
	return false;
}//less than or equal to
bool Rational::operator !=(Rational a) {
	Rational r = this->operator-(a);
	if (r.nume != 0) {
		return true;
	}
	return false;
}//not equal

void Rational::print() {
	cout << nume << "/" << deno;
}

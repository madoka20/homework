#include "Project06_Clare.h"
#include<stdexcept>
#include<iostream>
#include<string>
	//CS255C Project06 Clare 2/20/2019
	//The Rational class and the details of its methods.
	//These methods include adding, subtracting, multipying, dividing between two rational numbers, and get their negation and reciprocal.
	//The Rational objects are stored as fraction in the lowest terms (ex. 3/5 but not 9/15) all the time.
using namespace std;
Rational::Rational(int n, int d) {
	setRational(n, d);
}//constructor
void Rational::setRational(int n, int d) {
	if (gcd(n, d)!= 0) {
		g = gcd(n, d);
	}
	nume = n / g;
	deno = d / g;
}//setter
	

int Rational::gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}//gcd function

void Rational::add(Rational a){
		
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.deno + a.nume*this->deno);
	this->setRational(newNume, newDeno);
}//(a/b + c/d =(ad+bc)/bd)
void Rational::sub(Rational a) {
	
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.deno - a.nume*this->deno);//only change the "+" to "-" from add()
	this->setRational(newNume, newDeno);
}//(a/b - c/d =(ad-bc)/bd)
void Rational::mul(Rational a) {
	
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.nume);
	this->setRational(newNume, newDeno);
}//(a/b * c/d = ac/bd)
void Rational::div(Rational a) {
	int temp;
	temp = a.nume;
	a.nume = a.deno;
	a.deno = temp;//switch nume and deno
	newDeno = (this->deno*a.deno);
	newNume = (this->nume*a.nume);
	this->setRational(newNume, newDeno);//then do the same thing as mul()
}//(a/b / c/d = ad/bc)
void Rational::rec() {
	int temp;
	temp = this->nume;
	this->nume = this->deno;
	this->deno = temp;//switch nume and deno
	if (this->deno < 0) {
		this->deno *= -1;
		this->nume *= -1;
	}//keep negative sign on numerator
}//reciprocal of a/b is b/a 
void Rational::neg() {
	this->nume *= -1;
}//negation of a/b is -a/b
void Rational::print() {
	cout << nume << "/" << deno;
}

int main() {
	//Test 
	int n1,n2,d1,d2;
	Rational r1, r2,rTemp;//rTemp for returning the value 
	L1:cout << "Enter a rational number separating the numerator and denominator with a space: " << endl;//get first rational number from user
	cin >> n1;
	cin >> d1;
	cout << "Enter another rational number: " << endl;//get the second
	cin >> n2;
	cin >> d2;
	r1.setRational(n1, d1);
	r2.setRational(n2, d2);//make these numbers as Rational object
	float r1f = (r1.nume*1.0) / r1.deno;
	float r2f = (r2.nume*1.0) / r2.deno;//convert them to float
	//add
	r1.print();
	cout << "+";
	r2.print();
	cout << "=";
	rTemp = r1;
	r1.add(r2);
	r1.print();
	r1 = rTemp;
	cout << "" << endl;
	cout << r1f;
	cout << "+";
	cout << r2f;
	cout << "=";
	cout << r1f + r2f;
	cout << "" << endl;
	//subtract
	r1.print();
	cout << "-";
	r2.print();
	cout << "=";
	rTemp = r1;
	r1.sub(r2);
	r1.print();
	r1 = rTemp;
	cout << "" << endl;
	cout << r1f;
	cout << "-";
	cout << r2f;
	cout << "=";
	cout << r1f - r2f;
	cout << "" << endl;
	//multipy
	r1.print();
	cout << "*";
	r2.print();
	cout << "=";
	rTemp = r1;
	r1.mul(r2);
	r1.print();
	r1 = rTemp;
	cout << "" << endl;
	cout << r1f;
	cout << "*";
	cout << r2f;
	cout << "=";
	cout << r1f * r2f;
	cout << "" << endl;
	//divide
	r1.print();
	cout << "/";
	r2.print();
	cout << "=";
	rTemp = r1;
	r1.div(r2);
	r1.print();
	r1 = rTemp;
	cout << "" << endl;
	cout << r1f;
	cout << "/";
	cout << r2f;
	cout << "=";
	cout << r1f / r2f;
	cout << "" << endl;
	//reciprocal
	r1.rec();
	cout << "The reciprocal of the first number is: ";
	r1.print();
	cout << "" << endl;
	//negate
	r2.neg();
	cout << "The negation of the second number is: ";
	r2.print();
	cout << "" << endl;
	
	char yn;
	cout << "Would you like to enter new rational numbers? (y/n)" << endl;
	cin >> yn;
	if (yn == 'y') {
		goto L1;
	}//ask if the user wants to enter the number again

	
	system("pause");
}
/*
Sample interaction:
Enter a rational number separating the numerator and denominator with a space :
216 64
Enter another rational number :
74 222
27 / 8 + 1 / 3 = 89 / 24
3.375 + 0.333333 = 3.70833
27 / 8 - 1 / 3 = 73 / 24
3.375 - 0.333333 = 3.04167
27 / 8 * 1 / 3 = 9 / 8
3.375*0.333333 = 1.125
27 / 8 / 1 / 3 = 81 / 8
3.375 / 0.333333 = 10.125
The reciprocal of the first number is : 8 / 27
The negation of the second number is : -1 / 3
Would you like to enter new rational numbers ? (y / n)
y
Enter a rational number separating the numerator and denominator with a space :
1444 3800
Enter another rational number :
2019 4038
19 / 50 + 1 / 2 = 22 / 25
0.38 + 0.5 = 0.88
19 / 50 - 1 / 2 = -3 / 25
0.38 - 0.5 = -0.12
19 / 50 * 1 / 2 = 19 / 100
0.38*0.5 = 0.19
19 / 50 / 1 / 2 = 19 / 25
0.38 / 0.5 = 0.76
The reciprocal of the first number is : 50 / 19
The negation of the second number is : -1 / 2
Would you like to enter new rational numbers ? (y / n)
y
Enter a rational number separating the numerator and denominator with a space :
135 246
Enter another rational number :
111 1111
45 / 82 + 111 / 1111 = 59097 / 91102
0.548781 + 0.09991 = 0.64869
45 / 82 - 111 / 1111 = 40893 / 91102
0.548781 - 0.09991 = 0.448871
45 / 82 * 111 / 1111 = 4995 / 91102
0.548781*0.09991 = 0.0548287
45 / 82 / 111 / 1111 = 16665 / 3034
0.548781 / 0.09991 = 5.49275
The reciprocal of the first number is : 82 / 45
The negation of the second number is : -111 / 1111
Would you like to enter new rational numbers ? (y / n)
n
Press any key to continue . . .
*/



#include<iostream>
#include "Project11_Clare.h"
#include "ZeroDenoError.h"
using namespace std;
int main() {
	//test 
L1:Rational r1, r2;
	int n1, d1, n2, d2;

	cout << "Enter the numerator of a: " << endl;//get first rational number from user
	cin >> n1;
	cout << "Enter the denominator of a: " << endl;
	L2:cin >> d1;
	
	try {
			r1.setRational(n1, d1);
		}
	catch (ZeroDenoError&zeroDenoError) {
		cout << zeroDenoError.what() << "Please enter again: "<<endl;
		goto L2;
	}//catch exception

	cout << "a is: ";
	r1.print();
	cout << endl;

	cout << "Enter the numerator of the b: " << endl;
	cin >> n2;
	cout << "Enter the denominator of the b: " << endl;
	L3:cin >> d2;
	try {
		r2.setRational(n2, d2);
	}
	catch (ZeroDenoError&zeroDenoError) {
		cout << zeroDenoError.what() << "Please enter again: " << endl;
		goto L3;
	}//catch exception

	cout << "b is: ";
	r2.print();
	cout << endl;

	
	cout << "a+b is: ";
	Rational r3;
	r3 = r1 + r2;
	r3.print();
	cout << " or ";
	double f3 = 0.0;
	f3 = (r3.nume*1.0) / r3.deno;
	cout << f3 << endl;

	cout << "a-b is: ";
	Rational r4;
	r4 = r1 - r2;
	r4.print();
	cout << " or ";
	double f4 = 0.0;
	f4 = (r4.nume*1.0) / r4.deno;
	cout << f4 << endl;


	cout << "a*b is: ";
	Rational r5;
	r5 = r1 * r2;
	r5.print();
	cout << " or ";
	double f5 = 0.0;
	f5 = (r5.nume*1.0) / r5.deno;
	cout << f5 << endl;

	

	cout << "a/b is: ";
	Rational r6;
	r6 = r1 / r2;
	if (!r2.nume == 0) {
		r6.print();
		cout << " or ";
		double f6 = 0.0;
		f6 = (r6.nume*1.0) / r6.deno;
		cout << f6 << endl;
	}

	Rational r9;
	cout << "(a+b)/(a-b) is: ";
	r9 = (r1 + r2) / (r1 - r2);
	if(!(r1-r2==0))
	r9.print();
	cout << endl;

	if (r1 > r2) {
		r1.print();
		cout << " is greater than ";
		r2.print();
		cout << endl;
	}
	if (r1 < r2) {
		r1.print();
		cout << " is smaller than ";
		r2.print();
		cout << endl;
	}
	if (r1 >= r2) {
		r1.print();
		cout << " is greater or equal to ";
		r2.print();
		cout << endl;
	}
	if (r1 <= r2) {
		r1.print();
		cout << " is smaller or equal to ";
		r2.print();
		cout << endl;
	}
	if (r1 == r2) {
		r1.print();
		cout << " is equal to ";
		r2.print();
		cout << endl;
	}
	if (r1 != r2) {
		r1.print();
		cout << " is not equal to ";
		r2.print();
		cout << endl;
	}

	
	cout << "a negated is ";
	Rational r7;
	r7 = -r1;
	r7.print();
	cout << endl;

	cout << "The reciprocal of b is:";
	Rational r8;
	r8 = !r2;
	if (!r8.deno == 0) {
		r8.print();
	}
	cout << endl;

	char yn;
	cout << "Would you like to enter new rational numbers? (y/n)" << endl;
	cin >> yn;
	if (yn == 'y') {
		goto L1;
	}//ask if the user wants to enter the number again
	system("pause");
}
/*Sample interaction

Enter the numerator of a:
0
Enter the denominator of a:
0
Denominator can not be zero. Please enter again:
1
a is: 0
Enter the numerator of the b:
0
Enter the denominator of the b:
0
Denominator can not be zero. Please enter again:
2
b is: 0
a+b is: 0 or 0
a-b is: 0 or 0
a*b is: 0 or 0
a/b is: Division results in denominator of 0.
(a+b)/(a-b) is: Division results in denominator of 0.

0 is greater or equal to 0
0 is smaller or equal to 0
0 is equal to 0
a negated is 0
The reciprocal of b is:Operation results in denominator of 0.

Would you like to enter new rational numbers? (y/n)
n
*/
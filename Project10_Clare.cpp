#include<iostream>
#include<iomanip>
using namespace std;
//CS255C program10 Clare(Mingyang Fu) 3/27/19
//A list of problems about iostream
int main() {
	cout << "(1)Print integer 4444 left justified in a 13 digit field, surrounded by /" << endl;
	int x = 4444;
	cout <<"/"<<left<< setw(13) << x <<"/"<< endl;

	cout << "(2)Interactively input a 15 character string into a 10 character array 'state' and then print 'state'" << endl;
	char state[10];
	cout << "Enter a sentence: " << endl;
	cin.get(state, 10);
	cout.write(state,10);
	cout << endl;
	cin.ignore(255,'\n');//clear the buffer

	cout << "(3)Print a variable containing 200 with and without sign on the same line" << endl;
	int a = 200;
	cout << internal << showpos << a<<" "<<noshowpos<<a<<endl;

	cout << "(4)Print the decimal value 255 in hexadecimal form preceded by 0x" << endl;
	int b = 255;
	cout <<showbase<< hex << b << endl;

	cout<<"(5)Interactively input characters until the character '.' is encountered into array'charArray' of up to 10 characters"<<endl;
	cout << "Enter a sentence: " << endl;
	char charArray[10];
	cin.get(charArray, 10, '.');
	cout.write(charArray, cin.gcount());
	cout << endl;

	cout << "(6)Print 1.235 in a 9 digit field with 2 decimal places and with leading zeroes" << endl;
	cout << right<<setw(9)<<setfill('0')<<setprecision(3) << 1.235 << endl;
	system("pause");

}
/*Sample interaction
(1)Print integer 4444 left justified in a 13 digit field, surrounded by /
/4444         /
(2)Interactively input a 15 character string into a 10 character array 'state' and then print 'state'
Enter a sentence:
this is a c++ program.
this is a
(3)Print a variable containing 200 with and without sign on the same line
+200 200
(4)Print the decimal value 255 in hexadecimal form preceded by 0x
0xff
(5)Interactively input characters until the character '.' is encountered into array'charArray' of up to 10 characters
Enter a sentence:
java.lang.String
java
(6)Print 1.235 in a 9 digit field with 2 decimal places and with leading zeroes
000001.24

*/
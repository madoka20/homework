#include<iostream>
using namespace std;
/*
CS255C Project 05 Pointer 
Author:Clare Date:2/12/19
*/
int main() {
	unsigned int values[] = { 2,4,6,8,10 };
	const int SIZE = 5;//step a

	unsigned int *vPtr;//step b

	cout << "Initiation Array Declaration" << endl;
	for (int i = 0; i < SIZE; i++) {
		cout << values[i] << endl;
	}//step c 

	vPtr = values;//step d

	cout << "Pointer / offset Notation using pointer name" << endl;
	for (int j = 0; j < SIZE; j++) {
		cout << *(vPtr+j) << endl;
	}//step e 

	cout << "Pointer / offset Notation using array name" << endl;
	for (int k = 0; k < SIZE; k++) {
		cout << *(values + k) << endl;
	}//step f

	cout << "Display array with subscripting the pointer" << endl;
	for (int m = 0; m < SIZE; m++) {
		cout << vPtr[m] << endl;
	}//step g

	cout << "Array Subcript: "<<values[4] << endl;
	cout << "Pointer Notation with Array name: "<<*(values + 4) << endl;
	cout << "Pointer Subscript Notation: "<<vPtr[4] << endl;
	cout << "Pointer Notation: "<<*(vPtr + 4) << endl;//step h

	cout <<"Address referenced by vPtr+3: "<< vPtr + 3 << endl;
	cout << *(vPtr + 3) << " is found at " << vPtr + 3 << endl;//step i

	vPtr = &values[4];
	vPtr -= 4;
	cout << "Address referenced by vPtr-=4: " << vPtr << endl;
	cout << *vPtr << " is found at " << vPtr << endl;//step j

	system("pause");
}
/*
Sample interaction:

Initiation Array Declaration
2
4
6
8
10
Pointer / offset Notation using pointer name
2
4
6
8
10
Pointer / offset Notation using array name
2
4
6
8
10
Display array with subscripting the pointer
2
4
6
8
10
Array Subcript: 10
Pointer Notation with Array name: 10
Pointer Subscript Notation: 10
Pointer Notation: 10
Address referenced by vPtr+3: 006FF988
8 is found at 006FF988
Address referenced by vPtr-=4: 006FF97C
2 is found at 006FF97C
*/

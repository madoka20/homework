#ifndef IntegerSet_H
#define IntegerSet_H
#include<vector>
//CS255C Project07 
//Author:  Clare (Mingyang) 
//Date: 2/28/2019
//The head file of IntegerSet class.
using namespace std;
class IntegerSet {

public:
	vector <bool> intset;
	
public:
	IntegerSet();
	void insertElement(int);
	void deleteElement(int);
	void printSet();
	IntegerSet intersect(IntegerSet);
	IntegerSet unionize(IntegerSet);
	IntegerSet complement();
	IntegerSet difference(IntegerSet);
	bool subset(IntegerSet);
	bool isEmpty();
	bool isEqualTo(IntegerSet);
	

	};
#endif
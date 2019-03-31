#include "Project07_Clare.h"
#include<iostream>

using namespace std;
//CS255C Project07 
//Author:  Clare (Mingyang) 
//Date: 2/28/2019
//The IntegerSet class. The range of the integer is 0 to 100(inclusive)
//Using a bool vector to represet if the integer is in the set.
//We can insert or delete elements from the set, print the set, find the intersection, union, and difference of two sets.
//We can also find the implement of one set, judge if one set is the subset of another set, judge if they're equal and judge if one set is empty.
IntegerSet::IntegerSet() {
	intset.resize(101);
	fill(intset.begin(), intset.end(), false);
}

void IntegerSet::insertElement(int i) {
	intset[i] = true;
}//set the element true to add it

void IntegerSet::deleteElement(int i) {
	intset[i] = false;
}//set the element false to delete it

void IntegerSet::printSet() {
	cout << "{ ";
	for (int i = 0; i < 101; i++) {
		if (this->intset[i] == true) {
			cout << i <<" ";
		}
	}
	cout << "}";
}//print the set from beginning to the end

IntegerSet IntegerSet::intersect(IntegerSet set) {
	IntegerSet newSet;
	for (int i = 0; i < 101; i++) {
		newSet.intset[i] = (this->intset[i] && set.intset[i]);
	}
	return newSet;
}//if the elements are exist(true) in both of the two sets, store them in a new set and return.

IntegerSet IntegerSet::unionize(IntegerSet set) {
	IntegerSet newSet;
	for (int i = 0; i < 101; i++) {
		newSet.intset[i] = (this->intset[i] || set.intset[i]);
	}
	return newSet;
}//if the elements are exist(true) in any of the two sets, store them in a new set and return.

IntegerSet IntegerSet::complement() {
	IntegerSet newSet;
	for (int i = 0; i < 101; i++) {
		newSet.intset[i] = (!this->intset[i]);
	}
	return newSet;
}// if the element are not exist in the set, store them in a new set and return.

IntegerSet IntegerSet::difference(IntegerSet set) {
	IntegerSet newSet;
	newSet = this->intersect(set.complement());
	return newSet;
}//return the difference of two sets. (A-B)

bool IntegerSet::subset(IntegerSet set) {
	for (int i = 0; i < 101; i++) {
		if (this->intset[i] == true) {
			if (set.intset[i] == false) {
				return false;
			}
		}
	}
	return true;
}//judge if one set is the subset of another set.

bool IntegerSet::isEmpty() {
	for (int i = 0; i < 101; i++) {
		if (this->intset[i] == true) {
			return false;
		}
	}
	return true;
}//judge if one set is empty

bool IntegerSet::isEqualTo(IntegerSet set) {
	for (int i = 0; i < 101; i++) {
		if (this->intset[i] != set.intset[i]) {
			return false;
		}
	}
	return true;
}//judge if two sets are equal

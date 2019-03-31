#pragma once
#include<stdexcept>
//Project11 Clare 3/30/19 
//the exception
using namespace std;
class ZeroDenoError: public runtime_error {
public:
	ZeroDenoError() :runtime_error("Denominator can not be zero. ") {}

};
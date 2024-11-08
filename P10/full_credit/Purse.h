#ifndef PURSE_H
#define PURSE_H

#include <iostream>
#include <compare>

class Purse{
    private:
    int_pounds;
    int _shillings;
    int _pence;

    void rationalize();


public: 

    Purse(int pounds=0, int shillings=0, int pence=0);//populating with default values

    friend std::ostream& operator <<(std::ostream& os, const Purse& purse);//friend operattor to dtream out the value of Purse Object

    auto operator <=> (const Purse& purse) const=default;

    Purse& operator++(); //pre-increment, returns a ref to the current object
    Purse operator++(int); //post-increment, returns a copy of the orginal Purse object

    




}


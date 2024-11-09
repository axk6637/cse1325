#ifndef PURSE_H
#define PURSE_H

#include <iostream> 



class Purse{
    protected:
    int _pounds;
    int _shillings;
    int _pence;

    void rationalize();


public: 

    Purse(int pounds=0, int shillings=0, int pence=0);//populating with default values

    friend std::ostream& operator <<(std::ostream& os, const Purse& purse);//friend operattor to dtream out the value of Purse Object

    bool operator==(const Purse& purse) const;
    bool operator!=(const Purse& purse) const;
    bool operator<(const Purse& purse) const;
    bool operator<=(const Purse& purse) const;
    bool operator>(const Purse& purse) const;
    bool operator>=(const Purse& purse) const;

    Purse& operator++(); //pre-increment, returns a ref to the current object
    Purse operator++(int); //post-increment, returns a copy of the orginal Purse object

    //Arithmetic Operators
    Purse operator+(const Purse& purse) const;
    Purse operator-(const Purse& purse) const;

    //Compound airthmetic operatos
    Purse& operator+=(const Purse& purse);
    Purse& operator-=(const Purse& purse);

};

#endif 



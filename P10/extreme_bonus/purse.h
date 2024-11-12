#ifndef PURSE_H
#define PURSE_H

#include <iostream> 

class Purse{
private:
    int _pounds;
    int _shillings;
    int _pence;

    void rationalize();


public: 

    Purse(int pounds=0, int shillings=0, int pence=0);

    friend std::ostream& operator <<(std::ostream& ost, const Purse& purse);
    friend std::istream& operator >>(std::istream& ist, Purse& purse);
    

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



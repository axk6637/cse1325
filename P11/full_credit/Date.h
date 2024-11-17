#ifndef DATE_H
#define DATE_H

#include <iostream>

class Date{
    private:
    int _year, _month, _day;

    public:
    Date(int year= 1970, int month=1, int day=1);

    bool operator==(const Date& date) const;
    bool operator!=(const Date& date) const;
    bool operator<=(const Date& date) const;
    bool operator>=(const Date& date) const;
    bool operator>(const Date& date) const;
    bool operator<(const Date& date) const;

    friend std::ostream& operator <<(std::ostream& ost, const Date& date);

    
};
#endif
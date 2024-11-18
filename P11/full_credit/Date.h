#ifndef DATE_H
#define DATE_H

#include <iostream>

class Date{
    private:
    int _year, _month, _day;
    int compare(const Date& rhs) const;

    public:
    Date(int year= 1970, int month=1, int day=1);

    inline bool operator==(const Date& rhs) const { return compare(rhs) == 0; }
    inline bool operator!=(const Date& rhs) const { return compare(rhs) != 0; }
    inline bool operator<(const Date& rhs) const { return compare(rhs) < 0; }
    inline bool operator<=(const Date& rhs) const { return compare(rhs) <= 0; }
    inline bool operator>(const Date& rhs) const { return compare(rhs) > 0; }
    inline bool operator>=(const Date& rhs) const { return compare(rhs) >= 0; }


    friend std::ostream& operator <<(std::ostream& ost, const Date& date);

    
};
#endif
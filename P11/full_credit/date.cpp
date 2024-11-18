#include <iostream>
#include "date.h"
#include <iomanip>

Date::Date (int year, int month, int day)
    :_year{year}, _month{month}, _day{day}{}

int Date::compare(const Date& rhs) const {
    if (_year != rhs._year) return _year - rhs._year;
    if (_month != rhs._month) return _month - rhs._month;
    return _day - rhs._day;
}

std::ostream& operator<<(std::ostream& ost, const Date& date){
    char old_fill= ost.fill();
    
    ost <<std::setfill('0') << std::setw(4) << date._year << '/'
        <<std::setw(2) <<date._month <<'/'
        <<std::setw(2) <<date._day;

        ost.fill(old_fill);
    return ost;
}


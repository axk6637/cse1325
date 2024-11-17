#include <iostream>
#include "date.h"
#include <iomanip>

Date::Date (int year, int month, int day)
    :_year{year}, _month{month}, _day{day}{}

bool Date::operator==(const Date& date)const {
    return _year== date._year && _month==date._month &&_day==date._day;

}   

bool Date::operator!=(const Date& date) const {
    return !(*this == date);
}


bool Date::operator<(const Date& date)const {
    if(_year!=date._year) return _year < date._year;
    if(_month!=date._month) return _month < date._month;
    return _day< date._day;

} 

bool Date::operator > (const Date& date)const{
    if (_year != date._year) return _year >date._year;
    if(_month!=date._month) return _month>date._month;
    return _day>date._day;
}

bool Date::operator>=(const Date& date) const {
    return *this > date || *this == date;
}

bool Date::operator<=(const Date& date) const {
    return *this < date || *this == date;
}

std::ostream& operator<<(std::ostream& ost, const Date& date){
    
    ost <<std::setfill('0') << std::setw(4) << date._year << '/'
        <<std::setw(2) <<date._month <<'/'
        <<std::setw(2) <<date._day;
    return ost;
}


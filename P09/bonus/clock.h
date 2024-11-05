#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <stdexcept>
#include <iomanip>
class Clock {
protected:
    int _hours;
    int _minutes;
    int _seconds;

public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock() {} 

    virtual void tic();
    void print() const;
};

#endif // CLOCK_H
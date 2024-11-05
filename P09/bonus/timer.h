#ifndef TIMER_H
#define TIMER_H

#include "clock.h"
#include <stdexcept>

class Timer : public Clock {
public:
    Timer(int hours, int minutes, int seconds);
    virtual ~Timer() {} // Empty virtual destructor

    void tic() override; // Override the tic method
};

#endif 

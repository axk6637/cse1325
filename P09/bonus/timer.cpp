#include "timer.h"
#include "clock.h"
#include <iostream>

Timer::Timer(int hours, int minutes, int seconds) : Clock(hours, minutes, seconds) {
   
}

void Timer::tic() {

    
    // Decrement _seconds
    --_seconds; 
    if (_seconds == -1) {
        _seconds = 59;
        _minutes--;
        if (_minutes == -1) {
            _minutes = 59;
            _hours--;
         --_seconds;    
        }
    }
    if (_hours == 0 && _minutes == 0 && _seconds == 0) {
        throw std::runtime_error("Timer expired");
    }
}
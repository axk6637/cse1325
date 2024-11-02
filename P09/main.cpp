#include <iostream>
#include <stdexcept>
#include "clock.h"

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Clock clock(hours, minutes, seconds);
        std::string input;

        //prompt to the user
        std::cout << "Enter 'q' to quit or press Enter to tick: ";

    }
}
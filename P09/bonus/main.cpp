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

        while (true) {
            // Get user input
            std::getline(std::cin, input);

            if (input == "q") {
                break;
            } else {
                clock.tic();
            }

            // Print the current time after ticking
            std::cout << "The time is now ";
            clock.print();
            std::cout << std::endl;

            // Get user input again
            std::cout << "Enter 'q' to quit or press Enter to tick: ";
        }
    }catch (const std::out_of_range& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return -2;
    } catch (const std::invalid_argument&) {
        std::cerr << "Invalid input format. Please enter integers for hours, minutes, and seconds." << std::endl;
        return -1;
    }

    return 0;
}
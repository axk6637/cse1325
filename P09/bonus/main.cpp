#include <iostream>
#include <stdexcept>
#include "timer.h"

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Timer timer(hours, minutes, seconds);
        std::string input;

        //prompt to the user
        std::cout << "Enter 'q' to quit or press Enter to tick/continue: ";

        while (true) {
            // Get user input
            std::getline(std::cin, input);

            if (input == "q") {
                break;
            } else {
                timer.tic();
            }

            // Print the current time after ticking
            std::cout << "The time is now ";
            timer.print();
            std::cout << std::endl;
            
        }
    }catch (const std::out_of_range& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return -2;
    } catch (const std::invalid_argument&) {
        std::cerr << "Invalid input format: Please enter integers inuts." << std::endl;
    
    }catch (const std::runtime_error& e) {
        std::cout << e.what() << std::endl;  // Catch Timer expiration 
    }
    return 0;
}
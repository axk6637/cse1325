#include "date.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <map>
#include <string>
#include <iomanip>

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream file(filename);

    if (!file) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;
    std::string line;

    while (std::getline(file, line)) {
        std::istringstream iss(line);
        std::string continent, country, state, region, month, day, year, temp;

        std::getline(iss, continent, ',');
        std::getline(iss, country, ',');
        std::getline(iss, state, ',');
        std::getline(iss, region, ',');
        std::getline(iss, month, ',');
        std::getline(iss, day, ',');
        std::getline(iss, year, ',');
        std::getline(iss, temp, ',');

        Date date(std::stoi(year), std::stoi(month), std::stoi(day));
        temps[date] = std::stod(temp);
    }

    

    while (std::cin) {
        int start_year, start_month, start_day;
        int end_year, end_month, end_day;

        std::cout << "Starting date to list (year month day): ";
        if (!(std::cin >> start_year >> start_month >> start_day)) break;

        std::cout << "Ending date to list (year month day): ";
        if (!(std::cin >> end_year >> end_month >> end_day)) break;

        Date start_date(start_year, start_month, start_day);
        Date end_date(end_year, end_month, end_day);


        
       //find starting point for iteration
        std::map<Date, Temp>::iterator it = temps.find(start_date);

        //if there is no match for exact start_date, proceed with the date greater(or equal) to start_date
        if (it == temps.end() || it->first < start_date) {
         it = temps.lower_bound(start_date);
        } 

        while (it != temps.end() && it->first <= end_date) {
            std::cout << std::setw(12) << it->first
                      << std::setw(8) << std::fixed << std::setprecision(1) << it->second
                      << std::endl;
            ++it;
        }
    }

    return 0;
}

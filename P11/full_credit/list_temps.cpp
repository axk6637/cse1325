#include "date.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <map>
#include <string>

typedef double Temp;

int main(int argc, char* argv[]){
    if (argc!=2){
        std::cerr <<"usage: " << argv[0]<<argv[1] <<std::endl;
        return 1;
    }

    std::string filename= argv[1]; //program argument
    std::ifstream file(filename); //stream for reading files 

    if(!file){ //if not opened succefully
        std::cerr << "Can't open input file " <<filename<<std::endl;
        return 1;
    } 

    std::map <Date, Temp> temps;
    std::string s;

    while(std::getline(file, s)){
        std::istringstream iss(s);
        std::string continent, country, state, region, month, day, year, temp;

        std::getline(iss, continent, ',');
        std::getline(iss, country, ',');
        std::getline(iss, state, ',');
        std::getline(iss, region, ',');
        std::getline(iss, month, ',');
        std::getline(iss, day, ',');
        std::getline(iss, year, ',');
        std::getline(iss, temp, ',');     

        
    }


}
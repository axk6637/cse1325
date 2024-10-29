#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>
#include <random>
#include <chrono>


int main(int argc, char* argv[]){
    std::vector <std::string> numbers; //Stackbased vector
    std::vector<std::string>* words= new std::vector<std::string>();

    for (int i=1; i<argc; ++i){
        std::string arg=argv[i];

        if(std::isdigit(arg[0])){
            numbers.push_back(arg);
        }else{
            words->push_back(arg);
        }
    }

    //sort
    std::sort(words->begin(), words->end());

    //shuffle
    unsigned seed =std::chrono::system_clock::now().time_since_epoch().count();
    std::shuffle(numbers.begin(), numbers.end(), std::default_random_engine(seed));




    std::cout << "Numbers (shuffled): " <<std::endl;
    for(auto num: numbers){
           std::cout <<num << std::endl; 
    }

    std::cout << "Words (sorted): " << std::endl;
    for(auto word: *words){
        std::cout <<word <<std::endl;
    }

    delete words; 
    return 0;

}

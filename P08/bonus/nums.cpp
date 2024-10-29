#include <iostream>
#include <vector>
#include <string>
#include <cctype>

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

    std::cout << "Numbers: " <<std::endl;
    for(auto num: numbers){
           std::cout <<num << std::endl; 
    }

    

}

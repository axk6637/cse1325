#include <iostream>
#include <string>
#include <map>
#include "purse.h"

int main (){
    std::cout << "Welcome to Ye Olde Bank of Merry England\n\n";
    
    int count;
    std::cout << "How many accounts? ";
    std::cin >> count;
    std::cin.ignore();

    std::map<std::string, Purse> vault;  // Map to store accounts with account name as the key

    
    for (int i = 0; i < count; ++i) {
        std::string name;
        Purse purse;
        
        std::cout << "Name account " << i << ": ";
        std::getline(std::cin, name);  
        
        std::cout << "Enter your initial deposit (#3 4s5d): ";
        std::cin >> purse;
        //std::cin.ignore();  

        if (std::cin.fail()){
            std::cerr << "Invalid Format. Please use #pounds shillings s pence d (eg: #3 4s5d)\n";
            return -1;
        }
        vault[name] = purse;  
        std::cout << "Account " << name << " created with " << vault[name] << "\n\n";

        
    }
        Purse total;  // A Purse object
        std::cout << "\n\nAccount List\n============\n\n";
       

for (std::pair<const std::string, Purse>& i: vault) {
    std::cout << "  " << i.first << " with " << i.second << '\n';
    total += i.second;
}
        std::cout << "\nTotal in bank is " << total << '\n';
 
        return 0;
}

    




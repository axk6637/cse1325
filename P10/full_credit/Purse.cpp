#include "Purse.h"

Purse::purse (int pounds, int shillings, int pence)
    : _pounds{pounds}, _shillings{shillings}, _pence {pence}{
        rationalize ();

    }

std::ostream& operator << (std::ostream& os, const Purse& purse){
    ost << "£" << purse._pounds << ' '<<purse._shillings << '$' << purse._pence << 'd';

    return ost;
}

void Purse::rationalize(){
    if (_pence >= 12){
        _shillings += _pence /12;
        _pence %=12;
    }
}
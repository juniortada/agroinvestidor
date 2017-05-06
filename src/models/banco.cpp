#include "banco.hpp"

void Banco::inicializa(float valor){
	saldo = valor;
}

void Banco::deposita(float valor){
	saldo = saldo + valor;
}

void Banco::consulta(){
	cout << "Saldo atual: " << saldo << endl; 
}

void Banco::saque(float valor){
	if(saldo < valor){
		return 0;
	}
	else{
		saldo = saldo - valor;
		return 1;
	}
}
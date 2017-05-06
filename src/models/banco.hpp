#include <iostream>
using namespace std;

class Banco{
	int numero;	// atr privados
	float saldo;
public:
	void inicializa(float valor);
	void deposita(float valor);
	void consulta();
	int saque(float valor);
};
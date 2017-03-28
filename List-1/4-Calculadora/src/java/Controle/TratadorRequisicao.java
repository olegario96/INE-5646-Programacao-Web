/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Calculadora;
import com.google.gson.JsonPrimitive;

/**
 *
 * @author olegario
 */
public class TratadorRequisicao {
    public TratadorRequisicao() {
        
    }
    
    public String tratar_requisicao(String primeiro_operando,
            String segundo_operando, String operacao) {
        
        double resultado = 0;
        String mensagem_erro = null;
        JsonPrimitive js;
        
        try {
            Calculadora calculadora = new Calculadora();
            double operando_1 = Long.parseLong(primeiro_operando);
            double operando_2 = Long.parseLong(segundo_operando);
            
            switch(operacao) {
                case "adicao":
                    resultado = calculadora.soma(operando_1, operando_2);
                    break;
                case "subtracao":
                    resultado = calculadora.subtracao(operando_1, operando_2);
                    break;
                case "multiplicacao":
                    resultado = calculadora.multiplicacao(operando_1, operando_2);
                    break;
                case "divisao":
                    if (operando_2 == 0) {
                        mensagem_erro = "Impossível dividir por 0!";
                    } else {
                        resultado = calculadora.divisao(operando_1, operando_2);    
                    }
                    break;
                default:
                    mensagem_erro = "Essa operação não foi definida!";
                    break;
            }
        } catch (NumberFormatException e) {
            mensagem_erro = "Um dos operandos informados não é um número!";
        }
        
        if (mensagem_erro == null) {
            js = new JsonPrimitive(resultado);
        } else {
            js = new JsonPrimitive(mensagem_erro);
        }
        
        return js.toString();
    }
}

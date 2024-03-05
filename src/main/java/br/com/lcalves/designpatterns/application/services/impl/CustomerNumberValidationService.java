package br.com.lcalves.designpatterns.application.services.impl;

public class CustomerNumberValidationService {

        private static final int TAMANHO_MATRICULA = 5;



    private static char calcularDigitoVerificador(String matricula) {
        // Calcule o dígito verificador somando os dígitos e aplicando o módulo 10
        int soma = 0;
        for (char c : matricula.toCharArray()) {
            soma += Character.getNumericValue(c);
        }
        return (char) ('0' + (soma % 10));
    }


    public  boolean validarMatricula(String matricula) {
        // Verifica se a matrícula possui o formato esperado
        if (!matricula.matches("\\d{5}-\\d")) {
            return false;
        }

        // Extrai a parte numérica da matrícula para calcular o dígito verificador
        String parteNumerica = matricula.substring(0, TAMANHO_MATRICULA);
        char digitoVerificador = matricula.charAt(TAMANHO_MATRICULA + 1);

        // Calcula o dígito verificador esperado
        char digitoCalculado = calcularDigitoVerificador(parteNumerica);

        // Verifica se o dígito verificador coincide
        return digitoVerificador == digitoCalculado;
    }

}

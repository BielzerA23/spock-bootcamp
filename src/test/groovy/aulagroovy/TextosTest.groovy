package aulagroovy

import producao.CalculadoraSalario
import spock.lang.Specification

class TextosTest extends Specification {

    def 'deve ter Strings iguais'(){
        given:
            def texto1 = 'bom dia, amor'


        when:
            def texto2 = 'bom dia, amor' //'boa tarde, mano'

        then:
            texto1 == texto2
    }

    def 'deve pagar 5% de INSS'(){
        given:
            def calculadora = new CalculadoraSalario()
            def bruto = 800
        when:
            def inss = calculadora.getDescontoInss(bruto)

        then:
            inss == 40.0
    }

    def 'deve pegar o cara certo da lista'(){
        given:
            def lista = null //['abel',null,'mike']
        when:
            def cara = 1

        then:
        lista[cara].toUpperCase()== 'JORGE'
    }

    //data driven tests
    def 'deve calcular o liquido corretamente'(){
        expect:
            liquido == new CalculadoraSalario().getSalarioLiquido(bruto)

        where:
            bruto | liquido
            900   | 855
            1010  | 807
            3500  | 2450
    }


}

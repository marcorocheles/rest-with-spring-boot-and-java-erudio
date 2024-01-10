package br.com.erudio.math;

public class SimpleMath {
//	soma
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }
    
//    subtracao
    public Double subtraction(Double numberOne, Double numberTwo) {
    	return numberOne - numberTwo;
    }
    
//    multiplicacao
    public Double mult(Double numberOne, Double numberTwo) {
    	return numberOne * numberTwo;
    }

//    divisao
    public Double division(Double numberOne, Double numberTwo){
    	return numberOne * numberTwo;
    }
    
//  square
  public Double raiz(Double numberOne) {
  	return Math.sqrt(numberOne) ;
  }
  
//  media
  public Double media(Double numberOne, Double numberTwo) {
  	return (numberOne + numberTwo) / 2 ;
  }
}

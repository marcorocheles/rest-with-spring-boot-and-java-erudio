package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converter.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
    
	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
    
//	soma
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, 
                      @PathVariable(value = "numberTwo") String numberTwo
                      ) throws Exception {	
    	if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Please set a numeric Value");
		}
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
//    subtracao
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
		    				@PathVariable(value = "numberTwo") String numberTwo
		    				) throws Exception {
    	if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Please set a numeric Value");
    	}
    	return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
//    multiplicacao
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne,
	    				@PathVariable(value = "numberTwo") String numberTwo
	    				) throws Exception {
    	if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Please set a numeric Value");
    	}
    	return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

//    divisao
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
		    				@PathVariable(value = "numberTwo") String numberTwo
		    				) throws Exception {
    	if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Please set a numeric Value");
    	}
    	return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
//  square
    @RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
  public Double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception {
  	if (!NumberConverter.isNumeric(numberOne)){
  		throw new UnsupportedMathOperationException("Please set a numeric Value");
  	}
  	return math.raiz(NumberConverter.convertToDouble(numberOne));
  }
  
//  media
    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
  public Double media(@PathVariable(value = "numberOne") String numberOne,
  					@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
  	if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
  		throw new UnsupportedMathOperationException("Please set a numeric Value");
  	}
  	return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
  }

}

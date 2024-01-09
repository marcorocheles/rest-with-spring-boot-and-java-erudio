package br.com.erudio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
    
    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, 
                      @PathVariable("numberTwo") String numberTwo
                      ) throws Exception {	
    	if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Please set a numeric Value");
		}
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    
    @GetMapping("/min/{numberOne}/{numberTwo}")
    public Double min(@PathVariable("numberOne") String numberOne,
    				@PathVariable("numberTwo") String numberTwo
    				) throws Exception {
    	if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Please set a numeric Value");
    	}
    	return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D; 
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}

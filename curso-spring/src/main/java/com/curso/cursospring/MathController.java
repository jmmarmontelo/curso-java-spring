package com.curso.cursospring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
        )throws Exception {
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
                throw new Exception();
            }
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String number) {
        if(number == null) return 0D;
        String num = number.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(num);
        return 0D;
    }

    private boolean isNumeric(String number) {
        if (number == null) return false;
        String num = number.replaceAll(",", ".");
        return num.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

}

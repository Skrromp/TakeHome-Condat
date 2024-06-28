package com.condat.takehome.controller;

import com.condat.takehome.model.Calculator;
import com.condat.takehome.model.ICalculator;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    ICalculator calc;

    CalculatorController() {
        calc = new Calculator();
    }


    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAddition(
            @RequestParam double num1,
            @RequestParam double num2) {

        JSONObject jo = new JSONObject();
        double result = calc.add(num1, num2);

        jo.put("result", result);
        return ResponseEntity.ok(jo.toString());
    }

    @GetMapping(value = "/sub", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSubtraction(
            @RequestParam double num1,
            @RequestParam double num2) {

        JSONObject jo = new JSONObject();
        double result = calc.subtract(num1, num2);

        jo.put("result", result);
        return ResponseEntity.ok(jo.toString());
    }

    @GetMapping(value = "/mul", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMultiplication(
            @RequestParam double num1,
            @RequestParam double num2) {

        JSONObject jo = new JSONObject();
        double result = calc.multiply(num1, num2);

        jo.put("result", result);
        return ResponseEntity.ok(jo.toString());
    }

    @GetMapping(value = "/div", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDivision(
            @RequestParam double num1,
            @RequestParam double num2) {

        if (num2 == 0.0) {
            return ResponseEntity.badRequest().body("Cannot divide by zero!");
        }

        JSONObject jo = new JSONObject();
        double result = calc.divide(num1, num2);

        jo.put("result", result);
        return ResponseEntity.ok(jo.toString());
    }

}

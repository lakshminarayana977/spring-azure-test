package com.azure.test.springazuretest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ojalgo.OjAlgoUtils;
import org.ojalgo.netio.BasicLogger;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

@RestController
public class FormerController {

    @GetMapping("/farmer")
    public String getCalculateOptimalSolution()
    {



        BasicLogger.debug(FormerController.class);

        ExpressionsBasedModel model = new ExpressionsBasedModel();

        Variable X = model.addVariable("Area for Wheat").weight(50);
        Variable Y = model.addVariable("Area for barley").weight(120);

        Expression cost = model.addExpression("Cost")//
                .upper(20000)//
                .lower(0);
        cost.set(X, 100).set(Y, 200);

        Expression manDays = model.addExpression("ManDays")//
                .upper(2200)//
                .lower(0);
        manDays.set(X, 10).set(Y, 30);

        Expression totalArea = model.addExpression("TotalArea")//
                .upper(210)//
                .lower(0);
        totalArea.set(X, 1).set(Y, 1);

        Optimisation.Result result = model.maximise();

        // Print the result, and the model
        BasicLogger.debug();
        BasicLogger.debug(result);
        BasicLogger.debug();
        BasicLogger.debug(model);
        BasicLogger.debug();


        return result.toString()+ '\n' + model.toString();
    }
}

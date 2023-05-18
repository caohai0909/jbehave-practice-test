package core;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.steps.Steps;

public class BaseSteps extends Steps {
    @BeforeScenario
    public void initialization(){
        Driver.init();
    }

    @AfterScenario
    public void cleanup(){
        Driver.tearDown();
    }
}

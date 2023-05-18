package runners;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.GoogleSearchSteps;
import org.junit.runners.JUnit4;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class GoogleSearchRunner extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withFormats(Format.CONSOLE, Format.HTML, Format.XML));
    }

    @Override
    public List<String> storyPaths() {
        // Specify the paths to JBehave story files
        return Arrays.asList("stories/GoogleSearch.story");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        // Return an instance of step definitions class
        return new InstanceStepsFactory(configuration(), new GoogleSearchSteps());
    }
}


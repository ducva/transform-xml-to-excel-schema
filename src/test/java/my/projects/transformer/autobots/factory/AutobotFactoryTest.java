package my.projects.transformer.autobots.factory;

import java.util.ArrayList;
import java.util.List;

import my.projects.transformer.autobots.Autobot;
import my.projects.transformer.autobots.Ironhide;
import my.projects.transformer.constant.DbTypes;
import my.projects.transformer.exception.MissionFailedException;
import my.projects.transformer.options.CommandOptions;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.CliFactory;

public class AutobotFactoryTest {
    List<String> argList = new ArrayList<>();

    @Before public void initArguments() {
        this.argList.add("--ironhide");
    }

    @Test public void testReborn() throws Exception {
        final String schemaDir = "abc";
        this.argList.add("--dbType=" + DbTypes.POSTGRESQL);
        this.argList.add("--serverName=" + "192.168.99.100");
        this.argList.add("--dbName=" + "business_traceability");
        this.argList.add("--userName=" + "postgres");
        this.argList.add("--password=" + "x");
        final CommandOptions options =
                CliFactory.parseArguments(CommandOptions.class, this.argList.toArray(new String[] {}));

        final Autobot ironhide = AutobotFactory.reborn(options);
        Assertions.assertThat(ironhide).isNotNull();
        Assertions.assertThat(ironhide).isInstanceOf(Ironhide.class);
        Assertions.assertThat(ironhide.getName()).isEqualTo("Ironhide");
    }

    @Test(expected = MissionFailedException.class) public void testFailed1()
            throws ArgumentValidationException, MissionFailedException {
        final CommandOptions options =
                CliFactory.parseArguments(CommandOptions.class, this.argList.toArray(new String[] {}));

        final Autobot ironhide = AutobotFactory.reborn(options);
        Assertions.assertThat(ironhide).isNotNull();
        Assertions.assertThat(ironhide).isInstanceOf(Ironhide.class);
        Assertions.assertThat(ironhide.getName()).isEqualTo("Ironhide");

        ironhide.performMission();
    }

}

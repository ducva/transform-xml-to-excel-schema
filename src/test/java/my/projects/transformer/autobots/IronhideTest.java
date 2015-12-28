package my.projects.transformer.autobots;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import my.projects.transformer.autobots.factory.AutobotFactory;
import my.projects.transformer.constant.DbTypes;
import my.projects.transformer.exception.MissionFailedException;
import my.projects.transformer.options.CommandOptions;
import org.apache.ddlutils.model.Database;
import org.junit.Test;
import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.CliFactory;

/**
 *
 */
public class IronhideTest {
    private List<String> argList = new ArrayList<>();

    @Test public void testPerformMission() throws MissionFailedException, ArgumentValidationException {
        final String schemaDir = "abc";
        this.argList.add("--ironhide");
        this.argList.add("--dbType=" + DbTypes.POSTGRESQL);
        this.argList.add("--serverName=" + "192.168.99.100");
        this.argList.add("--dbName=" + "business_traceability");
        this.argList.add("--userName=" + "postgres");
        this.argList.add("--password=" + "x");
        final CommandOptions options =
                CliFactory.parseArguments(CommandOptions.class, this.argList.toArray(new String[] {}));

        Autobot ironhide = AutobotFactory.reborn(options);
        boolean methodResult = ironhide.performMission();

        assertThat(methodResult).isTrue();

        Object result = ironhide.getResult();

        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(Database.class);

    }
}

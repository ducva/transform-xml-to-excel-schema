package my.projects.transformer;

import my.projects.transformer.autobots.Autobot;
import my.projects.transformer.autobots.factory.AutobotFactory;
import my.projects.transformer.exception.MissionFailedException;
import my.projects.transformer.options.CommandOptions;
import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.CliFactory;

public class Transformers {
    public static void main(String[] args) throws ArgumentValidationException {
        final CommandOptions options = CliFactory.parseArguments(CommandOptions.class, args);

        try {
            final Autobot ironhide = AutobotFactory.reborn(options);
        } catch (final MissionFailedException e) {
            System.out.println(e.getMessage());
        }


    }
}

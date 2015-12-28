package my.projects.transformer.autobots.factory;

import my.projects.transformer.autobots.Autobot;
import my.projects.transformer.autobots.Ironhide;
import my.projects.transformer.exception.MissingResourceException;
import my.projects.transformer.exception.MissionFailedException;
import my.projects.transformer.options.CommandOptions;

public final class AutobotFactory {

    private AutobotFactory() {
        // Hide default constructor
    }

    public static Autobot reborn(CommandOptions options) throws MissionFailedException {
        if (options.getIronhide()) {
            if (!options.isDbType())
                throw new my.projects.transformer.exception.MissingResourceException("dbType", "missing value");

            if (!options.isServerName())
                throw new MissingResourceException("serverName", "missing value");

            if (!options.isDbName()) {
                throw new MissingResourceException("dbName", "missing value");
            }

            if (!options.isUserName()) {
                throw new MissingResourceException("userName", "missing value");
            }

            if (!options.isPassword()) {
                throw new MissingResourceException("password", "missing value");
            }

            return new Ironhide(options.getDbType(), options.getServerName(), options.getDbName(),
                    options.getUserName(), options.getPassword());
        }

        return null;
    }


}

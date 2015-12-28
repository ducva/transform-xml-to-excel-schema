package my.projects.transformer.options;

import uk.co.flamingpenguin.jewel.cli.Option;

public interface CommandOptions {

    @Option public boolean getIronhide();

    @Option public String getSchemaDir();

    public boolean isSchemaDir();

    @Option String getDbType();

    boolean isDbType();

    @Option String getServerName();

    boolean isServerName();

    @Option String getUserName();

    boolean isUserName();

    @Option String getPassword();

    boolean isPassword();

    @Option String getDbName();

    boolean isDbName();
}

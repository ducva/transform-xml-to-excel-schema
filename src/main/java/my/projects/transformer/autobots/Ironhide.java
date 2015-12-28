package my.projects.transformer.autobots;

import javax.sql.DataSource;

import my.projects.transformer.exception.MissionFailedException;
import my.projects.transformer.supporter.factory.DataSourceFactory;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Database;

/**
 * Ironhide transforms database model into Object models.
 */
public class Ironhide extends Autobot {

    private String dbType;

    private String serverName;

    private String dbName;

    private String userName;

    private String password;
    
    public Ironhide(String dbType, String serverName, String dbName, String userName, String password) {
        super();
        this.dbType = dbType;
        this.serverName = serverName;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.setName("Ironhide");
    }

    @Override public boolean performMission() throws MissionFailedException {
        DataSource ds =
                DataSourceFactory.create(this.dbType, this.serverName, this.dbName, this.userName, this.password);

        Platform platform = PlatformFactory.createNewPlatformInstance(ds);
        Database model = platform.readModelFromDatabase("Model");

        this.setResult(model);
        return true;
    }
}

package my.projects.transformer.supporter.factory;

import javax.sql.DataSource;

import my.projects.transformer.constant.DbTypes;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 */
public class DataSourceFactory {

    public static DataSource create(String dbType, String serverName, String dbName, String userName, String password) {
        switch (dbType) {
            case DbTypes.POSTGRESQL:
                return createPostgresDataSource(serverName, dbName, userName, password);
            default:
                return null;

        }
    }

    private static DataSource createPostgresDataSource(String serverName, String dbName, String userName,
            String password) {
        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setServerName(serverName);
        ds.setDatabaseName(dbName);
        ds.setUser(userName);
        ds.setPassword(password);
        ds.setMaxConnections(10);
        return ds;
    }
}

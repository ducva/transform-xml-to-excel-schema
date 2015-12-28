package my.projects.transformer.supporter.factory;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import my.projects.transformer.constant.DbTypes;
import org.junit.Test;
import org.postgresql.ds.PGPoolingDataSource;


/**
 *
 */
public class DataSourceFactoryTest {
    @Test public void testCreate() {
        DataSource ds = DataSourceFactory
                .create(DbTypes.POSTGRESQL, "192.168.99.100", "business_traceability", "postgres", "x");
        assertThat(ds).isNotNull();
        assertThat(ds).isInstanceOf(PGPoolingDataSource.class);

    }
}

package org.n3r.eql.mtcp.impl;

import com.codahale.metrics.MetricRegistry;
import org.n3r.eql.mtcp.DataSourceConfigurator;
import org.n3r.eql.trans.UnpooledDataSource;
import org.n3r.eql.util.O;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class UnpooledDataSourceConfigurator implements DataSourceConfigurator {
    private final UnpooledDataSource dataSource = new UnpooledDataSource();
    private String tenantId;

    @Override
    public void prepare(String tenantId,
                        Map<String, String> props,
                        MetricRegistry metricsRegistry,
                        ScheduledExecutorService destroyScheduler) {
        this.tenantId = tenantId;
        O.populate(dataSource, props);
    }

    @Override public DataSource getDataSource() {
        return dataSource;
    }

    @Override public void destroy(String tenantId, MetricRegistry metricsRegistry) {

    }

    @Override public String shrink() {
        return "tenantId: " + tenantId + " use UnpooledDataSource, there is nothing to shrink";
    }
}

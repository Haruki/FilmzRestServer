package gl.hb.filmzrestserver.metrics;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Asterix on 10.01.2017.
 */
public class TemplateHealthCheck extends HealthCheck{
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected HealthCheck.Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return HealthCheck.Result.unhealthy("template doesn't include a name");
        }
        return HealthCheck.Result.healthy();
    }
}

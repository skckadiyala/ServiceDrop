package services.resources;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

/**
 * Created by skchkadiyala on 2/8/2018.
 */
public class ServiceApplication extends Application<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new ServiceApplication().run(args);
    }
    @Override
    public void run(ServiceConfiguration config,
                    Environment environment) {

        final Client client = new JerseyClientBuilder(environment).using(config.getJerseyClientConfiguration())
                .build(getName());
        environment.jersey().register(new RESTClientController(client));
    }
}



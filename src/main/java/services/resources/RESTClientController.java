package services.resources;

import jdk.nashorn.api.scripting.JSObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by skchkadiyala on 2/8/2018.
 */
@Produces(MediaType.TEXT_PLAIN)
@Path("/client")
public class RESTClientController
{
    private Client client;

    public RESTClientController(Client client) {
        this.client = client;
    }

    @GET
    @Path("/pets/")
    public String getEmployees()
    {
        //Do not hard code in your application
        WebTarget webTarget = client.target("https://api.darksky.net/forecast/3f98fcf3af49ba25c7b7fa930878554a/37.8267,-122.4233");
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        @SuppressWarnings("rawtypes")
        String Hello = response.readEntity(String.class);
        // System.out.print("Employee is: " + employees);
        // return employees.toString();
        //return response.getEntity();
        return Hello;
    }

    @GET
    @Path("/{id}")
    public String getEmployeeById(@PathParam("id") int id)
    {
        //Do not hard code in your application
        WebTarget webTarget = client.target("http://petstore.swagger.io/v2/pet/"+id);
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        //Employee employee = response.readEntity(Employee.class);
        ArrayList employee = response.readEntity(ArrayList.class);
        return employee.toString();
    }
}
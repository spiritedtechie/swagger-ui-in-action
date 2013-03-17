package lab.api;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
@Path("/api/resources")
public class APIDefinitionResource {

    @GET
    @Produces("application/json")
    public Response getResources() throws Exception {

        final InputStream is = getClass().getClassLoader().getResourceAsStream("customer-api.json");

        final String apiDef = IOUtils.toString(is);

        return Response.ok(apiDef).build();
    }

}

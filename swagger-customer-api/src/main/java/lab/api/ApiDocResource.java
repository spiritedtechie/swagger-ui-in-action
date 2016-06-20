package lab.api;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;

@Component
@Path("/api-doc")
public class ApiDocResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAPIDocumentation() throws IOException {

        URL resourceUrl = this.getClass().getClassLoader().getResource("api.json");

        String apiSpecJson = IOUtils.toString(resourceUrl, "UTF-8");

        return Response.ok(apiSpecJson).build();
    }

}

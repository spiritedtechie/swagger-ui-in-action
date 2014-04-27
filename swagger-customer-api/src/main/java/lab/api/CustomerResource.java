package lab.api;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import lab.domain.Customer;
import lab.domain.Customers;
import lab.service.CustomerService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/api/customers")
public class CustomerResource {

    private static final Log LOG = LogFactory.getLog(CustomerResource.class);

    private CustomerService service;

    @Autowired
    public CustomerResource(final CustomerService service) {
        this.service = service;
    }

    public CustomerResource() {
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCustomers(@QueryParam("vulnerable") final boolean vulnerableOnly) {

        LOG.info("*** Customers Requested. Vulnerable? " + vulnerableOnly);

        final Customers customers = service.allCustomers(vulnerableOnly);

        if (customers == null || customers.getCustomers() == null || customers.getCustomers().isEmpty()) return Response
                .status(Status.NOT_FOUND).entity("Customers not found").build();

        return Response.ok(customers).build();
    }

    @GET
    @Path("/{customerId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCustomer(@PathParam("customerId") final String customerId) {

        LOG.info("*** Customer Requested With Id: " + customerId);

        final Customer customer = service.findCustomer(customerId);

        if (customer == null) return Response.status(Status.NOT_FOUND).entity("Customer not found").build();

        return Response.ok(customer).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response createCustomer(final Customer customer) throws Exception {

        LOG.info("*** Customer Creation Requested: " + customer);

        final Customer createdCustomer = service.newCustomer(customer);

        return Response.created(new URI("/customer/" + customer.getId())).entity(createdCustomer).build();
    }

    @PUT
    @Path("/{customerId}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateCustomer(@PathParam("customerId") final String customerId, final Customer customer)
            throws Exception {

        LOG.info("*** Customer Updation Requested: " + customer);

        final Customer findCustomer = service.findCustomer(customerId);

        if (findCustomer == null) return Response.status(Status.NOT_FOUND).entity("Customer not found").build();

        customer.setId(customerId);
        final Customer updatedCustomer = service.updateCustomer(customer);

        return Response.ok(updatedCustomer).build();
    }

    @DELETE
    @Path("/{customerId}")
    public Response updateCustomer(@PathParam("customerId") final String customerId) throws Exception {

        LOG.info("*** Customer Deletion Requested: " + customerId);

        final Customer deletedCustomer = service.deleteCustomer(customerId);

        if (deletedCustomer != null) return Response.ok().entity(deletedCustomer).build();

        return Response.ok().entity("No customer to delete").build();
    }

    @OPTIONS
    @Path("/{path:.*}")
    public Response options() {

        return Response.ok().build();
    }

    @OPTIONS
    public Response options2() {

        return Response.ok().build();
    }

}

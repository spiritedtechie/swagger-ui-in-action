package lab.api;

import lab.model.Customer;
import lab.model.Customers;
import lab.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;

@Component
@Path("/customers")
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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomers(@QueryParam("vulnerable") final boolean vulnerableOnly) {

        LOG.info("*** Customers Requested. Vulnerable? " + vulnerableOnly);

        final Customers customers = service.allCustomers(vulnerableOnly);

        if (customers == null || customers.getCustomers() == null || customers.getCustomers().isEmpty())
            return customerNotFound();

        return Response.ok(customers).build();
    }

    @GET
    @Path("/{customerId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCustomer(@PathParam("customerId") final String customerId) {

        LOG.info("*** Customer Requested With Id: " + customerId);

        final Customer customer = service.findCustomer(customerId);

        if (customer == null)
            return customerNotFound();

        return Response.ok(customer).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createCustomer(final Customer customer) throws Exception {

        LOG.info("*** Customer Creation Requested: " + customer);

        final Customer createdCustomer = service.newCustomer(customer);

        return Response.created(new URI("/customer/" + customer.getId())).entity(createdCustomer).build();
    }

    @PUT
    @Path("/{customerId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateCustomer(@PathParam("customerId") final String customerId, final Customer customer)
            throws Exception {

        LOG.info("*** Customer Updation Requested: " + customer);

        final Customer findCustomer = service.findCustomer(customerId);

        if (findCustomer == null)
            return customerNotFound();

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
        else return noCustomerToDelete();
    }

    @OPTIONS
    public Response options2() {

        return Response.ok().build();
    }

    private Response noCustomerToDelete() {
        return Response
                .status(Status.OK)
                .entity("{ \"msg\" : \"No customer to delete\" }")
                .build();
    }

    private Response customerNotFound() {
        return Response
                .status(Status.NOT_FOUND)
                .entity("{ \"error\" : \"Customers not found\" }")
                .build();
    }

}

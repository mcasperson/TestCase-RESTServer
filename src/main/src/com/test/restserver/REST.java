package com.test.restserver;
import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;

@Path("/")
@Provider
@ServerInterceptor
public class REST implements MessageBodyWriterInterceptor
{
    public void write(final MessageBodyWriterContext context) throws IOException, WebApplicationException
    {   context.getHeaders().add("Access-Control-Allow-Origin", "*");
        context.proceed();      
    }

    @OPTIONS
    @Path("/{path:.*}")
    public Response handleCORSRequest(@HeaderParam("Access-Control-Request-Method") final String requestMethod, @HeaderParam("Access-Control-Request-Headers") final String requestHeaders)
    {
        final ResponseBuilder retValue = Response.ok();

        if (requestHeaders != null)
            retValue.header("Access-Control-Allow-Headers", requestHeaders);

        if (requestMethod != null)
            retValue.header("Access-Control-Allow-Methods", requestMethod);

        retValue.header("Access-Control-Allow-Origin", "*");

        return retValue.build();
    }
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ "*" })
	public RESTObject<RESTChildObject<RESTGrandchildObject>> printMessage()
	{
		final RESTObject<RESTChildObject<RESTGrandchildObject>> retValue = new RESTObject<RESTChildObject<RESTGrandchildObject>>();
		retValue.setObjects(new ListWrapper<RESTChildObject<RESTGrandchildObject>>());
		retValue.getObjects().setList(new ArrayList<RESTChildObject<RESTGrandchildObject>>());
		
		final RESTChildObject<RESTGrandchildObject> child = new RESTChildObject<RESTGrandchildObject>();
		child.setSomeList(new ListWrapper<RESTGrandchildObject>());
		child.getSomeList().setList(new ArrayList<RESTGrandchildObject>());
		
		retValue.getObjects().getList().add(child);
		
		final RESTGrandchildObject grandchild = new RESTGrandchildObject();
		grandchild.setName("Grandchild");
		
		child.getSomeList().getList().add(grandchild);
				
		return retValue;

	}
}

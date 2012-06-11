import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class REST
{
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ "*" })
	public RESTObject printMessage()
	{
		final RESTObject retValue = new RESTObject();
		retValue.setValue(1);
		return retValue;

	}
}

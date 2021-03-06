package ae.zg.quarkus.mongoreactive.rest.json;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ae.zg.quarkus.mongoreactive.repo.FruitRepository;
import ae.zg.quarkus.mongoreactive.rest.model.Fruit;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(FruitResource.class);

	@Inject
	FruitRepository repo;

	@GET
	public List<Fruit> list() {
		return repo.listAll();
	}

	@POST
	public List<Fruit> add(Fruit fruit) {

		LOGGER.info("Saving Fruit....");
		repo.persist(fruit);

		LOGGER.info("Fruit saved successfully! Id = {}", fruit.id);
		return list();
	}
}

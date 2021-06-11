package jp.unext.controller.user;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import jp.unext.usecase.useradd.inputboundary.UserAddInputBoundary;
import jp.unext.usecase.useradd.inputdata.UserAddInputData;
import jp.unext.view.outputboundary.UserAddOutputData;

@Path("/users")
public class UsersController {

	@Inject
	UserAddInputBoundary userAddInputBoundary;

	@POST
	@Transactional
	public Response create(UserAddBody body) {
		UserAddInputData input = new UserAddInputData(body.accountName, body.mailAddress);
		UserAddOutputData output = userAddInputBoundary.handle(input);

		// TODO
		// OutputDataを直接返すのではなく、PresenterでViewModelに変換するのだと思うけど、ControllerからのIn/Outのつなぎこみがよく分からないな

		return Response.ok(output).status(201).build();
	}

}

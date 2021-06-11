package jp.unext.usecase.useradd.inputboundary;

import javax.enterprise.context.ApplicationScoped;

import jp.unext.usecase.useradd.inputdata.UserAddInputData;
import jp.unext.view.outputboundary.UserAddOutputData;

@ApplicationScoped
public interface UserAddInputBoundary {

	UserAddOutputData handle(UserAddInputData inputData);
}

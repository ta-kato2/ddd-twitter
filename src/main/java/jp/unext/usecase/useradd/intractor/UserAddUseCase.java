package jp.unext.usecase.useradd.intractor;

import java.util.UUID;

import javax.inject.Inject;

import jp.unext.model.entity.user.User;
import jp.unext.model.value.AccountName;
import jp.unext.model.value.MailAddress;
import jp.unext.model.value.UserId;
import jp.unext.store.gateway.UserRepository;
import jp.unext.usecase.useradd.inputboundary.UserAddInputBoundary;
import jp.unext.usecase.useradd.inputdata.UserAddInputData;
import jp.unext.view.outputboundary.UserAddOutputData;

/**
 * {@link UserAddInputBoundary} の実装
 */
public class UserAddUseCase implements UserAddInputBoundary {

	@Inject
	UserRepository userRepository;

	@Override
	public UserAddOutputData handle(UserAddInputData inputData) {
		String uuid = UUID.randomUUID().toString();

		User user = new User(new UserId(uuid), new AccountName(inputData.getAccountName()),
				new MailAddress(inputData.getMailAddress()));

		userRepository.save(user);

		return new UserAddOutputData(uuid);
	}
}

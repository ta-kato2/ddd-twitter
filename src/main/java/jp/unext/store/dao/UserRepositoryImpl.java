package jp.unext.store.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jp.unext.model.entity.user.User;
import jp.unext.model.value.AccountName;
import jp.unext.model.value.MailAddress;
import jp.unext.model.value.UserId;
import jp.unext.store.entity.UserEntity;
import jp.unext.store.gateway.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public void save(User user) {
		UserEntity entity = new UserEntity();
		entity.userId = user.getId().getValue(); // TODO DBEntityとModelのMapperも欲しくなるなぁ
		entity.name = user.getAccountName().getValue();
		entity.mailAddress = user.getMailAddress().getValue();
		entity.persist();
	}

	@Override
	public void remove(User user) {
		UserEntity entity = UserEntity.findById(user.getId());
		entity.delete();
	}

	@Override
	public List<User> findAll() {
		return UserEntity.list("order by member_id asc").stream().map(dbEntity -> {
			return mappingToModel(dbEntity);
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<User> find(UserId id) {
		return Optional.ofNullable(UserEntity.findById(id)).map(dbEntity -> {
			UserEntity entity = (UserEntity) dbEntity;

			UserId userId = new UserId(entity.userId);
			AccountName name = new AccountName(entity.name);
			MailAddress mailAddress = new MailAddress(entity.mailAddress);
			return new User(userId, name, mailAddress);
		});
	}

	private User mappingToModel(PanacheEntityBase dbEntity) {
		UserEntity entity = (UserEntity) dbEntity;

		UserId userId = new UserId(entity.userId);
		AccountName name = new AccountName(entity.name);
		MailAddress mailAddress = new MailAddress(entity.mailAddress);
		return new User(userId, name, mailAddress);
	}
}
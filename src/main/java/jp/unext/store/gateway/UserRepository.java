package jp.unext.store.gateway;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import jp.unext.model.entity.user.User;
import jp.unext.model.value.UserId;

@ApplicationScoped
public interface UserRepository {

	@Transactional //TODO トランザクションはリポジトリのメソッドではなく、UseCaseクラスに付与すべき？失敗時に必ずロールバックする前提なら、それでも良いのかな？
	public void save(User user);

	@Transactional
	public void remove(User user);

	@Transactional
	public List<User> findAll();

	@Transactional
	public Optional<User> find(UserId id);

}

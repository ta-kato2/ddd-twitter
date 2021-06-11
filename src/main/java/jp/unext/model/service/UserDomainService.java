package jp.unext.model.service;

import jp.unext.model.entity.user.User;

public class UserDomainService {

	public boolean isDuplicated(User user) {
		return false; // TODO DBを検索して、重複しているユーザーがいるかを確認する
	}
}

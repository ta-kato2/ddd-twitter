package jp.unext.model.entity.user;

import jp.unext.model.value.AccountName;
import jp.unext.model.value.MailAddress;
import jp.unext.model.value.UserId;

public class User {

	private UserId id;

	private AccountName accountName;

	private MailAddress mailAddress;

	public User(UserId userId, AccountName accountName, MailAddress mailAddress) {
		if (userId == null) {
			throw new IllegalArgumentException("ユーザーIDは必須です");
		}
		if (accountName == null) {
			throw new IllegalArgumentException("アカウント名は必須です");
		}
		if (mailAddress == null) {
			throw new IllegalArgumentException("メールアドレスは必須です");
		}
		this.id = userId;
		this.accountName = accountName;
		this.mailAddress = mailAddress;
	}

	public UserId getId() {
		return id;
	}

	public AccountName getAccountName() {
		return accountName;
	}

	public MailAddress getMailAddress() {
		return mailAddress;
	}
}

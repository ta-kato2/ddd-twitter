package jp.unext.model.value;

public class AccountName {

	private final String value;

	public AccountName(String value) {
		if (value == null) {
			throw new IllegalArgumentException("アカウント名は必須です。");
		}
		if (value.length() < 4 || value.length() > 20) {
			throw new IllegalArgumentException("アカウント名は4〜20文字である必要があります。");
		}
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

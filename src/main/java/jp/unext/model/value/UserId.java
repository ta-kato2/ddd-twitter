package jp.unext.model.value;

public class UserId {

	private final String value;

	public UserId(String value) {
		if (value == null) { // こういうルールはアノテーションでも行けるかもなぁ。
			throw new IllegalArgumentException("ユーザーIDは必須です");
		}
		if (value.length() != 20) {
			throw new IllegalArgumentException("ユーザーIDは20桁である必要があります");
		}
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

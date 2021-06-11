package jp.unext.model.value;

import java.util.regex.Pattern;

public class MailAddress {

	private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private final String value;

	public MailAddress(String value) {
		if (value == null) {
			throw new IllegalArgumentException("メールアドレスは必須です。");
		}
		if (isValid(value)) {
			throw new IllegalArgumentException("メールアドレスとして正しくありません。");
		}
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private boolean isValid(String value) {
		return EMAIL_REGEX.matcher(value).matches();
	}
}

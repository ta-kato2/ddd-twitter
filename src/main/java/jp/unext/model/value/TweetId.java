package jp.unext.model.value;

public class TweetId {

	private final String value;

	public TweetId(String value) {
		if (value == null) { // こういうルールはアノテーションでも行けるかもなぁ。
			throw new IllegalArgumentException("ツイートIDは必須です");
		}
		if (value.length() != 20) {
			throw new IllegalArgumentException("ツイートIDは20桁である必要があります");
		}
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

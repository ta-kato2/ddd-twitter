package jp.unext.model.entity.tweet;

public class Tweet {

	// TODO IDも必要。投稿日時とかも必要。いいねとかリツイートはどう表現する？

	private String message;

	public Tweet(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

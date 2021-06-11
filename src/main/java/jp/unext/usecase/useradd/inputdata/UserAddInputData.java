package jp.unext.usecase.useradd.inputdata;

public class UserAddInputData {

	private final String accountName;

	private final String mailAddress;

	public UserAddInputData(String accountName, String mailAddress) {
		this.accountName = accountName;
		this.mailAddress = mailAddress;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getMailAddress() {
		return mailAddress;
	}
}

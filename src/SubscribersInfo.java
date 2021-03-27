/**
* The Programming Assignment implements an application that
* simply displays all the messages subscribers received to the standard output file.
*
* @author  Wei Xin
* @ID	   1207050893
* @version 1.0
* @since   2018-11-26
*/

public class SubscribersInfo {

	//a class of putting subscribers information "company name" and "type" together as a pair
	private String company;

	private String type;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SubscribersInfo(String company, String type) {
		this.company = company;
	    this.type = type;
	}

}

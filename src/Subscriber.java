/**
* The Programming Assignment implements an application that
* simply displays all the messages subscribers received to the standard output file.
*
* @author  Wei Xin
* @ID	   1207050893
* @version 1.0
* @since   2018-11-26
*/

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {

	//subscribers arraylist that will be used in the child class "ConcreteSubscriber"
	protected List<SubscribersInfo> subscribers = new ArrayList<SubscribersInfo>();

	//public Broker broker;

	//a couple of abstract class that add or remove the subscribers that stored in the subscriber arraylist
	public abstract void addSubscriber(String sub, String type, Broker pubSubService);

	public abstract void removeSubscriber(String sub, String type, Broker pubSubService);

}

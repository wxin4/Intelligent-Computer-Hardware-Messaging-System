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

public class ConcreteSubscriber extends Subscriber {

	//an arraylist of Strings created for putting the subscriber company and the type together as a String to make things comparable
	protected ArrayList<String> arr = new ArrayList<String>();

	//public ConcretePublisher concretePublisher;

	//implements the two subscriber manipulations "addSubscriber" and "removeSubscriber"
	public void addSubscriber(String sub, String type, Broker pubSubService) {

		//create a pair of subscriber company and type together and store them in the arraylist of Strings
		SubscribersInfo pair = new SubscribersInfo(sub, type);
		String str = sub + type;
		
		//if the array does not have the sub+type then add it into the subscribers list and call the broker
		if(!arr.contains(str))
		{
			subscribers.add(pair);
			arr.add(str);
			pubSubService.addSubscriber(pair);
		}
	}

	//everything is the same as addSubscriber for this moment
	public void removeSubscriber(String sub, String type, Broker pubSubService) {

		SubscribersInfo pair = new SubscribersInfo(sub, type);
		String str = sub + type;
		arr.remove(str);
		pubSubService.removeSubscriber(pair);
	}

}

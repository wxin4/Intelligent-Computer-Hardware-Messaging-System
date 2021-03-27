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

public class Broker extends ConcreteSubscriber {

	//an arraylist of Strings that holds the converted messages coming from publishers
	private ArrayList<String> list = new ArrayList<String>();

	//an arraylist of Messages that holds the real messages coming from publishers
	private ArrayList<Message> messagesList = new ArrayList<Message>();

	//an arraylist of Subscribers information (pair) that comes from the Subscriber class
	private List<SubscribersInfo> subscribers = new ArrayList<SubscribersInfo>();

	//an arraylist of Messages that holds the subscriber messages received from the publisher
	private List<Message> subscriberMessages = new ArrayList<Message>();
	
	
	//get and set
	public List<Message> getSubscriberMessages() {
		return subscriberMessages;
	}

	public void setSubscriberMessages(List<Message> subscriberMessages) {
		this.subscriberMessages = subscriberMessages;
	}

	
	//implement the addMessageToArray and then broadcast the added message to all the subscribers at this time
	public void addMessageToArray(Message message) {
		String str = message.getPublisher() + message.getType() + message.getLevel();
		if(!list.contains(str))
		{
			messagesList.add(message);	
			list.add(str);
			broadcast();  //since this is adding publisher messages so only iterates the subscribers arraylist will be okay
		}
	}

	//add the subscriber information pair to the subscribers list and then add the converted subscriber information to the arr that holds the Strings
	public void addSubscriber(SubscribersInfo subInfo) {
		subscribers.add(subInfo);
		arr.add(subInfo.getCompany()+subInfo.getType());
		getMessageOfType();  //since this is adding subscribers so only iterates the message arraylist will be okay
	}

	//remove the subscriber if the keyword is unsubscribe, simply remove all the subscriber information pair and the strings of them
	public void removeSubscriber(SubscribersInfo subInfo) {
		subscribers.remove(arr.indexOf(subInfo.getCompany()+subInfo.getType()));
		arr.remove(arr.indexOf(subInfo.getCompany()+subInfo.getType()));
	}

	//notify the subscribers of the messages added by publishers
	public void broadcast() {
		Message message = messagesList.get(messagesList.size()-1);  //get the last element of the message list since that is the last added one
        String type = message.getType();

        //traverse the subscriber list
		for(SubscribersInfo subs : subscribers)
		{
			if(type.equalsIgnoreCase((subs.getType())))  //compare with the type that subscribers wanted, if true, then print the message to the system
			{
				getSubscriberMessages();
				subscriberMessages.add(message);
				setSubscriberMessages(subscriberMessages);
				System.out.println("Sent to " + subs.getCompany() + ": [A product is added by " + message.getPublisher() + "] [Type is "+ message.getType() + "] [Price is " + message.getLevel() + "]") ;
			}
		}
	}

	//traverse the messages list and find if the last added subscriber matches the type publisher gives
	public void getMessageOfType() {
		if(messagesList.isEmpty())
		{
			return;
		}
		else
		{
			//traverse the message list and see if we can get the same type of subscribers
			for (Message message : messagesList) {
				String type = message.getType();

				if (type.equalsIgnoreCase((subscribers.get(subscribers.size() - 1).getType()))) //found one
				{
					getSubscriberMessages();
					subscriberMessages.add(message);
					setSubscriberMessages(subscriberMessages);
					System.out.println("Sent to " + subscribers.get(subscribers.size() - 1).getCompany() + ": A product is added by " + message.getPublisher() + "] [Type is " + message.getType() + "] [Price is " + message.getLevel() + "]");
				}
			}
		}
	}

}

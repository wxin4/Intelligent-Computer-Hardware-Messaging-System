/**
* The Programming Assignment implements an application that
* simply displays all the messages subscribers received to the standard output file.
*
* @author  Wei Xin
* @ID	   1207050893
* @version 1.0
* @since   2018-11-26
*/

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//create three new publisher subscriber and broker
		Publisher publisher = new ConcretePublisher();
        
        Subscriber subscriber = new ConcreteSubscriber();
        
        Broker broker = new Broker();
        
        //create a scanner that scan the input file
    	Scanner sc = new Scanner(System.in);
    	            
    	while(sc.hasNextLine())
    	{
    	    String line = sc.nextLine();
    	    String[] details = line.split(",");  //get every string by splitting the commas
    	    
    	    //if the first word from the line is subscribe then add the subscriber to the list
    	    if(details[0].equalsIgnoreCase("subscribe"))
    	    {
    	        subscriber.addSubscriber(details[1], details[2], broker);
    	    }
    	    
    	    //if the first word from the line is unsubscribe then remove the subscriber from the list
    	    if(details[0].equalsIgnoreCase("unsubscribe"))
    	    {
    	        subscriber.removeSubscriber(details[1], details[2], broker);
    	    }
    	    
    	    //if the first word from the line is publish then add the published message to the list
    	    if(details[0].equalsIgnoreCase("publish"))
    	    {
    	        Message m = new Message(details[1], details[2], details[3]);
    	        publisher.publish(m, broker);
    	    }
    	}

	}

}

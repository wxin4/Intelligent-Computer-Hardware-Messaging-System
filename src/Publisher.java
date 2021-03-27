/**
* The Programming Assignment implements an application that
* simply displays all the messages subscribers received to the standard output file.
*
* @author  Wei Xin
* @ID	   1207050893
* @version 1.0
* @since   2018-11-26
*/

public interface Publisher {

	//public Broker broker;
	//The abstract method of publish
	public abstract void publish(Message message, Broker pubSubService);

}

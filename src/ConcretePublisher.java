/**
* The Programming Assignment implements an application that
* simply displays all the messages subscribers received to the standard output file.
*
* @author  Wei Xin
* @ID	   1207050893
* @version 1.0
* @since   2018-11-26
*/

public class ConcretePublisher implements Publisher {

	//the implemented publish method that calls the Broker and add the message
	public void publish(Message message, Broker pubSubService) {
		pubSubService.addMessageToArray(message);
	}

}

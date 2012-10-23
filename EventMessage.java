public class EventMessage extends Message
{
	State state;
	Member member;
	
	public EventMessage(String message, Member member, State state)
	{
		super(message);
		this.member = member;
		this.state = state;
	}	
}



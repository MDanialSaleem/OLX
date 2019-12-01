package com.company;
import java.util.*;

public class Chat {
	private UserAccount[] participants = new UserAccount[2];
	private List<Message> messages;
	
	public Chat(UserAccount user1, UserAccount user2) {
		participants[0] = user1;
		participants[1] = user2;
		messages = new ArrayList<>();
	}

	public Chat(UserAccount user1, UserAccount user2, List<Message> messages) {
		participants[0] = user1;
		participants[1] = user2;
		this.messages = messages;
	}
	
	public void addMessage(String text, UserAccount sender) {
		if(!sender.equals(participants[0]) && !sender.equals(participants[1])) {
			throw new IllegalArgumentException("In Chat class: Sender is not one of participants");
		}
		messages.add(new Message(text, sender));
		for(int i = 0; i < 2; i++) {
			if(!sender.equals(participants[i])) {
				participants[i].notifyUserOfMessage();
			}
		}
	}
	
	public UserAccount[] getParticipants() {
		UserAccount[] temp = new UserAccount[2];
		for(int i =0; i<2;i++)
		{
			temp[i] = participants[i];
		}
		return temp;
		}
		
}
	

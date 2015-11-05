package org.archcorner.pojo;

public class UserChat {

	private int chatUserId;
	
	private int chatId;
	
	private int fromUserId;
	
	private int toUserId;

	public int getChatUserId() {
		return chatUserId;
	}

	public void setChatUserId(int chatUserId) {
		this.chatUserId = chatUserId;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}
}

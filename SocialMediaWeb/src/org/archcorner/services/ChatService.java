/**
 * 
 */
package org.archcorner.services;

import java.util.List;

import org.archcorner.dal.dao.CampaignDAO;
import org.archcorner.dal.dao.ChatDAO;
import org.archcorner.pojo.Chat;
import org.archcorner.pojo.UserChat;

/**
 * @author bhagvan_kommadi
 *
 */
public class ChatService {
	
	public int getHighestChatUserId()
	{
		ChatDAO chatDAO = new ChatDAO();
		return chatDAO.getHighestChatUserId();
	}
 
	public int getHighestId()
	{
		ChatDAO chatDAO = new ChatDAO();
		return chatDAO.getHighestId();
	}
	public void saveUserChat(UserChat userChat)
	{
		ChatDAO chatDAO = new ChatDAO();
		chatDAO.saveUserChat(userChat);
		
	}
	public void saveChat(Chat chat)
	{
		ChatDAO chatDAO = new ChatDAO();
		chatDAO.saveChat(chat);
	}
	public Chat getChat(int chatIdno)
	{
		ChatDAO chatDAO = new ChatDAO();
		return chatDAO.getChat(chatIdno);
	}
	public List<Chat> getChatTo(int toUser,int fromUser)
	{
		ChatDAO chatDAO = new ChatDAO();
		return chatDAO.getChatTo(toUser, fromUser);
	}
	public List<Chat> getChatFrom(int fromUser)
	{
		ChatDAO chatDAO = new ChatDAO();
		return chatDAO.getChatFrom(fromUser);
	}
}

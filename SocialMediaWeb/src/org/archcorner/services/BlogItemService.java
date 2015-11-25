/**
 * 
 */
package org.archcorner.services;


import java.util.List;

import org.archcorner.dal.dao.BlogItemDAO;
import org.archcorner.pojo.Blog;
import org.archcorner.pojo.BlogItem;

/**
 * @author bhagvan_kommadi
 *
 */
public class BlogItemService {
	
	public int getHighestId()
    {
		BlogItemDAO blogItemDAO = new BlogItemDAO();
		return blogItemDAO.getHighestId();
    }
	public void saveBlogItem(BlogItem blogItem)
	{
		BlogItemDAO blogItemDAO = new BlogItemDAO();
		blogItemDAO.saveBlogItem(blogItem);
	}
	public void deleteBlogItem(BlogItem blogItem)
	{
		BlogItemDAO blogItemDAO = new BlogItemDAO();
		blogItemDAO.deleteBlogItem(blogItem);
	}
	public void updateBlogItem(BlogItem blogItem)
	{
		BlogItemDAO blogItemDAO = new BlogItemDAO();
		blogItemDAO.updateBlogItem(blogItem);
	}
	public List<BlogItem> getBlogItems(Blog blog)
	{
		BlogItemDAO blogItemDAO = new BlogItemDAO();
		return blogItemDAO.getBlogItems(blog);
	}
	
	public BlogItem getBlogItem(int blogItemId)
	{
		BlogItemDAO blogItemDAO = new BlogItemDAO();
		return blogItemDAO.getBlogItem(blogItemId);
	}
	
}

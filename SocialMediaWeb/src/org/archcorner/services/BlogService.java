/**
 * 
 */
package org.archcorner.services;


import java.util.List;

import org.archcorner.dal.dao.BlogDAO;
import org.archcorner.pojo.Blog;

/**
 * @author bhagvan_kommadi
 *
 */
public class BlogService {
	
	public int getHighestId()
    {
		BlogDAO blogDAO = new BlogDAO();
		return blogDAO.getHighestId();
    }
	
	public void saveBlog(Blog blog)
	{
		BlogDAO blogDAO = new BlogDAO();
		blogDAO.saveBlog(blog);
	}
	public List<Blog> getBlogs(int siteIdNo)
	{
		BlogDAO blogDAO = new BlogDAO();
		return blogDAO.getBlogs(siteIdNo);
	}
	public Blog getBlog(int blogIdNo)
	{
		BlogDAO blogDAO = new BlogDAO();
		return blogDAO.getBlog(blogIdNo);
	}
}

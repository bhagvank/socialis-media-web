/**
 * 
 */
package org.archcorner.services;

import java.util.List;

import org.archcorner.dal.dao.SiteDAO;
import org.archcorner.pojo.Site;
/**
 * @author bhagvan_kommadi
 *
 */
public class SiteService {

	public int getHighestId()
	{
		SiteDAO siteDAO = new SiteDAO();
		return siteDAO.getHighestId();
		
	}
	public void saveSite(Site site)
	{
		SiteDAO siteDAO = new SiteDAO();
		 siteDAO.saveSite(site);
	}
	public List<Site> getSites(int user)
	{
		SiteDAO siteDAO = new SiteDAO();
		return siteDAO.getSites(user);
	}
	public Site getSite(int siteIdNo)
	{
		SiteDAO siteDAO = new SiteDAO();
		return siteDAO.getSite(siteIdNo);
	}
}

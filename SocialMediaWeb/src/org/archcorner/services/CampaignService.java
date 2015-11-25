/**
 * 
 */
package org.archcorner.services;

import java.util.List;

import org.archcorner.dal.dao.CampaignDAO;
import org.archcorner.pojo.Campaign;
import org.archcorner.pojo.CustomerCampaign;

/**
 * @author bhagvan_kommadi
 *
 */
public class CampaignService {
	
	public Campaign getCampaign(int campaignId)
	{
		CampaignDAO campaignDAO = new CampaignDAO();
		return campaignDAO.getCampaign(campaignId);
	}
	
	public void deleteCampaign(Campaign campaign)
	{
		CampaignDAO campaignDAO = new CampaignDAO();
		campaignDAO.deleteCampaign(campaign);
	}

	public void updateCampaign(Campaign campaign)
	{
		CampaignDAO campaignDAO = new CampaignDAO();
		campaignDAO.updateCampaign(campaign);
	}
	public List<Campaign> getCampaigns(int site)
	{
		CampaignDAO campaignDAO = new CampaignDAO();
		return campaignDAO.getCampaigns(site);
	}
	public void saveCampaign(Campaign campaign)
    {
		CampaignDAO campaignDAO = new CampaignDAO();
		campaignDAO.saveCampaign(campaign);
    }
	public void saveCustomerCampaign(CustomerCampaign customerCampaign)
    {
		CampaignDAO campaignDAO = new CampaignDAO();
		campaignDAO.saveCustomerCampaign(customerCampaign);
    }
	public int getHighestId()
    {
		CampaignDAO campaignDAO = new CampaignDAO();
		return campaignDAO.getHighestId();
    }
	public int getHighestCustomerCampaignId()
    {
		CampaignDAO campaignDAO = new CampaignDAO();
		return campaignDAO.getHighestCustomerCampaignId();
		
    }
}

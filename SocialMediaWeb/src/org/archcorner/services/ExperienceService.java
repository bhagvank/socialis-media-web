/**
 * 
 */
package org.archcorner.services;

import java.util.List;

import org.archcorner.dal.dao.CustomerDAO;
import org.archcorner.dal.dao.ExperienceDAO;
import org.archcorner.pojo.Experience;
/**
 * @author bhagvan_kommadi
 *
 */
public class ExperienceService {
	
	public int getHighestId()
    {
		ExperienceDAO experienceDAO = new ExperienceDAO();
		return experienceDAO.getHighestId();
    }
	public void saveExperience(Experience experience)
	{
		ExperienceDAO experienceDAO = new ExperienceDAO();
		experienceDAO.saveExperience(experience);
	}

	public List<Experience> getExperiences(int siteIdNo)
	{
		ExperienceDAO experienceDAO = new ExperienceDAO();
		return experienceDAO.getExperiences(siteIdNo);
		
	}
	public void deleteExperience(Experience experience)
	{
		ExperienceDAO experienceDAO = new ExperienceDAO();
		experienceDAO.deleteExperience(experience);
	}
	public void updateExperience(Experience experience)
	{
		ExperienceDAO experienceDAO = new ExperienceDAO();
		experienceDAO.updateExperience(experience);
	}
}

package org.archcorner.pojo;

public class Campaign {

	private int campaignId;
	private String campaignName;
	private String campaignText;
	private int siteId;
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getCampaignText() {
		return campaignText;
	}
	public void setCampaignText(String campaignText) {
		this.campaignText = campaignText;
	}

}

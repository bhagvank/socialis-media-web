package org.archcorner.pojo;

public class BlogItem {
	
	private int blogItemId;
	
	public int getBlogItemId() {
		return blogItemId;
	}

	public void setBlogItemId(int blogItemId) {
		this.blogItemId = blogItemId;
	}

	public String getBlogItemTitle() {
		return blogItemTitle;
	}

	public void setBlogItemTitle(String blogItemTitle) {
		this.blogItemTitle = blogItemTitle;
	}

	public String getBlogItem() {
		return blogItem;
	}

	public void setBlogItem(String blogItem) {
		this.blogItem = blogItem;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	private String blogItemTitle;
	
	private String blogItem;
	
	private int blogId;

}

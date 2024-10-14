package entity;

public class News {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String title;
	private String content;
	private String image_url;

	public News(int id, String title, String content, String image_url) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.image_url = image_url;
	}

	public News() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

}

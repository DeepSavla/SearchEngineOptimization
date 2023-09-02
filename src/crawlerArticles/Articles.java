package crawlerArticles;

public class Articles {

	public String title = "";
	public String content = "";
        public String OG_content = "";

	Articles(String title, String content,String OG_content) {
		this.title = title;
		this.content = content;
                this.OG_content = OG_content;
	}

	public String getTitle() {
		return title;
	}
        public String getOG_content() {
		return OG_content;
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
        
        
        public void setOG_content(String OG_content) {
		this.OG_content = OG_content;
	}

}

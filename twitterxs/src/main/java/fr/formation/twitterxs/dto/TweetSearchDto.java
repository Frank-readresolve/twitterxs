package fr.formation.twitterxs.dto;

public class TweetSearchDto implements Dto {

    private static final long serialVersionUID = 7157469454293666128L;

    private String username;

    private int page;

    private int size;

    /**
     * Creates a new {@code TweetSeachDto} with default values.
     */
    public TweetSearchDto() {
	// Default no-arg constructor
    }

    public TweetSearchDto(String username, int page, int size) {
	setUsername(username);
	setSize(size);
	setPage(page);
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public int getSize() {
	return size;
    }

    public void setSize(int size) {
	this.size = size;
    }

    @Override
    public String toString() {
	return "{username=" + username + ", page=" + page + ", size=" + size
		+ "}";
    }
}

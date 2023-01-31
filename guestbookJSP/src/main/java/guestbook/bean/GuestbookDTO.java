package guestbook.bean;

public class GuestbookDTO {
	
	private int seq;
	private String name, email, homepage, subject, contents, logtime;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public GuestbookDTO(int seq, String name, String email, String homepage, String subject, String contents,
			String logtime) {
		super();
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.homepage = homepage;
		this.subject = subject;
		this.contents = contents;
		this.logtime = logtime;
	}

	public GuestbookDTO(String name, String email, String homepage, String subject, String contents, String logtime) {
		super();
	
		this.name = name;
		this.email = email;
		this.homepage = homepage;
		this.subject = subject;
		this.contents = contents;
		this.logtime = logtime;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	

	public GuestbookDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}

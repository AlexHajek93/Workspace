package ers.beans;

import java.sql.Date;

public class ErsReimbursement {
	private int id;
	private int amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private Object receipt;
	private ErsUser author;
	private ErsUser resolver;
	private ErsStatus status;
	private ErsType type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getReceipt() {
		return receipt;
	}
	public void setReceipt(Object receipt) {
		this.receipt = receipt;
	}
	public ErsUser getAuthor() {
		return author;
	}
	public void setAuthor(ErsUser author) {
		this.author = author;
	}
	public ErsUser getResolver() {
		return resolver;
	}
	public void setResolver(ErsUser resolver) {
		this.resolver = resolver;
	}
	public ErsStatus getStatus() {
		return status;
	}
	public void setStatus(ErsStatus status) {
		this.status = status;
	}
	public ErsType getType() {
		return type;
	}
	public void setType(ErsType type) {
		this.type = type;
	}
	public ErsReimbursement() {
		super();
	}
	public ErsReimbursement(int id, int amount, Date submitted, ErsUser author, ErsStatus status, ErsType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	public ErsReimbursement(int id, int amount, Date submitted, Date resolved, String description, Object receipt,
	    ErsUser author, ErsUser resolver, ErsStatus status, ErsType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	@Override
	public String toString() {
		return "ErsReimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
		    + ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver=" + resolver
		    + ", status=" + status + ", type=" + type + "]";
	}	
}

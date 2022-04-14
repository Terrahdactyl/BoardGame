package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "gameName")
	private Integer gameName;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "review")
	private String review;

	public Feedback() {
	}

	public Feedback(Integer gameName, Integer rating, String review) {
		super();
		this.gameName = gameName;
		this.rating = rating;
		this.review = review;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGameName() {
		return gameName;
	}

	public void setGameName(Integer gameName) {
		this.gameName = gameName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", gameName=" + gameName + ", rating=" + rating + ", review=" + review + "]";
	}

}

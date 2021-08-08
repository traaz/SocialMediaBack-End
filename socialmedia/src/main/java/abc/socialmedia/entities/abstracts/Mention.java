package abc.socialmedia.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mentions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mention {
	@Id
	@Column(name="mention_id")
	private int mentionId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private Post postId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private User userId;
	
	@Column(name="mention_text")
	private String text;
	

}

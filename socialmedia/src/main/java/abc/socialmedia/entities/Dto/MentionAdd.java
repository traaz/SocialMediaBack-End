package abc.socialmedia.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentionAdd {
	private int mentionId;
	private int postId;
	private int userId;
	private String text;

}

package abc.socialmedia.business.abstracts;

import java.util.List;

import abc.socialmedia.core.utilities.results.DataResult;
import abc.socialmedia.core.utilities.results.Result;
import abc.socialmedia.entities.Dto.MentionAdd;
import abc.socialmedia.entities.abstracts.Mention;

public interface MentionService {
	DataResult<List<Mention>> getAll();
	Result add(MentionAdd mentionAdd);
	DataResult<List<Mention>> findByPostId(int postId);
    Result deleteMention(int mentionId);
}

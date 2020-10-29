package cn.weforward.comment;

import cn.weforward.comment.impl.SimpleComment;
import cn.weforward.common.ResultPage;

public interface CommentService {
	
	
	/**
	 * 新建一个评论
	 */
	Comment createComment(String content,String sourceId);
	/**
	 * 根据任务id查询评论
	 */
	ResultPage<SimpleComment> searchCommentsBySourceId(String sourceId);
	/**
	 * 查询所有评论
	 */
//	ResultPage<SimpleComment> searchAllComments();
}

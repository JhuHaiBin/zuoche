package cn.weforward.comment.impl;


import cn.weforward.comment.Comment;
import cn.weforward.comment.CommentService;
import cn.weforward.common.ResultPage;
import cn.weforward.data.log.BusinessLoggerFactory;
import cn.weforward.data.persister.PersisterFactory;

public class CommentServiceImpl extends CommentDiImpl implements CommentService{

	public CommentServiceImpl(PersisterFactory factory,
			BusinessLoggerFactory loggerFactory) {
		super(factory,loggerFactory);
	}

	@Override
	public Comment createComment(String content, String sourceId) {
		
		return new SimpleComment(this, content, sourceId);
	}

	@Override
	public ResultPage<SimpleComment> searchCommentsBySourceId(String sourceId) {
		ResultPage<SimpleComment> rp = m_PsComment.startsWith(sourceId);
		return rp;
	}

}

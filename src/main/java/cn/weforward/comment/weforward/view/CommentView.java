package cn.weforward.comment.weforward.view;

import java.util.Date;

import cn.weforward.comment.Comment;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocObject;

@DocObject(description = "comment视图")
public class CommentView {
	Comment m_Comment;
	
	public CommentView(Comment comment) {
		m_Comment = comment;
	}
	
	public static CommentView valueOf(Comment comment) {
		return null == comment?null:new CommentView(comment);
	}
	
	@DocAttribute(description = "评论Id")
	public String getId() {
		return m_Comment.getId().getOrdinal();
	}
	@DocAttribute(description = "评论人")
	public String getUserName() {
		return m_Comment.getUserName();
	}
	@DocAttribute(description = "评论内容")
	public String getContent() {
		return m_Comment.getContent();
	}
	@DocAttribute(description = "评论时间")
	public Date getCreateTime() {
		return m_Comment.getCreateTime();
	}
}

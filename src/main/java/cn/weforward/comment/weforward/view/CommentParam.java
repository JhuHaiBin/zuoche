package cn.weforward.comment.weforward.view;

import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocObject;


@DocObject(description = "评论参数")
public class CommentParam {
	String m_Content;
	String m_SourceId;
	
	@DocAttribute(necessary = true, description = "评论内容", example = "XXX")
	public String getContent() {
		return m_Content;
	}
	public void setContent(String content) {
		m_Content = content;
	}
	
	@DocAttribute(necessary = true, description = "评论源id", example = "123")
	public String getSourceId() {
		return m_SourceId;
	}
	public void setSourceId(String sourceId) {
		m_SourceId = sourceId;
	}
}

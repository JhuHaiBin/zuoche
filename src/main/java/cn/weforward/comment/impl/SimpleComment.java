package cn.weforward.comment.impl;

import java.util.Date;

import javax.annotation.Resource;

import cn.weforward.comment.Comment;
import cn.weforward.comment.di.CommentDi;
import cn.weforward.data.UniteId;
import cn.weforward.data.persister.support.AbstractPersistent;
import cn.weforward.framework.support.Global;

public class SimpleComment extends AbstractPersistent<CommentDi> implements Comment{
	@Resource
	String m_Content;
	@Resource
	String m_UserName;
	@Resource
	Date m_CreateTime;

	
	protected SimpleComment(CommentDi di,String content,String sourceId) {
		super(di);
		genPersistenceId(sourceId);
		
		m_Content = content;
		m_UserName = Global.TLS.getValue("user");
		m_CreateTime = new Date();
		markPersistenceUpdate();
	}
	
	protected SimpleComment(CommentDi di) {
		super(di);
	}

	@Override
	public String getContent() {
		return m_Content;
	}

	@Override
	public Date getCreateTime() {
		return m_CreateTime;
	}

	@Override
	public String getUserName() {
		return m_UserName;
	}

	@Override
	public UniteId getId() {
		return getPersistenceId();
	}
	
	
}

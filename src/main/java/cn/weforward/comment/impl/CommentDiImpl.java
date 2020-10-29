package cn.weforward.comment.impl;

import cn.weforward.comment.di.CommentDi;
import cn.weforward.data.counter.CounterFactory;
import cn.weforward.data.log.BusinessLogger;
import cn.weforward.data.log.BusinessLoggerFactory;
import cn.weforward.data.persister.Persistent;
import cn.weforward.data.persister.Persister;
import cn.weforward.data.persister.PersisterFactory;

public class CommentDiImpl implements CommentDi{

	protected Persister<SimpleComment> m_PsComment;
	protected PersisterFactory m_Factory;
	
	public CommentDiImpl(PersisterFactory factory,BusinessLoggerFactory loggerFactory) {
		m_Factory = factory;
		m_PsComment = factory.createPersister(SimpleComment.class, this);
	}
	
	@Override
	public <E extends Persistent> Persister<E> getPersister(Class<E> clazz) {
		// TODO Auto-generated method stub
		return m_Factory.getPersister(clazz);
	}

}

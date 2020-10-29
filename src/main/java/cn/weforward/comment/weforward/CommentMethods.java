package cn.weforward.comment.weforward;

import javax.annotation.Resource;

import cn.weforward.comment.Comment;
import cn.weforward.comment.CommentService;
import cn.weforward.comment.impl.SimpleComment;
import cn.weforward.comment.weforward.view.CommentParam;
import cn.weforward.comment.weforward.view.CommentView;
import cn.weforward.common.ResultPage;
import cn.weforward.common.util.TransResultPage;
import cn.weforward.framework.ApiException;
import cn.weforward.framework.WeforwardMethod;
import cn.weforward.framework.WeforwardMethods;
import cn.weforward.framework.doc.DocMethods;
import cn.weforward.framework.util.ValidateUtil;
import cn.weforward.protocol.client.util.IdBean;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocMethod;
import cn.weforward.protocol.doc.annotation.DocParameter;

/**  
 * comment接口
 *
 */
@DocMethods(index = 100)
@WeforwardMethods
public class CommentMethods {
	@Resource
	CommentService m_Service;
	
	@WeforwardMethod
	@DocMethod(description = "发布一个评论")
	public CommentView createComment(CommentParam params) throws ApiException{
		String content = params.getContent();
		String sourceId = params.getSourceId();
		ValidateUtil.isEmpty(content, "评论内容不能为空");
		ValidateUtil.isEmpty(sourceId, "评论源id不能为空");
		
		Comment comment = m_Service.createComment(content, sourceId);
		return CommentView.valueOf(comment);
	}
	@WeforwardMethod
	@DocParameter({@DocAttribute(name = "id", type = String.class, necessary = true, description = "源id"),
				@DocAttribute(name = "page", type = Integer.class, necessary = false, description = "第几页"),
				@DocAttribute(name = "pageSize", type = Integer.class, necessary = false, description = "一页数据大小")})
	@DocMethod(description = "根据源id查询评论")
	public ResultPage<CommentView> searchCommentBySourceId(IdBean params)throws ApiException{
		String sourceId = params.getId();
		ValidateUtil.isEmpty(sourceId, "id不能为空");
		ResultPage<SimpleComment> rp = m_Service.searchCommentsBySourceId(sourceId);
		
		return new TransResultPage<CommentView, SimpleComment>(rp) {
			@Override
			protected CommentView trans(SimpleComment src) {
				// TODO Auto-generated method stub
				return CommentView.valueOf(src);
			}
			
		};
	}
//	@WeforwardMethod
//	@DocParameter({@DocAttribute(name = "page", type = Integer.class, necessary = false, description = "第几页"),
//					@DocAttribute(name = "pageSize", type = Integer.class, necessary = false, description = "一页数据大小")})
//	@DocMethod(description = "查询所有评论")
//	public ResultPage<CommentView> searchAllComment()throws ApiException{
//		ResultPage<SimpleComment> rp = m_Service.searchAllComments();
//		
//		return new TransResultPage<CommentView, SimpleComment>(rp) {
//			@Override
//			protected CommentView trans(SimpleComment src) {
//				// TODO Auto-generated method stub
//				return CommentView.valueOf(src);
//			}
//			
//		};
//	}
}

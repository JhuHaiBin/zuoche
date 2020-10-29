package cn.weforward.comment;

import java.util.Date;

import cn.weforward.data.UniteId;

public interface Comment {
	
	
	
	String getContent();
	
	Date getCreateTime();
	
	String getUserName();
	
	UniteId getId();
	
}

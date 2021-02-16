package notice.dao;

import java.util.List;

import notice.vo.NoticeVO;

public interface NoticeDAO {
	NoticeVO getNotice(int no);
	
	List<NoticeVO> getNotices();
	
	int insertNotice(NoticeVO notice);
	
	int updateNotice(NoticeVO notice);
	
	int deleteNotice(int no);
}

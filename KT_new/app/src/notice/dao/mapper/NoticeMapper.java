package notice.dao.mapper;

import java.util.List;

import notice.vo.NoticeVO;

public interface NoticeMapper {
	NoticeVO selectNoticeByNo(int no);
	
	List<NoticeVO> selectNoticeList();

	int insertNotice(NoticeVO notice);

	int updateNotice(NoticeVO notice);

	int deleteNotice(int no);
}

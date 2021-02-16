package notice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import notice.dao.mapper.NoticeMapper;
import notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public NoticeVO getNotice(int no) {
		// TODO Auto-generated method stub
		return mapper.selectNoticeByNo(no);
	}

	public NoticeDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NoticeVO> getNotices() {
		// TODO Auto-generated method stub
		return mapper.selectNoticeList();
	}

	@Override
	public int insertNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		return mapper.insertNotice(notice);
	}

	@Override
	public int updateNotice(NoticeVO notice) {
		// TODO Auto-generated method stub
		return mapper.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int no) {
		// TODO Auto-generated method stub
		return mapper.deleteNotice(no);
	}

}

package com.klef.jfsd.springboot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Notice;
import com.klef.jfsd.springboot.repository.CounsellerRepository;
import com.klef.jfsd.springboot.repository.NoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
	private CounsellerRepository counsellerRepository;
    public Notice addNotice(Notice notice) {
    	notice.setPublishedDate(LocalDateTime.now());
        return noticeRepository.save(notice);
    }
    public List<Notice> viewNotices(int cid)
    {
    	return noticeRepository.listNotices(cid);
    }
    public Notice getNoticeById(Long id) throws NotFoundException {
        Optional<Notice> optionalNotice = noticeRepository.findById(id);
        if (optionalNotice.isPresent()) {
            return optionalNotice.get();
        } else {
            // Handle the case where the notice with the given ID is not found
            throw new NotFoundException();
        }
    }
}

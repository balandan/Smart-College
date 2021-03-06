package com.smartcollege.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcollege.dao.AnnouncementRepository;
import com.smartcollege.models.Announcement;

@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementRepository announcementRepo;
	
	public Collection<Announcement> findAllAnnouncements()
	{
		List <Announcement> announcements = new ArrayList<Announcement>();
		for(Announcement announcement : announcementRepo.findAll()){
			announcements.add(announcement);
		}
		Collections.reverse(announcements);
		return announcements;
	}
	
	public void addAnnouncement(Announcement announcement)
	{
		announcementRepo.save(announcement);
	}
	
	public void deleteAnnouncement(int id)
	{
		announcementRepo.deleteById(id);
	}
	
	public Announcement findAnnouncement(int id)
	{
		return announcementRepo.findById(id);
	}
}

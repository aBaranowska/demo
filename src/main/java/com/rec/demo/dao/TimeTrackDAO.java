package com.rec.demo.dao;

import java.util.List;

import com.rec.demo.entity.TimeTrackEntity;

public interface TimeTrackDAO {

	List<TimeTrackEntity> getAllTimeTracks();

	void addTimeTrack(final TimeTrackEntity timeTrack);

}

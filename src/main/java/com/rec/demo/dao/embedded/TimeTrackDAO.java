package com.rec.demo.dao.embedded;

import java.util.List;

import com.rec.demo.entity.embedded.TimeTrackEntity;

public interface TimeTrackDAO {

	List<TimeTrackEntity> getAllTimeTracks();

	void addTimeTrack(final TimeTrackEntity timeTrack);

}

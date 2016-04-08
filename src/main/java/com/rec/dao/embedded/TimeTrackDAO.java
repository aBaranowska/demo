package com.rec.dao.embedded;

import java.util.List;

import com.rec.entity.embedded.TimeTrackEntity;

public interface TimeTrackDAO {

	List<TimeTrackEntity> getAllTimeTracks();

	void addTimeTrack(final TimeTrackEntity timeTrack);

}

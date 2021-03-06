package com.rec.dao.embedded;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rec.entity.embedded.TimeTrackEntity;

@Repository
public class TimeTrackDAOImpl extends BaseDAOImpl implements TimeTrackDAO {

	public List<TimeTrackEntity> getAllTimeTracks() {
		TypedQuery<TimeTrackEntity> query = entityManager.createQuery("from TimeTrackEntity", TimeTrackEntity.class);
		return query.getResultList();
	}

	public void addTimeTrack(final TimeTrackEntity timeTrack) {
		entityManager.persist(timeTrack);
	}

}

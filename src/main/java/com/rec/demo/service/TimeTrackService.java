package com.rec.demo.service;

import com.rec.demo.dto.TimeTrackDTO;
import com.rec.demo.service.exception.TimeTrackServiceException;

public interface TimeTrackService {

	void processTimeTrack(final TimeTrackDTO timeTrackDTO) throws TimeTrackServiceException;

	String getFirstName(final String user);

	String getLastName(final String user);

	String getLogin(final String user);

}

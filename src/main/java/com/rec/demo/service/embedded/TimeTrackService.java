package com.rec.demo.service.embedded;

import com.rec.demo.dto.TimeTrackDTO;
import com.rec.demo.exception.TimeTrackServiceException;

public interface TimeTrackService {

	void processTimeTrack(final TimeTrackDTO timeTrackDTO) throws TimeTrackServiceException;

	String getFirstName(final String user);

	String getLastName(final String user);

	String getLogin(final String user);

}

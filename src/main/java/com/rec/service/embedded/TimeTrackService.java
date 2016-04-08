package com.rec.service.embedded;

import com.rec.dto.TimeTrackDTO;
import com.rec.exception.TimeTrackServiceException;

public interface TimeTrackService {

	void processTimeTrack(final TimeTrackDTO timeTrackDTO) throws TimeTrackServiceException;

	String getFirstName(final String user);

	String getLastName(final String user);

	String getLogin(final String user);

}

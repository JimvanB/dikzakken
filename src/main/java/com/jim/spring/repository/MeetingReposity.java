package com.jim.spring.repository;

import com.jim.spring.domain.Deelnemer;
import com.jim.spring.domain.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jim on 10-11-17.
 */
@Repository
public interface MeetingReposity extends CrudRepository<Meeting, Long> {
}

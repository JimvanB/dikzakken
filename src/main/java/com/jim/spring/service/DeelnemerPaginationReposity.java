package com.jim.spring.service;

import com.jim.spring.domain.Deelnemer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jim on 12-12-17.
 */
@Repository
public interface DeelnemerPaginationReposity extends PagingAndSortingRepository<Deelnemer, Long> {

    @Query("select d from Deelnemer d")
    Page<Deelnemer> getDeelnemerByPage(Pageable pageable);

}

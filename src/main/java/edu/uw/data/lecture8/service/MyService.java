package edu.uw.data.lecture8.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Conor on 5/26/2015.
 */
@Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.READ_COMMITTED)
public class MyService {
}

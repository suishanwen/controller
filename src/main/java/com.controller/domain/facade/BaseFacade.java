package com.controller.domain.facade;


import javax.inject.Inject;
import javax.persistence.EntityManager;


public class BaseFacade {
    @Inject
    protected EntityManager entityManager;

}

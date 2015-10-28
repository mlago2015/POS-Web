/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mlago
 */
@Stateless
public class LogSysFacade extends AbstractFacade<LogSys> {
    @PersistenceContext(unitName = "POS-WebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogSysFacade() {
        super(LogSys.class);
    }
    
}

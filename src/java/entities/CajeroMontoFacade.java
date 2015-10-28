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
public class CajeroMontoFacade extends AbstractFacade<CajeroMonto> {
    @PersistenceContext(unitName = "POS-WebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajeroMontoFacade() {
        super(CajeroMonto.class);
    }
    
}

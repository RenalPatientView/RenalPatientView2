package com.worthsoln.database.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.Action;
import org.dasein.persist.MockSequencer;
import org.dasein.persist.PersistenceException;
import org.dasein.persist.Sequencer;
import org.dasein.persist.SequencerInterface;
import com.worthsoln.MockHolder;
import com.worthsoln.database.DatabaseDAO;

public abstract class DatabaseAction extends Action {

    public DatabaseAction() {
    }

    public abstract String getIdentifier();

    public abstract String getDatabaseName();

    protected DatabaseDAO getDao(HttpServletRequest request) throws Exception {
        if (request.getParameter("useMockDao") != null) {
            DatabaseDAO mockDao = (DatabaseDAO) MockHolder.getInstance().getMock(getIdentifier());
            if (mockDao == null) {
                throw new Exception("MockHolder does not contain a mock called " + getIdentifier());
            }
            return mockDao;
        }
        return new DatabaseDAO(getDatabaseName());
    }

    private SequencerInterface getSequencer(HttpServletRequest request) {
        if (request.getParameter("useMockDao") != null) {
            return new MockSequencer();
        }
        return Sequencer.getInstance(getIdentifier(), getDatabaseName());
    }

    private SequencerInterface getSequencer(HttpServletRequest request, String identifier) {
        if (request.getParameter("useMockDao") != null) {
            return new MockSequencer();
        }
        return Sequencer.getInstance(identifier, getDatabaseName());
    }

    protected int getNextInSequence(HttpServletRequest request) throws PersistenceException {
        SequencerInterface sequencer = getSequencer(request);
        long next = nonZeroSequence(sequencer);
        return (new Long(next)).intValue();
    }

    protected int getNextInSequence(HttpServletRequest request, String identifier) throws PersistenceException {
        SequencerInterface sequencer = getSequencer(request, identifier);
        long next = nonZeroSequence(sequencer);
        return (new Long(next)).intValue();
    }

    private long nonZeroSequence(SequencerInterface sequencer) throws PersistenceException {
        long next = sequencer.next();
        if (next == 0) {
            next = sequencer.next();
        }
        return next;
    }
}

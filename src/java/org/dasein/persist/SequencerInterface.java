package org.dasein.persist;

public interface SequencerInterface {

    long next() throws PersistenceException;
}

package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Terminal;

/**
 * Created by coreI7 on 30/04/2017.
 */
public interface TerminalService {

    Iterable<Terminal> listAllTerminals();

    Terminal getTerminalById(Integer id);

    Terminal saveTerminal(Terminal terminal);

    void deleteTerminal(Integer id);
}

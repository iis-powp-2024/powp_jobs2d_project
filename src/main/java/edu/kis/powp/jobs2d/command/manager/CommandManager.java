package edu.kis.powp.jobs2d.command.manager;

import java.util.Iterator;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.observer.Publisher;

/**
 * Command Manager.
 */
public class CommandManager {
    private DriverCommand currentCommand = null;

    private Publisher changePublisher = new Publisher();

    /**
     * Set current command.
     *
     * @param commandList Set the command as current.
     */
    public synchronized void setCurrentCommand(DriverCommand commandList) {
        this.currentCommand = commandList;
        changePublisher.notifyObservers();
    }

    /**
     * Set current command.
     *
     * @param commandList list of commands representing a compound command.
     * @param name        name of the command.
     */
    public synchronized void setCurrentCommand(List<DriverCommand> commandList, String name) {
        CompoundCommand compoundCommand = new CompoundCommand(name);
        compoundCommand.addCommands(commandList);
        setCurrentCommand(compoundCommand);
    }

    /**
     * Return current command.
     *
     * @return Current command.
     */
    public synchronized DriverCommand getCurrentCommand() {
        return currentCommand;
    }

    public synchronized void clearCurrentCommand() {
        currentCommand = null;
    }

    public synchronized String getCurrentCommandString() {
        if (getCurrentCommand() == null) {
            return "No command loaded";
        } else
            return getCurrentCommand().toString();
    }

    public Publisher getChangePublisher() {
        return changePublisher;
    }
}

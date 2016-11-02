package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by ilya on 05.04.2015.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}

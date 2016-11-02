package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by ilya on 05.04.2015.
 */
class InfoCommand  implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() throws InterruptOperationException
    {
            boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
            for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators())
            {
                if (manipulator.hasMoney())
                {
                    if (manipulator.getTotalAmount() > 0)
                    {
                        ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                        money = true;
                    }
                }
            }
            if (!money)
                ConsoleHelper.writeMessage(res.getString("no.money"));

    }
}

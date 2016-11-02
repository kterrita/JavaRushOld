package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilya on 05.04.2015.
 */
public class ConsoleHelper
{
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";
        try
        {
            message = reader.readLine();
            if (message.equalsIgnoreCase(res.getString("operation.EXIT")))
                throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode;
        while (true)
        {
            currencyCode = readString();
            if (currencyCode.length() == 3)
            {
                break;
            } else
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] data;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true)
        {
            data = readString().split(" ");
            int nominal = 0;
            int quantity = 0;
            try
            {
                nominal = Integer.parseInt(data[0]);
                quantity = Integer.parseInt(data[1]);
            }
            catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (nominal <= 0 || quantity <= 0 || data.length > 2)
            {
                continue;
            }
            break;
        }
        return data;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.INFO") + " - 1, " + res.getString("operation.DEPOSIT") + " - 2, "
         + res.getString("operation.WITHDRAW") + " - 3, " + res.getString("operation.EXIT") + " - 4");
        while (true)
        {
            String opString = readString();
            if (checkWithRegExp(opString))
            {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(opString));
            } else
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }

}

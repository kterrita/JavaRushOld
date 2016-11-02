package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;

/* Смена кодировки
В метод main первым параметром приходит имя файла,
                тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла,
                в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "Windows-1251"));

        ArrayList<String> list = new ArrayList<>();
        while (br.ready())
        {
            list.add(br.readLine());
        }
        br.close();

        for (String lane : list)
        {
            bw.write(lane);
        }
        bw.close();
    }
}

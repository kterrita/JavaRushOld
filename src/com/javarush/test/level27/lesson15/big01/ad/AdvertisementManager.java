package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ilya on 21.04.2015.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements = new ArrayList<>(storage.list());

        //бросаем ошибку для пустого листа
        if (advertisements.isEmpty()) throw new NoVideoAvailableException();


        //Список воспроизводимой рекламы для конкретного заказа
        List<Advertisement> toPlay = getTheMostExpensiveAdvertisements(advertisements, timeSeconds);

        //бросаем ошибку, если нет подходящей рекламы
        if(toPlay.isEmpty()) throw new NoVideoAvailableException();


        Collections.sort(advertisements, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                else {
                    long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                    long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    return Long.compare(oneSecondCost1, oneSecondCost2);
                }
            }
        });

        //показ рекламы
        for (Advertisement advertisement : toPlay) {
                advertisement.revalidate();
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        advertisement.getName(),
                        advertisement.getAmountPerOneDisplaying(),
                        advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));

        }
    }

    public List<Advertisement> getTheMostExpensiveAdvertisements(List<Advertisement> fullList, int timeLeft){
        if(fullList.isEmpty() || timeLeft <= 0) return new ArrayList<>();

        return  null;
    }

}

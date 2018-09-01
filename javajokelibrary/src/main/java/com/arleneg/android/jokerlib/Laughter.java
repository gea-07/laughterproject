package com.arleneg.android.jokerlib;


import java.util.ArrayList;
import java.util.Random;


public class Laughter {
    
    ArrayList<String> mLaughterList = new ArrayList<String>();

    public Laughter() {
        // Joke excerpts taken from National Geographics Kids Just Joking 6 book
        mLaughterList.add("What kind of car does an insect drive? " + "A Volkswagen Beetle");

        mLaughterList.add("What do you get when you cross a lamb and Japanese food? " +
                "Susheep");

        mLaughterList.add("Why is a frog always happy? " + "It eats whatever bugs him.");

        mLaughterList.add("What do you get if you cross a singer and a herb? " +
                "Elvis Parsley");

        mLaughterList.add ("How can you tell if a wedding cake is sad? " +
                "It's in tiers!");

        mLaughterList.add ("What kind of monster lives near your stomach? " +
                "An abdominal snowman!");

        mLaughterList.add ("What do you get when you cross a frog and an automobile? " +
                "A car that can jumpstart itself");

        mLaughterList.add ("Where do fish post their photographs? " +
                "On Fin-stagram");

        mLaughterList.add ("What do skeletons say before they serve dinner? " +
                "Bone appetit!");

        mLaughterList.add ("Knock, knock. Who's there? Noah. Noah who? " +
                "I Noah a lot more jokes!");
    }

    public String getALaugh() {
        Random rn = new Random();
        int pickedJoke = rn.nextInt(mLaughterList.size());
        return mLaughterList.get(pickedJoke);
    }
}

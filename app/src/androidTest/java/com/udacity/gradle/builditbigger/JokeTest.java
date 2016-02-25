package com.udacity.gradle.builditbigger;

import android.support.v4.util.Pair;
import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Felipe Berbert on 20/02/2016.
 */
public class JokeTest extends AndroidTestCase implements IJokeFetcher {
    CountDownLatch signal;
    String joke;

    public void testAsyncTask(){
        signal = new CountDownLatch(1);
        new JokeAsyncTask().execute(new Pair<IJokeFetcher, Boolean>(this, true));
        try {
            signal.await();
            assertNotNull(joke);
            assertFalse(joke.isEmpty());

        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Override
    public void deliverJoke(String joke) {
        this.joke = joke;
        signal.countDown();
    }
}
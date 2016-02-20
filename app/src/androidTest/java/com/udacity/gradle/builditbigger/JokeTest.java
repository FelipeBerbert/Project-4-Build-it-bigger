package com.udacity.gradle.builditbigger;

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
        new JokeAsyncTask().execute(this);
        try {
            signal.await();
            assertNotNull(joke);
            assertFalse(joke.isEmpty());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deliverJoke(String joke) {
        this.joke = joke;
        signal.countDown();
    }
}
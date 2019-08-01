package com.example.demonytimes;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.os.Handler;
import android.os.Looper;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

/**
 * Created by: Ashwani Kumar
 * Date: 01-08-2019
 */
@RunWith(JUnit4.class)
public class NyTimesMostPopularViewModelTest {

    @Mock
    private NyTimesMostPopularViewModel viewModel;
    
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void testGetNyTimesMostPopularList() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                viewModel = new NyTimesMostPopularViewModel();
                Assert.assertNotNull(viewModel);
            }
        });
    }
}

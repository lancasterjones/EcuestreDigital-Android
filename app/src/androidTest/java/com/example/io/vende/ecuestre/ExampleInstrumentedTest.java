package com.example.io.vende.ecuestre;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation io.vende.ecuestredigitalpublicowebview, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under io.vende.ecuestredigitalpublicowebview.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.io.vende.ecuestre", appContext.getPackageName());
    }
}

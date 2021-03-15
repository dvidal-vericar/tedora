package org.vericar.tedora;

import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

class FirestoreScratch {
    @Test
    void testTutorial() throws IOException, InterruptedException {
        var options = FirestoreOptions
                .getDefaultInstance()
                .toBuilder()
                .setProjectId("taxationdb")
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
        var db = options.getService();
        var fake = new HashMap<String, Object>();
        fake.put("along", 20200900001L);
        fake.put("bigd", new BigDecimal("15.26"));
        fake.put("astr", "Hello there");
        var docRef = db.collection("mytest").document();
        var latch = new CountDownLatch(1);
        ApiFutures.addCallback(docRef.set(fake),
                new ApiFutureCallback<>() {
                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                        latch.countDown();
                    }

                    @Override
                    public void onSuccess(WriteResult result) {
                        System.out.println("SUCEED!");
                        latch.countDown();
                    }
                },
                Executors.newSingleThreadExecutor());
        latch.await();
        System.out.println(docRef.getId());
    }
}

package com.nicomahnic.javaoldproject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.text_view);
        new LoadConcreteDataTask(this).execute();
    }

    private void update(ConcreteData concreteData) {
        textView.setText(concreteData.getField1());
    }

    private static class LoadConcreteDataTask extends AsyncTask<Void, Void, ConcreteData> {
        private final WeakReference<MainActivity> mainActivityWeakReference;

        private LoadConcreteDataTask(MainActivity mainActivity) {
            this.mainActivityWeakReference = new WeakReference<>(mainActivity);
        }

        @Override
        protected ConcreteData doInBackground(Void... voids) {
            return new ConcreteRequest().execute();
        }

        @Override
        protected void onPostExecute(ConcreteData concreteData) {
            super.onPostExecute(concreteData);
            MainActivity mainActivity = mainActivityWeakReference.get();
            if(mainActivity != null && concreteData != null) {
                mainActivity.update(concreteData);
            }
        }
    }
}
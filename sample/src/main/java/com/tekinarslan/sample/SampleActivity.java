package com.tekinarslan.sample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import java.io.File;

/**
 * Created by selim_tekinarslan on 10.10.2014.
 */
public class SampleActivity extends Activity {
    private static final String TAG = "SampleActivity";
    private static final String SAMPLE_FILE = "sample.pdf";
    private static final String FILE_PATH = "filepath";
    private static final String SEARCH_TEXT = "text";
    private PdfFragment fragment;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = SampleActivity.this;
        openPdfWithFragment();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query)//burada klavyeden ara ya basiyor user
            {
                fragment.search(1, query);
                return true;
            }
        };
        searchView.setOnQueryTextListener(textChangeListener);
        return super.onCreateOptionsMenu(menu);
    }

    public void openPdfWithFragment() {
        fragment = new PdfFragment();
        Bundle args = new Bundle();
        args.putString(FILE_PATH, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + SAMPLE_FILE);
        fragment.setArguments(args);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

}

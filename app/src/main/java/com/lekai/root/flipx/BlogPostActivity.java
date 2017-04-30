package com.lekai.root.flipx;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BlogPostActivity extends AppCompatActivity {
    @InjectView(R.id.blog_image)
    ImageView blogImage;
    @InjectView(R.id.blog_title)
    TextView blogTitle;
    @InjectView(R.id.blog_detail)
    TextView blogDetail;
    String blogNews = "This is how the detail page is gonna look like,will still" +
            " get all details from the real blog." +
            "well, Boruto has started some weeks back, hope you are watching?" +
            "this project is gonna be fun!!! ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_blog_post);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Blog Post");
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This will add the post to favorites", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        blogTitle.setText("Naruto Uzumaki!!!!!!");
        blogDetail.setText(blogNews);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        /* TODO will implement share link intent share
         */
        if(id == R.id.action_share){
            String mimeType = "text/plain";
            String title ="share";
            String news_read = "read this blog post on ";
            String link = "https://www.github.com/lekky71" ;
            String text = news_read + link;
            //will replace the link from the link fro the api
            ShareCompat.IntentBuilder.from(this)
                    .setType(mimeType)
                    .setChooserTitle(title)
                    .setText(text)
                    .startChooser();

        }

        return super.onOptionsItemSelected(item);
    }
    public void readMore(View v){
        String link = "https://www.github.com/lekky71" ;
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}

package com.example.tacianemartimiano.cklmvvm.modules.article_details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        setSupportActionBar(toolbar)

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        val currentArticle: Article = intent.getSerializableExtra(EXTRA_ARTICLE)
        title.text = currentArticle.title
        author.text = currentArticle.author
        author.text = currentArticle.author
        author.text = currentArticle.author
        author.text = currentArticle.author
        author.text = currentArticle.author

    }
}


authorText.setText(currentArticle.getAuthor());

TextView dateText = findViewById(R.id.date);
dateText.setText(currentArticle.getDate());

TextView websiteText = findViewById(R.id.website);
websiteText.setText(currentArticle.getWebsite());

TextView labelText = findViewById(R.id.label);
labelText.setText(currentArticle.getTags().get(0).getTagLabel());
labelText.setBackgroundColor(getResources().getColor(currentArticle.getTags().get(0).getTagColor()));

TextView contentsText = findViewById(R.id.contents);
contentsText.setText(currentArticle.getContents());

ImageView imageView = findViewById(R.id.image);
imageView.setImageBitmap(Cache.getInstance().getLru().get(currentArticle.getImageUrl()));
}

}




}

package brainwaves.gem.ShoppingSystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import brainwaves.gem.HelperMenu.VisitDetailsActivity;
import brainwaves.gem.R;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shopping);
    }
    public void clothesDetailsonClick(View v) {
        Intent intent = new Intent(ShoppingActivity.this,
                ClothesActivity.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }
    public void artifactShopDetailsonClick(View v) {
        Intent intent = new Intent(ShoppingActivity.this,
                ArtifactsActivity.class);

        startActivity(intent);
    }
    public void booksShopDetailsonClick(View v) {
        Intent intent = new Intent(ShoppingActivity.this,
                BooksActivity.class);

        startActivity(intent);
    }
}

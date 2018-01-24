package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import brainwaves.gem.R;
import brainwaves.gem.ShoppingSystem.ClothesActivity;

public class shoppingDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shopping_details);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        ImageView img = (ImageView) findViewById(R.id.shopping_detailsImg);
        switch (Integer.parseInt(id)){
            case R.id.shop_men_i:
                img.setImageResource(R.drawable.shop_men_i);
                break;
            case R.id.shop_men_ii:
                img.setImageResource(R.drawable.shop_men_ii);
                break;
            case R.id.shop_men_iii:
                img.setImageResource(R.drawable.shop_men_iii);
                break;
            case R.id.shop_women_i:
                img.setImageResource(R.drawable.shop_women_i);
                break;
            case R.id.shop_women_ii:
                img.setImageResource(R.drawable.shop_women_ii);
                break;
            case R.id.shop_women_iii:
                img.setImageResource(R.drawable.shop_women_iii);
                break;
            case R.id.shop_kids_i:
                img.setImageResource(R.drawable.shop_kids_i);
                break;
            case R.id.shop_kids_ii:
                img.setImageResource(R.drawable.shop_kids_ii);
                break;
            case R.id.shop_book_i:
                img.setImageResource(R.drawable.shop_book_i);
                break;
            case R.id.shop_book_ii:
                img.setImageResource(R.drawable.shop_book_ii);
                break;
            case R.id.shop_book_iii:
                img.setImageResource(R.drawable.shop_book_iii);
                break;
        }
    }
    public void shoppingCheckout (View v){
        Intent intent = new Intent(this,
                ShoppingCheckoutActivity.class);
        intent.putExtra("id",""+v.getId());
        startActivity(intent);
    }
}

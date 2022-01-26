package com.example.burgermunch.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.burgermunch.Adapter.RecommendedAdapter;
import com.example.burgermunch.Domain.CategoryDomain;
import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.R;

import java.util.ArrayList;

public class MealShowActivity extends AppCompatActivity {
    private CategoryDomain object;
    private TextView title;
    private RecyclerView MealShow;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_meal_show);
        initView();
        getBundle();
    }


    private void getBundle() {
        object = (CategoryDomain) getIntent().getSerializableExtra("object");
        title.setText(object.getTitle());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager.setReverseLayout(true);
        MealShow.setLayoutManager(linearLayoutManager);
        ArrayList<OrderDetails> foodlist = new ArrayList<>();

        if (object.getTitle().contains("מנות היכרות")) {
            foodlist.add(new OrderDetails("קלאסי", "clasic", "בורגר בקר בליווי ירקות טריים", 39, 4.6, 7, 750));
            foodlist.add(new OrderDetails("אנגוס בורגר", "angusburg", "בשר אנטריקוט מובחר, מוגש בליווי ירקות טריים", 44, 4.8, 8, 1490));
            foodlist.add(new OrderDetails("בורגר שניצלונים", "snitcburg", "120 גרם שניצלונים בליווי ירקות טריים", 32, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("מיני בורגר", "miniburg", "המבורגר לקטנטנים בליווי ירקות טריים", 33, 4.6, 7, 1270));

        }
        if (object.getTitle().contains("מיוחדים")) {
            foodlist.add(new OrderDetails("סמל ראשון", "sergeant", "440 גרם בקר, 250 גרם אנטריקוט, אווז מעושן, ביצת עין ובצל מטוגן", 87, 4.9, 8, 1490));
            foodlist.add(new OrderDetails("סמל", "sergent", "250 גרם אנטריקוט, אווז מעושן בצל מטוגן ופטריות", 83, 4.8, 7, 1270));
            foodlist.add(new OrderDetails("רב״ט", "firstser", "250 גרם אנטריקוט, אווז מעושן וחלפיניו", 59, 4.7, 7, 1270));
            foodlist.add(new OrderDetails("מנת הבית", "home_meal1", "220 גרם בשר בקר, אווז מעושן, ריבת בצל ורוטב קארי", 55, 5, 7, 600));

        }
        if (object.getTitle().contains("טורטיות")) {
            foodlist.add(new OrderDetails("טורטיית הבית", "home_meal1", "120 גרם בקר, בתוספת אווז מעושן וריבת בצל, בליווי ירקות טריים ורוטב הבית", 40, 4.7, 7, 600));
            foodlist.add(new OrderDetails("טורטייה שניצל", "snitctort", "120 גרם שניצל מוגש עם רוטב הבית, בליווי ירקות טריים", 29, 4.8, 8, 1490));
            foodlist.add(new OrderDetails("טורטייה בקר קצוץ", "sergent", "בשר בקר 120 גרם על הפלנצה בטיבול הבית, מוגש עם רוטב הבית", 29, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("טורטייה אנטריקוט", "sergent", "בשר בקר 120 גרם אנטריקוט עסיסיים, מוגש עם רוטב הבית", 31, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("טורטייה אווז מעושן", "sergent", "בשר בקר 120 גרם אווז מעושן, מוגש עם רוטב הבית", 35, 4.7, 7, 1270));
            foodlist.add(new OrderDetails("טורטייה צימחונית", "no", "חביתה עם בצל מטוגן ופטריות", 24, 4.4, 7, 600));
        }
        if (object.getTitle().contains("מטוגנים")) {
            foodlist.add(new OrderDetails("ציפס", "chips", "ציפ׳ס דק", 13, 4.5, 7, 600));
            foodlist.add(new OrderDetails("טבעות בצל", "onionrings", "עיגולי בצל מטוגנים", 13, 4.6, 8, 1490));
            foodlist.add(new OrderDetails("ציפס בטטה", "battachips", "בטטה חתוכה לרצועות", 16, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("שניצלונים", "snitc", "שניצלונים בקריספיות מחרישה", 16, 4.7, 7, 1270));
            foodlist.add(new OrderDetails("שניצלונים וציפס", "snitcandchips", "השילוב המושלם של שניצל וציפ׳ס", 29, 4.5, 7, 1270));
            foodlist.add(new OrderDetails("מיקס מטוגנים", "mixgrill", "מיקס מטוגנים", 33, 4.5, 7, 1270));

        }
        if (object.getTitle().contains("שתייה")) {
            foodlist.add(new OrderDetails("מים", "water", "מים מינרלים טבעיים מבטן האדמה", 6, 5, 7, 600));
            foodlist.add(new OrderDetails("סודה", "soda", "מים מינרלים מוגזים בעדינות", 6, 4.8, 8, 1490));
            foodlist.add(new OrderDetails("קוקה-קולה", "cola", "לסיום ארוחה", 9, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("קולה-זירו", "colazero", "לסיום ארוחה", 9, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("ענבים", "grape", "לסיום ארוחה", 9, 4.6, 7, 1270));
            foodlist.add(new OrderDetails("פיוזטי", "fuzetea", "תה קר", 9, 4.6, 7, 1270));
        }

        adapter = new RecommendedAdapter(foodlist);
        MealShow.setAdapter(adapter);
    }

    private void initView() {
        title = findViewById(R.id.title_txt);
        MealShow = findViewById(R.id.mealsShow);

    }

}
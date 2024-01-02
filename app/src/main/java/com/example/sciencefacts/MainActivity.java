package com.example.sciencefacts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.example.sciencefacts.R;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String[] scienceFacts = {
                   "The Earth is approximately 4.54 billion years old.",
                    "A group of owls is called a parliament.",
                    "The speed of light is approximately 299,792 kilometers per second.",
                    "Honey never spoils; archaeologists have found pots of honey in ancient Egyptian tombs thousands of years old and still perfectly edible.",
                    "The human brain is 73% water.",
                    "A single rainforest can produce 20% of the Earth's oxygen.",
                    "A day on Venus is longer than a year on Venus.",
                    "The Milky Way galaxy is estimated to contain over 100 billion stars.",
                    "Octopuses have three hearts and blue blood.",
                    "The Great Wall of China is not visible from the Moon without aid.",
                    "The dinosaur Tyrannosaurus rex lived closer in time to humans than it did to the stegosaurus.",
                    "The coldest temperature ever recorded on Earth was -128.6°F (-89.2°C) in Antarctica.",
                    "Jupiter is the largest planet in our solar system.",
                    "Cows have best friends and can become stressed when they are separated.",
                    "Humans share about 50% of their DNA with bananas.",
                    "The speed of sound is faster in water than in air.",
                    "The Sun is about 4.6 billion years old and is expected to last another 5 billion years.",
                    "The longest mountain range on Earth is the Mid-Atlantic Ridge, underwater in the Atlantic Ocean.",
                    "There are more possible iterations of a game of chess than there are atoms in the observable universe.",
                    "The smell of freshly cut grass is actually a plant distress call.",
                    "The Earth's atmosphere is composed of approximately 78% nitrogen and 21% oxygen.",
                    "The Eiffel Tower can be 15 cm taller during the summer due to thermal expansion.",
                    "A spoonful of a neutron star would weigh about 6 billion tons.",
                    "Bananas are berries, but strawberries aren't.",
                    "The Hubble Space Telescope can see about 10 billion light-years away.",
                    "The first computer programmer was Ada Lovelace, who wrote the first algorithm in the 1840s."
    };

    private final int[] scienceFactImages = {
            R.drawable.earth,
            R.drawable.owl,
            R.drawable.speedoflight,
            R.drawable.honey,
            R.drawable.brain,
            R.drawable.rainforest,
            R.drawable.venus,
            R.drawable.milkyway,
            R.drawable.octopus,
            R.drawable.greatwall,
            R.drawable.trex,
            R.drawable.antarctica,
            R.drawable.jupiter,
            R.drawable.cow,
            R.drawable.humandna,
            R.drawable.soundspeed,
            R.drawable.sun,
            R.drawable.midatlanticridge,
            R.drawable.chess,
            R.drawable.cutgrass,
            R.drawable.atmosphere,
            R.drawable.eiffeltower,
            R.drawable.neutronstar,
            R.drawable.banana,
            R.drawable.hubblespace,
            R.drawable.firstprogrammer
    };

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    private TextView factTextView;
    private Button generateButton;
    private ImageView factImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        generateButton = findViewById(R.id.generateButton);
        factTextView = findViewById(R.id.factTextView);
        factImageView = findViewById(R.id.factImageView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomFact();
            }
        });
    }

    private void displayRandomFact() {
        int randomIndex = new Random().nextInt(scienceFacts.length);

        factTextView.setText(scienceFacts[randomIndex]);
        factImageView.setImageResource(scienceFactImages[randomIndex]);
    }




    private void shareApp() {
        // Share app using an implicit intent
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this amazing app!");
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(sendIntent, "Share App"));
        } else {
            showToast("No app found to handle the share action");
        }
    }

    private void rateApp() {
        // Open the Play Store for rating
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent rateIntent = new Intent(Intent.ACTION_VIEW, uri);

        if (rateIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(rateIntent);
        } else {
            showToast("Could not open Play Store for rating");
        }
    }




    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });

        builder.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

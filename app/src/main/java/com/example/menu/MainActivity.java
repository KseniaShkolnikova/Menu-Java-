package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new First());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.f1) {
                    setFragment(new First());
                    return true;
                }
                if (item.getItemId() == R.id.f2) {
                    setFragment(new SecondFragment());
                    return true;
                }
                if (item.getItemId() == R.id.f3) {
                    setFragment(new ThridFragment());
                    return true;
                }
                return false;
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        ImageView headerImage = headerView.findViewById(R.id.header_image);
        headerImage.setImageResource(R.drawable.cat);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.item1) {
                    setFragment(new First());
                    bottomNavigationView.setSelectedItemId(R.id.f1);
                    return true;
                }
                else if (id == R.id.item2) {
                    setFragment(new SecondFragment());
                    bottomNavigationView.setSelectedItemId(R.id.f2);
                    return true;
                }
                else if (id == R.id.item3) {
                    setFragment(new ThridFragment());
                    bottomNavigationView.setSelectedItemId(R.id.f3);
                    return true;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menures, menu);
        return true;
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.selected_menu, fragment, null).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings ) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.frag_first) {
            setFragment(new First());
            bottomNavigationView.setSelectedItemId(R.id.f1);
        } else if (id == R.id.frag_two) {
            setFragment(new SecondFragment());
            bottomNavigationView.setSelectedItemId(R.id.f2);
        } else if (id == R.id.frag_thrid) {
            setFragment(new ThridFragment());
            bottomNavigationView.setSelectedItemId(R.id.f3);
        }
        else if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

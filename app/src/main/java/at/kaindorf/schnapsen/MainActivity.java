package at.kaindorf.schnapsen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //////////////----Hide Notification Bar----///////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ///////////////////////////////////////////////
        setContentView(R.layout.activity_main);


        //////////////----BACKGROUND----///////////////
        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
        ///////////////////////////////////////////////

        imageView = (ImageView) findViewById(R.id.imageView);   //       <---- ImageView for the Logo "Schnapsen"

        /////////////Animation bei Start//////////////
        ObjectAnimator yAnimation = ObjectAnimator.ofFloat(imageView,"y",230f);
        ObjectAnimator xAnimation = ObjectAnimator.ofFloat(imageView,"x",70f);
        yAnimation.setDuration(1500);
        xAnimation.setDuration(1500);
        Set<Animator> hashSet = new HashSet<>();
        hashSet.add(yAnimation);
        hashSet.add(xAnimation);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(hashSet);
        animatorSet.start();
        /////////////////////////////////////////////



        ///////////-----Move to the right Animation-----////////////////////
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator toRight = ObjectAnimator.ofFloat(imageView,"x",2000f);
                toRight.setDuration(700);
                toRight.start();
            }
        }, 1000);
        /////////////////////////////////////////////////////////////////



        ////////////-----Animatioon für TextView Items ( Klassisch, Blitzschnapsen, ... ) werden eingeblendet.


    }

}
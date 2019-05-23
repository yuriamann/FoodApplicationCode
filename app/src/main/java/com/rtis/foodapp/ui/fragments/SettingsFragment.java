package com.rtis.foodapp.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.rtis.foodapp.R;
import com.rtis.foodapp.ui.MainActivity;
import com.rtis.foodapp.ui.SplashActivity;

/**
 * Fragment for settings page.
 * Instantiated in Main Activity.
 */
public class SettingsFragment extends Fragment {
    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);

        // Create Logout button
        Button logout = (Button) view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

 //       Button phone = (Button) view.findViewById(R.id.help_phone);
        TextView phone = (TextView) view.findViewById(R.id.help_phone);
        phone.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                helpPhone();
            }
        });

//        Button email = (Button) view.findViewById(R.id.help_email);
        TextView email = (TextView) view.findViewById(R.id.help_email);
        email.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                helpEmail();
            }
        });


        ImageButton facebookLink = (ImageButton) view.findViewById(R.id.facebook_button);
        facebookLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFacebook();
            }
        });

        ImageButton twitterLink = (ImageButton) view.findViewById(R.id.twitter_button);
        twitterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTwitter();
            }
        });

        ImageButton InstagramLink = (ImageButton) view.findViewById(R.id.instangram_button);
        InstagramLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInstagram();
            }
        });

        return view;
    }

    /**
     * Helper method to log user out of account when button is pressed.
     */
    private void logout() {
        Backendless.UserService.logout(new AsyncCallback<Void>() {
            public void handleResponse(Void response) {
                // user has been logged out.
                startActivity(new Intent(getContext(), SplashActivity.class));
            }

            public void handleFault(BackendlessFault fault) {
                // something went wrong and logout failed, to get the error code call fault.getCode()
            }
        });
    }

    /**
     * Helper method to handle phone call
     */
    private void helpPhone() {
        Uri number = Uri.parse((String) getText(R.string.help_phone_uri));
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        try{
            startActivity(Intent.createChooser(callIntent, "Make Call"));
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "Phone not available.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Helper method to handle email
     */
    private void helpEmail() {
<<<<<<< HEAD
        Uri email = Uri.parse((String) getText(R.string.help_email_uri));
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {(String) getText(R.string.help_email_uri)});
=======
        //Uri email = Uri.parse((String) getText(R.string.help_email_uri));
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", (String) getText(R.string.help_email_uri), null));
        //emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {(String) getText(R.string.help_email_uri)});
>>>>>>> 44e4570be2ee49aa0a17b0d101c72d0b633ed32f
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MySnapFoodLog: Support Request");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Description of Problem\n");

        try{
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getContext(), "Email client not available.", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Link to facebook
     */

    private void goToFacebook(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(intent);
    }

    /**
     * Link to Twitter
     */

    private void goToTwitter(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://twitter.com/"));
        startActivity(intent);
    }

    /**
     * Link to Instagram
     */

    private void goToInstagram(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.instagram.com/"));
        startActivity(intent);
    }
}

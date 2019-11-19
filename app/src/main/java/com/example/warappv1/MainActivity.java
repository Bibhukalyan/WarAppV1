package com.example.warappv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.warappv1.fragment.ButtonListFragment;
import com.example.warappv1.fragment.ItemListFragment;
import com.example.warappv1.model.GunModel;
import com.example.warappv1.model.HorseModel;
import com.example.warappv1.utils.AppConstants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.warappv1.utils.AppConstants.REQUEST_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity implements ButtonListFragment.ButtonClickListener,ItemListFragment.OnItemSelectedListener{

    ArrayList<HorseModel> horseModels;
    ArrayList<GunModel> gunModels;
    ImageView imageView;
    Uri picUri;
    private Bitmap myBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
    }

    private void initViews() {

        horseModels = new ArrayList<>();
        gunModels = new ArrayList<>();

        imageView = findViewById(R.id.iv_image_captured);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameForFragment,new ButtonListFragment(null,null))
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onButtonClick(int buttonId) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ItemListFragment itemListFragment = new ItemListFragment();
        switch (buttonId){
            case AppConstants.HORSE_SELECTED:{

                Bundle horseBundle = new Bundle();
                horseBundle.putInt(AppConstants.TYPE_KEY_FOR_FRAGMENT_ARG,AppConstants.HORSE_TYPE);
                horseBundle.putParcelableArrayList(AppConstants.HORSE_LIST_KEY,HorseModel.getHorseList());
                itemListFragment.setArguments(horseBundle);

                fragmentTransaction.replace(R.id.frameForFragment,itemListFragment)
                .commit();
                break;
            }
            case AppConstants.GUN_SELECTED:{
                Bundle gunBundle = new Bundle();
                gunBundle.putInt(AppConstants.TYPE_KEY_FOR_FRAGMENT_ARG,AppConstants.GUN_TYPE);
                gunBundle.putParcelableArrayList(AppConstants.GUN_LIST_KEY, GunModel.getGunList());
                itemListFragment.setArguments(gunBundle);

                fragmentTransaction.replace(R.id.frameForFragment,itemListFragment)
                        .commit();
                break;
            }
            case AppConstants.CAPTURE_NEW_LIFE_SELECTED:{
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA},
                            AppConstants.MY_PERMISSIONS_REQUEST_CAMERA);
                } else {
                    dispatchTakePictureIntent();

                }
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(int position, int typeOfResource) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (typeOfResource){

            case AppConstants.HORSE_SELECTED: {
                horseModels.add(HorseModel.getHorseList().get(position));

                break;
            }

            case AppConstants.GUN_SELECTED: {
                gunModels.add(GunModel.getGunList().get(position));

                break;
            }
        }

        fragmentTransaction.replace(R.id.frameForFragment,new ButtonListFragment(horseModels,gunModels))
                .commit();

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, AppConstants.REQUEST_TAKE_PHOTO);
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppConstants.REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            /*Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");*/
            Uri outputFileUri = null;
            File getImage = getExternalCacheDir();
            if (getImage != null) {
                File file = new File(currentPhotoPath);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    outputFileUri = FileProvider.getUriForFile(this, "com.example.android.fileprovider", file);
                else
                    outputFileUri = Uri.fromFile(file);
            }
            //return outputFileUri;
            //Bundle extras = data.getExtras();
            //Bitmap imageBitmap = (Bitmap) outputFileUri;
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageURI(outputFileUri);
            Log.e("Uri",outputFileUri.getPath());
        }
    }

    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case AppConstants.MY_PERMISSIONS_REQUEST_CAMERA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    dispatchTakePictureIntent();
                }
                break;
            }
        }
    }

}

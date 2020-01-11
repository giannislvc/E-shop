package com.nativeboys.eshop.john;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import com.nativeboys.eshop.R;
import com.nativeboys.eshop.john2.Item;
import com.nativeboys.eshop.john2.ItemDetailActivity;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class EditItemActivity extends DialogFragment implements AdapterView.OnItemSelectedListener {

    public final static String ITEM = "item";
    private Item item;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button changeItemPicButton;
    private CircleImageView itemPic;
    private Button save;
    private Button cancel;
    private Button delete;
    private EditText name;
    private EditText description;
    private EditText price;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private Spinner spinner;
    private Button preview;

    public static EditItemActivity newInstance(Item item) {
        Bundle args = new Bundle();
        args.putParcelable(ITEM, item);
        EditItemActivity fragment = new EditItemActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FadeFragmentTheme);
        if (getArguments() != null) {
            item = getArguments().getParcelable(ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_item_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.titleEditText);
        description = view.findViewById(R.id.descriptionEditText);
        price = view.findViewById(R.id.priceEditText);
        itemPic = view.findViewById(R.id.item_pic);

        if (item != null) {
            name.setText(item.getName());
            description.setText(item.getDescription());
            price.setText(item.getPrice());
            itemPic.setImageResource(item.getThumbnail());
        }

        preview = view.findViewById(R.id.previewItemButton);
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDetailActivity.newInstance(item).show(getChildFragmentManager(), ItemDetailActivity.class.getSimpleName());
            }
        });

        spinner = view.findViewById(R.id.editItemCategorySpinner);
        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(getContext(), R.array.categorys, android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);
        spinner.setOnItemSelectedListener(this);

        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Are you sure you want to delete this item ?");
        builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //delete item
                dismiss();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog = builder.create();

        changeItemPicButton = view.findViewById(R.id.changeItemPicButton);
        changeItemPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        save = view.findViewById(R.id.saveItemButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //eisagwgh dedomenwn ston server
                dismiss();
            }
        });

        delete = view.findViewById(R.id.deleteItemButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete item
                dialog.show();

            }
        });

        cancel = view.findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }

    private void openGallery() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PICK_IMAGE_REQUEST);
        } else {
            openFileChooser();
        }
    }

    private void openFileChooser() {
        startActivityForResult(new Intent()
                .setType("image/*")
                .setAction(Intent.ACTION_GET_CONTENT), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PICK_IMAGE_REQUEST && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openFileChooser();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            itemPic.setImageURI(data.getData());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedCategory = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "selected category: " + selectedCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

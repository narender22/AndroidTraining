package com.example.draganddropexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {

    private TextView textView;
    private Button button;
    private ImageView imageView;
    private static final String IMAGE_VIEW_TAG = "LAUNCHER LOGO";
    private static final String TEXT_VIEW_TAG = "DRAG TEXT";
    private static final String BUTTON_VIEW_TAG = "DRAG BUTTON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        implementEvents();
    }

//    Implement long click and drag listener
    private void implementEvents() {
//        add or remove any view that you don't want to be dragged
        textView.setOnLongClickListener(this);
        imageView.setOnLongClickListener(this);
        button.setOnLongClickListener(this);

//        add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.topLayout).setOnDragListener(this);
        findViewById(R.id.leftLayout).setOnDragListener(this);
        findViewById(R.id.rightLayout).setOnDragListener(this);
    }

//    find all views and set Tag to all draggable views
    private void findViews() {
        textView = findViewById(R.id.label);
        textView.setTag(TEXT_VIEW_TAG);
        imageView = findViewById(R.id.image);
        imageView.setTag(IMAGE_VIEW_TAG);
        button = findViewById(R.id.button);
        button.setTag(BUTTON_VIEW_TAG);
    }


    @Override
    public boolean onLongClick(View view) {
//        create a new ClipData
//        This is done in two steps to provide clarity. The convenience method
//        ClipData.newPlainText() can create a plain text ClipData in one step
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

//        Create a new ClipData using the tag as a label, the plain text MIME type, and
//        the already-created item. This will create a new ClipDescription object within the the
//        ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

//        Instantiates the drag shadow builder.
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

//        starts the drag

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.startDragAndDrop(data  //data to be dragged
                    , shadowBuilder     //drag shadow
                    , view              //local data about teh drag and drop
                    , 0             //no needed flags
            );
        }
        else{
            view.startDrag(data  //data to be dragged
                    , shadowBuilder     //drag shadow
                    , view              //local data about teh drag and drop
                    , 0             //no needed flags
            );
        }

//        set view visibility to INVISIBLE as we are going to drag the view
        view.setVisibility(View.INVISIBLE);

        return true;
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
//        Defines a variable to store the action type for the incoming event
        int action = dragEvent.getAction();

//        Handles each of the expected events
        switch (action){
            case DragEvent.ACTION_DRAG_STARTED:
//                determined if this view can accept the dragged data
                // if you want to apply color when drag started to your view you can uncomment below lines
                // to give any color tint to the View to indicate that it can accept
                // data.
                //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);//set background color to your view
                // Invalidate the view to force a redraw in the new tint
                //  view.invalidate();
                // returns true to indicate that the View can accept the dragged data.
                return dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN);
                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
            case DragEvent.ACTION_DRAG_ENTERED:
//                Applies a yellow or any color tint to the view, when the dragged view entered into
//                return true; the return value is ignored
                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);

//                Invalidate teh view to force a redraw in the new tint
                view.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
//                ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
//                resets the color ting to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Return true; the return value is ignored

//                view.getBackground().setColorFilter(Color.blue, porterDuff.Mode.SRC_IN);

//                If you had not provided any color in ACTION_DRAG_STARTED then clear color filter.
                view.getBackground().clearColorFilter();
//                Invalidate teh view to force a redraw in the new tint
                view.invalidate();

                return true;

            case DragEvent.ACTION_DROP:
//                gets the item containing the dragged data
                ClipData.Item item = dragEvent.getClipData().getItemAt(0);

//                Gets teh data from the item.
                String dragData = item.getText().toString();

//                Displays ta message containing the dragged data.
                Toast.makeText(this, "Dragged data is "+ dragData, Toast.LENGTH_SHORT).show();

//                Turn off any color tints
                view.invalidate();

                View v = (View) dragEvent.getLocalState();
                ViewGroup owner = (ViewGroup) v.getParent();
                owner.removeView(v); //remove the dragged view.
                LinearLayout container = (LinearLayout) view; //caste teh view into LL as our drag acceptable layout is LL
                container.addView(v); //Add teh dragged view
                v.setVisibility(View.VISIBLE); //finally set visibility to VISIBLE

//                returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
//                turn off any color tinting
                view.getBackground().clearColorFilter();

//                invalidate the view to force a redraw
                view.invalidate();

//                Does a getResult(), and displays what happened.
                if (dragEvent.getResult())
                    Toast.makeText(this, "The drop was handled", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "The drop didn't work", Toast.LENGTH_SHORT).show();

//                return true; teh value is ignored
                return true;

            default:
                Log.d("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }
}
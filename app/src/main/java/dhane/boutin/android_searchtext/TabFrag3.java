package dhane.boutin.android_searchtext;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by bouti on 15/10/2015.
 */
public class TabFrag3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_frag_3, container, false);
        String longText = getString(R.string.lorem_ipsum);
        final String[] wordTable = longText.split(" ");
        int lengthText = longText.length();

        final TextView textView = (TextView) rootView.findViewById(R.id.textView3);
        final View view = rootView.findViewById(R.id.view3);
        final Button button = (Button) rootView.findViewById(R.id.buttonNext);
        final Paint paint = textView.getPaint();

        //textView.setText(longText);
        textView.measure(0, 0);
        final float densityMultiplier = getContext().getResources().getDisplayMetrics().density;
        final float scaledPx = 15 * densityMultiplier;
        float sizeline = 120 * scaledPx;
        paint.setTextSize(scaledPx);
        //final float size = paint.measureText(longText);
        final float width = getContext().getResources().getDisplayMetrics().widthPixels;
        final float height = getContext().getResources().getDisplayMetrics().heightPixels;
        //view.measure(0, 0);
        final float[] viewHeight = {-1};
        final float[] viewWidth = {-1};

        final int[] nbWord = {0};
        //viewWidth[0] = -1;
        //viewHeight[0] = -1;
        final boolean[] changeText = {true};


        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                int heightButton = button.getHeight();
                viewHeight[0] = view.getHeight() - heightButton;
                viewWidth[0] = view.getWidth();
                Rect result = new Rect();
                Rect space = new Rect();
                Rect test = new Rect();
                int charCount = 100;
                int nbLine = 1;
                float spaceLine = paint.getFontSpacing();
                float totalTextHeight = 100 + (2*spaceLine);
                // gets called after layout has been done but before display.
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    charCount = 100;
                        for(int i=0; i<wordTable.length;i++) {
                            paint.getTextBounds(wordTable[i], 0, wordTable[i].length(), result);
                            paint.getTextBounds(" ", 0, " ".length(), space);
                            /*paint.getTextBounds("Constantina exultans ut in tuto iam locata mariti", 0, "Constantina exultans ut in tuto iam locata mariti".length(), test);
                            //float sizeSpace = paint.measureText(" ");
                            if (i == 0) {
                                //Log.d("tag", "------> width = " + test.width());
                                paint.getTextBounds("salute", 0, "salute".length(), test);
                                //Log.d("tag", "------> widthS = " + test.width());
                                //Log.d("tag", "------> heightButton = " + heightButton);
                            }*/
                            if ((totalTextHeight + spaceLine) < viewHeight[0]) {
                                if ((result.width() + space.width() + charCount) < viewWidth[0]) {
                                    //Log.d("tag", "---------------------------------->   Size = " + result.height() + ", Size space = " + space.height());
                                    textView.append(wordTable[i]);
                                    textView.append(" ");
                                    nbWord[0] += 1;
                                    charCount += (result.width() + space.width());
                                } else {
                                    //Log.d("tag", "--------------> nbLine = " + nbLine + ", charCount = " + charCount + ", mot = " + wordTable[i] + ", width = " + result.width());

                                    charCount = 100;
                                    nbLine += 1;
                                    textView.append(wordTable[i]);
                                    textView.append(" ");
                                    nbWord[0] += 1;
                                    totalTextHeight += spaceLine;
                                    charCount += (result.width() + space.width());

                                }
                            } else {
                                break;
                            }
                        }
                //Log.d("tag", "iwidth = " + viewWidth[0] + ", iheight = " + viewHeight[0] + ", total = " + totalTextHeight);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(changeText[0]) {
                    textView.setText("");
                    int heightButton = button.getHeight();
                    viewHeight[0] = view.getHeight() - heightButton;
                    viewWidth[0] = view.getWidth();
                    Rect result = new Rect();
                    Rect space = new Rect();
                    Rect test = new Rect();
                    int charCount = 100;
                    int nbLine = 1;
                    float spaceLine = paint.getFontSpacing();
                    float totalTextHeight = 100 + (2 * spaceLine);
                    int nbTmp = nbWord[0];
                    for (int i = nbTmp; i < wordTable.length; i++) {
                        paint.getTextBounds(wordTable[i], 0, wordTable[i].length(), result);
                        paint.getTextBounds(" ", 0, " ".length(), space);
                        /*paint.getTextBounds("Constantina exultans ut in tuto iam locata mariti", 0, "Constantina exultans ut in tuto iam locata mariti".length(), test);
                        //float sizeSpace = paint.measureText(" ");
                        if (i == 0) {
                            //Log.d("tag", "------> width = " + test.width());
                            paint.getTextBounds("salute", 0, "salute".length(), test);
                            //Log.d("tag", "------> widthS = " + test.width());
                            //Log.d("tag", "------> heightButton = " + heightButton);
                        }*/
                        if ((totalTextHeight + spaceLine) < viewHeight[0]) {
                            if ((result.width() + space.width() + charCount) < viewWidth[0]) {
                                //Log.d("tag", "---------------------------------->   Size = " + result.height() + ", Size space = " + space.height());
                                textView.append(wordTable[i]);
                                textView.append(" ");
                                nbWord[0] += 1;
                                charCount += (result.width() + space.width());
                            } else {
                                //Log.d("tag", "--------------> nbLine = " + nbLine + ", charCount = " + charCount + ", mot = " + wordTable[i] + ", width = " + result.width());

                                charCount = 100;
                                nbLine += 1;
                                textView.append(wordTable[i]);
                                textView.append(" ");
                                nbWord[0] += 1;
                                totalTextHeight += spaceLine;
                                charCount += (result.width() + space.width());

                            }
                        } else {
                            break;
                        }
                    }

                    if(nbWord[0] >= wordTable.length){
                        changeText[0] = false;
                        Log.d("tag", "-----> Stop next");
                    }
                }
            }
        });
        return rootView;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    int countLineBreaks(final TextView textView, final String toMeasure) {

        final Paint paint = textView.getPaint(); // Get the paint used by the TextView
        int startPos = 0;
        int lineCount = 0;
        final int endPos = toMeasure.length();

        // Loop through the string, moving along the number of characters that will
        // fit on a line in the TextView. The number of iterations = the number of line breaks

        while (startPos < endPos) {
            startPos += paint.breakText(toMeasure.substring(startPos, endPos),
                    true,  textView.getWidth(),(float[]) null);
            lineCount++;
        }
        // Line count will now equal the number of line-breaks the string will require
        return lineCount;
    }
}

package com.example.roylmobile.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roylmobile.R;
import com.example.roylmobile.language.LanguageHelper;
import com.example.roylmobile.language.Languages;
import com.example.roylmobile.widgets.Toaster;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util  implements MediaPlayer.OnPreparedListener {
    public static String CustomString(String c) {
        if (c.length()>=7){
            String s = c;
            String left = "";
            int p = s.indexOf('M');
            if (p >= 0) {
                left = s.substring(0, p + 1);
//            String right = s.substring(p + 2);
            } else {
                // s does not contain '-'
            }
            return left;}
        else
            return c;
    }


    public static void requestFocus(View view, Window window) {
        if (view.requestFocus()) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public static String getISO8601StringForDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Log.d("date", dateFormat.format(date));

        return dateFormat.format(date);
    }

    /*2018-09-18T22:46:00*/
    public static Date getDateFromIso(String date_str, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.parse(date_str);
    }

    public static Date fromStringToDate(String dateTime, String format, Context context) {

        // TODO : dateTime returns as current date not the sent date
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);


        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date convertedDate = new Date();


        try {
            convertedDate = dateFormat.parse(dateTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;

    }

    public static String fromDateToString(Date dateTime, String format, Context context) {


        SimpleDateFormat dateFormat;

        if (LanguageHelper.getLanguage(context).equals(Languages.ARABIC)) {

            dateFormat = new SimpleDateFormat(format, new Locale("ar",
                    "EG"));

            Log.e("date", "ar");

        } else {
            dateFormat = new SimpleDateFormat(format, Locale.US);
            Log.e("date", "en");


        }
        return dateFormat.format(dateTime);

    }

    public static String getDateFromFormatToFormat(String date, String currFormat, String expectedFormat,
                                                   Context context) {

//        Log.e("getDateFromFormat",fromDateToString(fromStringToDate(date,currFormat,context),expectedFormat));

        return fromDateToString(fromStringToDate(date, currFormat, context), expectedFormat, context);

    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static void ShareApp(Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out my app at: https://play.google.com/store/apps/details?id=com.example.mahmoud.ajeer");
        sendIntent.setType("text/plain");
        sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(sendIntent);
    }


    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public static String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);
        return imgString;
    }

    public static String getRealPathFromURI(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(uri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


    public static Bitmap decodeAndResizeFile(File f) {
        try {
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            // The new size we want to scale to
            final int REQUIRED_SIZE = 150;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE
                        || height_tmp / 2 < REQUIRED_SIZE)
                    break;
                width_tmp /= 3;
                height_tmp /= 3;
                scale *= 2;
            }
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
        }
        return null;
    }


    public static void handleException(Context context, Throwable t) {
        if (t instanceof SocketTimeoutException)
            makeToast(context, R.string.time_out_error);
        else if (t instanceof UnknownHostException)
            makeToast(context, R.string.network_connection_error);

        else if (t instanceof ConnectException)
            makeToast(context, R.string.network_connection_error);
        else
            makeToast(context, R.string.anonymous_error);


//        Log.e("ERROR",t.getLocalizedMessage());

    }


    public static void makeToast(Context context, int msgId) {
        Toaster toaster = new Toaster(context);
        toaster.makeToast(context.getString(msgId));

    }

    public static void makeToast(Context context, String msg) {
        Toaster toaster = new Toaster(context);
        toaster.makeToast(msg);

    }

    public static boolean emptyString(String s) {
        boolean empty = false;

        if (s.equals("") || s.isEmpty()) {

            empty = true;

        }

        return empty;

    }

    public static StringBuilder getStringCourseElements(List<Integer> choosenElements) {
        StringBuilder courseElements = new StringBuilder("");

        for (int i = 0; i < choosenElements.size(); i++) {
            if (i == choosenElements.size() - 1) {
                courseElements.append(choosenElements.get(i));

            } else {
                courseElements.append(choosenElements.get(i)).append(",");
            }
        }
        return courseElements;
    }

    public static boolean isValidPassword(String password) {

        boolean valid = true;

        //^[a-zA-Z0-9]*$
        //remove for now
        /*if (!password.matches("^([0-9]+[a-zA-Z]+|[a-zA-Z]+[0-9]+)[0-9a-zA-Z]*$") ||
                password.length()<8) {
            valid = false;
        }*/

        return valid;

    }

    public static boolean isValidUsername(String userName) {
//        @/./+/-/_

        boolean valid = true;

        //^[a-zA-Z0-9]*$

        if (!userName.matches("^[0-9a-zA-Z\\+\\.\\_\\-\\@]*$")) {

            valid = false;

        }

        return valid;

    }

    public static void setError(EditText editText, String errorMessage) {

        editText.setError(errorMessage);
        editText.requestFocus();

    }

    public static boolean isConnectedToNetwork(Context cn) {
        boolean validate = false;

        ConnectivityManager cm = (ConnectivityManager) cn.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                validate = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                validate = true;
            }
        } else {
            // not connected to the internet
            validate = false;

        }

        return validate;
    }

    public static void emptyCase(View visible, View gone, TextView textView, String msg) {
        gone.setVisibility(View.GONE);
        visible.setVisibility(View.VISIBLE);
        textView.setText(msg);
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        return width;

    }

    public static String displayDate(String rest_date) {

        Calendar calendar = getCalendarFromString(Constants.DISPLAY_DATE_FORMAT, rest_date);

        return formatCalendarDate(Constants.DISPLAY_DATE_FORMAT, calendar);

    }

    public static Calendar getCalendarFromString(String format, String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }

    public static String formatCalendarDate(String format, Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(date.getTime());
    }


    public static void takeScreenshot(Activity activity) {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/PICTURES/Screenshots/" + now + ".jpg";

            // create bitmap screen capture
            View v1 = activity.getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);
            File imageFile = new File(mPath);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();


            MediaScannerConnection.scanFile(activity,
                    new String[]{imageFile.toString()}, null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        public void onScanCompleted(String path, Uri uri) {
                            Log.i("ExternalStorage", "Scanned " + path + ":");
                            Log.i("ExternalStorage", "-> uri=" + uri);
                        }
                    });

//            openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }
    }


    @Override
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    public static String getDeviceID(Context cn) {
        return Settings.Secure.getString(cn.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public static boolean isMyServiceRunning(Class<?> serviceClass, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static String convertToHtml(String htmlString) {

        return "<![CDATA[" +
                htmlString +
                "]]>";
    }

//     static String getErrorMsgFromErrorBody(String msg, Context context){
//
//         String correspondantMsg = "";
//
//         Log.e("erororororo", msg);
//
//
//         if (isJson(msg)) {
//
//             JsonParser jsonParser = new JsonParser();
//
//             JsonElement jsonElement = jsonParser.parse(msg);
//
//             if (jsonElement.isJsonObject()) {
//
//                 correspondantMsg = getMsgAndCheckJsonType(context, jsonElement.getAsJsonObject());
//
//             } else if (jsonElement.isJsonArray()) {
//
//                 JsonArray jsonArray = jsonElement.getAsJsonArray();
//
//                 for (JsonElement object : jsonArray) {
//
//                     if (object.isJsonObject()) {
//
//                         correspondantMsg = getMsgAndCheckJsonType(context, object.getAsJsonObject());
//
//                     } else {
//
//                         correspondantMsg = searchIntoErrorMapAndGetMsg(context, object.getAsString());
//
//                     }
//                 }
//
//             }
//         }
//        if (!correspondantMsg.equals(""))
//            return correspondantMsg;
//         else
//            return context.getString(R.string.anonymous_error);
//
//    }

//    private static String getMsgAndCheckJsonType(Context context, JsonObject jsonObject) {
//
//
//        Set<Map.Entry<String, JsonElement>> elementSet = jsonObject.entrySet();
//
//        Iterator<Map.Entry<String, JsonElement>> elementSetIt = elementSet.iterator();
//
//        Map.Entry<String, JsonElement> entry = elementSetIt.next();
//
//        if (!entry.getValue().isJsonObject())
//            return searchIntoErrorMapAndGetMsg(context,entry.getValue().getAsString());
//        else
//            return context.getString(R.string.anonymous_error);
//
//
//    }

//    private static String searchIntoErrorMapAndGetMsg(Context context,String s){
//
//        HashMap<String,String> errorMap = Constants.DataLists.getErrorMap(context);
//
//
//        if (errorMap.containsKey(s)) {
//
//
//            return errorMap.get(s);
//
//
//        }else {
//
//            return "";
//        }
//
//    }

//    public static void viewErrorMsg(Response response, IBase basePresenter){
//        try {
//
//
//            if (response.code() == 500)
//
//                basePresenter.error(basePresenter.getContext().getString(R.string.anonymous_error));
//
//            else
//
//                basePresenter.error(Util.getErrorMsgFromErrorBody(response.errorBody().string(),
//                    basePresenter.getContext()));
//
//        } catch (IOException e) {
////            basePresenter.error(response.code());
//            e.printStackTrace();
//        }
//    }


    public static String removeTextAlign(String text) {

        if (text != null) {

            text = text.replace("text-align:left;", "");
            text = text.replace("text-align:right;", "");
            text = text.replace("text-align:center;", "");

            text = text.replace("align=left;", "");
            text = text.replace("align=right;", "");
            text = text.replace("align=center;", "");
            text = text.replace("align=\"left\"", "");
            text = text.replace("align=\"right\"", "");
            text = text.replace("text-align:justify;", "");
        }


        return text;

    }

    //    public static String getTextWithCenterAlign(String text,String align){
//
//
//        StringBuilder builder = new StringBuilder("");
//
//
////        if(align.equals(Constants.ALIGN_CENTER)){
////
////            builder.append("<span style=\"text-align:"+align+"\"><p>")
////                    .append(text).append("</p></span><br/>");
//
////        }else {
////
////            builder.append("<span style=\"text-align:"+align+"\"><p>")
////                    .append(text).append("</p></span>");
////
////        }
////
////        return builder.toString();
////
////    }
////
////    public static Integer getMinFromArray(Integer[] array){
////        Integer min = 0;
////
////        for (Integer num:array){
////
////            if (num < min)
////
////                min = num;
////        }
////        return min;
////
////    }
////    public static Integer getMaxFromArray(Integer[] array){
////
////        Integer max = 0;
////
////        for (Integer num:array){
////
////            if (num > max)
////
////                max = num;
////        }
////        return max;
////
////    }
////
////    public static boolean isPhoneValid(Integer origin_country,String phone) {
////        if (origin_country == Constants.ServiceConstants.EG)
////            return matchesRegex(Constants.EG_REGEX,phone);
////        else
////            return matchesRegex(Constants.SAUDI_REGEX,phone);
////    }
////    public static boolean matchesRegex(String regex,String textToCompare){
////
////        Pattern pattern = Pattern.compile(regex);
////
////        return pattern.matcher(textToCompare).matches();
////
////    }
////    public static boolean isJson(String Json) {
////        try {
////            new JSONObject(Json);
////        } catch (JSONException ex) {
////            try {
////                new JSONArray(Json);
////            } catch (JSONException ex1) {
////                return false;
////            }
////        }
////        return true;
////    }
////
////    public static boolean validPhoneStart(String phone) {
////
////        if (phone.length() > 3) {
////            String start = phone.substring(0, 3);
////
////            Log.e("valid start",start);
////            if (start.equals("010") || start.equals("011") ||
////                    start.equals("012") || start.equals("015")){
////
////                return true;
////
////            }
////            return false;
////        }else
////            return false;
////    }
////
    public static void showDialog(Dialog dialog, Activity activity) {

        if (dialog != null && !dialog.isShowing() && !activity.isFinishing()) {
            dialog.show();
        }
    }

    public static void dismissDialog(Dialog dialog, Activity activity) {

        if (dialog != null && dialog.isShowing() && !activity.isFinishing()) {
            dialog.dismiss();
        }
    }
}
////
////    public static void showToaster(Toaster toaster,Activity activity,String msg) {
////
////        if (toaster != null && !activity.isFinishing()) {
////
////            toaster.makeToast(msg);
////        }
////    }
////
////    public static void openPrivacy(Context context) {
////        String url ;
////
////        if (LanguageHelper.getLanguage(context).equals(Languages.ENGLISH) ){
////
////            url = Constants.POLICY_ENG;
////
////        }else{
////            url = Constants.POLICY_AR;
////        }
////
////        Intent i = new Intent(Intent.ACTION_VIEW);
////        i.setData(Uri.parse(url));
////        context.startActivity(i);
////    }


package com.example.roylmobile.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GlobalPreferences {
    final static String APP_lANGUAGE = "language";
    final static String PREFS_NAME = "settings";
    final static String PREFS_DATA = "user_data";
    final static String SETTINGS_LOGIN = "login";
    final static String SETTINGS_VALID = "valid";
    final static String SETTINGS_NOTIFICATION = "notification";
    final static String SETTINGS_VIBRATION = "vibration";
    final static String USER = "user";
    final static String AUTH_TOKEN = "auth_token";
    final static String EMAIL = "email";
    public final static String CASE = "case";
    final static String USER_Device_GCM = "gcm";
    final static String ME = "me";
    final static String THIS_EXAM="this_exam";
    final static String admin_token = "admin_token";
    final static String TICKETS = "tickets";
    final static String PASS = "pass";
    final static String CONTENT_DIRECTION = "content_direction";
    final static String SCHOOL ="school";
    final static String CORRECT_BY = "correct_by";

    public static final String FIRST_RUN = "first_run";


    private static final String THIS_TRAINING = "this_training";
    private static final String SETTINGS_USER_ID ="" ;


    private Context context;
    private SharedPreferences prefs;
    private SharedPreferences.Editor PrefsEditor;

    private SharedPreferences dataPrefs;
    private SharedPreferences.Editor dataEditor;

    private static Gson gson = new Gson();


    public GlobalPreferences(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(PREFS_NAME, 0);
        PrefsEditor = prefs.edit();

        dataPrefs = context.getSharedPreferences(PREFS_NAME, 0);
        dataEditor = dataPrefs.edit();
    }


    public void logOut() {
        PrefsEditor.clear();
        PrefsEditor.commit();
    }

    public Boolean getLoginStatus() {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        Boolean value = prefs.getBoolean(SETTINGS_LOGIN, false);
        return value;
    }

    public void storeLoginStatus(Boolean status) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SETTINGS_LOGIN, status);
        editor.commit();
    }

    public void storeValidStatus(Boolean profile_valid) {

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SETTINGS_VALID, profile_valid);
        editor.commit();

    }
    public Boolean getValidStatus() {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        Boolean value = prefs.getBoolean(SETTINGS_VALID, false);
        return value;
    }

    public void storeVibration(Boolean status) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SETTINGS_VIBRATION, status);
        editor.commit();
    }

    public Boolean getVibration() {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        Boolean value = prefs.getBoolean(SETTINGS_VIBRATION, false);
        return value;
    }

    public void storeNotification(Boolean status) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SETTINGS_NOTIFICATION, status);
        editor.commit();
    }

    public Boolean getNotification() {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        Boolean value = prefs.getBoolean(SETTINGS_NOTIFICATION, true);
        return value;
    }


    public void storeLanguage(String ln) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(APP_lANGUAGE, ln);
        editor.commit();
    }

    public void storeAuthToken(String token) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(AUTH_TOKEN, token);
        editor.commit();
    }
    public String getAuthToken() {
        String value = "";
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        value = prefs.getString(AUTH_TOKEN, "");
        return value;
    }
    public void storeSchoolId(int id) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SCHOOL, id);
        editor.commit();
    }
    public int getSchoolId() {
        int value = 0;
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        value = prefs.getInt(SCHOOL, 0);
        return value;
    }
    public void storeContentDirection(String content) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(CONTENT_DIRECTION, content);
        editor.commit();
    }
    public String getContentDirection() {
        String value = "";
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        value = prefs.getString(CONTENT_DIRECTION, "");
        return value;
    }

    public void storeAdminToken(String token) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(admin_token, token);
        editor.commit();
    }
    public String getAdminToken() {
        String value = "";
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        value = prefs.getString(admin_token, "");
        return value;
    }
    public void storeEmail(String email) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(EMAIL, email);
        editor.commit();
    }
    public String getEmail() {
        String value = "";
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        value = prefs.getString(EMAIL, "");
        return value;
    }

    public void storeCorrectBy(String correct_by) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(CORRECT_BY, correct_by);
        editor.commit();
    }
    public String getCorrectBy() {
        String value = "";
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        value = prefs.getString(CORRECT_BY, "");
        return value;
    }


    public String getLanguage() {
        String value = "";
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        Log.d(APP_lANGUAGE, Locale.getDefault().getDisplayLanguage());
        value = prefs.getString(APP_lANGUAGE, "en");
        return value;
    }
    public int getID() {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);

        return prefs.getInt(SETTINGS_USER_ID,-1);
    }

    public void storeID(int id) {

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SETTINGS_USER_ID, id);
        editor.commit();

    }
    public void storeUserDeviceId(String device_id) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_DATA,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER_Device_GCM, device_id);
        editor.commit();
    }

    public String getUserDeviceId() {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_DATA, 0);
        String value = prefs.getString(USER_Device_GCM, "");
        return value;
    }

    public void storeMe(String me){

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(ME, me);
        editor.commit();

    }
    public String getMe(){
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        String value = prefs.getString(ME, "");
        return value;

    }
    public void storeExam(String exam){

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(THIS_EXAM, exam);
        editor.commit();

    }
    public String getExam(){
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        String value = prefs.getString(THIS_EXAM, "");
        return value;

    }
    public String getTraining(){
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, 0);
        String value = prefs.getString(THIS_TRAINING, "");
        return value;

    }
    public void storeTraining(String training){

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME,
                0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(THIS_TRAINING, training);
        editor.commit();

    }





    public static String toJson(Object obj){

        return gson.toJson(obj);

    }

    public static String toJsonImageList(List<String> images) {

        return gson.toJson(images);

    }
    public static List<String> fromJsonImages(String list){
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        return gson.fromJson(list, listType);
    }


    public boolean isFirstRun(){

        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(FIRST_RUN, false);


    }
    public void storeFirstRun(boolean firstRun) {


        PreferenceManager.getDefaultSharedPreferences(context).edit()
                .putBoolean(FIRST_RUN, firstRun)
                .apply();


    }

}

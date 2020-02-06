package com.example.roylmobile.language;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Locale;

public class LanguageHelper {
    private static final String PREFS_NAME = "language.prefs";
    private static final String PREF_KEY_LANGUAGE = "language";
    private static String DEFAULT_LANG = Languages.ARABIC.name();

    public static void changeLanguage(Activity activity, Languages language) {
        activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(PREF_KEY_LANGUAGE, language.name()).apply();
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static Languages getLanguage(Context context) {
        return Languages.valueOf(context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).
                getString(PREF_KEY_LANGUAGE, DEFAULT_LANG));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void applyLanguage(Context context) {
        Languages language = Languages.valueOf(context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getString(PREF_KEY_LANGUAGE, getDefaultLang(context)));
        Locale locale = new Locale(language.getLanguageCode());
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public static int getLanguagePosition(Context context) {
        return getLanguage(context).ordinal();
    }

    public static String getDefaultLang(Context context) {

        if (Locale.getDefault().getLanguage().equals("ar"))
            DEFAULT_LANG = Languages.ARABIC.name();
        else
            DEFAULT_LANG = Languages.ENGLISH.name();
        return DEFAULT_LANG;
    }

}

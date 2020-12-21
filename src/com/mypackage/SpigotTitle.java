package com.mypackage;

import com.sun.istack.internal.Nullable;

public class SpigotTitle {

    @Nullable
    public String title;
    @Nullable
    public String subtitle;
    public int fadeIn;
    public int stay;
    public int fadeOut;

    public SpigotTitle(@Nullable String title, @Nullable String subtitle)
    {
        this.title = title;
        this.subtitle = subtitle;
        this.fadeIn = 10;
        this.fadeOut = 20;
        this.stay = 70;
    }

    public SpigotTitle(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut)
    {
        this.title = title;
        this.subtitle = subtitle;
        this.fadeIn = fadeIn;
        this.fadeOut = fadeOut;
        this.stay = stay;
    }



}

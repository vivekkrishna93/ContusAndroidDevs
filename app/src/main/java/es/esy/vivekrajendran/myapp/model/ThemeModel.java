package es.esy.vivekrajendran.myapp.model;


public class ThemeModel {
    private String themeName;
    private int themeResource;

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public int getThemeResource() {
        return themeResource;
    }

    public void setThemeResource(int themeResource) {
        this.themeResource = themeResource;
    }

    public ThemeModel(String themeName, int themeResource) {
        this.themeName = themeName;
        this.themeResource = themeResource;
    }
}

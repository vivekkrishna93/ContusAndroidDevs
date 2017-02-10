package es.esy.vivekrajendran.myapp.model;

public class GridModel {
    private int imageRes;
    private String text;
    private int colorRes;

    public GridModel(int imageRes, String text, int colorRes) {
        this.imageRes = imageRes;
        this.text = text;
        this.colorRes = colorRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getColorRes() {
        return colorRes;
    }

    public void setColorRes(int colorRes) {
        this.colorRes = colorRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

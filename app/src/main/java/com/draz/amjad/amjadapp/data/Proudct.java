package com.draz.amjad.amjadapp.data;

/**
 * Created by user on 22/11/2017.
 */

public class Proudct {
    private String mainMeal;
    /**
     * the Drinks of the product
     */
    private String Drinks;
    /**
     * the secondMeal of the product
     */
    private String secondMeal;
    /**
     * if the product is bought
     */
    private boolean isCompleted;
    /**
     * the path of product's image
     */
    private String imagPath;

    /**
     * a specail key or id unique for each product (primary key)
     */

    private String keyId;

    /**
     * building
     * @param mainmeal
     * @param drinks
     * @param secondmeal
     */
    public Proudct(String mainmeal, String drinks, String secondmeal) {
        this.mainMeal = mainmeal;
        this.Drinks = drinks;
        this.secondMeal = secondmeal;
        isCompleted=false;
        imagPath=null;

    }

    public Proudct(String name, String price, String amount, boolean isCompleted, String imagPath, String keyId) {
        this.mainMeal = name;
        this.Drinks = price;
        this.secondMeal = amount;
        this.isCompleted = isCompleted;
        this.imagPath = imagPath;
        this.keyId = keyId;
    }

    public Proudct() {
    }

    public String getMainMeal() {
        return mainMeal;
    }

    public void setMainMeal(String mainMeal) {
        this.mainMeal = mainMeal;
    }

    public String getDrinks() {
        return Drinks;
    }

    public void setDrinks(String drinks) {
        this.Drinks = drinks;
    }

    public String getSecondMeal() {
        return secondMeal;
    }

    public void setSecondMeal(String secondMeal) {
        this.secondMeal = secondMeal;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getImagPath() {
        return imagPath;
    }

    public void setImagPath(String imagPath) {
        this.imagPath = imagPath;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}

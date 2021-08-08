/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuancq.dto;

/**
 *
 * @author ADmin
 */
public class FoodErrDTO {
    private String idErr;
    private String nameErr;
    private String descriptionErr;
    private String priceErr;
    private String cookingTimeErr;
    private String idErrFormat;

    public FoodErrDTO() {
    }


    public String getIdErr() {
        return idErr;
    }

    public void setIdErr(String idErr) {
        this.idErr = idErr;
    }

    public String getNameErr() {
        return nameErr;
    }

    public void setNameErr(String nameErr) {
        this.nameErr = nameErr;
    }

    public String getDescriptionErr() {
        return descriptionErr;
    }

    public void setDescriptionErr(String descriptionErr) {
        this.descriptionErr = descriptionErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getCookingTimeErr() {
        return cookingTimeErr;
    }

    public void setCookingTimeErr(String cookingTimeErr) {
        this.cookingTimeErr = cookingTimeErr;
    }

    public String getIdErrFormat() {
        return idErrFormat;
    }

    public void setIdErrFormat(String idErrFormat) {
        this.idErrFormat = idErrFormat;
    }
    
    
}

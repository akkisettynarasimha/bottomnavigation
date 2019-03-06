package net.simplifiedcoding.bottomnavigationexample;

/**
 * Created by Grepthor_3 on 12/29/2017.
 */

public class NextModel {
  private String name1,web;
   private String image;
   private String bankName;

   private String card_name,imm,imgbb,appTime,anualFee,rewlFee,webvi;

    public NextModel(String bankN){
        bankName=bankN;
    }
    public NextModel(String nametext, String imageUr) {
        name1 = nametext;
        image = imageUr;
        //web=webdata;

    }
    public NextModel(String cardname, String imageUrl, String imageback, String approvalTime, String annualFee) {
        card_name=cardname;
        imm=imageUrl;
        imgbb=imageback;
        appTime=approvalTime;
        anualFee=annualFee;

    }
    public String getCardname(){
        return card_name;
    }
    public void setCardname(String cardname1){
        card_name=cardname1;
    }
    public String getImm(){
        return imm;
    }
    public void setImm(String imm1){
        card_name=imm1;
    }
    public String getImgbb(){
        return imgbb;
    }
    public void setImgbb(String imgbbb){
        imgbb=imgbbb;
    }
    public String getAppTime(){
        return appTime;
    }
    public void setAppTime(String appTimee){
        appTime=appTimee;
    }
    public String getAnualFee(){
        return anualFee;
    }
    public void setAnualFee(String anualFee1){
        anualFee=anualFee1;
    }
    public String getRewlFee(){
        return rewlFee;
    }
    public void setRewlFee(String rewlFee1){
        rewlFee=rewlFee1;
    }
    public String getWebvi(){
        return webvi;
    }
    public void setWebvi(String webvi1){
        webvi=webvi1;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        name1 = bankName;
    }

    public String getName() {
        return name1;
    }

    public void setName1(String name11) {
        name1 = name11;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image11) {
        image = image11;
    }
    public String getWeb() {
        return web;
    }

    public void setWeb(String web1) {
        web = web1;
    }


}

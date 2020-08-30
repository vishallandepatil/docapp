package com.pvp.doctorapp.home.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class  Notification{

    @SerializedName("bse_trading_symbol")
    String bse_trading_symbol;
    @SerializedName("bse_security_name")
    String bse_security_name;
    @SerializedName("nse_security_name")
    String nse_security_name;
    @SerializedName("isin")
    String isin;
    @SerializedName("is_bse_exchange")
    String is_bse_exchange;
    @SerializedName("nse_exchange_token")
    int nse_exchange_token;




}

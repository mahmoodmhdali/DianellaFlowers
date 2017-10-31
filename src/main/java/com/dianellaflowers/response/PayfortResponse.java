/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mahmo
 */
public class PayfortResponse {
    
    @JsonProperty("command")
    String command;
    @JsonProperty("access_code")
    String access_code;
    @JsonProperty("merchant_identifier")
    String merchant_identifier;
    @JsonProperty("merchant_reference")
    String merchant_reference;
    @JsonProperty("amount")
    String amount;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("language")
    String language;
    @JsonProperty("customer_email")
    String customer_email;
    @JsonProperty("signature")
    String signature;
    @JsonProperty("token_name")
    String token_name;
    @JsonProperty("fort_id")
    String fort_id;
    @JsonProperty("payment_option")
    String payment_option;
    @JsonProperty("sadad_olp")
    String sadad_olp;
    @JsonProperty("eci")
    String eci;
    @JsonProperty("order_description")
    String order_description;
    @JsonProperty("customer_ip")
    String customer_ip;
    @JsonProperty("customer_name")
    String customer_name;
    @JsonProperty("merchant_extra")
    String merchant_extra;
    @JsonProperty("merchant_extra1")
    String merchant_extra1;
    @JsonProperty("merchant_extra2")
    String merchant_extra2;
    @JsonProperty("merchant_extra3")
    String merchant_extra3;
    @JsonProperty("merchant_extra4")
    String merchant_extra4;
    @JsonProperty("authorization_code")
    String authorization_code ;
    @JsonProperty("response_message")
    String response_message;
    @JsonProperty("response_code")
    String response_code;
    @JsonProperty("status")
    String status;
    @JsonProperty("card_holder_name")
    String card_holder_name;
    @JsonProperty("expiry_date")
    String expiry_date;
    @JsonProperty("card_number")
    String card_number;
    @JsonProperty("remember_me")
    String remember_me;
    @JsonProperty("phone_number")
    String phone_number;
    @JsonProperty("settlement_reference")
    String settlement_reference;

    public String getSettlement_reference() {
        return settlement_reference;
    }

    public void setSettlement_reference(String settlement_reference) {
        this.settlement_reference = settlement_reference;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRemember_me() {
        return remember_me;
    }

    public void setRemember_me(String remember_me) {
        this.remember_me = remember_me;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }

    public String getMerchant_extra4() {
        return merchant_extra4;
    }

    public void setMerchant_extra4(String merchant_extra4) {
        this.merchant_extra4 = merchant_extra4;
    } 

    public String getMerchant_extra3() {
        return merchant_extra3;
    }

    public void setMerchant_extra3(String merchant_extra3) {
        this.merchant_extra3 = merchant_extra3;
    }

    public String getMerchant_extra2() {
        return merchant_extra2;
    }

    public void setMerchant_extra2(String merchant_extra2) {
        this.merchant_extra2 = merchant_extra2;
    }

    public String getMerchant_extra1() {
        return merchant_extra1;
    }

    public void setMerchant_extra1(String merchant_extra1) {
        this.merchant_extra1 = merchant_extra1;
    }

    public String getMerchant_extra() {
        return merchant_extra;
    }

    public void setMerchant_extra(String merchant_extra) {
        this.merchant_extra = merchant_extra;
    }

    public String getSadad_olp() {
        return sadad_olp;
    }

    public void setSadad_olp(String sadad_olp) {
        this.sadad_olp = sadad_olp;
    }

    public String getToken_name() {
        return token_name;
    }

    public void setToken_name(String token_name) {
        this.token_name = token_name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getAccess_code() {
        return access_code;
    }

    public void setAccess_code(String access_code) {
        this.access_code = access_code;
    }

    public String getMerchant_identifier() {
        return merchant_identifier;
    }

    public void setMerchant_identifier(String merchant_identifier) {
        this.merchant_identifier = merchant_identifier;
    }

    public String getMerchant_reference() {
        return merchant_reference;
    }

    public void setMerchant_reference(String merchant_reference) {
        this.merchant_reference = merchant_reference;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getFort_id() {
        return fort_id;
    }

    public void setFort_id(String fort_id) {
        this.fort_id = fort_id;
    }

    public String getPayment_option() {
        return payment_option;
    }

    public void setPayment_option(String payment_option) {
        this.payment_option = payment_option;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getOrder_description() {
        return order_description;
    }

    public void setOrder_description(String order_description) {
        this.order_description = order_description;
    }

    public String getCustomer_ip() {
        return customer_ip;
    }

    public void setCustomer_ip(String customer_ip) {
        this.customer_ip = customer_ip;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getCard_holder_name() {
        return card_holder_name;
    }

    public void setCard_holder_name(String card_holder_name) {
        this.card_holder_name = card_holder_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    @Override
    public String toString() {
        return "payfortResponse{" + "command=" + command + ", access_code=" + access_code + ", merchant_identifier=" + merchant_identifier + ", merchant_reference=" + merchant_reference + ", amount=" + amount + ", currency=" + currency + ", language=" + language + ", customer_email=" + customer_email + ", signature=" + signature + ", fort_id=" + fort_id + ", payment_option=" + payment_option + ", eci=" + eci + ", order_description=" + order_description + ", customer_ip=" + customer_ip + ", customer_name=" + customer_name + ", response_message=" + response_message + ", response_code=" + response_code + ", card_holder_name=" + card_holder_name + ", status=" + status + ", expiry_date=" + expiry_date + ", card_number=" + card_number + '}';
    }
    
    
}

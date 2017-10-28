/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.response;

/**
 *
 * @author mahmo
 */
public class PayfortResponse {
    String command;
    String access_code;
    String merchant_identifier;
    String merchant_reference;
    String amount;
    String currency;
    String language;
    String customer_email;
    String signature;
    String fort_id;
    String payment_option;
    String eci;
    String order_description;
    String customer_ip;
    String customer_name;
    String response_message;
    String response_code;
    String status;
    String card_holder_name;
    String expiry_date;
    String card_number;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.utilities;

import com.dianellaflowers.service.EmailService;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mahmoud
 */
@Component
public class Utilities {

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    private EmailService emailService;

    @Autowired
    private Environment environment;

    public static Date getFormattedDateAsDate(String format) {
        /* This function just returns the current / instant date in the specified format. If u need specific dates then this function 
        *  should be updated by another parameter representing a given date
         */
        try {
            return new SimpleDateFormat(format).parse(getFormattedDateAsString(format));
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String getFormattedDateAsString(String format) {
        /* This function just returns the current / instant date in the specified format. If u need specific dates then this function 
        *  should be updated by another parameter representing a given date
         */

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    public static long getTimeDiffMin(Date dateOne, Date dateTwo) {
        //difference in milliseconds
        long diff = dateTwo.getTime() - dateOne.getTime();

        long diffmin = diff / (60 * 1000);

        return diffmin;
    }

    public static long getTimeDiffSec(Date dateOne, Date dateTwo) {
        //difference in milliseconds
        long diff = dateTwo.getTime() - dateOne.getTime();

        long diffsec = diff / (1000);

        return diffsec;
    }

    public static String getCatalinaHome() {
        return System.getProperty("catalina.home");
    }

    public static byte[] getFileAsBytes(String filePath) {
        Path path = Paths.get(filePath);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException ex) {
            //Log.append("Error in getFileAsBytes " + filePath + " -- " + ex.getMessage(), "", "", Log.LOG_TYPE_ALARM);
        }
        return data;
    }

    public static String extractFileNameFromPath(String filePath, boolean removeExtension) {
        String fileName = new File(filePath).getName();
        if (removeExtension) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        return fileName;
    }

    public static void createDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (!checkIfDirExists(dirPath)) {
            dir.mkdir();
        }
    }

    public static boolean checkIfDirExists(String dirPath) {
        File dir = new File(dirPath);
        return dir.exists();
    }

    public static String generateTokenForPassword() {
        return UUID.randomUUID().toString();
    }

    public static String getHostIPAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    public void sendEmail(String text, String[] to, String subject) throws AddressException {
        // Email message
        //Log.append("Email Message Data [Sender ==> " + "Outbound Dialer <" + environment.getRequiredProperty("mail.username") + ">" + ", Receivers ==>" + receiversEmails + ", Body ==>" + text + ", Subject ==>" + subject + "]", "", "", Log.LOG_TYPE_NORMAL);
        SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
        passwordResetEmail.setFrom("Outbound Dialer <" + environment.getRequiredProperty("mail.username") + ">");
        passwordResetEmail.setBcc(to);//setTo(to) is not used here in order not to show all recepient mails;
        passwordResetEmail.setSubject(subject);
        passwordResetEmail.setText(text);

        emailService.sendEmail(passwordResetEmail);
    }

    public static Date timeToZeros(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    public static String getSaltString(Integer id) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "_" + id;

    }

}

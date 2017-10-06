///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.dianellaflowers.utilities;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
///**
// *
// * @author Pc-Lenovo
// */
//public class Log {
//    
//    private static String logRootDirName = "DianellaFlower";
//    public static final int LOG_TYPE_NORMAL = 0;
//    public static final int LOG_TYPE_ALARM = 1;
//    public static final int LOG_TYPE_ERROR = 2;
//    private static final boolean byPassLog = true;
//    /* Buffering Logs */
//    private static boolean immediatFlush = false;
//    private static HashMap<String, StringBuilder> bufferedLog = new HashMap<String, StringBuilder>();
//    private static HashMap<String, StringBuilder> flushedBufferedLog = new HashMap<String, StringBuilder>();
//    private static int allowedIdleTimeBeforeFlush = 10;
//    private static ScheduledExecutorService logBufferTimer;
//
//    /* Buffering Logs */
//    public synchronized static int append(String message, String source, String clientName, int logType) {
//        return byPassLog ? writeLogData(message, source, logType, clientName, false) : 0;
//    }
//
//    public synchronized static int append(String message, String source, int logType, boolean pushAlarm) {
//        return byPassLog ? writeLogData(message, source, logType, "", pushAlarm) : 0;
//    }
//
//    private static int writeLogData(String message, String source, int logType, String clientName, boolean pushAlarmMessage) {
//        try {
//            String path = "";
//            if (source.equals("TOMCAT")) {
//                path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/TomcatEvents.log";
//            } else if (source.equals("AUDITTRAIL")) {
//                path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/AuditTrail.log";
//            } else if (logType == LOG_TYPE_NORMAL) {
//                if (clientName.equals("")) {
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/logdata_" + Utilities.getFormattedDateAsString("dd-MM-yyyy") + ".log";
//                } else if (!clientName.contains("~@~@~")) {
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + clientName + "/" + clientName + "_main.log";
//                } else {
//                    String[] clientAndServiceNames = clientName.split("~@~@~");
//                    if (!Utilities.checkIfDirExists(Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + 
//                            clientAndServiceNames[0] + "/" + clientAndServiceNames[1] + "/" + 
//                            Utilities.getFormattedDateAsString("dd-MM-yyyy"))) {
//                        Utilities.createDirectory(Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + 
//                                clientAndServiceNames[0] + "/" + clientAndServiceNames[1] + "/" + 
//                                Utilities.getFormattedDateAsString("dd-MM-yyyy"));
//                    }
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + 
//                            clientAndServiceNames[0] + "/" + clientAndServiceNames[1] + "/" + 
//                            Utilities.getFormattedDateAsString("dd-MM-yyyy") + "/" + 
//                            clientAndServiceNames[0] + "_" + clientAndServiceNames[1] + "_" + 
//                            Utilities.getFormattedDateAsString("dd-MM-yyyy HH") + ".log";
//                }
//            } else if (logType == LOG_TYPE_ALARM) {
//                if (clientName.equals("")) {
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + logRootDirName + "_Alarms_" + Utilities.getFormattedDateAsString("dd-MM-yyyy HH") + ".log";
//                } else {
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + clientName + "/" + logRootDirName + "_Alarms_" + Utilities.getFormattedDateAsString("dd-MM-yyyy HH") + ".log";
//                }
//
//            } else if (logType == LOG_TYPE_ERROR) {
//                if (clientName.equals("")) {
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + logRootDirName + "_Errors_" + Utilities.getFormattedDateAsString("dd-MM-yyyy HH") + ".log";
//                } else {
//                    path = Utilities.getCatalinaHome() + "/logs/" + logRootDirName + "/" + clientName + "/" + logRootDirName + "_Errors_" + Utilities.getFormattedDateAsString("dd-MM-yyyy HH") + ".log";
//                }
//            }
//
//            if (pushAlarmMessage) {
//                // use websockets (EventsServer) to push the alarms
//            }
//
//            if (logType == LOG_TYPE_ALARM || logType == LOG_TYPE_ERROR) {
//                log_data_to_file(path, Utilities.getFormattedDateAsString("dd-MM-yyyy HH:mm:ss") + "  " + source + "  " + " --- " + message);
//            } else if (immediatFlush) {
//                log_data_to_file(path, Utilities.getFormattedDateAsString("dd-MM-yyyy HH:mm:ss") + "  " + source + "  " + " --- " + message);
//            } else {
//                start_log_buffer_timer();
//                append_to_buffer(path, Utilities.getFormattedDateAsString("dd-MM-yyyy HH:mm:ss") + "  " + source + "  " + " --- " + message);
//            }
//            return 0;
//        } catch (Exception ex) {
//            return -1;
//        } finally {
//
//        }
//    }
//
//    private static void start_log_buffer_timer() {
//        if (logBufferTimer == null) {
//            logBufferTimer = Executors.newSingleThreadScheduledExecutor();
//            logBufferTimer.scheduleAtFixedRate(() -> flush_buffer(), 0, allowedIdleTimeBeforeFlush, TimeUnit.SECONDS);
//        }
//    }
//
//    private static void flush_buffer() {
//        synchronized (bufferedLog) {
//            flushedBufferedLog.clear();
//            flushedBufferedLog = (HashMap<String, StringBuilder>) bufferedLog.clone();
//            bufferedLog.clear();
//        }
//
//        for (Map.Entry<String, StringBuilder> entry : flushedBufferedLog.entrySet()) {
//            log_data_to_file(entry.getKey(), entry.getValue().toString());
//        }
//    }
//
//    private static void append_to_buffer(String file_path, String data) {
//        synchronized (bufferedLog) {
//            if (bufferedLog.containsKey(file_path)) {
//                bufferedLog.put(file_path, bufferedLog.get(file_path).append("\n" + data));
//            } else {
//                bufferedLog.put(file_path, new StringBuilder().append(data));
//            }
//        }
//    }
//
//    private static void log_data_to_file(String path, String data) {
//        try {
//            FileWriter fstream = new FileWriter(path, true);
//            BufferedWriter out = new BufferedWriter(fstream);
//            out.write(data);
//            out.newLine();
//            
//            out.close();
//            fstream.close();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//        }
//    }
//}

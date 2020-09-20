/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mude.srl.ssc.mail;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import mude.srl.ssc.service.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jackarian
 */
public class LoggerSSC {

    private static final Logger LOGGER = Logger.getLogger("LoggerSpedizioni");

    public Logger getLogger() {
        return LOGGER;
    }
    private SevereMessageHandler smh;
   
    private static LoggerSSC instance;
    private boolean error = false;
    private Exception exception = null;

    public static final int NO_QUANTY_AVAILABLE = 0;
    public static final int INSERTED = 1;
    public static final int DOCUMENT_ORDER_NOT_INSERTED = 2;
    public static final int NO_CONNECTION = 3;
    public static final int ERRORE_INSERIMENTO_ANAGRAFICA = 4;
    public static final int ERRORE_INSERIMENTO_ORDINE = 5;
    public static final int ERRORE_INSERIMENTO_RIGA_ORDINE = 6;
    public static final int ERRORE_INSERIMENTO_RIGA_ORDINE_NO_CONNECTION = 9;
    public static final int ERRORE_INSERIMENTO_RIGA_ORDINE_DOCUMENTO = 7;
    public static final int ERRORE_INSERIMENTO_DOCUMENTO_FINALE = 8;
    public static final int ERRORE_INSERIMENTO_ORDINE_MAGENTO = 21;
    public static final int NO_ORDER_ROW = 9;
    public static final int GENERAL_ERROR = 10;
    public static final int NO_ADDRESS_ROW = 11;
    public static final int ERROR_BUILDING_ROW_ADDRESS = 12;
    public static final int ERROR_BLOCK_QTY_PENDIG_ORDER = 13;
    public static final int ERROR_BUILDING_ROW_ITEM_PENDING = 14;
    public static final int PRODUCT_NOT_FOUND_EXCEPTION = 15;
    public static final int SQL_EXCEPTION = 16;
    public static final int ORDER_NUMEBER_EXCEPTION = 17;
    public static final int NULL_POINTER_EXCEPTION = 18;
    public static final int ERROR_SBLOCK_QTY_PENDIG_ORDER = 19;
    public static final int NO_RESULT_FOR_CURRENT_PRODUCT_LIST = 20;
    
    public static final String SHIPPING_FOLDER = "/var/log/spedizioni";
    public static final String SHIPPING_FOLDER_FTP = "/var/log/spedizioni/ftp";

    private LoggerSSC() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        FileHandler fh = new FileHandler(SHIPPING_FOLDER + File.separator + "spedizioni_" + format.format(Calendar.getInstance(Locale.ITALIAN).getTime()) + ".log");
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        smh = new SevereMessageHandler("Logger Spedizioni");
        smh.setFormatter(formatter);
        LOGGER.addHandler(fh);
        LOGGER.setUseParentHandlers(true);
        LOGGER.addHandler(smh);
        LOGGER.info("Initializing LoggerSpedizioni");
    }

    public static LoggerSSC getInstance() {
        if (instance == null) {
            try {
                instance = new LoggerSSC();
            } catch (IOException ex) {
                Logger.getLogger(LoggerSSC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    public static void flush() {
        if (LOGGER != null) {
            Handler[] handlers = LOGGER.getHandlers();
            for (Handler h : handlers) {
                h.close();
            }
        }
    }

}

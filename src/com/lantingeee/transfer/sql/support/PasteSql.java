package com.lantingeee.transfer.sql.support;

/**
 * Created by lantingeee on 29/09/2017.
 */
public class PasteSql implements TransferSql {
    @Override
    public String[] operateStrings(String[] args) {
        String[] res = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            if (i != args.length - 1) {
                res[i] = "\"" + args[i] + " \" ,";
            } else {
                res[i] = "\"" + args[i] + " \"";
            }
        }
        return res;
    }
}

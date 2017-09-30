package com.lantingeee.transfer.sql.support;

/**
 * Created by lantingeee on 29/09/2017.
 */
public class CopySql implements TransferSql {

    @Override
    public String[] operateStrings(String[] orc) {

        String newStrings[] = new String[orc.length];

        for (int i = 0; i < orc.length; i++) {

            char[] lc = orc[i].toCharArray();
            int index = 0;
            for (int j = 0; j < lc.length; j++) {

                if (lc[j] == '"') {
                    lc[j] = ' ';
                    index++;
                }

                if (index == 2) {
                    lc[j] = ' ';
                }
            }
            newStrings[i] = new String(lc);
        }
        return newStrings;
    }

}

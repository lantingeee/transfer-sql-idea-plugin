package com.lantingeee.transfer.sql.support;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * Created by lantingeee on 29/09/2017.
 */
public interface TransferSql {


    static String extractFromClip(Transferable clipTf) {

        String orgContent = "";
        if (clipTf != null) {

            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    orgContent = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return orgContent;
    }

    String[] operateStrings(String[] args);

    static String join(String[] args, char jc) {
        StringBuilder sbu = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i != args.length - 1) {
                sbu.append(args[i]);
                sbu.append(jc);
            } else {
                sbu.append(args[i]);
            }
        }
        return sbu.toString();
    }

    static void setContent(Clipboard sysClip, String[] arg) {
        Transferable tText = new StringSelection(join(arg, '\n'));
        sysClip.setContents(tText, null);
    }
}

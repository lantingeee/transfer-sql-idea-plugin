package com.lt.copySqlPlugin.action;

import com.intellij.ide.CopyProvider;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * Created by lantingeee on 27/09/2017.
 */
public class CopySqlSupportAction extends AnAction {
    public CopySqlSupportAction() {
        this.setEnabledInModalContext(true);
    }

    @Override
    public void actionPerformed(AnActionEvent var1) {
        DataContext var2 = var1.getDataContext();
        CopyProvider var3 = PlatformDataKeys.COPY_PROVIDER.getData(var2);
        if (var3 != null) {
            var3.performCopy(var2);
        }

        // get a system clipboard
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // get content from clipboard
        Transferable clipTf = sysClip.getContents(null);

        String orgContent = "";
        if (clipTf != null) {

            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    orgContent = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String[] orgList = orgContent.split("\n|\r");
                String[] news = rmSpcCharacter(orgList);

                Transferable tText = new StringSelection(join(news, '\n'));
                sysClip.setContents(tText, null);
            }
        }
    }

    private String[] rmSpcCharacter(String[] orc) {

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

    private String join(String[] args, char jc) {
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
}

package com.lantingeee.transfer.sql;

import com.intellij.ide.CopyProvider;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.lantingeee.transfer.sql.support.CopySql;
import com.lantingeee.transfer.sql.support.TransferSql;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

/**
 * Created by lantingeee on 27/09/2017.
 */
public class CopySqlAction extends AnAction {

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

        String[] orgList = TransferSql.extractFromClip(clipTf).split("\n|\r");
        String[] news = new CopySql().operateStrings(orgList);
        TransferSql.setContent(sysClip, news);

    }
}

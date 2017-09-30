package com.lantingeee.transfer.sql;

import com.intellij.ide.PasteProvider;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.lantingeee.transfer.sql.support.PasteSql;
import com.lantingeee.transfer.sql.support.TransferSql;

/**
 * Created by lantingeee on 29/09/2017.
 */
public class PasteSqlAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent var1) {

        String[] orgList = TransferSql.extractFromClip().split("\n|\r");
        String[] news = new PasteSql().operateStrings(orgList);
        TransferSql.setContent(news);

        DataContext var2 = var1.getDataContext();
        PasteProvider var3 = PlatformDataKeys.PASTE_PROVIDER.getData(var2);
        if (var3 != null && var3.isPasteEnabled(var2)) {
            var3.performPaste(var2);
        }
    }
}

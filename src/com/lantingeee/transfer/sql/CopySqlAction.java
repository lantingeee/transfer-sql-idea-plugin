package com.lantingeee.transfer.sql;

import com.intellij.ide.CopyProvider;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.lantingeee.transfer.sql.support.CopySql;
import com.lantingeee.transfer.sql.support.TransferSql;

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

        String[] orgList = TransferSql.extractFromClip().split("\n|\r");
        String[] news = new CopySql().operateStrings(orgList);
        TransferSql.setContent(news);

    }


}

package com.lt.copySqlPlugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.lt.copySqlPlugin.action.support.CopySql;
import com.lt.copySqlPlugin.action.support.TransferSql;

/**
 * Created by lantingeee on 27/09/2017.
 */
public class CopySqlSupportAction extends AnAction {
    public CopySqlSupportAction() {
        this.setEnabledInModalContext(true);
    }

    @Override
    public void actionPerformed(AnActionEvent var1) {
//        DataContext var2 = var1.getDataContext();
//        CopyProvider var3 = PlatformDataKeys.COPY_PROVIDER.getData(var2);
//        if (var3 != null) {
//            var3.performCopy(var2);
//        }
        String[] orgList = TransferSql.extractFromClip().split("\n|\r");
        String[] news = new CopySql().operateStrings(orgList);
        TransferSql.setContent(news);

    }
}


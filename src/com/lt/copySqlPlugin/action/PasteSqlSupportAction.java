package com.lt.copySqlPlugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.lt.copySqlPlugin.action.support.PasteSql;
import com.lt.copySqlPlugin.action.support.TransferSql;

/**
 * Created by lantingeee on 29/09/2017.
 */
public class PasteSqlSupportAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent var1) {

        String[] orgList = TransferSql.extractFromClip().split("\n|\r");
        String[] news = new PasteSql().operateStrings(orgList);
        TransferSql.setContent(news);
    }
}

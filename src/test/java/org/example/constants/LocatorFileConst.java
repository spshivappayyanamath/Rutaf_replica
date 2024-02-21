package org.example.constants;

import org.example.constants.LocatorFileConst;
import java.nio.file.Paths;

public class LocatorFileConst {
    public static final String CT_LOGIN= Paths.get(GlobalConst.LOCATORS_PATH,"ctlogin","ctlogin.json").toAbsolutePath().toString();

}

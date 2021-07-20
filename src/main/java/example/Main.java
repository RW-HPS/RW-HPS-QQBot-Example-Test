package example;

import com.github.dr.rwserver.data.global.Data;
import com.github.dr.rwserver.dependent.LibraryManager;
import com.github.dr.rwserver.plugin.Plugin;

import java.security.NoSuchProviderException;

/**
 * @author Dr
 */
public class Main extends Plugin {
	public Main() {
		/* 必须注入到Server中 */
		LibraryManager libraryManager = new LibraryManager(true,Data.Plugin_Lib_Path);
		libraryManager.importLib("org.jetbrains.kotlin", "kotlin-reflect", "1.5.21");
		libraryManager.loadToClassLoader();
	}
	/**
	 * 加载Mirai
	 */
	@Override
	public void init(){
		try {
			new BotTest();
		} catch (Exception e) {
			//忽略 Mirai调用的检查 以及其他的问题
		}
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}
}

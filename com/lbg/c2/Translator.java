package com.lbg.c2;
import java.io.*;

public class Translator {
	
	public static final String ENG = "English";
	public static final  String RUS = "Russian";
	public static String Language = ENG;
	public static  File LangFolder;
	public static  File LangFile;
	public static  File TempFile;
	public static ObjectInputStream in;
	
	public static void init () {
		
		LangFolder = new File (System.getenv("appdata")+"\\CPM");
		LangFile = new File (System.getenv("appdata")+"\\CPM\\lang.dat");
		TempFile = new File (System.getenv("appdata")+"\\CPM\\template.dat");
		
		if (! LangFolder.exists()) {
			LangFolder.mkdir();
		}
		
		if (LangFile.exists()) {
			try {
				in = new ObjectInputStream(new FileInputStream(LangFile));
				Language = (String) in.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static File getLangFolder () {
		return LangFolder;
	}
	
	public static File getLangFile () {
		return LangFile;
	}
	
	public static File getTempFile () {
		return TempFile;
	}
	
	public static String getlang () {
		return Language;
	};
	
	public static void setlang (String Lang) {
		Language = Lang;
	}
	
	// translations
	
	public static String getTitle () {
		if (Language.equals(RUS) ) {
			return "Построить 2 Плагин чайник ";
		}
		else {
			return "Construct 2 Plugin Maker";
		}
		
	}
	
	public static String getFile () {
		if (Language.equals(RUS)) {
			return "Файл";
		}
		else {
			return "file";
		}
		
	}
	
	public static String getEdit () {
		if (Language.equals(RUS)) {
			return "Редактировать";
		}
		else {
			return "edit";
		}
		
	}
	
	public static String getBuild () {
		if (Language.equals(RUS) ) {
			return "Экспорт";
		}
		else {
			return "build";
		}
		
	}
	
	public static String getHelp () {
		if (Language.equals(RUS) ) {
			return "Помощь";
		}
		else {
			return "help";
		}
		
	}
	
	public static String getNew () {
		if (Language.equals(RUS) ) {
			return "Новый";
		}
		else {
			return "new";
		}
		
	}
	
	public static String getSave () {
		if (Language.equals(RUS) ) {
			return "Сохранить";
		}
		else {
			return "save";
		}
		
	}
	
	public static String getOpen () {
		if (Language.equals(RUS) ) {
			return "Открыть";
		}
		else {
			return "open";
		}
		
	}
	
	public static String getInfo () {
		if (Language.equals(RUS) ) {
			return "Информация";
		}
		else {
			return "info";
		}
		
	}
	
	public static String getParameters () {
		if (Language.equals(RUS) ) {
			return "Параметры";
		}
		else {
			return "parameters";
		}
		
	}
	
	public static String getTemplate () {
		if (Language.equals(RUS)) {
			return "Шаблон";
		}
		else {
			return "template";
		}
		
	}
	
	public static String getExport () {
		if (Language.equals(RUS)) {
			return "Экспортировать";
		}
		else {
			return "export";
		}
		
	}
	
	public static String getReExport () {
		if (Language.equals(RUS)) {
			return "Переэкспортировать";
		}
		else {
			return "reexport";
		}
		
	}
	
	public static String getAbout () {
		if (Language.equals(RUS)) {
			return "О программе";
		}
		else {
			return "about";
		}
		
	}
	
	public static String getDoc () {
		if (Language.equals(RUS) ) {
			return "Документация";
		}
		else {
			return "documentation";
		}
		
	}
	
	public static String getConditions () {
		if (Language.equals(RUS) ) {
			return "Условия";
		}
		else {
			return "conditions";
		}
		
	}
	
	public static String getActions () {
		if (Language.equals(RUS) ) {
			return "Действия";
		}
		else {
			return "actions";
		}
		
	}
	
	public static String getExpressions () {
		if (Language.equals(RUS) ) {
			return "Выражения";
		}
		else {
			return "expressions";
		}
		
	}
	
	public static String getProperties () {
		if (Language.equals(RUS) ) {
			return "Свойства";
		}
		else {
			return "properties";
		}
		
	}
	
	public static String getAdd () {
		if (Language.equals(RUS) ) {
			return "Добавить";
		}
		else {
			return "add";
		}
		
	}
	
	public static String getDelete () {
		if (Language.equals(RUS) ) {
			return "Удалить";
		}
		else {
			return "delete";
		}
		
	}
	
	public static  String[] getParamTypes () {
		if (Language.equals(RUS)) {
			String types [] = {"Число","Текст","Любой тип","Сравнение","Опция комбинации",
					"Комбинация","Объект","Слой","Уровень","Клавиатура","Анимация","Аудио"};
			return types;
			
		}
		else {
			String types [] = {"number","string","any type","comparision","combo option",
					"combo","object","layer","layout","keyboard","animation","audio"};
			return types;
		}
	}
	
}

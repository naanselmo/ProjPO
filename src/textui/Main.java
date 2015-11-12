package edt.textui;

import edt.core.Document;

import edt.textui.main.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;


public class Main{
	/**
	 * Starts the main program and creates an interaction menu to it.
	 */

	public static void main(String[] args) throws Exception{
		Document document = new Document();
		MainMenu menu = new MainMenu(document);

		IO.setTitle("Document Main Menu"); // Opcional, necessário verificar se o professor permite
		menu.open();
		IO.close();
	}
}